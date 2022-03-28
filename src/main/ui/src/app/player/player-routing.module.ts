import {RouterModule, Routes} from "@angular/router";
import {PlayerShipComponent} from "./player-ship/player-ship.component";
import {NgModule} from "@angular/core";
import {PlayerWelcomeComponent} from "./player-welcome/player-welcome.component";
import {SolarSystemComponent} from "./solar-system/solar-system.component";

const playerRoutes: Routes = [
  {path: '', redirectTo: 'welcome'},
  {path: 'welcome', component: PlayerWelcomeComponent},
  {path: 'ship', component: PlayerShipComponent},
  {path: 'solar-system', component: SolarSystemComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(playerRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class PlayerRoutingModule {
}
