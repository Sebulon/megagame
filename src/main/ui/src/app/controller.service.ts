import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ship} from "./ship";
import {Links} from "./links";

@Injectable({
  providedIn: 'root'
})
export class ControllerService {

  rootURL = '/api'

  constructor(private http: HttpClient) {
  }

  getShips() {
    return this.http.get<Ship[]>(this.rootURL + Links.ships);
  }

  getState() {
    //TODO: Add a getter for game state
    return null
  }
}
