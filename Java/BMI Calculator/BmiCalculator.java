
import java.util.*;

public class BmiCalculator {
	int unit;
	double weight;
	double height;
	double bmi;
	
	Scanner input = new Scanner(System.in);
	
	public double calculateBmi() {
	System.out.println("Please select your unit of measurement (the preceeding number):");
	System.out.println("1. Weight in pounds, height in inches\n 2. Weight in kilograms, height in meters");
	
	try {
			unit = input.nextInt();
		} catch (InputMismatchException e) 
		
		{
			System.out.println("Enter a numberic value");
		}
			
	switch(unit){
		case 1: 
		System.out.print("Enter your weight in Ibs (Pounds): ");
		
		try {
			weight = input.nextDouble();
		} catch (InputMismatchException e) 
		
		{
			System.out.println("Enter a numberic value");
		}
		
		
		System.out.print("Enter your height in In (Inches) : ");
		
		try {
			height = input.nextDouble();
		} catch (InputMismatchException e) 
		
		{
			System.out.println("Enter a numberic value");
		}
				
		bmi = (weight * 705)/(height*height);
		break;
		
		case 2: 
		System.out.print("Enter your weight in Kgs (Kilograms): ");
		try {
			weight = input.nextDouble();
		} catch (InputMismatchException e) 
		
		{
			System.out.println("Enter a numberic value");
		}
				
		System.out.print("Enter your height in m (Meters) : ");
		try {
			height = input.nextDouble();
		} catch (InputMismatchException e) 
		
		{
			System.out.println("Enter a numberic value");
		}
				
		bmi = weight / (height*height);
		
	}
	
	return bmi;
	}
  
  public static void main (String[] args) {
	  BmiCalculator bmi = new BmiCalculator();
	  double bmiValue = 0;
	  
	  try {
			bmiValue = bmi.calculateBmi();
		} catch (InputMismatchException e) 
		
		{
			System.out.println("Enter a numberic value");
		}
	  	    
	  if(bmiValue < 18.5) {
	  System.out.println("You are under-weight. Please consider increasing your daily meal intake."); }
	  
	  else if(bmiValue >= 18.5 || bmiValue <= 24.9)
	  System.out.println("Your weight is normal. Continue keeping your diet pattern to maintian your weight.");
	  
	  else if(bmiValue >= 25 || bmiValue <= 29.9) 
	  System.out.println("You are overweight. Please consider checking your diet to keep your weight under control.");
	  
	  else 
	  System.out.println("You are obese. It will be best to check your diet or consult your dietician for recommendations to keep your weight under control."); 
  }
}
