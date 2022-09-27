import { Category } from "./category";
import { User } from "./user";

export class DateNight {
  id: number;
  name: string;
  user: User;
  imageUrl: string;
  description: string;
  createdDate: string;
  lastUpdatedDate: string;
  active: boolean;
  categories: Category[];

  constructor(
  id: number = 0,
  name: string= '',
  user: User = new User(),
  imageUrl: string = '',
  description: string = '',
  createdDate: string = '',
  lastUpdatedDate: string = '',
  active: boolean = false,
  categories: Category[] = []
  ){
    this.id = id;
    this.name = name;
    this.user = user;
    this.imageUrl = imageUrl;
    this.description = description;
    this.createdDate = createdDate;
    this.lastUpdatedDate = lastUpdatedDate;
    this.active = active;
    this.categories = categories;
  }
}
