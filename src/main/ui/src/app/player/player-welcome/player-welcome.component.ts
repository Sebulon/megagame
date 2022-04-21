import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Player} from "../../interfaces/player";
import {Observable} from "rxjs";
import {RoleService} from "../role.service";
import {TextFormatService} from "../../text-format.service";

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
              private textFormatService: TextFormatService,
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

  formatText(text: string) {
    return this.textFormatService.convertFromMarkdownToHtml(text);
  }

  private navigateToRoleSelection() {
    this.router.navigate(['role-selector'], {relativeTo: this.route.parent})
  }
}
