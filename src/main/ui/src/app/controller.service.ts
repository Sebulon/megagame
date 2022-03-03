import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ship} from "./ship";

@Injectable({
  providedIn: 'root'
})
export class ControllerService {

  rootURL = '/api'

  constructor(private http: HttpClient) {
  }

  getShips() {
    return this.http.get<Ship[]>(this.rootURL + '/allShips');
  }

  getState() {
    //TODO: Add a getter for game state
    return null
  }
}
