package praticeproject;


class privateaccessspecifier 
{ 
   private void display() 
    { 
        System.out.println(" private access specifier"); 
    } 
} 

public class AccessSpecifiersPrivate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Private Access Specifier");
		privateaccessspecifier  obj = new privateaccessspecifier(); 
        //trying to access private method of another class 
        //obj.display();


	}

}
