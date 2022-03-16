import {NgModule} from "@angular/core";
import {PlayerRoutingModule} from "./player-routing.module";
import {PlayerViewComponent, ResourceGiftDialog} from "./player-view/player-view.component";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDialogModule} from "@angular/material/dialog";
import {MatSelectModule} from "@angular/material/select";
import {CommonModule} from "@angular/common";
import {MatSliderModule} from "@angular/material/slider";
import {FormsModule} from "@angular/forms";

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
    PlayerViewComponent,
    ResourceGiftDialog
  ]
})
export class PlayerModule {}
