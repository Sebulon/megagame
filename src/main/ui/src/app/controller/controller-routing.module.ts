import {RouterModule, Routes} from "@angular/router";
import {ControllerShipsComponent} from "./controller-ships/controller-ships.component";
import {ControllerShipComponent} from "./controller-ship/controller-ship.component";
import {ControllerPlayersComponent} from "./controller-players/controller-players.component";
import {NgModule} from "@angular/core";
import {ControllerViewComponent} from "./controller-view/controller-view.component";

const controllerRoutes: Routes = [
  {path: '', component: ControllerViewComponent},
  {path: 'ships', component: ControllerShipsComponent},
  {path: 'ships/:ship', component: ControllerShipComponent},
  {path: 'players', component: ControllerPlayersComponent}
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
