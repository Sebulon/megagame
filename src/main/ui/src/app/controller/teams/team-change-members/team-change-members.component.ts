import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../../player.service";
import {TeamService} from "../../team.service";
import {Team} from "../../../objects/team";
import {Player} from "../../../objects/player";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-team-change-members',
  templateUrl: './team-change-members.component.html',
  styleUrls: ['./team-change-members.component.css']
})
export class TeamChangeMembersComponent implements OnInit {

  teams?: Team[];
  currentTeam?: Team;
  allPlayers?: Player[];

  constructor(private playerService: PlayerService,
              private teamService: TeamService,
              private route: ActivatedRoute) {
    playerService.getPlayers().subscribe(players => this.allPlayers = players);

    let teamName = route.snapshot.paramMap.get("teamName")!!;
    teamService.getTeams().subscribe(teams => {
      this.teams = teams;
      this.currentTeam = teams.find(team => team.name == teamName);
    })
  }

  getAvailablePlayers() {
    if (!this.teams || !this.allPlayers) return null;

    let availablePlayers = this.allPlayers.slice()
    for (let team of this.teams) {
      for (let player of team.members) {
        let indexToRemove = availablePlayers.findIndex(player1 => player1.id == player.id);
        if (indexToRemove == -1) continue;
        availablePlayers.splice(indexToRemove, 1);
      }
    }
    return availablePlayers;
  }

  ngOnInit(): void {
  }

}
