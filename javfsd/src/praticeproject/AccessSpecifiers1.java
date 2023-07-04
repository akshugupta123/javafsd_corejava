package praticeproject;



class defaultAccessSpecifier
{ 
  void display() 
     { 
         System.out.println("defalut access specifier"); 
     } 
} 

public class AccessSpecifiers1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Dafault Access Specifier");
		defaultAccessSpecifier obj = new defaultAccessSpecifier(); 		  
        obj.display(); 

	}

}

