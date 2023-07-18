import { Component, DoCheck } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements DoCheck {
  title = 'LoginApp';

  isNavbarVisible=false;

  constructor(private router:Router){}

  ngDoCheck():void
  {
      let currentUrl = this.router.url;
      console.log(currentUrl);
      
      if(currentUrl=="/login" || currentUrl=="/register"  || currentUrl=="/")
      {
        this.isNavbarVisible = false;
      }
      else
      {
        this.isNavbarVisible =true;
      }
  }

}
