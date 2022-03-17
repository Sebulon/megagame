import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../user.service";
import {Ship} from "../../objects/ship";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {ShipService} from "../../ship.service";

export interface DialogData {
  resources: object,
  ship: Ship
}

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css']
})
export class PlayerViewComponent implements OnInit {

  public ship: Ship | null = null;
  public resources: object | null = null;
  private id: string;

  constructor(private shipService: ShipService,
              private userService: UserService,
              private route: ActivatedRoute,
              private router: Router,
              private dialog: MatDialog) {
    this.id = userService.getId(route)!!;
  }


  public openDialog() {
    if (!this.resources || !this.ship) {
      console.error("Cannot find resources or ship!");
      return;
    }
    let dialogData: DialogData = {resources: this.resources, ship: this.ship};
    const dialogRef = this.dialog.open(ResourceGiftDialog, {
      width: '250px',
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(_ => this.updateValues());
  }

  ngOnInit(): void {
    this.updateValues();
  }

  private updateValues() {
    this.shipService.getShip(this.id).subscribe(ship => {
      this.ship = ship;
      this.shipService.getResources(ship.name).subscribe(resources => this.resources = resources);
    });
  }

}


/**
 * Class for dialog box when gifting resources
 */
@Component({
  selector: 'resource-gift-dialog',
  templateUrl: './resource-gift-dialog.html',
  styleUrls: ['./player-view.component.css']
})
export class ResourceGiftDialog {
  public ships: Ship[] | null = null;
  public resourcesToGive = new Map<string, number>();
  public selectedShip: string | null = null;

  constructor(private dialogRef: MatDialogRef<ResourceGiftDialog>,
              private shipService: ShipService,
              @Inject(MAT_DIALOG_DATA) public data: DialogData) {
    shipService.getShips().subscribe(ships => this.ships = ships.filter(s => s.name != data.ship.name));
  }

  onSubmit() {
    if (!this.selectedShip) {
      console.warn('There is no selected ship!');
      return;
    }
    this.shipService.sendResources(this.data.ship.name, this.selectedShip, this.resourcesToGive)
      .subscribe(_ => this.dialogRef.close());
  }
}
