import {Component, OnInit} from '@angular/core';
import {TeamService} from "../team.service";
import {Observable} from "rxjs";
import {Team} from "../../interfaces/team";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

  teams$: Observable<Team[]>;

  constructor(private teamService: TeamService,
              private router: Router,
              private route: ActivatedRoute) {
    this.teams$ = teamService.getTeams();
  }

  ngOnInit(): void {
  }

  goToDetail(teamName: string) {
    this.router.navigate([teamName, 'details'], {relativeTo: this.route})
  }

  createTeam(teamNameInput: HTMLInputElement) {
    // TODO: add ability to create team with members
    // TODO: add actual feedback to users when cannot create team

    if (!/^[a-zA-Z].*/gm.test(teamNameInput.value)) {
      console.warn("The team name " + teamNameInput.value + " does not start with a letter!");
      return;
    }

    let newTeam: Team = {name: teamNameInput.value, members: []}
    this.teams$.subscribe(teams => {
      if (teams.find(team => team.name == teamNameInput.value)) {
        console.warn("Teams cannot have the same name!");
        return;
      }
      this.teamService.addTeam(newTeam);
      teamNameInput.value = '';
    }).unsubscribe()
  }
}
