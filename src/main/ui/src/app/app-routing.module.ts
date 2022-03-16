import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LogInComponent} from "./log-in/log-in.component";

const appRoutes: Routes = [
  {
    path: '',
    component: LogInComponent
  },
  {
    path: ':id/player-view',
    loadChildren: () => import('./player/player.module').then(m => m.PlayerModule)
  },
  {
    path: ':id/controller-view',
    loadChildren: () => import('./controller/controller.module').then(m => m.ControllerModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
