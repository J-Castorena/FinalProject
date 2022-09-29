import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { BlogComment } from '../models/blog-comment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class BlogCommentService {
  private baseUrl = 'http://localhost:8090/'
  private url = environment.baseUrl + 'api/blogcomments';

  constructor(private http: HttpClient,private auth: AuthService) { }

  getAllBlogComments(): Observable<BlogComment[]> {
    return this.http.get<BlogComment[]>(this.url).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'BlogCommentService.getAllBlogComments():error retrieving list from BlogComment: ' + error
          )
        )
      })
    );
  }

  getAllBlogCommentsById(id: number): Observable<BlogComment[]> {
    return this.http.get<BlogComment[]>(this.baseUrl + 'api/blogs/' + id + '/comments', this.getHttpOptions()).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'BlogCommentService.getAllBlogComments():error retrieving list from BlogComment: ' + error
          )
        )
      })
    );
  }

  getBlog(id: number): Observable<BlogComment> {
    return this.http.get<BlogComment>(this.url + '/' + id).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'BlogCommentService.getBlog():error retrieving BlogComment: ' + error
          )
        )
      })
    );
  }

  create(blogComment: BlogComment): Observable<BlogComment> {
    return this.http.post<BlogComment>(this.url, blogComment).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'BlogCommentService.create():error creating BlogComment: ' + error
         )
       );
     })
    );
   }

   delete(blogCommentId: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${blogCommentId}`).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'BlogCommentService.delete():error deleting BlogComment: ' + error
         )
       );
     })
    );
   }

   update(blogComment: BlogComment): Observable<BlogComment> {
    return this.http.put<BlogComment>(this.url, blogComment).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'BlogCommentService.update():error updating BlogComment: ' + error
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
