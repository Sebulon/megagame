import {Component, OnInit} from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {filter} from "rxjs";

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {

  routes: { name: string, link: string }[] = [];

  constructor(router: Router) {
    router.events.pipe(
      filter(e => e instanceof NavigationEnd)
    ).subscribe(e => this.updateRoute((e as NavigationEnd).url))
  }

  ngOnInit(): void {
  }

  private updateRoute(url: string) {
    let splitURL = url.split('/').slice(1);
    if (splitURL.length < 3) {
      this.routes = [];
      return;
    }

    let prefix = `${splitURL[0]}/${splitURL[1]}`
    if (splitURL[1] == 'controller-view') {
      this.routes = this.getControllerRoutes(prefix, splitURL[splitURL.length - 1]);
    } else if (splitURL[1] == 'player-view') {
      this.routes = this.getPlayerRoutes(prefix, splitURL[splitURL.length - 1]);
    } else {
      throw new Error('Has no routing options for this route');
    }
  }

  /**
   * All top-bar links for controller are created here
   * @param prefix
   * @param lastDirectory
   * @private
   */
  private getControllerRoutes(prefix: string, lastDirectory: string) {
    let controllerRoutes = [
      {name: 'Overview', link: prefix},
      {name: 'Ships', link: prefix + '/ships'},
      {name: 'Players', link: prefix + '/players'},
      {name: 'Teams', link: prefix + '/teams'}
    ];
    return this.getRoutes(controllerRoutes, lastDirectory);
  }

  /**
   * All top-bar links for player are created here
   * @param prefix
   * @param lastDirectory
   * @private
   */
  private getPlayerRoutes(prefix: string, lastDirectory: string) {
    let playerRoutes = [
      {name: 'Welcome', link: prefix + '/welcome'},
    ];
    return this.getRoutes(playerRoutes, lastDirectory);
  }

  private getRoutes(routes: { name: string; link: string }[], lastDirectory: string) {
    return routes.filter(r => r.link.substring(r.link.length - lastDirectory.length) != lastDirectory);
  }
}
