import {Component, OnInit} from '@angular/core';
import {TeamService} from "../team.service";
import {Observable} from "rxjs";
import {Team} from "../../objects/team";

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

  $teams: Observable<Team[]>;

  constructor(private teamService: TeamService) {
    this.$teams = teamService.getTeams();
  }

  ngOnInit(): void {
  }

}
