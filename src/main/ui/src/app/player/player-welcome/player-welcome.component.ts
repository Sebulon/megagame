import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Player} from "../../interfaces/player";
import {Observable} from "rxjs";
import {RoleService} from "../role.service";

@Component({
  selector: 'app-player-welcome',
  templateUrl: './player-welcome.component.html',
  styleUrls: ['./player-welcome.component.css']
})
export class PlayerWelcomeComponent implements OnInit {

  player$: Observable<Player>;
  description?: string;
  miniGameDescription?: string;

  constructor(private playerService: PlayerService,
              private roleService: RoleService,
              private router: Router,
              private route: ActivatedRoute) {
    this.player$ = playerService.getPlayer(route.snapshot.paramMap.get('id')!!);
    this.player$.subscribe(player => {
      if (player.role == "" || player.role == null) {
        this.navigateToRoleSelection();
        return;
      }
      roleService.getRole(player.role).subscribe(role => {
        this.description = role.description;
        this.miniGameDescription = role.miniGameDescription;
      });
    })
  }

  ngOnInit(): void {
  }

  getRoleImg(role?: string): string {
    //TODO Make sure these are correct after all roles are implemented
    switch (role) {
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

  private navigateToRoleSelection() {
    this.router.navigate(['role-selector'], {relativeTo: this.route.parent})
  }
}
