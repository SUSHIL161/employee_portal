import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  get(url:string): Observable<any> {
    return this.http.get(url);
  }

  post(url:string, data: any): Observable<any> {
    return this.http.post(url,data);
  }

  postJSONData(path: string, body: Object = {}, enableHttpHeaders: boolean): Observable<any> {
    let httpOptions = {};
    if (enableHttpHeaders) {
      httpOptions = {
       headers: new HttpHeaders({
         'Content-Type':  'application/json'
       }),
        withCredentials: false,
        observe: 'response' as 'response'
     };
   }
    return this.http.post(path, body, httpOptions);
  }
  putJSONData(path: string, body: Object = {}, enableHttpHeaders: boolean): Observable<any> {
    let httpOptions = {};
    if (enableHttpHeaders) {
      httpOptions = {
       headers: new HttpHeaders({
         'Content-Type':  'application/json'
       }),
        withCredentials: false,
        observe: 'response' as 'response'
     };
   }
    return this.http.put(path, body, httpOptions);
  }
}
