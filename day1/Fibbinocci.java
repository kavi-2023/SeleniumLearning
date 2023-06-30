package week1.day1;

public class Fibbinocci {
	public static void main(String[] args) {
		
		int firstNum= 0;
		int SecNum = 1;
		int sum = 0;
		
		System.out.println(firstNum+"\n"+SecNum);
		
		for( int i =1;i<=11; i++) {
		
		sum=(firstNum+SecNum);//sum=0+1=1
		
	    firstNum=SecNum;//1
	    
	    SecNum=sum;//1
	    System.out.println(sum);//0, 1, 1, 2, 3, 5, 8, 13
	    
	}
					
		}
	
	}
	


