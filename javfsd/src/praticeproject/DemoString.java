package praticeproject;

//package praticeProject1;

public class DemoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("Methods of Strings");
	   String sl=new String("Hello Akshatha");

	   System.out.println(sl.length());

		//substring
		String sub=new String("Welcome");
		System.out.println(sub.substring(2));

		//String Comparison
		String s1="Akshatha";
		String s2="Heldo";
		System.out.println(s1.compareTo(s2));

		//IsEmpty
		String s4="";
		System.out.println(s4.isEmpty());

		//toLowerCase
		String s5="Akshatha";
		System.out.println(s1.toLowerCase());
		
		//replace
		String s6="Heldo";
		String replace=s2.replace('d', 'l');
		System.out.println(replace);

		//equals
		String x="Welcome to Java";
		String y="WeLcOmE tO JaVa";
		System.out.println(x.equals(y));

		System.out.println("\n");
		System.out.println("Creating StringBuffer");
		//Creating StringBuffer and append method
		StringBuffer s=new StringBuffer("Welcome to Java!");
		s.append("Enjoy your learning");
		System.out.println(s);

		//insert method
		s.insert(0, 'w');
		System.out.println(s);

		//replace method
		StringBuffer sb=new StringBuffer("Hello");
		sb.replace(0, 2, "hEl");
		System.out.println(sb);

		//delete method
		sb.delete(0, 1);
		System.out.println(sb);
		
		//StringBuilder
		System.out.println("\n");
		System.out.println("Creating StringBuilder");
		StringBuilder sb1=new StringBuilder("Happy");
		sb1.append("Learning");
		System.out.println(sb1);

		System.out.println(sb1.delete(0, 1));

		System.out.println(sb1.insert(1, "Welcome"));

		System.out.println(sb1.reverse());
				
		//conversion	
		System.out.println("\n");
		System.out.println("---Conversion of Strings to StringBuffer and StringBuilder---");
		
		String str = "Akshatha"; 
       
       // conversion from String object to StringBuffer 
       StringBuffer sbr = new StringBuffer(str); 
       sbr.reverse(); 
       System.out.println("---String to StringBuffer---");
       System.out.println(sbr); 
         
       // conversion from String object to StringBuilder 
       StringBuilder sbl = new StringBuilder(str); 
       sbl.append("gupta"); 
       System.out.println("---String to StringBuilder---");
       System.out.println(sbl);


	}

}
