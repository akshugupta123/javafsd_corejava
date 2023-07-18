import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  constructor(private  service:LoginService) { }
  allusers : Observable<any>;
  
  ngOnInit(): void {
    this.allusers = this.service.ViewAllUsersinfo();
  }

}
