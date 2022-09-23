export class DateNightDiscussionBoard {
  id: number;
  message: string;
  commentDate: string;

  constructor(
  id: number = 0,
  message: string = '',
  commentDate: string = ''
  ){
    this.id = id;
    this.message = message;
    this.commentDate = commentDate;
  }
}
