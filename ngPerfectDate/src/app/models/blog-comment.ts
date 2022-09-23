export class BlogComment {
  id: number;
  message: string;
  blogCommentDate: string;
  imageUrl: string;

  constructor(
  id: number = 0,
  message: string = '',
  blogCommentDate: string = '',
  imageUrl: string = ''
  ){
    this.id = id;
    this.message = message;
    this.blogCommentDate = blogCommentDate;
    this.imageUrl = imageUrl;
  }
}
