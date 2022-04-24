import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {PlayerService} from "../../player.service";
import {TeamService} from "../team.service";
import {ShipService} from "../../ship.service";
import {Observable} from "rxjs";
import {Player} from "../../interfaces/player";
import {Ship} from "../../interfaces/ship";
import {Team} from "../../interfaces/team";

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements OnInit, AfterViewInit {

  players$: Observable<Player[]>;
  ships: Ship[] | null = null;
  teams: Team[] | null = null;
  isAddingPlayer = false;
  selectedShip: string | null = null;
  id: string | null = null;

  @ViewChild('nameInput') inputElement?: ElementRef;
  @ViewChild('addPlayerField') addPlayerField?: ElementRef;

  constructor(private playerService: PlayerService,
              private teamService: TeamService,
              private shipService: ShipService) {
    this.players$ = playerService.getPlayers();
    shipService.getShips().subscribe(ships => this.ships = ships);
    teamService.getTeams().subscribe(teams => this.teams = teams);
  }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
  }

  getTeamName(playerId: string) {
    if (this.teams == null) return null;
    let teamsContainingPlayer = this.teams
      .filter(team => team.members.filter(player => player.id == playerId).length > 0)
    if (teamsContainingPlayer.length == 0) return null;
    return teamsContainingPlayer[0].name;
  }

  getShipName(playerId: string) {
    let teamName = this.getTeamName(playerId);
    if (teamName == null) return null;
    return this.getShipBasedOnTeam(teamName);
  }

  generateId() {
    const characters = 'abcdefghijklmnopqrstuvwxyz0123456789';
    let result = '';
    for (let i = 0; i < 5; i++) {
      result += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    return result;
  }

  getShipBasedOnTeam(team: string) {
    if (team == null || team == '' || team == '-') return null;
    if (this.ships == null) return null;

    let shipsContainingTeam = this.ships
      .filter(ship => ship.team?.name == team);
    if (shipsContainingTeam.length == 0) return null;
    return shipsContainingTeam[0].name;
  }

  addPlayer() {
    this.addPlayerField!!.nativeElement.hidden = false;
    this.id = this.generateId();
    this.inputElement!!.nativeElement.focus();
  }

  createPlayer(id: string, name: string, teamName: string) {
    let player: Player = {id: id, name: name};
    let members = this.teams?.find(team => team.name == teamName)?.members;

    this.playerService.createPlayer(player);

    this.id = this.generateId();
    if (!members) return;

    members.push(player);
    this.teamService.changeTeamMembers(teamName, members).subscribe();
  }

  deletePlayer(player: Player) {
    this.playerService.deletePlayer(player.id);
  }
}
