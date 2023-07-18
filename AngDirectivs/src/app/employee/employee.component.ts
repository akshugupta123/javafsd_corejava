import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  empinfo:Employee[]=[
    new Employee(1001, "Ravi", 10000.00, "Developer"),
    new Employee(1002, "Kavi", 9000.00, "Tester"),
    new Employee(1003, "Lavi", 15000.00, "HR Manager"),
    new Employee(1004, "Bavi", 9000.00, "Tester"),
    new Employee(1005, "Mavi", 10000.00, "Developer")
  ];
  newEmp:Employee=new Employee(0,"",0,"");

  constructor() { }

  ngOnInit(): void {
  }

  addNewEmployee()
  {
    this.empinfo.push(new Employee(this.newEmp.empno,this.newEmp.ename,this.newEmp.salary,this.newEmp.job));
    this.newEmp.empno = 0;
    this.newEmp.ename = "";
    this.newEmp.salary = 0;
    this.newEmp.job = "";
  }
  deleteEmployee(i:number)
  {
    if(confirm("Are u sure to delete an emp"))
    {
      this.empinfo.splice(i,1);
    }
  }
}
