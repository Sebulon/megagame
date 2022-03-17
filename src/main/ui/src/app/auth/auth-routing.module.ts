import {RouterModule, Routes} from "@angular/router";
import {LogInComponent} from "./log-in/log-in.component";
import {NgModule} from "@angular/core";

const authRoutes: Routes = [
  {path: 'login', component: LogInComponent}
]

@NgModule({
  imports: [
    RouterModule.forChild(authRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AuthRoutingModule {
}
