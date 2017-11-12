public class EuclideanAlgorithm
{
    public static int calculateGcd(int firstNum, int secondNum){
        int remainder, gcd, quotient, divisor, dividend;
        
        dividend = Math.max(firstNum, secondNum);
        divisor = Math.min(firstNum, secondNum);
        gcd = 0;
            
        do {
            remainder = dividend % divisor;
            quotient = dividend - remainder;
            
            if(remainder !=0){
            gcd = remainder; 
            dividend = quotient;
            divisor = remainder;
            }
        } while(remainder > 1);
        
        return gcd;
        
    }
    
	public static void main(String[] args) {
		System.out.print("GCD is " +calculateGcd(120,200));
	}
}
