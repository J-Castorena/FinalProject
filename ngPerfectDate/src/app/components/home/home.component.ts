import { AuthService } from 'src/app/services/auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { DateNight } from 'src/app/models/date-night';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
loggedInUser: User = new User();
datenights: DateNight [] = [];
images = true;

  constructor(private AuthService: AuthService, private router: Router) { }

  ngOnInit(): void {
  this.AuthService.getCredentials();
  }

  logout(){
    console.log('logging out');
  this.AuthService.logout();
  this.router.navigateByUrl('/home')
  console.log('logout successful');

  }
}
