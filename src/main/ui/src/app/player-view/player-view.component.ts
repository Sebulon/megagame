import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css']
})
export class PlayerViewComponent implements OnInit {

  //TODO: If the user has the wrong role or no id, should not be able to be here

  constructor() { }

  ngOnInit(): void {
  }

}
