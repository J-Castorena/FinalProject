export class Review {
  id: number;
  rating: number;
  comment: string;
  reviewDate: string;

  constructor(
  id: number = 0,
  rating: number = 0,
  comment: string = '',
  reviewDate: string = ''
  ){
    this.id = id;
    this.rating = rating;
    this.comment = comment;
    this.reviewDate = reviewDate;
  }
}
