import { BlogComment } from './blog-comment';
import { ɵExtraLocaleDataIndex } from "@angular/core";
import { Blog } from "./blog";

export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  username: string;
  password: string;
  imageUrl: string;
  biography: string;
  role: string;
  enabled: boolean;
  dob: string;
  blogs: Blog[];
  blogComments: BlogComment[];

  constructor(
  id: number = 0,
  firstName: string = '',
  lastName: string = '',
  email: string = '',
  username: string= '',
  password: string = '',
  imageUrl: string = '',
  biography: string = '',
  role: string = '',
  enabled: boolean = false,
  dob: string = '',
  blogs: [] = [],
  blogComments: [] = []
  ){
    this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.username = username;
      this.password = password;
      this.imageUrl = imageUrl;
      this.biography = biography;
      this.role = role;
      this.enabled = enabled;
      this.dob = dob;
      this.blogs = blogs;
      this.blogComments = blogComments;
  }

}
