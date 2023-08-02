import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpComponent } from './emp/emp.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { UserGuard } from './user.guard';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'welcome', component:WelcomeComponent, canActivate:[UserGuard]},
  {path:'login', component:LoginComponent},
  {path:'user', component:UserInfoComponent, canActivate:[UserGuard]},
  {path:'register', component:RegisterComponent},
  {path:'emp', component:EmpComponent, canActivate:[UserGuard]},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
