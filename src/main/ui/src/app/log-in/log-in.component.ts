import {Component, OnInit} from '@angular/core';
import {UsersService} from "../users.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor(
    private usersService: UsersService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(): void {
  }

  submitPlayerID(id: string): void {
    this.usersService.getUsers().subscribe(data => this.gotoNextScreen(id, data));
  }

  gotoNextScreen(id: string, data: { id: string, role: string }[]): void {
    let user = this.getData(id, data);
    if (user == null) {
      //TODO: Id input is wrong, should give feedback to user
      console.log("id is not in system!");
      return;
    }

    // Saves data for future usage
    localStorage.setItem("id", user.id)
    localStorage.setItem("role", user.role)

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
