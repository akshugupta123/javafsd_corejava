import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Emp } from './emp';

@Injectable({
  providedIn: 'root'
})
export class EmpService {

  constructor(private httpclient:HttpClient) { }

  private apiurl = "http://localhost:3000/employees";

  getAllEmployeeDetails()
  {
      return this.httpclient.get<Emp[]>(this.apiurl);
  }

}
