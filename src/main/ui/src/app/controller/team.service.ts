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
    return this.http.get<Team[]>(Links.teams.all)
  }

  createTeam(newTeam: Team) {
    return this.http.post(Links.teams.post, newTeam).pipe(
      retry(3),
      catchError(handleError)
    );
  }

  deleteTeam(team: Team) {
    return this.http.delete(Links.teams.delete, {body: team}).pipe(
      retry(3),
      catchError(handleError)
    )
  }

  getTeam(name: string) {
    return this.http.get<Team>(Links.teams.get(name));
  }

  addPlayerToTeam(teamName: string, playerId: string) {
    let params = new HttpParams().append('playerId', playerId).append('teamName', teamName);
    return this.http.put(Links.teams.assignPlayer, undefined, {params: params}).pipe(
      retry(3),
      catchError(handleError)
    )
  }

  removePlayerFromTeam(teamName: string, playerId: string) {
    let params = new HttpParams().append('playerId', playerId).append('teamName', teamName);
    return this.http.put(Links.teams.removePlayer, undefined, {params: params}).pipe(
      retry(3),
      catchError(handleError)
    )
  }

  changeTeam(changedTeam: Team) {
    return this.http.put(Links.teams.change, changedTeam).pipe(
      retry(3),
      catchError(handleError)
    )
  }
}
