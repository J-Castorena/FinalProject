import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Address } from '../models/address';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private url = environment.baseUrl + 'api/address';

  constructor(private http: HttpClient) { }

  getAllAddress(): Observable<Address[]> {
    return this.http.get<Address[]>(this.url).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'AddressService.getAllAddress():error retrieving list from Address: ' + error
          )
        )
      })
    );
  }

  getAddress(id: number): Observable<Address> {
    return this.http.get<Address>(this.url + '/' + id).pipe(
      catchError((error: any) => {
        console.log(error);
        return throwError(
          () => new Error(
            'AddressService.getAddress():error retrieving Address: ' + error
          )
        )
      })
    );
  }

  create(address: Address): Observable<Address> {
    return this.http.post<Address>(this.url, address).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'AddressService.create():error creating Address: ' + error
         )
       );
     })
    );
   }

   delete(address: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${address}`).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'AddressService.delete():error deleting Address: ' + error
         )
       );
     })
    );
   }

   update(address: Address): Observable<Address> {
    return this.http.put<Address>(this.url, address).pipe(
     catchError((error: any) => {
       console.log(error);
       return throwError(
         () => new Error(
           'AddressService.update():error updating Address: ' + error
         )
       );
     })
    );
   }
}
