export class Category {
  id: number;
  name: string;
  imageUrl: string;
  types: any[] = [];

  constructor(
    id: number = 0,
    name: string = '',
    imageUrl: string = '',
    types: any[] = []
  ){
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.types = types;
  }
}
