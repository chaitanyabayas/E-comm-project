import {
  HttpClient,
  HttpErrorResponse,
  HttpEvent,
  HttpHeaders,
  HttpInterceptor,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { select, Store } from '@ngrx/store';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { User } from '../models/user';
import { ToasterService } from './toaster.service';

@Injectable({
  providedIn: 'root',
})
export class ProductServiceService implements HttpInterceptor {
  httpOptions = {};
  userId!: string;
  token!: string;
  header: any;

  constructor(private http: HttpClient, private toaster: ToasterService,
       private authStore: Store<{ auth: User }>) {
    this.authStore.pipe(select('auth')).subscribe((data) => {
          if (data.isAuthenticated) {
            this.userId = data.user.id + '';
            this.token = data.user.token;
          }
        });
  }
  intercept(): Observable<HttpEvent<any>> {
    throw new Error('Method not implemented.');
  }

  getAllProducts() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };

    return this.http.get('http://localhost:8764/product/getProducts').pipe(
      map((event: any) => {
        if (event.status) {
          return event;
        } else {
          this.toaster.getToastMessage(
            event.msg || event.message,
            'error',
            3000,
            'bottom-end'
          );
          return null;
        }
      }),
      catchError((error: HttpErrorResponse) => {
        this.toaster.getToastMessage(
          error.error.message || error.statusText,
          'error',
          3000,
          'bottom-end'
        );
        return throwError(error.error);
      })
    );
  }

  apiFormDataPostCall = (URL: string, data: any) => {
    this.httpOptions = {
      headers: new HttpHeaders({
        XUUID: this.token,
          userId: this.userId,
        }).set('X-Real-IP', '127.0.0.1'),
    };
    return this.http.post(URL, data ? this.httpOptions : {}).pipe(
      map((event: any) => {
        if (event.status) {
          return event;
        } else {
          this.toaster.getToastMessage(
            event.msg || event.message,
            'error',
            3000,
            'bottom-end'
          );
          return null;
        }
      }),
      catchError((error: HttpErrorResponse) => {
        this.toaster.getToastMessage(
          error.error.message || error.statusText,
          'error',
          3000,
          'bottom-end'
        );
        return throwError(error.error);
      })
    );
  };
  
}
