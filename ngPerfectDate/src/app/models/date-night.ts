import { Category } from './category';
export class DateNight {
  id: number;
  name: string;
  imageUrl: string;
  description: string;
  createdDate: string;
  lastUpdatedDate: string;
  active: boolean;
  categories: Category[];

  constructor(
  id: number = 0,
  name: string= '',
  imageUrl: string = '',
  description: string = '',
  createdDate: string = '',
  lastUpdatedDate: string = '',
  active: boolean = false,
  categories: Category[] = []
  ){
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.description = description;
    this.createdDate = createdDate;
    this.lastUpdatedDate = lastUpdatedDate;
    this.active = active;
    this.categories = categories;
  }
}
