import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../user.service";
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
              private userService: UserService,
              private route: ActivatedRoute,
              private router: Router) {

    let {allowed, id} = userService.checkCredentials(route, {role: 'player'});

    if (!allowed) {
      router.navigate(['/'])
    }

    this.playerService.getShip(id).subscribe(ship => {
      this.ship = ship;
      this.playerService.getResources(ship.name).subscribe(resources => this.resources = resources);
    });
  }

  ngOnInit(): void {
  }

}
