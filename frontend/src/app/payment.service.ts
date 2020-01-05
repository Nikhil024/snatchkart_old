import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private httpService: HttpClient) { }

  capturePayment() {
    let url = 'http://localhost:8080/secure/payments/properties';
    let bearer = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1ZTA4Y2VjMWUwMTMzZjYwZmIwNDc3Y2EiLCJpYXQiOjE1Nzc3ODI0ODUsImV4cCI6MTU3ODY0NjQ4NX0.vIXFXxijtNTyqL9DlBG5WOg0gEeicqSd8buaGhj7yrUBV6ieF461fsMYPZKsllqELryKIZsET_sp7KvhCg5lsw';
    let headers = new HttpHeaders({
      'Authorization': 'bearer ' + bearer
    });
    return this.httpService.post(url, {headers: headers});
  }
}
