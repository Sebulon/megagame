import {NgModule} from "@angular/core";
import {ControllerRoutingModule} from "./controller-routing.module";
import {ControllerShipComponent, ResourceChangeDialog} from "./controller-ship/controller-ship.component";
import {ControllerShipsComponent} from "./controller-ships/controller-ships.component";
import {ControllerPlayersComponent} from "./controller-players/controller-players.component";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatSliderModule} from "@angular/material/slider";
import {MatDialogModule} from "@angular/material/dialog";
import {ControllerViewComponent} from "./controller-view/controller-view.component";

@NgModule({
  imports: [
    ControllerRoutingModule,
    CommonModule,
    ReactiveFormsModule,
    MatSliderModule,
    MatDialogModule,
    FormsModule
  ],
  declarations: [
    ControllerViewComponent,
    ControllerShipComponent,
    ControllerShipsComponent,
    ControllerPlayersComponent,
    ResourceChangeDialog
  ]
})
export class ControllerModule {
}