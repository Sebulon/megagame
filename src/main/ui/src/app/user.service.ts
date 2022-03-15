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

  checkCredentials(route: ActivatedRoute, userRole: UserRole): { allowed: boolean, id: string } {
    let id = route.snapshot.paramMap.get('id') ?? "";

    let expectedId = localStorage.getItem('id');
    let expectedRole = localStorage.getItem('role');

    let allowed = (id != "" &&
      expectedId != null &&
      expectedRole != null &&
      id == expectedId &&
      userRole.role == expectedRole);

    return {allowed, id};
  }

  setId(id: string) {
    localStorage.setItem('id', id);
  }

  setRole(role: string) {
    localStorage.setItem('role', role);
  }
}
