import { Router } from '@angular/router';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loggedInUser: User = new User();

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  login(user: User): void {
    console.log('Logged in user');
    console.log(user);
        this.auth.login(user.username, user.password).subscribe({
          next: (loggedInUser) => {
            console.log(loggedInUser);

            this.router.navigateByUrl('/home');
          },
          error: (problem) => {
            console.error('LoginComponent.login(): Error logging in user:');
            console.error(problem);
          }
          });
  }


}
