import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Links} from "./links";
import {Player} from "./interfaces/player";
import {Ship} from "./interfaces/ship";
import {BehaviorSubject} from "rxjs";
import {map, switchMap, take} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private players$ = new BehaviorSubject<Player[]>([])

  constructor(private http: HttpClient) {
  }

  /**
   * Get all players that the backend knows of.
   */
  getPlayers() {
    this.http.get<Player[]>(Links.players.all).subscribe(players => this.players$.next(players));
    return this.players$.asObservable();
  }

  getPlayer(id: string) {
    return this.http.get<Player>(Links.players.get(id));
  }

  getPlayerShip(playerId: string) {
    return this.http.get<Ship>(Links.players.ship(playerId));
  }

  createPlayer(player: Player) {
    this.players$.pipe(
      take(1),
      switchMap(players => this.http.post(Links.players.create, player).pipe(
        map(() => [...players, player])
      ))
    ).subscribe(players => this.players$.next(players));
  }

  deletePlayer(id: string) {
    this.players$.pipe(
      take(1),
      switchMap(players => this.http.delete(Links.players.delete(id)).pipe(
        map(() => players.filter(player => player.id != id))
      ))
    ).subscribe(teams => this.players$.next(teams))
  }

  setRole(id: string, roleName: string) {
    return this.http.put(Links.players.setRole(id), roleName);
  }
}
