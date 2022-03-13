import {Component, OnInit} from '@angular/core';
import {Player} from "../../objects/player";
import {Observable} from "rxjs";
import {UserService} from "../../user.service";
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
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute,
    private controllerService: ControllerService
  ) {
    if (!userService.checkCredentials(route, {role: 'controller'}).allowed) {
      router.navigate(['/']);
    }

    this.players = controllerService.getPlayers();
  }

  ngOnInit(): void {
  }

}
