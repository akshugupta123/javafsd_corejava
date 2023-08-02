export class Employee {
    empno:number;
    ename:string;
    salary:number;
    job:string;

    constructor(eno:number, ename:string, sal:number, job:string)
    {
        this.empno = eno;
        this.ename = ename;
        this.job=job;
        this.salary=sal;
    }
}
