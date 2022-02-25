import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-controller-view',
  templateUrl: './controller-view.component.html',
  styleUrls: ['./controller-view.component.css']
})
export class ControllerViewComponent implements OnInit {

  //TODO: If the user has the wrong role or no id, should not be able to be here

  constructor() { }

  ngOnInit(): void {
  }

}
