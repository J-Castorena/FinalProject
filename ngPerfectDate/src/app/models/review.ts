import { AdditionalImage } from './additional-image';
export class Review {
  id: number;
  rating: number;
  comment: string;
  reviewDate: string;
  images: AdditionalImage [];

  constructor(
  id: number = 0,
  rating: number = 0,
  comment: string = '',
  reviewDate: string = '',
  images: AdditionalImage[] = []

  ){
    this.id = id;
    this.rating = rating;
    this.comment = comment;
    this.reviewDate = reviewDate;
    this.images = images;
  }
}
