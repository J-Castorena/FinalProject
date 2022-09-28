import { AuthService } from 'src/app/services/auth.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { catchError } from 'rxjs/internal/operators/catchError';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8090/'
  private url = this.baseUrl + 'api/users';

  constructor(private http: HttpClient, private auth: AuthService) { }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'UserService.getAllUsers():error retrieving Users: ' + error
          )
        )
      })
    );
  }

  getUser(id: number): Observable<User> {
    return this.http.get<User>(this.url + '/uid/' + id).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'UserService.getUser():error retrieving User: ' + error
          )
        )
      })
    );
  }

  getUserByUsername(username: string): Observable<User> {
    return this.http.get<User>(this.url + '/' + username).pipe(
        catchError((error: any) => {
          console.log(error);
          return throwError(
            () => new Error(
              'UserService.getUser():error retrieving User: ' + error
            )
          )
        })
      );
  }


  create(user: User): Observable<User> {
    return this.http.post<User>(this.url, user).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'UserService.create():error creating User: ' + error
         )
       );
     })
    );
   }

   delete(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${userId}`).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'UserService.delete():error deleting User: ' + error
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

   update(user: User): Observable<User> {
    console.log(user);

    return this.http.put<User>(this.url + "/"+ user.id, user, this.getHttpOptions()).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'UserService.update():error updating User: ' + error
         )
       );
     })
    );
   }
}
