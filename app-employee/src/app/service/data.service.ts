import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private apiService: ApiService) { }

  getAllEmployees(): Observable<any> {
    return this.apiService.get("http://localhost:7075/getAllEmployees");
  }
}
