import { User } from "./user";

export class Blog {
  id: number;
  comments: string;
  blogDate: string | undefined;
  title: string;
  active: boolean;
  imageUrl: string;
  user: User;

  constructor(
    id: number = 0,
    comments: string = '',
    blogDate: string = '',
    title: string = '',
    active: boolean = false,
    imageUrl: string= '',
    user: User = new User()
  ){
      this.id = id;
      this.comments = comments;
      this.blogDate = blogDate;
      this.title = title;
      this.active = active;
      this.imageUrl = imageUrl;
      this.user = user;
  }
}
