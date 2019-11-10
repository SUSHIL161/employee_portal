import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service';
import { TranslateService } from '@ngx-translate/core';
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  employees: any = [];
  headers: any = [];
  i18text: any;
  employee: any = {};
  constructor(private dataService: DataService, private translateService: TranslateService) {
    this.translateService.setDefaultLang('en');
    this.translateService.use('en');
    this.translateService.get('employee').subscribe((res: any) => {
      this.i18text = {'employee': res};
      console.log(JSON.stringify(this.i18text));
    }, (error) => {
      console.log(error)
    });

   }

  ngOnInit() {
    this.dataService.getAllEmployees().subscribe(
      (response) => {this.employees = response },
      error => { },
    );
    this.headers = ['First Name', 'Last Name', 'Gender', 'Date of Birth', 'Department'];

  }

  onUpdate = (employee) => {
    console.log(employee);
  }

  selectOption = (option) => {
    console.log(option);
  }
}
