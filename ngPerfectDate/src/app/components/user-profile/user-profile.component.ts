import { BlogService } from './../../services/blog.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';
import { Blog } from 'src/app/models/blog';

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
  loggedIn: User = new User();
  blogs: Blog [] = [];
  selectedBlog: Blog | null = null;

  constructor(
    private auth: AuthService,
    private router: Router,
    private userServ: UserService,
    private blogServ: BlogService
  ) {}

  ngOnInit(): void {
    this.reload();
  }

  reload() {
    this.getLoggedInUser();
  }

  displayUser(user: User) {
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

  getLoggedInUser() {
    return this.auth.getLoggedInUser().subscribe({
      next: (data) => {
        this.loggedIn = data;
      },
      error: (err) => {
        console.log('DatenightComponent.reload(): error loading datenights:');
        console.log(err);
      },
    });
  }

  setEdit() {
    this.editUser = Object.assign({}, this.selected);
  }

  update(updatedUser: User) {
    this.userServ.update(updatedUser).subscribe({
      next: (data) => {
        this.selected = data;
        this.editUser = null;
        this.reload();
      },
      error: (err) => {
        console.error(
          'UserProfileComponent.updateUser(): error updating user:'
        );
        console.error(err);
      },
    });
  }


  delete(id: number) {
    this.userServ.delete(id).subscribe({
      next: (data) => {
        this.selected = null;
        this.reload();
      },
      error: (err) => {
        console.error('UserProfileComponent.delete(): error deleting User:');
        console.error(err);
      },
    });
  }
}
