import { Pipe, PipeTransform } from '@angular/core';
import { Review } from '../models/review';

@Pipe({
  name: 'review'
})
export class ReviewPipe implements PipeTransform {

  transform(reviews: Review[], comment: string): Review[] {
    let result: Review[] = [];
  //   for(let review of reviews) {
  //     for(let dateNight of review.comment)
  //       if(review.comment === comment) {
  //         result.push(review);
  //       }
  //   }
    return result;
  }

}
