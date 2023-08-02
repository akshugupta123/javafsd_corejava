import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms'
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  msg:any;
  result:any;
  constructor(
    private builder :FormBuilder, 
    private service : LoginService, 
    private router : Router
  ) {
      sessionStorage.clear();// it will delete all values form session memory
   }

  ngOnInit(): void {
  }

  loginForm = this.builder.group(
    {
      username: this.builder.control('', Validators.required),
      password: this.builder.control('', Validators.required)
    });

    procedLogin()
    {
/*
      this.service.GetUserByID(this.loginForm.value.username).subscribe
      (data=>{
        // onsuccess
      },
      error =>{
        //onerror
      });
*/
      if(this.loginForm.valid)
      {
          this.service.GetUserByID(this.loginForm.value.username).subscribe(data=>{
            
            this.result = data;
            if(this.result.password== this.loginForm.value.password)
            {
              sessionStorage.setItem('username', this.result.username);
                    // it will store in sessio memory(browser memory), so that it can access any other component of the site.
              this.router.navigate(['welcome']);
            }
            else
            this.msg = "Invalid password";
          }, 
          error=>{
            console.log(error);
            this.msg = "Invalid Username";
          });
      }
      else
      {
        this.msg = "Please fill username and password";
      }
    }
}
