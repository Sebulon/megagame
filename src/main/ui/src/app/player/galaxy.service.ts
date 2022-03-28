import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class GalaxyService {

  constructor(private http: HttpClient) { }

  getActiveSolarSystem() {
    //TODO
    return this.http.get<CelestialObject[]>('../assets/solarSystem.json');
  }
}

export interface CelestialObject {
  type: string,
  size: number,
  features: Feature[]
}

interface Feature {
  name: string,
  description: string
}
