import {Injectable} from "@angular/core";
import {UserRole} from "../objects/user-role";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  attemptedUrl: string | null = null;

  setId(id: string) {
    localStorage.setItem('id', id);
  }

  setRole(role: string) {
    localStorage.setItem('role', role);
  }

  checkCredentials(expectedRole: UserRole) {
    if (this.attemptedUrl == null) return false;

    let urlId = this.attemptedUrl.split('/')[1];
    if (urlId != localStorage.getItem('id')) return false;

    return expectedRole.role == localStorage.getItem('role');
  }
}
