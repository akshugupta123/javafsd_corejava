import { Component, OnInit } from '@angular/core';
import { Emp } from '../emp';
import { EmpService } from '../emp.service';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.css']
})
export class EmpComponent implements OnInit {

  empinfo:Emp[] = [];
  ename:any;
  p:number=1;
  constructor(private service:EmpService) { }

  ngOnInit(): void {
    this.service.getAllEmployeeDetails().subscribe(data=>{
      this.empinfo = data;
    });
  }

  Search()
  {
    if(this.ename=="")
    {
      this.ngOnInit();
    }
    else
    {
      this.empinfo = this.empinfo.filter(res=>{
        //return res.ename.match(this.ename);
        return res.ename.toLocaleLowerCase().match(this.ename);
      });
    }
  }
  key:any='';
  reverse:boolean = false;
  sort(key:any)
  {
    this.key = key;
    this.reverse= !this.reverse;
  }

}
