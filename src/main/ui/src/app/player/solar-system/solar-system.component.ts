import {Component, OnInit} from '@angular/core';
import {CelestialObject, GalaxyService} from "../galaxy.service";

@Component({
  selector: 'app-solar-system',
  templateUrl: './solar-system.component.html',
  styleUrls: ['./solar-system.component.css']
})
export class SolarSystemComponent implements OnInit {

  activeGalaxy: CelestialObject[] | null = null

  constructor(private galaxyService: GalaxyService) {
    galaxyService.getActiveSolarSystem().subscribe(galaxy => this.activeGalaxy = galaxy)
  }

  ngOnInit(): void {
  }

}

