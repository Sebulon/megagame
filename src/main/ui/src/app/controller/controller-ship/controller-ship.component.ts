import {Component, OnInit} from '@angular/core';
import {Ship} from "../../objects/ship";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../user.service";
import {ShipService} from "../../ship.service";

@Component({
  selector: 'app-controller-ship',
  templateUrl: './controller-ship.component.html',
  styleUrls: ['./controller-ship.component.css']
})
export class ControllerShipComponent implements OnInit {

  public ship: Ship | null = null;
  public hpChange: number | null = null;
  public resources: object | null = null;

  constructor(private shipService: ShipService,
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

    this.shipService.changeShipHP(this.ship.name, this.hpChange).subscribe();
    this.hpChange = null;
    this.updateShipValues();
  }

  public deleteShip(): void {
    if (this.ship == null) return;

    this.shipService.deleteShip(this.ship.name).subscribe(_ =>
      this.router.navigate(['../'], {relativeTo: this.route})
    );
  }

  /**
   * Call this when in need of updating the values.
   * @private
   */
  private updateShipValues() {
    this.shipService.getShips().subscribe(
      ships => {
        this.ship = ControllerShipComponent.getCurrentShip(ships, this.route.snapshot.paramMap.get('ship'))
        if(this.ship != null)
          this.shipService.getResources(this.ship.name).subscribe(resources => this.resources = resources);
      });
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
