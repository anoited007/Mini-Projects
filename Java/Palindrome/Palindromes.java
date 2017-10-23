import java.util.Scanner;
/**
 * This class checks if an integer or a string is palindrome or not.
 */

public class Palindromes{
    /**
    * This method checks if a String is a palindrome.
    * @param input takes string as parameter. The method checks if this string is a palindrome or not.
    * @return True if the String is palindrome and false if it is not.
    */
    public boolean checkPalindromeString(String input){
        
        // this pattern [^A-Za-z0-9] means: match all characters that are NOT in the set 
        // A to Z, a to z, and 0 to 9.
        String newInput =input.replaceAll("[^A-Za-z0-9]", "");
        char[] word = newInput.toLowerCase().toCharArray();
	int wordLength = word.length-1; 
	
        for(int i = 0; i<word.length; i++,wordLength--){
            if(word[i]!=(word[wordLength])){
                return false;
            }
        }
        return true;
    }
    
    /**
     * @param input takes an integer as parameter. 
     * @return True if the integer is palindrome and false if it is not.
     */
    public boolean checkPalindromeNumber(int input){
        String newInput= Integer.toString(input);
        return checkPalindromeString(newInput); 
    }
}
