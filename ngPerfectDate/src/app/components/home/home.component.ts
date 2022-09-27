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
images = true;

  constructor(private auth: AuthService,
    private router: Router) { }

  ngOnInit(): void {
  }

  loggedIn(){
    return this.auth.checkLogin();
  }

}
