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
  activeTeam: Team | null = null;

  constructor(private teamService: TeamService) {
    this.$teams = teamService.getTeams();
  }

  ngOnInit(): void {
  }

  setActiveTeam(team: Team) {
    if(this.activeTeam != null) {
      const listItem = document.getElementById(this.activeTeam.name);
      if(listItem != null) {
        listItem.classList.remove("active-team");
      }
    }
    this.activeTeam = team;
    const listItem = document.getElementById(this.activeTeam.name);
    if(listItem != null) {
      listItem.classList.add("active-team");
    }
  }
}
