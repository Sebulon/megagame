import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from "@angular/router";
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";

import {AppComponent} from './app.component';
import {TopBarComponent} from './top-bar/top-bar.component';
import {LogInComponent} from './log-in/log-in.component';
import {ControllerViewComponent} from './controller/controller-view/controller-view.component';
import {PlayerViewComponent, ResourceGiftDialog} from './player-view/player-view.component';
import {ControllerShipComponent} from './controller/controller-ship/controller-ship.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ControllerShipsComponent} from './controller/controller-ships/controller-ships.component';
import {ControllerPlayersComponent} from './controller/controller-players/controller-players.component';
import {MatDialogModule} from "@angular/material/dialog";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatSelectModule} from "@angular/material/select";
import {MatSliderModule} from "@angular/material/slider";

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    LogInComponent,
    ControllerViewComponent,
    PlayerViewComponent,
    ControllerShipComponent,
    ControllerShipsComponent,
    ControllerPlayersComponent,
    ResourceGiftDialog
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatSliderModule,
    RouterModule.forRoot([
      {path: '', component: LogInComponent},
      {path: ':id/controller-view', component: ControllerViewComponent},
      {path: ':id/controller-view/ships', component: ControllerShipsComponent},
      {path: ':id/controller-view/ships/:ship', component: ControllerShipComponent},
      {path: ':id/controller-view/players', component: ControllerPlayersComponent},
      {path: ':id/player-view', component: PlayerViewComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
