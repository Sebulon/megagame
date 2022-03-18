import {Injectable} from "@angular/core";
import {CanLoad, Route, Router} from "@angular/router";
import {AuthService} from "./auth.service";
import {UserRole} from "../objects/user-role";

@Injectable({providedIn: 'root'})
export class AuthControllerGuard implements CanLoad {
  constructor(private authService: AuthService,
              private router: Router) {
  }

  canLoad(route: Route) {
    let authenticated = checkLogin(this.authService, {role: 'controller'});
    if (!authenticated) this.router.navigate(['login']);
    return authenticated;
  }
}

@Injectable({providedIn: 'root'})
export class AuthPlayerGuard implements CanLoad {
  constructor(private authService: AuthService,
              private router: Router) {
  }

  canLoad(route: Route) {
    let authenticated = checkLogin(this.authService, {role: 'player'});
    if (!authenticated) this.router.navigate(['login']);
    return authenticated;
  }
}

function checkLogin(authService: AuthService, expectedRole: UserRole): boolean {
  return authService.checkCredentials(expectedRole);
}
