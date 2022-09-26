import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { DateNight } from '../models/date-night';

@Injectable({
  providedIn: 'root'
})
export class DateNightService {
  private baseUrl = 'http://localhost:8090/'
  private url = this.baseUrl + 'api/datenights';


  constructor(private http: HttpClient) { }

  index(): Observable<DateNight[]> {
    return this.http.get<DateNight[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('DateNightComonent.index(): error retrieving datenight: ' + err)
          );
      })
    );
  }

  getAllDateNights(): Observable<DateNight[]> {
    return this.http.get<DateNight[]>(this.url).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'DateNightService.getAllDateNights():error retrieving DateNights: ' + error
          )
        )
      })
    );
  }

  getDateNight(id: number): Observable<DateNight> {
    return this.http.get<DateNight>(this.url + '/' + id).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'DateNightService.getDateNight():error retrieving DateNight: ' + error
          )
        )
      })
    );
  }



  create(dateNight: DateNight): Observable<DateNight> {
    return this.http.post<DateNight>(this.url, dateNight).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'DateNightService.create():error creating DateNight: ' + error
         )
       );
     })
    );
   }

   delete(dateNightId: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${dateNightId}`).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'DateNightService.delete():error deleting DateNight: ' + error
         )
       );
     })
    );
   }

   update(dateNight: DateNight): Observable<DateNight> {
    return this.http.put<DateNight>(this.url, dateNight).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'DateNightService.update():error updating DateNight: ' + error
         )
       );
     })
    );
   }
}
