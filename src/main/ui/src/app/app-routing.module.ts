import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthControllerGuard, AuthPlayerGuard} from "./auth/auth.guard";

const appRoutes: Routes = [
  {
    path: '', redirectTo: 'login', pathMatch: 'full'
  },
  {
    path: ':id/player-view',
    loadChildren: () => import('./player/player.module').then(m => m.PlayerModule),
    canLoad: [AuthPlayerGuard]
  },
  {
    path: ':id/controller-view',
    loadChildren: () => import('./controller/controller.module').then(m => m.ControllerModule),
    canLoad: [AuthControllerGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
