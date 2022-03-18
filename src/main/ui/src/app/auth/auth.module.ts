import {NgModule} from "@angular/core";
import {LogInComponent} from "./log-in/log-in.component";
import {AuthRoutingModule} from "./auth-routing.module";

@NgModule({
  imports: [
    AuthRoutingModule
  ],
  declarations: [
    LogInComponent
  ]
})
export class AuthModule {
}
