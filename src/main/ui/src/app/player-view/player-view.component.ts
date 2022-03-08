import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UsersService} from "../users.service";
import {Observable} from "rxjs";
import {Ship} from "../objects/ship";

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css']
})
export class PlayerViewComponent implements OnInit {

  //TODO: If the user has the wrong role or no id, should not be able to be here


  public ship$: Observable<Ship>;

  constructor(private playerService: PlayerService,
              private usersService: UsersService,
              private route: ActivatedRoute,
              private router: Router) {

    if (!usersService.checkCorrectId(route) || !usersService.checkCorrectRole("player")) {
      router.navigate(['/'])
    }
    this.ship$ = this.playerService.getShip(localStorage.getItem('id')!!)
  }

  ngOnInit(): void {
  }

}
