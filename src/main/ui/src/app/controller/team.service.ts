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
    return this.http.get<Team[]>(Links.teams)
  }

  changeTeam(newTeam: Team) {
    return this.http.post(Links.addTeam, newTeam).pipe(
      retry(3),
      catchError(handleError)
    );
  }

  createTeam(newTeam: Team) {
    return this.changeTeam(newTeam);
  }

  deleteTeam(teamName: string) {
    return this.http.delete(Links.deleteTeam(teamName)).pipe(
      retry(3),
      catchError(handleError)
    )
  }
}
