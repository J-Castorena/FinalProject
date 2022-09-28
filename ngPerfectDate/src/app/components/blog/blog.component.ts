import { BlogComment } from './../../models/blog-comment';
import { BlogService } from './../../services/blog.service';
import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/models/blog';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {

  blogs: Blog[] = [];
  blogComments: BlogComment[] = [];
  selected: Blog[] | null = null;
  loggedIn: User = new User();
  editBlog: Blog[] | null = null;
  newBlog: Blog = new Blog();

  constructor(private blogService: BlogService, private auth: AuthService) { }

  ngOnInit(): void {
    this.displayAllBlogs();
    this.getLoggedInUser();
    console.log(this.blogs);

  }


  getLoggedInUser(){
    return this.auth.getLoggedInUser().subscribe(
      {
        next: (data) => {
        this.loggedIn = data;
        },
        error: (err) => {
          console.log('BlogComponent.getLoggedInUser(): error loading logged in user:');
          console.log(err);
      }
    }
    );
  }

  setEdit() {
    this.editBlog = Object.assign({}, this.selected);
  }

  displayAllBlogs()  {
    this.blogService.getAllBlogs().subscribe({
      next: (data) => {
        this.blogs = data;
        this.selected = this.blogs;
        console.log(this.blogs);
      },
      error: (err) => {
        console.error(
          'Blog.component.ts displayAllBlogs(): error retrieving blogs ' + err
        );
      },
    });
  }

  create(blog: Blog): void {
    this.blogService.create(this.newBlog).subscribe(
      {
        next: (result) => {
          this.newBlog = new Blog();
          this.displayAllBlogs();

        },
        error: (problem) => {
          console.error('BlogHttpComponent.createBlog(): error adding blog:');
          console.error(problem);
        }
      }
    );
  }

  delete(id: number) {
    this.blogService.delete(id).subscribe(
      {
        next: (data) => {
          this.selected = null;
          this.displayAllBlogs();
        },
        error: (err) => {
          console.error('BlogComponent.delete(): error deleting blog:');
          console.error(err);
        }
      }
    )
  }

  // getComments(): void {
  //   this.blogCommentService.index().subscribe(
  //     {
  //     next: (blogComments) => {
  //       this.blogComments = blogComments;
  //     },
  //     error: (err) => {
  //       console.log('DatenightComponent.reload(): error loading datenights:');
  //       console.log(err);
  //     }
  //     }
  //   );
  // }

}
