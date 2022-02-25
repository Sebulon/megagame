import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class IdService {

  constructor(private http: HttpClient) {
  }

  getIds() {
    return this.http.get<{id: string, role: string}[]>('/assets/temp.json');
  }

}
