import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Links} from "../links";
import {Team} from "../objects/team";
import {catchError, retry} from "rxjs/operators";
import {handleError} from "../errorHandler";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) {
  }

  getTeams() {
    return this.http.get<Team[]>(Links.teams.all)
  }

  createTeam(newTeam: Team) {
    return this.http.post(Links.teams.post, newTeam).pipe(
      retry(3),
      catchError(handleError)
    );
  }

  deleteTeam(team: string) {
    return this.http.delete(Links.teams.delete(team)).pipe(
      retry(3),
      catchError(handleError)
    )
  }

  getTeam(name: string) {
    return this.http.get<Team>(Links.teams.get(name));
  }

  changeTeamMembers(teamName: string, newMembers: string[]) {
    return this.http.put(Links.teams.change(teamName), newMembers).pipe(
      retry(3),
      catchError(handleError)
    )
  }
}
