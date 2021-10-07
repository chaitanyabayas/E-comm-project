import { Injectable } from '@angular/core';

import {
  HttpClient,
  HttpEvent,
  HttpErrorResponse,
  HttpHeaders,
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, take } from 'rxjs/operators';
import { ToasterService } from './toaster.service';

import { Auth } from '../models/Auth.model';
import { select, Store } from '@ngrx/store';
import { Location } from '@angular/common';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class ApiCallerService implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    throw new Error('Method not implemented.');
  }
  // httpOptions = {};
  // options = {};
  // userId!: string;
  // token!: string;
  // header: any;
  // baseURL!: string;
  // constructor(
  //   private http: HttpClient,
  //   private toaster: ToasterService,
  //   private authStore: Store<{ auth: User }>
  // ) {
  //   this.authStore.pipe(select('auth')).subscribe((data) => {
  //     if (data.isAuthenticated) {
  //       this.userId = data.user.id + '';
  //       this.token = data.user.token;
  //     }
  //   });
  // }
  // apiGetCall = (URL: string, isAuthenticated: boolean) => {
  //   if (this.userId)
  //     this.httpOptions = {
  //       headers: new HttpHeaders({
  //         'Content-Type': 'application/json',
  //         XUUID: this.token,
  //         userId: this.userId,
  //       }),
  //     };
  //   return this.http
  //     .get(this.baseURL + URL, isAuthenticated ? this.httpOptions : {})
  //     .pipe(
  //       take(1),
  //       map((event: any) => {
  //         if (event.status) {
  //           return event;
  //         } else {
  //           this.toaster.getToastMessage(
  //             event.msg || event.message,
  //             'error',
  //             3000,
  //             'bottom-end'
  //           );
  //           return null;
  //         }
  //       }),
  //       catchError((error: HttpErrorResponse) => {
  //         this.toaster.getToastMessage(
  //           error.error.message || error.statusText,
  //           'error',
  //           3000,
  //           'bottom-end'
  //         );
  //         return throwError(error.error);
  //       })
  //     );
  // };
  // apiPostCall = (
  //   URL: string,
  //   data: any,
  //   isAuthenticated: boolean,
  //   isToaster: boolean = true
  // ) => {
  //   if (this.userId)
  //     this.httpOptions = {
  //       headers: new HttpHeaders({
  //         'Content-Type': 'application/json',
  //         XUUID: this.token,
  //         userId: this.userId,
  //       }),
  //       responseType: 'blob' as 'json',
  //     };
  //   return this.http
  //     .post(this.baseURL + URL, data, isAuthenticated ? this.httpOptions : {})
  //     .pipe(
  //       take(1),
  //       map((event: any) => {
  //         if (event.status) {
  //           return event;
  //         } else {
  //           if (isToaster)
  //             this.toaster.getToastMessage(
  //               event.msg || event.message,
  //               'error',
  //               3000,
  //               'bottom-end'
  //             );
  //           return null;
  //         }
  //       }),
  //       catchError((error: HttpErrorResponse) => {
  //         if (isToaster)
  //           this.toaster.getToastMessage(
  //             error.error
  //               ? error.error.message
  //               : error.message || error.statusText,
  //             'error',
  //             3000,
  //             'bottom-end'
  //           );
  //         return throwError(error.error);
  //       })
  //     );
  // };
  // makeAuthCall = (URL: string, data: Auth): Observable<any> => {
  //   var header = {
  //     headers: new HttpHeaders()
  //       .set('X-AUTH', 'Basic ' + btoa(data.email + ':' + data.password))
  //       .set('X-Real-IP', '127.0.0.1'),
  //   };
  //   return this.http.get(this.baseURL + URL, header).pipe(
  //     take(1),
  //     map((event: any) => {
  //       if (event.status) {
  //         return event;
  //       } else {
  //         this.toaster.getToastMessage(
  //           event.msg || event.message,
  //           'error',
  //           3000,
  //           'bottom-end'
  //         );
  //         return null;
  //       }
  //     }),
  //     catchError((error: HttpErrorResponse) => {
  //       this.toaster.getToastMessage(
  //         error.error.message || error.statusText,
  //         'error',
  //         3000,
  //         'bottom-end'
  //       );
  //       return throwError(error.error);
  //     })
  //   );
  // };
  // apiFormDataPostCall = (URL: string, data: any, isAuthenticated: boolean) => {
  //   if (this.userId)
  //     this.httpOptions = {
  //       headers: new HttpHeaders({
  //         XUUID: this.token,
  //         userId: this.userId,
  //       }).set('X-Real-IP', '127.0.0.1'),
  //     };
  //   return this.http
  //     .post(this.baseURL + URL, data, isAuthenticated ? this.httpOptions : {})
  //     .pipe(
  //       take(1),
  //       map((event: any) => {
  //         if (event.status) {
  //           return event;
  //         } else {
  //           this.toaster.getToastMessage(
  //             event.msg || event.message,
  //             'error',
  //             3000,
  //             'bottom-end'
  //           );
  //           return null;
  //         }
  //       }),
  //       catchError((error: HttpErrorResponse) => {
  //         this.toaster.getToastMessage(
  //           error.error.message || error.statusText,
  //           'error',
  //           3000,
  //           'bottom-end'
  //         );
  //         return throwError(error.error);
  //       })
  //     );
  // };
  // intercept(
  //   req: HttpRequest<any>,
  //   next: HttpHandler
  // ): Observable<HttpEvent<any>> {
  //   return next.handle(req);
  // }
}
