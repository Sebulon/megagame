import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";
import {Links} from "./links";
import {UserRole} from "./objects/user-role";

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

  getRole(): UserRole | null {
    let tmp = localStorage.getItem('role');
    if (!tmp) return null;
    switch (tmp) {
      case 'controller':
        return {role: 'controller'};
      case 'player':
        return {role: 'player'};
      default:
        throw new Error("Saved role is not a user role!");
    }
  }
}
