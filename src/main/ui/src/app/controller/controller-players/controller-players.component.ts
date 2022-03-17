import {Component, OnInit} from '@angular/core';
import {Player} from "../../objects/player";
import {Observable} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerService} from "../../player.service";

@Component({
  selector: 'app-controller-players',
  templateUrl: './controller-players.component.html',
  styleUrls: ['./controller-players.component.css']
})
export class ControllerPlayersComponent implements OnInit {

  players: Observable<Player[]>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private playerService: PlayerService
  ) {
    this.players = playerService.getPlayers();
  }

  ngOnInit(): void {
  }

}
