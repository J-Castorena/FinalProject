import { BlogComment } from './../../models/blog-comment';
import { BlogService } from './../../services/blog.service';
import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/models/blog';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  blogs: Blog[] = [];
  blogComments: BlogComment[] = [];

  selected: Blog[] | null = null;

  constructor(private blogService: BlogService) { }

  ngOnInit(): void {
    this.displayAllBlogs();
    console.log(this.blogs);

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
