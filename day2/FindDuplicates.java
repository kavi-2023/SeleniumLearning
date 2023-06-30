package week1.day2;

public class FindDuplicates {
	public static void main(String[] args) {
		
		
	int[] nums = {2, 5, 7, 7, 5, 9, 2, 3};
    
    //Output = 2,5,7
    //Declare an outer for loop
    for (int i= 0; i < nums.length; i++) {
    	        
        //declare another for loop(inner)
        for (int j = i+1; j < nums.length; j++) {
            //compare both the arrays using if condition
            if(nums[i]==nums[j]) {
                System.out.println(nums[i]);
            }
            
        }
        
    }
}
}


