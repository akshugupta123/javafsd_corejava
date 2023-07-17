package praticeproject;

//package praticeProject1;

public class InnerClass1 {
	private String msg="Inner Classes";

	 void display(){  
		 class Inner{  
			 void msg(){
				 System.out.println(msg);
			 }  
	  }  
	  
	  Inner l=new Inner();  
	  l.msg();  
	 }  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClass1  ob=new InnerClass1 ();  
		ob.display();  


	}

}

