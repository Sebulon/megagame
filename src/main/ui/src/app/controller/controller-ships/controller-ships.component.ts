import {Component, OnInit} from '@angular/core';
import {emptyShip, Ship} from "../../objects/ship";
import {ControllerService} from "../../controller.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {UserService} from "../../user.service";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-controller-ships',
  templateUrl: './controller-ships.component.html',
  styleUrls: ['./controller-ships.component.css']
})
export class ControllerShipsComponent implements OnInit {

  //TODO: If the user has the wrong role or no id, should not be able to be here

  public ships: Observable<Ship[]>;
  public shipConstructor = this.formBuilder.group(new emptyShip())


  constructor(private controllerService: ControllerService,
              private userService: UserService,
              private route: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder
  ) {
    if (!userService.checkCredentials(route, {role: 'controller'}).allowed) {
      router.navigate(['/'])
    }
    this.ships = this.controllerService.getShips();
    this.shipConstructor.reset();
  }

  ngOnInit(): void {
    //TODO: Do something with state
    //this.controllerService.getState().subscribe(state => console.log(state))
  }

  /**
   * Creates a ship and gives the ship to the backend.
   * Also updates the list of all ships.
   */
  onSubmit(): void {
    let newShip = this.shipConstructor.value as Ship;

    let containsNull = false

    Object.values(newShip).forEach(value => {
      if (value == null) {
        containsNull = true
        return;
      }
    })

    if (containsNull) {
      console.warn("All data fields are not filled!");
      return;
    }

    this.controllerService.addShip(newShip).subscribe(() => this.ships = this.controllerService.getShips());
    this.shipConstructor.reset();
  }
}
