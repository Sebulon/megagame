import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Links} from "./links";
import {Player} from "./objects/player";
import {Role} from "./objects/role";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) {
  }

  /**
   * Get all players that the backend knows of.
   */
  getPlayers() {
    return this.http.get<Player[]>(Links.users + '/player');
  }

  getRole(id: string) {
    //TODO
    return this.http.get<Role[]>('../assets/temp.json');
  }

  getBackstory() {
    //TODO
    return this.http.get('../assets/backstory.html', {responseType: 'text'});
  }
}
