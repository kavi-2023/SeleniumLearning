package week1.day2;

public class MissingElementInArray {
	
	public static void main(String[] args) {
	 
		int[] a= {1,2,3,4,5,7};
		
		int len=a.length;
				
		for (int i = a[0]; i <=len+1; i++) {
			
				   
				if(i!=a[i-1]) {
					
					System.out.println("Missing Element:"+i);
							
				   break;
				}	
			
			}
			}
		}
	



