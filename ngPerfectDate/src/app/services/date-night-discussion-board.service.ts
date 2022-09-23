import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { DateNightDiscussionBoard } from '../models/date-night-discussion-board';

@Injectable({
  providedIn: 'root'
})
export class DateNightDiscussionBoardService {
  private baseUrl = 'http://localhost:8090/'
  private url = this.baseUrl + 'api/datenightdiscussionboards';

  constructor(private http: HttpClient) { }

  getAllDateNightDiscussionBoards(): Observable<DateNightDiscussionBoard[]> {
    return this.http.get<DateNightDiscussionBoard[]>(this.url).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'DateNightDiscussionBoardService.getAllDateNightDiscussionBoards():error retrieving DateNightDiscussionBoards: ' + error
          )
        )
      })
    );
  }

  getDateNightDiscussionBoard(id: number): Observable<DateNightDiscussionBoard> {
    return this.http.get<DateNightDiscussionBoard>(this.url + '/' + id).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'DateNightDiscussionBoardService.getDateNightDiscussionBoard():error retrieving DateNightDiscussionBoard: ' + error
          )
        )
      })
    );
  }


  create(dateNightDiscussionBoard: DateNightDiscussionBoard): Observable<DateNightDiscussionBoard> {
    return this.http.post<DateNightDiscussionBoard>(this.url, dateNightDiscussionBoard).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'DateNightDiscussionBoardService.create():error creating DateNightDiscussionBoard: ' + error
         )
       );
     })
    );
   }

   delete(dateNightDiscussionBoardId: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${dateNightDiscussionBoardId}`).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'DateNightDiscussionBoardService.delete():error deleting DateNightDiscussionBoard: ' + error
         )
       );
     })
    );
   }

   update(dateNightDiscussionBoard: DateNightDiscussionBoard): Observable<DateNightDiscussionBoard> {
    return this.http.put<DateNightDiscussionBoard>(this.url, dateNightDiscussionBoard).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'DateNightDiscussionBoardService.update():error updating DateNightDiscussionBoard: ' + error
         )
       );
     })
    );
   }
}
