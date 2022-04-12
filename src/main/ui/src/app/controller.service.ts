import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Links} from "./links";

@Injectable({
  providedIn: 'root'
})
export class ControllerService {

  constructor(private http: HttpClient) {
  }

  getController(id: string) {
    return this.http.get(Links.getController(id), {responseType: "text"})
  }
}
