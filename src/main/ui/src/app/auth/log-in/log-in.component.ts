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

  submitID(id: string): void {
    this.userService.getController(id).subscribe(data => {
      if (data == null || data == "") {
        this.gotoNextScreenPlayer(id);
        return;
      }
      this.gotoNextScreen(id, "controller");
    })
  }

  private gotoNextScreenPlayer(id: string) {
    this.userService.getPlayer(id).subscribe(data => {
      if (data == null || data == "") {
        LogInComponent.wrongId(id);
        return;
      }
      this.gotoNextScreen(id, "player");
    })
  }

  private static wrongId(id: string) {
    // TODO: Id input is wrong, should give feedback to user
    console.error("The id " + id + " is not in system!");
  }

  private gotoNextScreen(id: string, role: string) {
    // Saves data for future usage
    this.authService.setId(id);
    this.authService.setRole(role);

    // Routes to a new page (a standard view page for the role)
    this.router.navigate([id, role + '-view'])
  }
}
