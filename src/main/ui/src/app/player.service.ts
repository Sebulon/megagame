import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ship} from "./objects/ship";
import {Links} from "./links";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) {
  }

  getShip(id: string) {
    return this.http.get<Ship>(Links.playerShip(id));
  }
}
