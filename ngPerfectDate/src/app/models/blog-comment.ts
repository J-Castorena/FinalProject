import { User } from "./user";

export class BlogComment {
  id: number;
  message: string;
  blogCommentDate: string;
  imageUrl: string;
  user: User;
  parentBlogComment: BlogComment;
  blogComments: BlogComment[];

  constructor(
  id: number = 0,
  message: string = '',
  blogCommentDate: string = '',
  imageUrl: string = '',
  user: User = new User(),
  parentBlogComment: BlogComment = new BlogComment(),
  blogComments: [] = []
  ){
    this.id = id;
    this.message = message;
    this.blogCommentDate = blogCommentDate;
    this.imageUrl = imageUrl;
    this.user = user;
    this.parentBlogComment = parentBlogComment;
    this.blogComments = blogComments;
  }
}
