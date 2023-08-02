import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-switch',
  templateUrl: './switch.component.html',
  styleUrls: ['./switch.component.css']
})
export class SwitchComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  country:string = "";
  cities:string[] = ["Hyderbad", "Pune", "Bangalore", "Vizag", "Kolkatta"];
}
