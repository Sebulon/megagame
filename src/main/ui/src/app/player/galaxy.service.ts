import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SolarSystem} from "../interfaces/solar-system";
import {Links} from "../links";

@Injectable({
  providedIn: 'root'
})
export class GalaxyService {

  constructor(private http: HttpClient) {
  }

  getActiveSolarSystem() {
    return this.http.get<SolarSystem>(Links.space.currentSolarSystem);
  }
}
