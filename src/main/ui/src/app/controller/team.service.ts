import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) {
  }

  // TODO
  getTeams() {
    return this.http.get<{ name: string }[]>('../../assets/tempTeams.json');
  }
}
