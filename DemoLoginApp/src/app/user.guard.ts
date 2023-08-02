import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {
  constructor(private router:Router, private service:LoginService){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    
    if(this.service.CheckLoginUser()==true)
    {
      if(this.router.url.length>0)
      {
        let urlmap = route.url[0].path;
        if(urlmap=="user" || urlmap=="welcome" || urlmap=="emp")
          return true;
      }
    }
    else
    {
      alert("First User has to Login");
      this.router.navigate(['login']);
      return false;
    }
    
    
      
  }
  
}
