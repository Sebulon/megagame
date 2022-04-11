import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../player.service";
import {ActivatedRoute} from "@angular/router";
import {Player} from "../../objects/player";
import {Observable} from "rxjs";

@Component({
  selector: 'app-player-welcome',
  templateUrl: './player-welcome.component.html',
  styleUrls: ['./player-welcome.component.css']
})
export class PlayerWelcomeComponent implements OnInit {

  player$: Observable<Player>;

  constructor(private playerService: PlayerService,
              private route: ActivatedRoute) {
    this.player$ = playerService.getPlayer(route.snapshot.paramMap.get('id')!!);
  }

  ngOnInit(): void {
  }

  formatText(text: string) {
    return text.replace(/\.[s]*/g, ". ")
      .replace(/\*\*/g, "<b>")
      .replace(/<b>([^|]*)<b>/g, "<b>$1</b>")
  }
}
