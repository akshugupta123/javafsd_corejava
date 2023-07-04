package praticeproject;

//package praticeProject1;
//Writing a program in Java to implement implicit and explicit type casting
public class Typecasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//implicit conversion
				System.out.println("Type Casting Implicit");
				char a='C';
				int b=a;
				float c=a;
				long d=a;
				double e=a;
				System.out.println("Value of a: "+a);				
				System.out.println("Value of b: "+b);
				System.out.println("Value of c: "+c);				
				System.out.println("Value of d: "+d);
				System.out.println("Value of e: "+e);					
				System.out.println("\n");
				
				System.out.println("Explicit Type Casting");
				//explicit conversion		
				double m=58.5;
				int n=(int)m;
				System.out.println("Value of m: "+m);
				System.out.println("Value of n: "+n);

				

	}

}

