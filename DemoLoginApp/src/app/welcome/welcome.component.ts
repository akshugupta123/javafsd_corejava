import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  userwelcome:string;
  constructor(private service:LoginService) {
    this.userwelcome = sessionStorage.getItem('username');
   }

  ngOnInit(): void {
    //this.userwelcome = this.service.getLoginUser();
  }

}
