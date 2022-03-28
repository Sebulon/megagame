import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerService} from "../../player.service";
import {TeamService} from "../team.service";
import {CdkDragDrop} from '@angular/cdk/drag-drop';
import {Team} from "../../objects/team";
import {Player} from "../../objects/player";

@Component({
  selector: 'app-controller-players',
  templateUrl: './controller-players.component.html',
  styleUrls: ['./controller-players.component.css']
})
export class ControllerPlayersComponent implements OnInit {

  players: Player[] | null = null;
  activePlayers: Player[] | null = null;
  teams: Team[] | null = null;
  selectedTeam: Team | null = null;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private playerService: PlayerService,
    private teamService: TeamService
  ) {
  }

  private updateValues() {
    this.teamService.getTeams().subscribe(data => this.teams = data);
    this.playerService.getPlayers().subscribe(players => {
      this.players = players;
      this.activePlayers = players;
    });
  }

  ngOnInit(): void {
    this.updateValues();
  }


  getIndexes() {
    let rows = Math.max(this.players!!.length, this.teams!!.length);
    return Array(rows).fill(0).map((x, i) => i);
  }

  drop(event: CdkDragDrop<Player[]>) {
    if (event.previousContainer === event.container) {
    } else {
      if (event.container.id.includes('0')) {
        this.change(this.selectedTeam!!.members[event.previousIndex]);
      } else {
        this.change(this.players!![event.previousIndex]);
      }
    }
  }

  change(player: Player) {

    if (this.activePlayers == null || this.selectedTeam == null) return;

    if (this.activePlayers.includes(player)) {
      this.selectedTeam.members.push(player);
      this.activePlayers = this.activePlayers.filter(p => p != player);
    } else {
      this.activePlayers.push(player);
      this.selectedTeam.members = this.selectedTeam.members.filter(p => p != player);
    }
  }

  getPlayers(selectedTeam: Team) {
    this.selectedTeam = selectedTeam;
    this.activePlayers = [];
    for (let i = 0; i < this.players!!.length; i++) {
      let contains = false;
      for (let p of selectedTeam.members) {
        if (p.id == this.players!![i].id) {
          contains = true;
          break;
        }
      }
      if (!contains) this.activePlayers.push(this.players!![i]);
    }
  }

  click(event: MouseEvent) {
    let okClicks = ['list-data', 'list', 'list-container'];
    let classNames = (event.target as Element).className;

    for (let okClick of okClicks) {
      if (classNames.includes(okClick)) return;
    }


    this.teamService.changeTeam(this.selectedTeam!!).subscribe();


    this.updateValues();
    this.selectedTeam = null;
  }
}
