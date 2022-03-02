import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  rootURL = '/api'

  constructor(private http: HttpClient) {
  }

  getShip(id: string) {
    let queryParams = new HttpParams().append('id', id)
    return this.http.get(this.rootURL + '/playerShip', {params: queryParams});
  }
}
