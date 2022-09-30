import { AdditionalImage } from './../models/additional-image';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdditionalImageService {

  private url = environment.baseUrl + 'api/additionalimages';

  constructor(private http: HttpClient) { }

  getAllAdditionalImages(): Observable<AdditionalImage[]> {
    return this.http.get<AdditionalImage[]>(this.url).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'AdditionalImageService.getAllAdditionalImages():error retrieving list from AdditionalImage: ' + error
          )
        )
      })
    );
  }

  getAdditionalImage(id: number): Observable<AdditionalImage> {
    return this.http.get<AdditionalImage>(this.url + '/' + id).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'AdditionalImageService.getAdditionalImage():error retrieving AdditionalImage: ' + error
          )
        )
      })
    );
  }

  create(additionalImage: AdditionalImage): Observable<AdditionalImage> {
    return this.http.post<AdditionalImage>(this.url, additionalImage).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'AdditionalImageService.create():error creating AdditionalImage: ' + error
         )
       );
     })
    );
   }

   delete(additionalImage: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${additionalImage}`).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'AdditionalImageService.delete():error deleting AdditionalImage: ' + error
         )
       );
     })
    );
   }

   update(additionalImage: AdditionalImage): Observable<AdditionalImage> {
    return this.http.put<AdditionalImage>(this.url, additionalImage).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'AdditionalImageService.update():error updating AdditionalImage: ' + error
         )
       );
     })
    );
   }
}
