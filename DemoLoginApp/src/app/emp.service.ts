import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Emp } from './emp';

@Injectable({
  providedIn: 'root'
})
export class EmpService {

  constructor(private httpClient: HttpClient) { }

  private apiUrl = "http://localhost:3000/employees";

  getAllEmployees()
  {
    return this.httpClient.get<Emp[]>(this.apiUrl);
  }
  
}
