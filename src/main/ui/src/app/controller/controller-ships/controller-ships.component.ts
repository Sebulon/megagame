import {Component, OnInit} from '@angular/core';
import {emptyShip, Ship} from "../../interfaces/ship";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {ShipService} from "../../ship.service";
import {Team} from "../../interfaces/team";
import {TeamService} from "../team.service";

@Component({
  selector: 'app-controller-ships',
  templateUrl: './controller-ships.component.html',
  styleUrls: ['./controller-ships.component.css']
})
export class ControllerShipsComponent implements OnInit {

  public ships?: Ship[];
  public shipConstructor = this.formBuilder.group(new emptyShip())
  public teams?: Team[];

  constructor(private shipService: ShipService,
              private teamService: TeamService,
              private route: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder
  ) {
    this.shipService.getShips().subscribe(ships => this.ships = ships);
    this.shipConstructor.reset();
    teamService.getTeams().subscribe(teams => this.teams = teams);
  }

  ngOnInit(): void {
  }

  /**
   * Creates a ship and gives the ship to the backend.
   * Also updates the list of all ships.
   */
  onSubmit(): void {

    if (this.shipConstructor.invalid) {
      console.warn("All data fields are not filled!");
      return;
    }

    let newShip = this.shipConstructor.value as Ship;

    this.shipService.addShip(newShip).subscribe(_ => this.shipService.getShips().subscribe(ships => this.ships = ships));
    this.shipConstructor.reset();
  }

  getAcceptableTeams() {
    return this.teams?.filter(team => !this.ships?.find(ship => ship.team?.name == team.name))
  }
}
