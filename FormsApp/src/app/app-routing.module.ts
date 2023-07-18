import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path:"", component:HomeComponent}, // default page
  {path:"home", component:HomeComponent},
  {path:"login", component:LoginComponent},
  {path:"aboutus", component:AboutusComponent},
  {path:"welcome", component:WelcomeComponent},
  {path:"reg", component:RegisterComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
