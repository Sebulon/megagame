import {Component, OnInit} from '@angular/core';
import {Player} from "../../objects/player";
import {Observable} from "rxjs";
import {UsersService} from "../../users.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ControllerService} from "../../controller.service";

@Component({
  selector: 'app-controller-players',
  templateUrl: './controller-players.component.html',
  styleUrls: ['./controller-players.component.css']
})
export class ControllerPlayersComponent implements OnInit {

  players: Observable<Player[]>;

  constructor(
    private usersService: UsersService,
    private router: Router,
    private route: ActivatedRoute,
    private controllerService: ControllerService
  ) {
    if (!usersService.checkCorrectId(route) || !usersService.checkCorrectRole('controller')) {
      router.navigate(['/']);
    }

    this.players = controllerService.getPlayers();
  }

  ngOnInit(): void {
  }

}
