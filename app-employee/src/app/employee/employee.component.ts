import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  employees: any = [];
  headers: any = [];
  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.dataService.getAllEmployees().subscribe(
      response => this.employees = response
    ), error => {

    }, () => {
      
    };
    this.headers = ['First Name', 'Last Name', 'Gender', 'Date of Birth', 'Department'];
  }


}
