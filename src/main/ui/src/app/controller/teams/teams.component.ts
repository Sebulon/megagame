import {Component, OnInit} from '@angular/core';
import {TeamService} from "../team.service";
import {Observable} from "rxjs";
import {Team} from "../../objects/team";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

  $teams: Observable<Team[]>;

  constructor(private teamService: TeamService,
              private router: Router,
              private route: ActivatedRoute) {
    this.$teams = teamService.getTeams();
  }

  ngOnInit(): void {
  }

  goToDetail(teamName: string) {
    this.router.navigate([teamName, 'details'], {relativeTo: this.route})
  }

}
