import {Component, OnInit} from '@angular/core';
import {ControllerService} from "../../controller.service";
import {UsersService} from "../../users.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-controller-view',
  templateUrl: './controller-view.component.html',
  styleUrls: ['./controller-view.component.css']
})
export class ControllerViewComponent implements OnInit {

  constructor(private controllerService: ControllerService,
              private usersService: UsersService,
              private route: ActivatedRoute,
              private router: Router) {

    if (!usersService.checkCorrectId(route) || !usersService.checkCorrectRole('controller')) {
      router.navigate(['/'])
    }

  }

  ngOnInit(): void {
    //TODO: Do something with state
    //this.controllerService.getState().subscribe(state => console.log(state))
  }
}
