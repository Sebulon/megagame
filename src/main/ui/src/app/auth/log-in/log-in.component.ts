import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../auth.service";
import {PlayerService} from "../../player.service";
import {ControllerService} from "../../controller.service";

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor(
    private authService: AuthService,
    private playerService: PlayerService,
    private controllerService: ControllerService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(): void {

    // Sets up enter as a valid button to submit pin code
    const input = document.getElementById("player-id");
    if (input != null) {
      input.addEventListener("keyup", function (event) {
        if (event.keyCode === 13){
          event.preventDefault();
          const button = document.getElementById("submit-player-id");
          if (button != null){
            button.click();
          }
        }
      });
    }
  }

  submitID(id: string): void {
    this.controllerService.getController(id).subscribe(data => {
      if (data == null || data == "") {
        this.gotoNextScreenPlayer(id);
        return;
      }
      this.gotoNextScreen(id, "controller");
    })
  }

  private gotoNextScreenPlayer(id: string) {
    this.playerService.getPlayer(id).subscribe(data => {
      if (data == null) {
        LogInComponent.wrongId(id);
        return;
      }
      this.gotoNextScreen(id, "player");
    })
  }

  private static wrongId(id: string) {
    // TODO: Id input is wrong, should give feedback to user
    console.error("The id " + id + " is not in system!");
  }

  private gotoNextScreen(id: string, role: string) {
    // Saves data for future usage
    this.authService.setId(id);
    this.authService.setRole(role);

    // Routes to a new page (a standard view page for the role)
    this.router.navigate([id, role + '-view'])
  }
}
