import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../player.service";
import {TeamService} from "../team.service";
import {ShipService} from "../../ship.service";
import {Observable} from "rxjs";
import {Player} from "../../objects/player";
import {Ship} from "../../objects/ship";
import {Team} from "../../objects/team";

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements OnInit {

  players$: Observable<Player[]>;
  ships: Ship[] | null = null;
  teams: Team[] | null = null;

  constructor(private playerService: PlayerService,
              private teamService: TeamService,
              private shipService: ShipService) {
    this.players$ = playerService.getPlayers();
    shipService.getShips().subscribe(ships => this.ships = ships);
    teamService.getTeams().subscribe(teams => this.teams = teams);
  }


  ngOnInit(): void {
  }

  getTeamName(playerId: string) {
    if (this.teams == null) return null;
    let teamsContainingPlayer = this.teams
      .filter(team => team.members.filter(player => player.id == playerId).length > 0)
    if (teamsContainingPlayer.length == 0) return null;
    return teamsContainingPlayer[0].name;
  }

  getShipName(playerId: string) {
    if (this.ships == null) return null;
    let teamName = this.getTeamName(playerId);
    if (teamName == null) return null;
    let shipsContainingTeam = this.ships
      .filter(ship => ship.team?.name == teamName);
    if (shipsContainingTeam.length == 0) return null;
    return shipsContainingTeam[0].name;
  }
}
