import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Ship} from "./objects/ship";
import {Links} from "./links";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) {
  }

  getShip(id: string) {
    let queryParams = new HttpParams().append('id', id)

    return this.http.get<Ship>(Links.playerShip, {params: queryParams});
  }
}
