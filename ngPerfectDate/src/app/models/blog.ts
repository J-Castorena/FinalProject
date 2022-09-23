export class Blog {
  id: number;
  comments: string;
  blogDate: string | undefined;
  title: string;
  active: boolean;
  imageUrl: string;

  constructor(
    id: number = 0,
    comments: string = '',
    blogDate: string = '',
    title: string = '',
    active: boolean = false,
    imageUrl: string= ''
  ){
      this.id = id;
      this.comments = comments;
      this.blogDate = blogDate;
      this.title = title;
      this.active = active;
      this.imageUrl = imageUrl;
  }
}
