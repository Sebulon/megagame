import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerService} from "../../player.service";
import {TeamService} from "../team.service";
import {CdkDragDrop} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-controller-players',
  templateUrl: './controller-players.component.html',
  styleUrls: ['./controller-players.component.css']
})
export class ControllerPlayersComponent implements OnInit {

  players: string[] | null = null;
  teams: string[] | null = null;
  selectedTeam: string | null = null;
  selectedTeamPlayers: string[] | null = null;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private playerService: PlayerService,
    private teamService: TeamService
  ) {
  }

  private updateValues() {
    this.playerService.getPlayers().subscribe(players => this.players = players.map(p => p.id));
    this.teamService.getTeams().subscribe(teams => this.teams = teams.map(t => t.name));
  }

  ngOnInit(): void {
    this.updateValues();
  }


  getIndexes() {
    let rows = Math.max(this.players!!.length, this.teams!!.length);
    return Array(rows).fill(0).map((x, i) => i);
  }

  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
    } else {
      if (event.container.id.includes('0')) {
        this.change(this.selectedTeamPlayers!![event.previousIndex]);
      } else {
        this.change(this.players!![event.previousIndex]);
      }
    }
  }

  change(player: string) {
    if (this.selectedTeamPlayers == null) return;
    if (this.players!!.includes(player)) {
      this.selectedTeamPlayers.push(player);
      this.players = this.players!!.filter(p => p != player);
    } else {
      this.players!!.push(player);
      this.selectedTeamPlayers = this.selectedTeamPlayers.filter(p => p != player);
    }
  }

  getPlayers(selectedTeam: string) {
    this.selectedTeam = selectedTeam;
    this.selectedTeamPlayers = [];
  }

  click(event: MouseEvent) {
    let okClicks = ['list-data', 'list', 'list-container'];
    let classNames = (event.target as Element).className;

    for (let okClick of okClicks) {
      if (classNames.includes(okClick)) return;
    }

    //TODO: Give data to backend
    console.log('Players in team ' + this.selectedTeam + ':')
    this.selectedTeamPlayers!!.forEach(p => console.log(p));


    this.updateValues();
    this.selectedTeam = null;
    this.selectedTeamPlayers = null;
  }
}
