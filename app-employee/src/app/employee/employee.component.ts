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
  showView: any = {};
  employeeBeingEdited: any = {};
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
    this.showView = {
      'registration': false,
      'viewAll': false
    }

  }

  onUpdate = (employee) => {
    this.employee = JSON.parse(JSON.stringify(employee));
    this.employeeBeingEdited = JSON.parse(JSON.stringify(employee));
    this.showView['registration'] = true;
    this.showView['viewAll'] = false;

  }
  
  submit = () => {
    this.dataService.addEmployee(this.employee).subscribe((response) => {
      if(response.body) {
        let employee = JSON.parse(JSON.stringify(this.employee));
        this.employees.push(employee);
        this.employees.sort((first,second) => first.firstName.toLowerCase() > second.firstName.toLowerCase() ? 1:  first.firstName.toLowerCase() < second.firstName.toLowerCase() ? -1 : 0);
        this.employee = {};
        alert('Saved Successfully')
        this.showView.registration = false;
        this.showView.viewAll = true;
      } else {
        alert('Failed to Save')
      }
    }), error => {
      alert('Failed to Save');
    }
  }

  selectView = (option1, option2) => {
    this.showView[option1] = true;
    this.showView[option2] = false;
  }
}
