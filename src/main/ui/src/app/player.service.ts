import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Links} from "./links";
import {Player} from "./objects/player";
import {Ship} from "./objects/ship";

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
    return this.http.get<Player[]>(Links.players.all);
  }

  getPlayer(id: string) {
    return this.http.get<Player>(Links.players.get(id));
  }

  getPlayerShip(playerId: string) {
    return this.http.get<Ship>(Links.players.ship(playerId));
  }
}
