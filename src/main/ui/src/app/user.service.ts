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

  getUsers() {
    return this.http.get<{ id: string, role: string }[]>(Links.users);
  }

  getId(route: ActivatedRoute) {
    return route.snapshot.paramMap.get('id');
  }
}
