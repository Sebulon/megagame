import {Component, Inject, OnInit} from '@angular/core';
import {Ship} from "../../objects/ship";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../user.service";
import {ShipService} from "../../ship.service";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {DialogData, ResourceGiftDialog} from "../../player-view/player-view.component";

@Component({
  selector: 'app-controller-ship',
  templateUrl: './controller-ship.component.html',
  styleUrls: ['./controller-ship.component.css']
})
export class ControllerShipComponent implements OnInit {

  public ship: Ship | null = null;
  public hpChange: number | null = null;
  public resources: object | null = null;

  constructor(private shipService: ShipService,
              private route: ActivatedRoute,
              private userService: UserService,
              private router: Router,
              private dialog: MatDialog) {
    if (!userService.checkCredentials(route, {role: 'controller'}).allowed) {
      router.navigate(['/'])
    }
    this.updateShipValues();
  }

  public changeHP(): void {

    if (this.ship == null) return;

    if (this.hpChange == null) {
      console.error("New hp cannot be null!");
      return;
    }

    this.shipService.changeShipHP(this.ship.name, this.hpChange).subscribe();
    this.hpChange = null;
    this.updateShipValues();
  }

  public deleteShip(): void {
    if (this.ship == null) return;

    this.shipService.deleteShip(this.ship.name).subscribe(_ =>
      this.router.navigate(['../'], {relativeTo: this.route})
    );
  }

  /**
   * Call this when in need of updating the values.
   * @private
   */
  private updateShipValues() {
    this.shipService.getShips().subscribe(
      ships => {
        this.ship = ControllerShipComponent.getCurrentShip(ships, this.route.snapshot.paramMap.get('ship'))
        if(this.ship != null)
          this.shipService.getResources(this.ship.name).subscribe(resources => this.resources = resources);
      });
  }

  private static getCurrentShip(ships: Ship[], wantedShip: string | null) {
    if (wantedShip == null) {
      return null;
    }

    for (let ship of ships) {
      if (ship.name == wantedShip) {
        return ship;
      }
    }
    return null;
  }

  public openDialog() {
    if (!this.resources || !this.ship) {
      console.error("Cannot find resources or ship!");
      return;
    }
    let dialogData: DialogData = {resources: this.resources, ship: this.ship};
    const dialogRef = this.dialog.open(ResourceChangeDialog, {
      width: '250px',
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(_ => this.updateValues());
  }

  private updateValues() {
    this.shipService.getResources(this.ship!!.name).subscribe(resources => this.resources = resources);
  }


  ngOnInit(): void {
  }
}

/**
 * Class for dialog box when controller changes resources of a ship
 */
@Component({
  selector: 'resource-change.dialog',
  templateUrl: './resource-change-dialog.html',
  styleUrls: ['./controller-ship.component.css']
})
export class ResourceChangeDialog {
  public ship: Ship | null = null;
  public resourcesToChange = new Map<string, number>();

  constructor(private dialogRef: MatDialogRef<ResourceChangeDialog>,
              private shipService: ShipService,
              @Inject(MAT_DIALOG_DATA) public data: DialogData) {
  }

  onSubmit() {
    this.shipService.changeResources(this.data.ship.name, this.resourcesToChange);
  }
}
