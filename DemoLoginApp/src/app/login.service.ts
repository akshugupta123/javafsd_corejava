import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  private apiUrl = "http://localhost:3000/userinfo";

  CreateNewUser(userdata:any)
  {
    return this.http.post(this.apiUrl, userdata);
  }

  ViewAllUsersinfo()
  {
    return this.http.get(this.apiUrl);
  }

  GetUserByID(username:any)
  {
    return this.http.get(this.apiUrl + '/' + username);
  }

  CheckLoginUser()
  {
    return sessionStorage.getItem('username')!=null;
  }

  getLoginUser()
  {
    return sessionStorage.getItem('username');
  }
  
}
