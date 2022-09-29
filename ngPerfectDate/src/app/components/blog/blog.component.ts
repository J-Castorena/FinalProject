import { BlogCommentService } from './../../services/blog-comment.service';
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
  editBlogUser: Blog | null = null;
  showThread: boolean[] = [];






  constructor(private blogService: BlogService, private auth: AuthService, private blogCommentService: BlogCommentService ) { }

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
        for(let blog of this.blogs){
          this.showThread.push(false);
        }
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

  update(updatedBlog: Blog) {
    this.blogService.update(updatedBlog).subscribe(
      {
        next: (data) => {
          this.selected = null;
          this.editBlogUser = null;
          this.displayAllBlogs();
        },
        error: (err) => {
          console.error('BlogComponent.updateBlog(): error updating blog:');
          console.error(err);
        }

      }
    )
    }

    updateCompleted(updatedBlog: Blog) {
      this.blogService.update(updatedBlog).subscribe(
       {
         next: (data) => {
           this.displayAllBlogs();
         },
         error: (err) => {
           console.error('BlogComponent.updateBlog(): error updating blog:');
           console.error(err);
         }
       }
     );
     }

    showAllBlogComments(id: number, index: number){
      this.blogCommentService.getAllBlogCommentsById(id).subscribe(
            {
            next: (blogComments) => {
              this.blogComments = blogComments;
              this.showThread[index] = !this.showThread[index];
              console.log(this.blogComments);
            },
            error: (err) => {
              console.log('BlogCommentComponent.getAllBlogComments(): error loading blog comments:');
              console.log(err);
            }
            }
          );
    }



}
