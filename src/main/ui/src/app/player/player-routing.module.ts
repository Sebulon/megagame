import {RouterModule, Routes} from "@angular/router";
import {PlayerViewComponent} from "./player-view/player-view.component";
import {NgModule} from "@angular/core";

const playerRoutes: Routes = [
  {path: '', component: PlayerViewComponent}
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
