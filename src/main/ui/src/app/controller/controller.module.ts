import {NgModule} from "@angular/core";
import {ControllerRoutingModule} from "./controller-routing.module";
import {ControllerShipComponent, ResourceChangeDialog} from "./controller-ship/controller-ship.component";
import {ControllerShipsComponent} from "./controller-ships/controller-ships.component";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatSliderModule} from "@angular/material/slider";
import {MatDialogModule} from "@angular/material/dialog";
import {ControllerViewComponent} from "./controller-view/controller-view.component";
import {DragDropModule} from "@angular/cdk/drag-drop";
import {TeamsComponent} from './teams/teams.component';
import {PlayersComponent} from './players/players.component';
import {TeamDetailComponent} from './teams/team-detail/team-detail.component';
import {TeamChangeMembersComponent} from './teams/team-change-members/team-change-members.component';

@NgModule({
  imports: [
    ControllerRoutingModule,
    CommonModule,
    ReactiveFormsModule,
    MatSliderModule,
    MatDialogModule,
    FormsModule,
    DragDropModule
  ],
  declarations: [
    ControllerViewComponent,
    ControllerShipComponent,
    ControllerShipsComponent,
    ResourceChangeDialog,
    TeamsComponent,
    PlayersComponent,
    TeamDetailComponent,
    TeamChangeMembersComponent
  ]
})
export class ControllerModule {
}
