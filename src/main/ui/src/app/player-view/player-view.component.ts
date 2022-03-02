import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {IdService} from "../id.service";
import {Observable} from "rxjs";
import {Ship} from "../ship";

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css']
})
export class PlayerViewComponent implements OnInit {

  //TODO: If the user has the wrong role or no id, should not be able to be here


  public ship$: Observable<Ship>;

  constructor(private playerService: PlayerService,
              private idService: IdService,
              private route: ActivatedRoute,
              private router: Router) {

    if (!idService.checkCorrectId(route) || !idService.checkCorrectRole("player")) {
      router.navigate(['/'])
    }
    this.ship$ = this.playerService.getShip(localStorage.getItem('id')!!)
  }

  ngOnInit(): void {
  }

}
