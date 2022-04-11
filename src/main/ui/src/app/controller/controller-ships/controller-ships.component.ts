import {Component, OnInit} from '@angular/core';
import {emptyShip, Ship} from "../../objects/ship";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {FormBuilder} from "@angular/forms";
import {ShipService} from "../../ship.service";

@Component({
  selector: 'app-controller-ships',
  templateUrl: './controller-ships.component.html',
  styleUrls: ['./controller-ships.component.css']
})
export class ControllerShipsComponent implements OnInit {

  public ships: Observable<Ship[]>;
  public shipConstructor = this.formBuilder.group(new emptyShip())

  constructor(private shipService: ShipService,
              private route: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder
  ) {
    this.ships = this.shipService.getShips();
    this.shipConstructor.reset();
  }

  ngOnInit(): void {
  }

  /**
   * Creates a ship and gives the ship to the backend.
   * Also updates the list of all ships.
   */
  onSubmit(): void {

    if (this.shipConstructor.invalid) {
      console.warn("All data fields are not filled!");
      return;
    }

    let newShip = this.shipConstructor.value as Ship;

    this.shipService.addShip(newShip).subscribe(() => this.ships = this.shipService.getShips());
    this.shipConstructor.reset();
  }
}
