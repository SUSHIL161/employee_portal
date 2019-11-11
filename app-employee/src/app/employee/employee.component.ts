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
  isupdate: boolean = false;
  employeeBeingEdited: any = {};
  formError:any = {};
  textPattern: RegExp;

  constructor(private dataService: DataService, private translateService: TranslateService) {
    this.translateService.setDefaultLang('en');
    this.translateService.use('en');
    this.translateService.get('employee').subscribe((res: any) => {
      this.i18text = {'employee': res};
    }, (error) => {
    });

   }

  ngOnInit() {
    this.dataService.getAllEmployees().subscribe(
      (response) => {this.employees = response },
      error => { },
    );
    this.headers = ['First Name', 'Last Name', 'Gender', 'Date of Birth', 'Department'];
    this.showView = {
      'registration': true,
      'viewAll': false
    }
    this.textPattern = new RegExp(/^[a-zA-Z][a-zA-Z]*$/g);
  }

  onUpdate = (employee) => {
    this.employee = JSON.parse(JSON.stringify(employee));
    this.employeeBeingEdited = JSON.parse(JSON.stringify(employee));
    this.showView['registration'] = true;
    this.showView['viewAll'] = false;
    this.isupdate = true;
  }

  sortEmployee = () => {
    this.employees.sort((first,second) => first.firstName.toLowerCase() > second.firstName.toLowerCase() ? 1:  first.firstName.toLowerCase() < second.firstName.toLowerCase() ? -1 : 0);
    this.employee = {};
    this.showView.registration = false;
    this.showView.viewAll = true;
  }
  
  submit = () => {
    if(this.isupdate) {
      this.dataService.updateEmployee(this.employee.empID, this.employee).subscribe((response) => {
        if(response.body.success && response.body.employee) {
          let index = this.employees.findIndex(employee=> employee.empID === this.employeeBeingEdited.empID);
          this.employee = response.body.employee;
          if(index >=0 ) {
            this.employees[index] = this.employee;
            alert('Upated Successfully');
            this.sortEmployee();
          } else {
            alert('Failed to Save');
          }
        } else {
          alert('Failed to Save');
        }
      }, (error) => {
        alert('Failed to Update');
      });
    } else {
      this.dataService.addEmployee(this.employee).subscribe((response) => {
        if(response.body.success && response.body.employee) {
          this.employee = response.body.employee;
          this.employees.push(this.employee);
          this.sortEmployee();
          alert('Saved Successfully');
        } else {
          alert('Failed to Save');
        }
      }), error => {
        alert('Failed to Save');
      }
    }

  }

  selectView = (option1, option2) => {
    this.showView[option1] = true;
    this.showView[option2] = false;
    this.employee = {};
    this.formError = {};
  }

  parseText = (key:string) => {
    if(this.employee[key] && this.employee[key].trim().length > 0) {
      delete this.formError[key];
    } else {
      this.formError[key] = true;
    }
  }
  
  isError = () =>  Object.keys(this.formError).length > 0;

}
