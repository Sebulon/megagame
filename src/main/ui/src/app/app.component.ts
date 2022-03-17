import {Component, OnInit} from '@angular/core';
import {Router, RouterEvent} from "@angular/router";
import {AuthService} from "./auth/auth.service";
import {filter} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ui';

  constructor(private router: Router,
              private authService: AuthService) {
  }

  ngOnInit(): void {
    this.router.events
      .pipe(
        filter(e => e instanceof RouterEvent)
      )
      .subscribe(e => {
        this.authService.attemptedUrl = (e as RouterEvent).url;
      });
  }
}
