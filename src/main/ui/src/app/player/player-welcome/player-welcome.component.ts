import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../player.service";
import {Role} from "../../objects/role";
import {UserService} from "../../user.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-player-welcome',
  templateUrl: './player-welcome.component.html',
  styleUrls: ['./player-welcome.component.css']
})
export class PlayerWelcomeComponent implements OnInit {

  role: Role | null = null;
  backstory: string | null = null;

  constructor(private playerService: PlayerService,
              private userService: UserService,
              private route: ActivatedRoute) {
    playerService.getRole(userService.getId(route)!!).subscribe(role => this.role = role[Math.floor(Math.random() * role.length)]);
    playerService.getBackstory().subscribe(story => this.backstory = story);
  }

  ngOnInit(): void {
  }
}
