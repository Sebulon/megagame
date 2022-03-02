import {Component, OnInit} from '@angular/core';
import {ControllerService} from "../controller.service";
import {IdService} from "../id.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-controller-view',
  templateUrl: './controller-view.component.html',
  styleUrls: ['./controller-view.component.css']
})
export class ControllerViewComponent implements OnInit {

  //TODO: If the user has the wrong role or no id, should not be able to be here

  constructor(private controllerService: ControllerService,
              private idService: IdService,
              private route: ActivatedRoute,
              private router: Router
  ) {
    if (!idService.checkCorrectId(route) || !idService.checkCorrectRole("controller")) {
      router.navigate(['/'])
    }
  }

  ngOnInit(): void {
    //TODO: Do something with state
    //this.controllerService.getState().subscribe(state => console.log(state))
  }

}
