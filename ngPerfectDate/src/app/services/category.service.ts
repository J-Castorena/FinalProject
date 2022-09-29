import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private baseUrl = 'http://localhost:8090/'
  private url = environment.baseUrl + 'api/categories';

  constructor(private http: HttpClient) { }

  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.url).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'CategoryService.getAllCategories():error retrieving list from Category: ' + error
          )
        )
      })
    );
  }

  getCategoryByName(name: string): Observable<Category> {
    return this.http.get<Category>(this.url + '/' + name).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'CategoryService.getCategory():error retrieving Category: ' + error
          )
        )
      })
    );
  }

  getListOfDateNightsPerCategory(){
    return this.http.get
  }

  create(category: Category): Observable<Category> {
    return this.http.post<Category>(this.url, category).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'CategoryService.create():error creating Category: ' + error
         )
       );
     })
    );
   }

   delete(categoryId: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${categoryId}`).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'CategoryService.delete():error deleting Category: ' + error
         )
       );
     })
    );
   }

   update(category: Category): Observable<Category> {
    return this.http.put<Category>(this.url, category).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'CategoryService.update():error updating Category: ' + error
         )
       );
     })
    );
   }

}
