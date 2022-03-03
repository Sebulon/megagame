import {Component, OnInit} from '@angular/core';
import {ControllerService} from "../controller.service";
import {IdService} from "../id.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {emptyShip, Ship} from "../ship";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-controller-view',
  templateUrl: './controller-view.component.html',
  styleUrls: ['./controller-view.component.css']
})
export class ControllerViewComponent implements OnInit {

  //TODO: If the user has the wrong role or no id, should not be able to be here

  public ships: Observable<Ship[]>;
  public shipConstructor = this.formBuilder.group(new emptyShip())


  constructor(private controllerService: ControllerService,
              private idService: IdService,
              private route: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder
  ) {
    if (!idService.checkCorrectId(route) || !idService.checkCorrectRole('controller')) {
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
