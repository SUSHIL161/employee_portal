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

  addEmployee(employee):Observable<any> {
    return this.apiService.postJSONData("http://localhost:7075/addEmployee", employee, true);
  }
  updateEmployee(empID:string,employee:any):Observable<any> {
    return this.apiService.putJSONData("http://localhost:7075/updateEmployee/"+empID, JSON.stringify(employee), true);
  }
}
