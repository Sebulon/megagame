import {Component, OnInit} from '@angular/core';
import {UserService} from "../../user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../auth.service";

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor(
    private userService: UserService,
    private authService: AuthService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(): void {
  }

  submitPlayerID(id: string): void {
    this.userService.getUser(id).subscribe(role => this.gotoNextScreen(id, role));
  }

  gotoNextScreen(id: string, role: string) {
    if (role == "") {
      // TODO: Id input is wrong, should give feedback to user
      console.error("id is not in system!");
      return;
    }

    // Saves data for future usage
    this.authService.setId(id);
    this.authService.setRole(role);

    // Routes to a new page (a standard view page for the role)
    this.router.navigate([id, role + '-view'])
  }
}
