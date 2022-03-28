import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Links} from "../links";
import {Team} from "../objects/team";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) {
  }

  getTeams() {
    return this.http.get<Team[]>(Links.teams);
  }
}
