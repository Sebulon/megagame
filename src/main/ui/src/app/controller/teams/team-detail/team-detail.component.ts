import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {Team} from "../../../interfaces/team";
import {TeamService} from "../../team.service";

@Component({
  selector: 'app-team-detail',
  templateUrl: './team-detail.component.html',
  styleUrls: ['./team-detail.component.css']
})
export class TeamDetailComponent implements OnInit {

  team$: Observable<Team> | null = null;

  constructor(private route: ActivatedRoute,
              private teamService: TeamService,
              private router: Router) {
    route.params.subscribe(params => this.team$ = this.teamService.getTeam(params['teamName']));
  }


  ngOnInit(): void {
  }

  navigateToChangeMembers(teamName: string) {
    this.router.navigate([teamName, 'change'], {relativeTo: this.route.parent})
  }

  removeTeam(name: string) {
    this.teamService.deleteTeam(name);
    this.navigateToTeams();
  }

  private navigateToTeams() {
    this.router.navigate(['teams'], {relativeTo: this.route.parent?.parent});
  }
}
