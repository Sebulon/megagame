import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {BrowserModule} from "@angular/platform-browser";
import {TopBarComponent} from "./top-bar/top-bar.component";
import {HttpClientModule} from "@angular/common/http";
import {AuthModule} from "./auth/auth.module";

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AuthModule
  ],
  declarations: [
    AppComponent,
    TopBarComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
