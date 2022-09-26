import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { LoginComponent } from './components/login/login.component';
import { DatenightComponent } from './components/datenight/datenight.component';
import { CategoryComponent } from './components/category/category.component';
import { BlogComponent } from './components/blog/blog.component';
import { HomeComponent } from './components/home/home.component';
import { NotfoundComponent } from './components/notfound/notfound.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
{ path: 'home', component: HomeComponent },
{ path: 'blog', component: BlogComponent },
{ path: 'category', component: CategoryComponent },
{ path: 'datenight', component: DatenightComponent },
{ path: 'login', component: LoginComponent},
{ path: 'user-profile', component: UserProfileComponent },
{ path: '**', component: NotfoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
