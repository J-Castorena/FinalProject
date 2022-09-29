import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Blog } from '../models/blog';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  private baseUrl = 'http://localhost:8090/'
  private url = this.baseUrl + 'api/blogs';

  constructor(private http: HttpClient, private auth: AuthService) { }


  index() {

  }
  getAllBlogs(): Observable<Blog[]> {
    return this.http.get<Blog[]>(this.url).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'BlogService.getAllBlogs():error retrieving list from Blog: ' + error
          )
        )
      })
    );
  }

  getBlog(id: number): Observable<Blog> {
    return this.http.get<Blog>(this.url + '/' + id).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'BlogService.getBlog():error retrieving Blog: ' + error
          )
        )
      })
    );
  }


  create(blog: Blog): Observable<Blog> {
    return this.http.post<Blog>(this.url, blog).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'BlogService.create():error creating Blog: ' + error
         )
       );
     })
    );
   }

   delete(blogId: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${blogId}`,  this.getHttpOptions()).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'BlogService.delete():error deleting Blog: ' + error
         )
       );
     })
    );
   }

   update(blog: Blog): Observable<Blog> {
    return this.http.put<Blog>(this.url, blog,  this.getHttpOptions()).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'BlogService.update():error updating Blog: ' + error
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
