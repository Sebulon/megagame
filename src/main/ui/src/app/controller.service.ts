import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ControllerService {

  rootURL = '/api'

  constructor(private http: HttpClient) {
  }

  getState() {
    //TODO: Add a getter for game state
    return null
  }
}
