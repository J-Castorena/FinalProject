import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';

user: new User();

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  today: number = Date.now();
  editUser: User | null = null;
  user: User = new User();
  selected: User | null = null;
  users: User[] = [];

  constructor(
    private auth: AuthService,
    private router: Router,
    private userServ: UserService
  ) {}

  ngOnInit(): void {
    this.reload();
  }

  reload() {
    this.userServ.getAllUsers().subscribe({
      next: (data) => {
        this.users = data;
      },
      error: (err) => {
        console.error('HomeComponent.reload(): error loading users:');
        console.error(err);
      },
    });
  }

  displayUser(user: User){
    this.selected = user;
  }



  getUserByUsername(username: string) {
    this.userServ.getUserByUsername(username).subscribe({
      next: (data) => {
        this.selected = data;
        this.reload();
      },
      error: (err) => {
        console.error('HomeComponent.updateUser(): error updating user:');
        console.error(err);
      },
    });
  }

  loggedIn() {
    return this.auth.checkLogin();
  }

  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

  setEdit() {
    this.editUser = Object.assign({}, this.selected);
  }


}
