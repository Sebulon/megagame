import {Component, OnInit} from '@angular/core';
import {ControllerService} from "../controller.service";
import {IdService} from "../id.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {Ship} from "../ship";

@Component({
  selector: 'app-controller-view',
  templateUrl: './controller-view.component.html',
  styleUrls: ['./controller-view.component.css']
})
export class ControllerViewComponent implements OnInit {

  //TODO: If the user has the wrong role or no id, should not be able to be here

  public ships: Observable<Ship[]>;

  constructor(private controllerService: ControllerService,
              private idService: IdService,
              private route: ActivatedRoute,
              private router: Router
  ) {
    if (!idService.checkCorrectId(route) || !idService.checkCorrectRole('controller')) {
      router.navigate(['/'])
    }
    this.ships = this.controllerService.getShips();
  }

  ngOnInit(): void {
    //TODO: Do something with state
    //this.controllerService.getState().subscribe(state => console.log(state))
  }

}
