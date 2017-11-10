
import java.util.Scanner;
import java.util.InputMismatchException;

/** 
This class creates a square with the side lenght the user will input.
*/
public class SquareGenerator
{
	public static void main(String[] args) {
	    
	    Scanner input = new Scanner(System.in);
	    int sideOfSquare = 0;
	    
	    try{
	         sideOfSquare = input.nextInt();
	    } catch(InputMismatchException e) {
	        System.out.println("Please enter a valid number!");
	    }
	    
	    if(sideOfSquare >= 2) {
	    
	    for(int i=0; i<sideOfSquare; i++){
	        if(i==0 || i == sideOfSquare -1){
	            for(int j=0; j<sideOfSquare; j++){
	                if(j==sideOfSquare-1)
	                System.out.println("* ");
	                
	                else
	                System.out.print("* ");
	            }
	            
	        }
	        
	        else {
	             for(int j=0; j<sideOfSquare; j++){
	                if(j==0)
	                System.out.print("* ");
	                
	                else if(j==sideOfSquare-1)
	                System.out.println("* ");
	                
	                else
	                System.out.print("  ");
	            }
	        }
	    } 
	}
	
	else 
	System.out.println("Please enter a number greater than 1.");    
	}
}
