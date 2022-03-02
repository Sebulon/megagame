import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../player.service";
import {UserDataService} from "../user-data.service";

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css']
})
export class PlayerViewComponent implements OnInit {

  //TODO: If the user has the wrong role or no id, should not be able to be here


  public ship$;

  constructor(private playerService: PlayerService, private userDataService: UserDataService) {
    let id = this.userDataService.getId();
    if (id == null) {
      //TODO: Should not be able to reach here
      console.log("The player has no id");
      this.ship$ = null
    } else {
      this.ship$ = this.playerService.getShip(id)
    }
  }

  ngOnInit(): void {
  }

}
