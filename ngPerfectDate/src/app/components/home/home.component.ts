import { AuthService } from 'src/app/services/auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
loggedInUser: User = new User();

  constructor(private AuthService: AuthService) { }

  ngOnInit(): void {
  this.AuthService.getCredentials();
  }

}
