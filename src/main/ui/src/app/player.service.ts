import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Links} from "./links";
import {Player} from "./interfaces/player";
import {Ship} from "./interfaces/ship";

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

  createPlayer(player: Player) {
    return this.http.post(Links.players.create, player);
  }

  deletePlayer(id: string) {
    return this.http.delete(Links.players.delete(id));
  }

  setRole(id: string, roleName: string) {
    return this.http.put(Links.players.setRole(id), roleName);
  }
}
