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

  // TODO: more modular?
  updateRoute(url: string) {
    console.log(url);
    if (url.includes('controller-view')) {
      let id = url.split('/')[1];
      let prefix = id + '/controller-view';
      this.routes = [
        {name: 'Overview', link: prefix},
        {name: 'Ships', link: prefix + '/ships'},
        {name: 'Players', link: prefix + '/players'}
      ];
    } else if (url.includes('player-view')) {
      let id = url.split('/')[1];
      let prefix = id + '/player-view';
      this.routes = [{name: 'Overview', link: prefix}];
    } else {
      this.routes = [];
    }
  }

}
