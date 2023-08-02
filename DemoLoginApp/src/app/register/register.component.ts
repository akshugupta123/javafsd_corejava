import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms'
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  msg:any;
  constructor(
    private builder :FormBuilder, 
    private service : LoginService, 
    private router:Router
  ) { }
  ngOnInit(): void {
  }

  registerform = this.builder.group(
    {
      id: this.builder.control('', Validators.required),
      uname: this.builder.control('', Validators.required),
      password: this.builder.control('', Validators.required)
    });

    procedRegister()
    {
      if(this.registerform.valid)
      {
        this.service.CreateNewUser(this.registerform.value).subscribe(data=>{
          //alert("User Registered");
          this.router.navigate(['login']);
        });
      }
      else
      {
        this.msg = "Invalid Form";
      }
    }
}
