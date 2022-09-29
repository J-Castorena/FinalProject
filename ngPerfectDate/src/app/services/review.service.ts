import { DateNight } from 'src/app/models/date-night';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from 'src/environments/environment';
import { Review } from '../models/review';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  private baseUrl = 'http://localhost:8090/'
  private url = environment.baseUrl + 'api/reviews';

  constructor(private http: HttpClient, private auth: AuthService) { }

  getAllReviews(): Observable<Review[]> {
    return this.http.get<Review[]>(this.url).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'ReviewService.getAllReviews():error retrieving Reviews: ' + error
          )
        )
      })
    );
  }

  getReviewsByDateNightId(datenight: DateNight): Observable<Review[]> {
    return this.http.get<Review[]>(this.url + "/datenights/" + datenight.id, this.getHttpOptions()).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'ReviewService.getAllReviews():error retrieving Reviews: ' + error
          )
        )
      })
    );
  }

  getReview(id: number): Observable<Review> {
    return this.http.get<Review>(this.url + '/' + id).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'ReviewService.getReview():error retrieving Review: ' + error
          )
        )
      })
    );
  }

  create(review: Review, dateNightId: number): Observable<Review> {
    return this.http.post<Review>(this.url + '/' + dateNightId, review, this.getHttpOptions()).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'ReviewService.create():error creating Review: ' + error
         )
       );
     })
    );
   }

   delete(reviewId: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${reviewId}`).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'ReviwService.delete():error deleting Review: ' + error
         )
       );
     })
    );
   }

   update(review: Review): Observable<Review> {
    return this.http.put<Review>(this.url, review).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'ReviewService.update():error updating Review: ' + error
         )
       );
     })
    );
   }

   getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }
}
