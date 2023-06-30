package week1.day2;

import java.util.Arrays;

public class SecondLargestInArray {
	
	public static void main(String[] args) {
		
		int[] a= {20,2,15,8,9,25,30};
		
		int len=a.length;
		
	    Arrays.sort(a);
		
	  	System.out.println(a[len-2]);
		
}
}
