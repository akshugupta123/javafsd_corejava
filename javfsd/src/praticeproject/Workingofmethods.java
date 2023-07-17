package praticeproject;

//package praticeProject1;


public class Workingofmethods {
	
	public int multipynumbers(int a,int b) {
		int z=a*b;
		//int z=a+b;
		return z;
			
	}
	//calling methods
	int val=250;

	int operation(int val) {
		val =val*10/100;
		return(val);
	}
    //method overloading
	public void area(int b,int h)
    {
         System.out.println("Area of Triangle : "+(0.5*b*h));
    }
    public void area(int r) 
    {
         System.out.println("Area of Circle : "+(3.14*r*r));
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Workingofmethods b=new Workingofmethods();
		int ans= b.multipynumbers(3,3);
		System.out.println("Multipilcation is :"+ans);
		System.out.println("\n");
		//calling methods
		System.out.println("---calling methods---");
		System.out.println("Before operation value of data is "+b.val);
		b.operation(100);
		System.out.println("After operation value of data is "+b.val);
		System.out.println("\n");
		System.out.println("---method overloading---");
		//method overloading
	       b.area(50,12);
	       b.area(5);  


	}

}

