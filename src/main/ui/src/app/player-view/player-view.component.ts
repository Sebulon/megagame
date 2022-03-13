import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UsersService} from "../users.service";
import {Ship} from "../objects/ship";

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css']
})
export class PlayerViewComponent implements OnInit {

  public ship: Ship | null = null;
  public resources: object | null = null;

  constructor(private playerService: PlayerService,
              private usersService: UsersService,
              private route: ActivatedRoute,
              private router: Router) {

    // TODO: Make these into one function
    if (!usersService.checkCorrectId(route) || !usersService.checkCorrectRole("player")) {
      router.navigate(['/'])
    }

    let id = localStorage.getItem('id');
    if (id == null) {
      return;
    }

    this.playerService.getShip(id).subscribe(ship => {
      this.ship = ship;
      this.playerService.getResources(ship.name).subscribe(resources => this.resources = resources);
    });
  }

  ngOnInit(): void {
  }

}
