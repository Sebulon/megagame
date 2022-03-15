import {Component, OnInit} from '@angular/core';
import {Player} from "../../objects/player";
import {Observable} from "rxjs";
import {UserService} from "../../user.service";
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
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute,
    private playerService: PlayerService
  ) {
    if (!userService.checkCredentials(route, {role: 'controller'}).allowed) {
      router.navigate(['/']);
    }

    this.players = playerService.getPlayers();
  }

  ngOnInit(): void {
  }

}
