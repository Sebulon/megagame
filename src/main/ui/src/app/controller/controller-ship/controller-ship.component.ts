import {Component, Inject, OnInit} from '@angular/core';
import {Ship} from "../../interfaces/ship";
import {ActivatedRoute, Router} from "@angular/router";
import {ShipService} from "../../ship.service";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {Observable} from "rxjs";

@Component({
  selector: 'app-controller-ship',
  templateUrl: './controller-ship.component.html',
  styleUrls: ['./controller-ship.component.css']
})
export class ControllerShipComponent implements OnInit {
  //TODO: Make ship see all resources that are in circulation

  public ship$: Observable<Ship>;
  public hpChange: number | null = null;
  private readonly shipName: string;

  constructor(private shipService: ShipService,
              private route: ActivatedRoute,
              private router: Router,
              private dialog: MatDialog) {
    this.shipName = this.route.snapshot.paramMap.get('ship')!!;
    this.ship$ = shipService.getShip(this.shipName);
  }

  public changeHP(): void {

    if (this.hpChange == null) {
      console.error("New hp cannot be null!");
      return;
    }

    this.shipService.changeShipHP(this.shipName, this.hpChange).subscribe();
    this.hpChange = null;
  }

  public deleteShip(): void {
    this.shipService.deleteShip(this.shipName).subscribe(_ =>
      this.router.navigate(['../'], {relativeTo: this.route})
    );
  }

  public openDialog() {
    this.ship$.subscribe(ship => {
      let dialogData: DialogData = {resources: ship.resourceQuantities, ship: this.shipName};
      const dialogRef = this.dialog.open(ResourceChangeDialog, {
        width: '250px',
        data: dialogData
      });

      dialogRef.afterClosed().subscribe(_ => location.reload());
    });
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
    this.shipService.changeResources(this.data.ship, this.resourcesToChange).subscribe();
    this.dialogRef.close();
  }
}

interface DialogData {
  resources: Map<string, number>,
  ship: string
}
