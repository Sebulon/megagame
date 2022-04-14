import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Player} from "../../interfaces/player";
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

  getRoleImg(role: string): string  {
    //TODO Make sure these are correct after all roles are implemented
    switch(role) {
      case "Archeologist":
        return "Archeologist.png";
      case "Captain":
        return "Captain.png";
      case "Doctor":
        return "Doctor.png";
      case "Engineer":
        return "Engineer.png";
      case "Resource Officer":
        return "Resource-officer.png";
      case "Scientist":
        return "Scientist.png";
      default:
        return "UN-representative.png";
    }
  }

  formatText(text: string) {
    return text.replace(/\.[s]*/g, ". ")
      .replace(/\*\*/g, "<b>")
      .replace(/<b>([^|]*)<b>/g, "<b>$1</b>")
  }
}
