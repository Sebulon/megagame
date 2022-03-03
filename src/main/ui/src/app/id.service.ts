import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";
import {Links} from "./links";

@Injectable({
  providedIn: 'root'
})
export class IdService {

  constructor(private http: HttpClient) {
  }

  getIds() {
    return this.http.get<{ id: string, role: string }[]>(Links.ids);
  }

  checkCorrectId(route: ActivatedRoute) {
    let id = localStorage.getItem("id");
    return !(id == null || route.snapshot.paramMap.get('id') != id);
  }

  checkCorrectRole(role: string) {
    let expectedRole = localStorage.getItem('role');
    return !(expectedRole == null || expectedRole != role);
  }
}
