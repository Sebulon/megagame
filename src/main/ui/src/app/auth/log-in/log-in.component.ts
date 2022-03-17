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
    this.userService.getUsers().subscribe(data => this.gotoNextScreen(id, data));
  }

  gotoNextScreen(id: string, data: { id: string, role: string }[]): void {
    let user = this.getData(id, data);
    if (user == null) {
      // TODO: Id input is wrong, should give feedback to user
      console.log("id is not in system!");
      return;
    }

    // Saves data for future usage
    this.authService.setId(user.id);
    this.authService.setRole(user.role);

    // Routes to a new page (a standard view page for the role)
    this.router.navigate([user.id, user.role + '-view'])
  }

  getData(id: string, data: { id: string, role: string }[]): { id: string, role: string } | null {
    for (let d of data) {
      if (d.id === id) return d;
    }
    return null;
  }

}
