import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../../player.service";
import {TeamService} from "../../team.service";
import {Team} from "../../../objects/team";
import {Player} from "../../../objects/player";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-team-change-members',
  templateUrl: './team-change-members.component.html',
  styleUrls: ['./team-change-members.component.css']
})
export class TeamChangeMembersComponent implements OnInit {

  teamName: string;
  availablePlayers?: Player[];
  currentPlayers?: Player[];

  constructor(private playerService: PlayerService,
              private teamService: TeamService,
              private route: ActivatedRoute,
              private router: Router) {
    this.teamName = route.snapshot.paramMap.get("teamName")!!;

    playerService.getPlayers().subscribe(
      players => teamService.getTeams().subscribe(
        teams => {
          this.currentPlayers = teams.find(team => this.teamName == team.name)!!.members;
          this.getAvailablePlayers(teams, players);
        }
      )
    );
  }

  private getAvailablePlayers(teams: Team[], players: Player[]) {
    let availablePlayers = players.slice()
    for (let team of teams) {
      for (let player of team.members) {
        let indexToRemove = availablePlayers.findIndex(player1 => player1.id == player.id);
        if (indexToRemove == -1) continue;
        availablePlayers.splice(indexToRemove, 1);
      }
    }
    this.availablePlayers = availablePlayers;
  }

  change(player: Player) {
    let i0 = this.currentPlayers!!.findIndex(p1 => p1.id == player.id);
    let i1 = this.availablePlayers!!.findIndex(p1 => p1.id == player.id);

    if (i0 == -1) {
      this.currentPlayers?.push(player);
      this.availablePlayers?.splice(i1, 1);
      return;
    }

    this.availablePlayers?.push(player);
    this.currentPlayers?.splice(i0, 1);
  }

  finish() {
    this.teamService.changeTeamMembers(this.teamName, this.currentPlayers!!.map(player => player.id)).subscribe(_ =>
      this.router.navigate([this.teamName, 'details'], {relativeTo: this.route.parent})
    );
  }

  ngOnInit(): void {
  }

}
