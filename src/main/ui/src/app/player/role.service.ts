import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Role} from "../interfaces/role";
import {Links} from "../links";

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private http: HttpClient) {
  }

  getRole(role: string) {
    return this.http.get<Role>(Links.roles.get(role));
  }

  getRoles() {
    return this.http.get<Role[]>(Links.roles.all);
  }
}
