import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test1',
  templateUrl: './test1.component.html',
  styleUrls: ['./test1.component.css']
})
export class Test1Component implements OnInit {

  marks:number=78;
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
