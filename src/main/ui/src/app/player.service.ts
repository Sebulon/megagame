import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Ship} from "./ship";
import {Links} from "./links";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  rootURL = '/api'

  constructor(private http: HttpClient) {
  }

  getShip(id: string) {
    let queryParams = new HttpParams().append('id', id)

    return this.http.get<Ship>(this.rootURL + Links.playerShip, {params: queryParams});
  }
}
