import {Component, OnInit} from '@angular/core';
import {Player} from "../../objects/player";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerService} from "../../player.service";
import {TeamService} from "../team.service";

@Component({
  selector: 'app-controller-players',
  templateUrl: './controller-players.component.html',
  styleUrls: ['./controller-players.component.css']
})
export class ControllerPlayersComponent implements OnInit {

  players: Player[] | null = null;
  teams: { name: string }[] | null = null;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private playerService: PlayerService,
    private teamService: TeamService
  ) {
    playerService.getPlayers().subscribe(players => this.players = players);
    teamService.getTeams().subscribe(teams => this.teams = teams);
  }

  ngOnInit(): void {
  }


  getIndexes() {
    let rows = Math.max(this.players!!.length, this.teams!!.length);
    return Array(rows).fill(0).map((x, i) => i);
  }
}
