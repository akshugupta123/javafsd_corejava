import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test2',
  templateUrl: './test2.component.html',
  styleUrls: ['./test2.component.css']
})
export class Test2Component implements OnInit {
  marks:number=38;
  cssclass:string = "";
  res:boolean=false;

  constructor() {
    if(this.marks>=40)
    {
      this.cssclass = "css1";
      this.res=true;
    }
    else
    {
      this.cssclass = "css2";
      this.res = false;
    }
   }

  ngOnInit(): void {
  }

}
