import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerService} from "../../player.service";
import {TeamService} from "../team.service";
import {CdkDragDrop} from '@angular/cdk/drag-drop';
import {Team} from "../../objects/team";
import {Player} from "../../objects/player";
import {Observable} from "rxjs";

@Component({
  selector: 'app-controller-players',
  templateUrl: './controller-players.component.html',
  styleUrls: ['./controller-players.component.css']
})
export class ControllerPlayersComponent implements OnInit {

  players$: Observable<Player[]>
  teamPlayers: Player[] | null = null;
  otherPlayers: Player[] | null = null;
  teams$: Observable<Team[]>
  selectedTeam: Team | null = null;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private playerService: PlayerService,
    private teamService: TeamService
  ) {
    this.teams$ = teamService.getTeams();
    this.players$ = playerService.getPlayers();
  }

  ngOnInit(): void {
  }

  // Functionality for the drop mechanic
  drop(event: CdkDragDrop<Player[] | null>) {
    if (event.previousContainer === event.container) return;

    if (event.container.id.includes('0')) {
      this.change(this.teamPlayers!![event.previousIndex]);
    } else {
      this.change(this.otherPlayers!![event.previousIndex]);
    }
  }

  // Change player between a team and active pool
  change(player: Player) {

    if (this.teamPlayers == null || this.otherPlayers == null) return;

    if (this.otherPlayers.filter(p => p.id == player.id).length > 0) {
      this.teamPlayers.push(player);
      this.otherPlayers = this.otherPlayers.filter(p => p.id != player.id);
    } else {
      this.otherPlayers.push(player);
      this.teamPlayers = this.teamPlayers.filter(p => p.id != player.id);
    }
  }

  // When a click occurs, check if the click was on the list or on the background
  // If a click occurs outside, update values in backend
  click(event: MouseEvent) {

    if (this.selectedTeam == null) return;

    let okClicks = ['list-data', 'list', 'list-container'];
    let classNames = (event.target as Element).className;

    for (let okClick of okClicks) {
      if (classNames.includes(okClick)) return;
    }


    this.teamService.getTeam(this.selectedTeam.name).subscribe(team => {
      if (this.teamPlayers == null) return;

      let bothContains = team.members.filter(p => this.teamPlayers?.filter(p1 => p1.id == p.id).length != 0);
      let toRemove = team.members.filter(p => bothContains.filter(p1 => p1.id == p.id).length == 0);
      let toAdd = this.teamPlayers.filter(p => bothContains.filter(p1 => p1.id == p.id).length == 0);

      for (let p of toAdd) {
        this.teamService.addPlayerToTeam(team.name, p.id).subscribe();
      }
      for (let p of toRemove) {
        this.teamService.removePlayerFromTeam(team.name, p.id).subscribe();
      }
      this.selectedTeam = null;
    })
  }

  createNewTeam(value: string) {
    let tempTeam: Team = {name: value, members: []}
    this.teamService.createTeam(tempTeam).subscribe()
  }

  deleteActiveTeam() {
    if (!this.selectedTeam) {
      return
    }

    this.teamService.deleteTeam(this.selectedTeam).subscribe(_ => this.selectedTeam = null);
  }

  // Sets active team and players that is not taken yet
  setActiveTeam(team: Team) {
    this.teamService.getTeam(team.name).subscribe(team => {
      this.selectedTeam = team;
      this.teamPlayers = team.members;
      this.players$.subscribe(players => {
        this.teams$.subscribe(teams => {
          this.otherPlayers = players;
          for (let currentTeam of teams) {
            this.otherPlayers = this.otherPlayers.filter(p => currentTeam.members.filter(p1 => p1.id == p.id).length == 0)
          }
        })
      })
    })
  }
}
