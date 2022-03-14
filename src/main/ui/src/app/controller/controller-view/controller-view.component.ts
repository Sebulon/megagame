import {Component, OnInit} from '@angular/core';
import {UserService} from "../../user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-controller-view',
  templateUrl: './controller-view.component.html',
  styleUrls: ['./controller-view.component.css']
})
export class ControllerViewComponent implements OnInit {

  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private router: Router) {

    if (!userService.checkCredentials(route, {role: 'controller'}).allowed) {
      router.navigate(['/'])
    }

  }

  ngOnInit(): void {
    //TODO: Do something with state
    //this.controllerService.getState().subscribe(state => console.log(state))
  }
}
