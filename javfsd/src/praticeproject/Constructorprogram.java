package praticeproject;

//package praticeProject1;
//default constructor
class EmpInfo{
	int id;
	String name;
	int age;

void display() {
	System.out.println(id+" "+name+" "+age);
	}
}
//parameter constructor
class Student{
	int id;
	String name;
	int age;

	Student(int i,String n,int x)
	{
	id=i;
	name=n;
	age=x;
	}

	void display() {
	System.out.println(id+" "+name+" "+age);
	}
}

public class Constructorprogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---default construct---");
		EmpInfo emp1=new EmpInfo();
		EmpInfo emp2=new EmpInfo();

		emp1.display();
		emp2.display();
		System.out.println("--parameterconstructor---");
		Student std1=new Student(2,"Akshatha",24);
		Student std2=new Student(10,"Annie",10);
		std1.display();
		std2.display();

		


	}

}

