import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Links} from "./links";
import {Player} from "./objects/player";

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

}
