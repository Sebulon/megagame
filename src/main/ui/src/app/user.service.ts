import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";
import {Links} from "./links";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getId(route: ActivatedRoute) {
    return route.snapshot.paramMap.get('id');
  }

  getController(id: string) {
    return this.http.get(Links.getController(id), {responseType: "text"});
  }

  getPlayer(id: string) {
    return this.http.get(Links.getPlayer(id), {responseType: "text"});
  }
}
