export class AdditionalImage {
  id: number;
  imagerUrl: string;
  caption: string;
  review: string;

  constructor(
  id: number = 0,
  imagerUrl: string = "",
  caption: string = "",
  review: string = ""
  ){
    this.id = id;
    this.imagerUrl = imagerUrl;
    this.caption = caption;
    this.review = review;
  }
}
