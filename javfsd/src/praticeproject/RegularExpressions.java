package praticeproject;

//package praticeProject1;
import java.util.regex.*;
public class RegularExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "[a-z]+";
		String check = "Akshatha gupta";
		Pattern p = Pattern.compile(pattern);
		Matcher c = p.matcher(check);
		
		while (c.find())
	      	System.out.println( check.substring( c.start(), c.end() ) );


	}

}
