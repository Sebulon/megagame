import {Component, OnInit} from '@angular/core';
import {GalaxyService} from "../galaxy.service";
import {Observable} from "rxjs";
import {SolarSystem} from "../../interfaces/solar-system";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-solar-system',
  templateUrl: './solar-system.component.html',
  styleUrls: ['./solar-system.component.css']
})
export class SolarSystemComponent implements OnInit {

  imgPath = "../../../assets/img/space"
  solarSystem$: Observable<SolarSystem>;

  constructor(private galaxyService: GalaxyService,
              private router: Router,
              private route: ActivatedRoute) {
    this.solarSystem$ = galaxyService.getActiveSolarSystem()
  }

  ngOnInit(): void {
  }

  navigateToShip() {
    this.router.navigate(['ship'], {relativeTo: this.route.parent})
  }
}

