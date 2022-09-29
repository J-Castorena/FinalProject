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
  loggedIn: User | null = null;
  editBlog: Blog[] | null = null;
  newBlog: Blog = new Blog();
  editBlogUser: Blog | null = null;
  showThread: boolean[] = [];
  // newComment: BlogComment | null = null;
  newComment: BlogComment = new BlogComment();
  doReplyFlag: boolean = false;
  blogCommentReplies: any = [];
  replyButtonText: string = "Reply";



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
              // this.blogComments = blogComments;
              if(blogComments.length > 0){
                let blogId = blogComments[0].blog.id;
                for(let i =0; i < this.blogs.length; i++){
                  if(this.blogs[i].id === blogId){
                    this.blogs[i].blogComments = blogComments;
                    break;
                  }
                }
              }
              if(index >= 0){
              this.showThread[index] = !this.showThread[index];
            }
              // for(let i = 0; i < blogComments.length; i++){
              // this.blogCommentService.getAllBlogRepliesById(blogComments[i].id).subscribe(
              //   {
              //   next: (blogComments) => {
              //     this.blogCommentReplies.push(blogComments);
              //   },
              //   error: (err) => {
              //     console.log('BlogCommentComponent.getAllBlogComments(): error loading blog comments:');
              //     console.log(err);
              //   }
              //   }
              // );
            // }
              console.log(this.blogComments);
            },
            error: (err) => {
              console.log('BlogCommentComponent.getAllBlogComments(): error loading blog comments:');
              console.log(err);
            }
            }
          );
    }

    reply(blogId: number, newComment: BlogComment){
      this.blogCommentService.addCommentToBlog(newComment, blogId).subscribe(
        {
        next: (data) => {
          this.blogComments.push(data);
          this.showAllBlogComments(blogId, -1);
        },
        error: (err) => {
          console.log('BlogCommentComponent.getAllBlogComments(): error loading blog comments:');
          console.log(err);
        }
        }
      );
    }

    toggleReplyButtonText(){
    if(this.doReplyFlag){
      this.replyButtonText = "Cancel";
    } else{
      this.replyButtonText = "Reply";
    }
    }

}
