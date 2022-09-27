export class Category {
  id: number;
  name: string;
  imageUrl: string;

  constructor(
    id: number = 0,
    name: string = '',
    imageUrl: string = ''
  ){
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
  }
}
