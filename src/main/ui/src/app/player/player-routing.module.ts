import {RouterModule, Routes} from "@angular/router";
import {PlayerShipComponent} from "./player-ship/player-ship.component";
import {NgModule} from "@angular/core";
import {PlayerWelcomeComponent} from "./player-welcome/player-welcome.component";
import {SolarSystemComponent} from "./solar-system/solar-system.component";
import {RoleSelectorComponent} from "./role-selector/role-selector.component";

const playerRoutes: Routes = [
  {path: '', redirectTo: 'welcome'},
  {path: 'welcome', component: PlayerWelcomeComponent},
  {path: 'ship', component: PlayerShipComponent},
  {path: 'solar-system', component: SolarSystemComponent},
  {path: 'role-selector', component: RoleSelectorComponent}
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
