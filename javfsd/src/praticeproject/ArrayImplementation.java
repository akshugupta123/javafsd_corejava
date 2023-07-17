package praticeproject;


public class ArrayImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//single-dimensional array
		int a[]= {100,200,300,400,500};
		for(int i=0;i<5;i++) {
		System.out.println("Elements of array a: "+a[i]);
		//multidimensional array
		int[][] b = {
		            {2, 4, 6, 8}, 
		            {3, 6, 9} };
		      
		      System.out.println("\nLength of row 1: " + b[0].length);
		      }
	}

}

