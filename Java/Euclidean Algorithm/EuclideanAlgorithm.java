
import java.util.Scanner;
import java.util.InputMismatchException;

public class EuclideanAlgorithm
{
    public static int calculateGcd(int firstNum, int secondNum){
        int remainder = 0;
		int quotient = 0;
        int dividend = Math.max(firstNum, secondNum);
        int divisor = Math.min(firstNum, secondNum);
        int gcd = 0;
            
        do {
		if(divisor > 0) {
            remainder = dividend % divisor;
            quotient = dividend - remainder;
			
			if(remainder == 0) {
				gcd = divisor;
				return gcd;
			   }
			}
			
            if(remainder !=0){
            gcd = remainder; 
            dividend = quotient;
            divisor = remainder;
            }
        } while(remainder > 1);
        
        return gcd;    
    }
    
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int firstNum = 0;
		int secondNum = 0;
		
		try {
			System.out.print("Enter fisrt number: ");
			firstNum = input.nextInt();
			System.out.print("Enter fisrt number: ");
			secondNum = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Enter a valid number!");
		}
		
		if(firstNum > 0 || secondNum > 0)
		System.out.print("GCD is " +calculateGcd(firstNum, secondNum));
	}
}
