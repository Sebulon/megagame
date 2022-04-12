import {RouterModule, Routes} from "@angular/router";
import {ControllerShipsComponent} from "./controller-ships/controller-ships.component";
import {ControllerShipComponent} from "./controller-ship/controller-ship.component";
import {NgModule} from "@angular/core";
import {ControllerViewComponent} from "./controller-view/controller-view.component";
import {TeamsComponent} from "./teams/teams.component";
import {PlayersComponent} from "./players/players.component";

const controllerRoutes: Routes = [
  {path: '', component: ControllerViewComponent},
  {path: 'ships', component: ControllerShipsComponent},
  {path: 'ships/:ship', component: ControllerShipComponent},
  {path: 'players', component: PlayersComponent},
  {path: 'teams', component: TeamsComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(controllerRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class ControllerRoutingModule {
}
