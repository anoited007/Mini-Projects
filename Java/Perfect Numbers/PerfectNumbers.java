
public class PerfectNumbers
{
// This method to check if a number is a perfect number. 
	public static boolean isPerfect(int number) {
	    int sumOfFactors = 0;
		//No need to find the factors of a number less than 2
	    if(number < 2)
	    return false;
	    
	    else {
	        for(int i=1; i<=number/2; i++){
	          if(number % i == 0) {
	              sumOfFactors += i;
	          }  
	        }
	   }
	   return sumOfFactors == number; 
	}
  
	// This method to print perfect numbers within a range 
	public static void isPerfect(int firstNum, int secondNum) {
	    //Ensure that the first number is the smallest
	    firstNum = Math.min(firstNum, secondNum);
	    secondNum = Math.max(firstNum, secondNum);
	    	    
	    if(firstNum < 2)
	    System.out.println("Enter a number greater than 1.");
	    
	    else {
	        System.out.printf("Number \t %s%n", "Factors");
	        for(int i=firstNum; i<=secondNum; i++) {
				int sumOfFactors = 0;
				String factors = " ";
	            //Using the notion that a number can't have a factor greater than half of its size
	            for(int j = 1; j <= i/2; j++) {
	                if(i % j == 0) {
	                  sumOfFactors += j;
					  factors += (j+",");
	                }	
		        }
				
				if(sumOfFactors == i){
					System.out.printf("%6d \t %s %n", i,factors);
				}
	        }
	    }
	      
	}
	
	public static void main(String[] args) {
		isPerfect(5,100);
	}
}
