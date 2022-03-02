import {Component, OnInit} from '@angular/core';
import {ControllerService} from "../controller.service";
import {Ship} from "../ship";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-controller-ship',
  templateUrl: './controller-ship.component.html',
  styleUrls: ['./controller-ship.component.css']
})
export class ControllerShipComponent implements OnInit {

  public ship: Ship | null = null;

  constructor(private controllerService: ControllerService, private route: ActivatedRoute) {
    controllerService.getShips().subscribe(
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
