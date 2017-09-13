  import java.util.Random;
/**
 * class RandomNumber is a class with methods that help explore Random class in Java. 
 * 
 * @author (Immanuel) 
 * @version (2017)
 */
 public class RandomNumber
 {
   
     public static void generateRandomTrip(int min, int max){
       Random random =  new Random();
       //Swapping the inputs to ensure that the min is smaller than max if the user inputs them interchangeably.
       if(min > max){
           min = max;
           max = min;
        }
        
       int param = (max - min) + 1;
       String[] continent = {"Africa", "Asia", "Australia", "Europe", "North America", "South America"};
       
       int continentIndex = random.nextInt(continent.length);
       int numberOfDays = random.nextInt(param) + min;
       
       System.out.println("You should visit " + continent[continentIndex] + " for " + numberOfDays+ " days");
    }
   
    public static int[] generatLotteryNum(){
        Random random = new Random();
        //int num1 = 1;
        //int num2 = 6;
        int[] array = {0,0,0,0,0,0}; 
        for(int i= 0; i<6; i++){
         // We add one to the generated number because the nextInt method generates from 0 to the paramenter -1. 
         int next = random.nextInt(49)+1;
         
         while(!notDuplicate(array,next)){
            next = random.nextInt(49)+1;
            }
          array[i] = next;           
       }
       return array;
   }
     
    private static boolean notDuplicate(int[] generatedArray, int generatedNumber){
      //Helper method to check if the generated number already exists in the array.
      for(int number : generatedArray){
       if(number == generatedNumber){
           return false;
        }
     }
     return true;
    }
	
	/**
     * @param min The minimum number of characters the password should have.
     * @param max The maximum number of characters the password should have.
     * @return A string of characters to be used as the password.
     */
    public static String generateStrongPassword(int min, int max){  
     /* I will be using ASCII codes to get the password. Hence a few things to note.
     * Capital letters range from 65 to 90.
     * Small letters range from 97 to 122.
     * Numbers range from 48 to 57.
     * Special characters range from 33 to 64.
     */
    
    Random generator = new Random();
    //Here the calculation is ((max-min)+1)+min 
    // Get the index to be used as the length of the array. It will also be the number of characters in the password.
    if(min > max){
           min = max;
           max = min;
     }
     
    int index = generator.nextInt((max-min)+1)+min;
    char[] charArray= new char[index];
    
    /* Generating the first four characters to meet the requirement.
     * Thus, at least one capital letter, one small letter, one special character and a number.
     */
    for(int i=0; i<4; i++){
      
        switch(i) {
            case 0: charArray[0] = (char)(generator.nextInt(26)+65); 
            break;
            case 1: charArray[1] = (char)(generator.nextInt(25)+97);
            break;
            case 2: charArray[2] = (char) (generator.nextInt(10)+48);
            break;
            case 3: charArray[3] = (char) (generator.nextInt(32)+33);
            break;
        }       
            
    }
    
    //Generating the remaining characters.
    for(int i=4; i<charArray.length; i++){
        charArray[i] = (char) (generator.nextInt(90)+33);
    }
    
    // Re-arraging the first 4 characters to make it less predictable
     for(int i=0; i<4; i++){
      int staticPos = generator.nextInt(4);
      char temp = charArray[staticPos];
      int pos = generator.nextInt(min);
      charArray[staticPos] = charArray[pos];
      charArray[pos] = temp;
    }
    
    // Create the String that will be returned
      String password = new String(charArray); 
      return password;
   } 
       
    }