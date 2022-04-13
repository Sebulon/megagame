import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Links} from "../links";
import {Team} from "../objects/team";
import {catchError, map, retry, switchMap, take} from "rxjs/operators";
import {handleError} from "../errorHandler";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private teams$ = new BehaviorSubject<Team[]>([]);

  constructor(private http: HttpClient) {
  }

  getTeams() {
    this.http.get<Team[]>(Links.teams.all).subscribe(teams => this.teams$.next(teams))
    return this.teams$.asObservable();
  }

  addTeam(newTeam: Team) {
    this.teams$.pipe(
      take(1),
      switchMap(teams => this.http.post(Links.teams.post, newTeam).pipe(
        map(() => [...teams, newTeam])
      ))
    ).subscribe(teams => this.teams$.next(teams))
  }

  deleteTeam(team: string) {
    this.teams$.pipe(
      take(1),
      switchMap(teams => this.http.delete(Links.teams.delete(team)).pipe(
        map(() => teams.filter(t1 => t1.name != team))
      ))
    ).subscribe(teams => this.teams$.next(teams))
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
