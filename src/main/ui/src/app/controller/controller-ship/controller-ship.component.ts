import {Component, OnInit} from '@angular/core';
import {ControllerService} from "../../controller.service";
import {Ship} from "../../objects/ship";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../user.service";

@Component({
  selector: 'app-controller-ship',
  templateUrl: './controller-ship.component.html',
  styleUrls: ['./controller-ship.component.css']
})
export class ControllerShipComponent implements OnInit {

  public ship: Ship | null = null;
  public hpChange: number | null = null;

  constructor(private controllerService: ControllerService,
              private route: ActivatedRoute,
              private userService: UserService,
              private router: Router) {
    if (!userService.checkCredentials(route, {role: 'controller'}).allowed) {
      router.navigate(['/'])
    }
    this.updateShipValues();
  }

  public changeHP(): void {

    if (this.ship == null) return;

    if (this.hpChange == null) {
      console.error("New hp cannot be null!");
      return;
    }

    this.controllerService.changeShipHP(this.ship.name, this.hpChange).subscribe();
    this.hpChange = null;
    this.updateShipValues();
  }

  public deleteShip(): void {
    if (this.ship == null) return;

    this.controllerService.deleteShip(this.ship.name).subscribe(_ =>
      this.router.navigate(['../'], {relativeTo: this.route})
    );
  }

  /**
   * Call this when in need of updating the values.
   * @private
   */
  private updateShipValues() {
    this.controllerService.getShips().subscribe(
      ships => this.ship = ControllerShipComponent.getCurrentShip(ships, this.route.snapshot.paramMap.get('ship'))
    );
  }

  private static getCurrentShip(ships: Ship[], wantedShip: string | null) {
    if (wantedShip == null) {
      return null;
    }

    for (let ship of ships) {
      if (ship.name == wantedShip) {
        return ship;
      }
    }
    return null;
  }


  ngOnInit(): void {
  }


}
