import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private builder:FormBuilder) { }

  ngOnInit(): void {
  }
  result:any;
  msg:string="";

  regForm = this.builder.group({
    personname: this.builder.control('', Validators.required),
    phonenumber: this.builder.control('', Validators.required),
    email:this.builder.control('', Validators.required)
  });

  printDetails()
  {
    if(this.regForm.valid)
    {
      this.result = "Person Name : " + this.regForm.value.personname;
      this.result += "<br />Phone Number : " + this.regForm.value.phonenumber;
      this.result += "<br />Email : " + this.regForm.value.email;
      this.msg = this.result; 
    }
    else 
    this.msg = "Invalid Form";
  }
}
