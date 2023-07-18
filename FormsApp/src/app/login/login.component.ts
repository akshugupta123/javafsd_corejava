import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string="";
  password:string="";
  msg:string = "";

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  LoginCheck(frm:any)
  {
    if(frm.valid)
    {
      if(this.username=="venugopal" && this.password=="12345")
        //this.msg = "User Existed"
        this.router.navigate(['/welcome']);
        else
        this.msg = "Please check username / password";
    }
    else
      this.msg="Invalid Form";
  }
}
