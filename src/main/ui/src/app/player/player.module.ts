import {NgModule} from "@angular/core";
import {PlayerRoutingModule} from "./player-routing.module";
import {PlayerShipComponent, ResourceGiftDialog} from "./player-ship/player-ship.component";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDialogModule} from "@angular/material/dialog";
import {MatSelectModule} from "@angular/material/select";
import {CommonModule} from "@angular/common";
import {MatSliderModule} from "@angular/material/slider";
import {FormsModule} from "@angular/forms";
import {PlayerWelcomeComponent} from "./player-welcome/player-welcome.component";
import { SolarSystemComponent } from './solar-system/solar-system.component';

@NgModule({
  imports: [
    PlayerRoutingModule,
    MatFormFieldModule,
    MatDialogModule,
    MatSelectModule,
    CommonModule,
    MatSliderModule,
    FormsModule
  ],
  declarations: [
    PlayerShipComponent,
    PlayerWelcomeComponent,
    ResourceGiftDialog,
    SolarSystemComponent
  ]
})
export class PlayerModule {
}
