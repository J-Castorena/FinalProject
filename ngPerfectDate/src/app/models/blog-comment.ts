import { Blog } from "./blog";
import { User } from "./user";

export class BlogComment {
  id: number;
  message: string;
  blogCommentDate: string;
  imageUrl: string;
  user: User;
  blog: Blog;

  constructor(
  id: number = 0,
  message: string = '',
  blogCommentDate: string = '',
  imageUrl: string = '',
  user: User = new User(),
  blog: Blog = new Blog()

  ){
    this.id = id;
    this.message = message;
    this.blogCommentDate = blogCommentDate;
    this.imageUrl = imageUrl;
    this.user = user;
    this.blog = blog;
  }
}
