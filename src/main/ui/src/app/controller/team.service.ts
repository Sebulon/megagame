import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
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
    return this.http.get<Team[]>(Links.allTeams)
  }

  changeTeam(newTeam: Team) {
    return this.http.post(Links.teams, newTeam).pipe(
      retry(3),
      catchError(handleError)
    );
  }

  createTeam(newTeam: Team) {
    return this.changeTeam(newTeam);
  }

  deleteTeam(team: Team) {
    return this.http.delete(Links.teams, {body: team}).pipe(
      retry(3),
      catchError(handleError)
    )
  }

  getTeam(name: string) {
    return this.http.get<Team>(Links.team(name));
  }

  addPlayerToTeam(teamName: string, playerId: string) {
    let params = new HttpParams().append('playerId', playerId).append('teamName', teamName);
    return this.http.put(Links.assignPlayer, undefined, {params: params}).pipe(
      retry(3),
      catchError(handleError)
    )
  }

  removePlayerFromTeam(teamName: string, playerId: string) {
    let params = new HttpParams().append('playerId', playerId).append('teamName', teamName);
    return this.http.put(Links.removePlayer, undefined, {params: params}).pipe(
      retry(3),
      catchError(handleError)
    )
  }
}
