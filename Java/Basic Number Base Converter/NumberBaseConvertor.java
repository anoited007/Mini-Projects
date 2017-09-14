import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author (Immanuel) 
 * @version (2017)
 */
public class NumberBaseConvertor
{
   
    /**
     * Do not use this method to convert to Hexadecimal(Base 16)
     * @param number This is the integer or decimal value you want to convert.
     * @param base This is the number base you want to convert to. 
     * @return int[] An array of integers containing the converted number.
     */
    public static int[] decimalToLowerBase(Integer number, int base){

        ArrayList<Integer> numberBase = new ArrayList();
        int[] baseArray = null;
        
        if(base >= 16){
            System.out.println("You can not use this method to convert to Hexadecimal.");
        }

        else{

            while(number != 0){
                numberBase.add(number%base);
                number/=base;

                if(number == 1){
                    numberBase.add(number);
                    break;
                }
            }
            baseArray = new int[numberBase.size()];
            for(int i=0; i<baseArray.length; i++){
                baseArray[i] = numberBase.get(baseArray.length-i-1);
            }
        }
        return baseArray;
    }

    /**
     * Do not use this method to convert to other bases below 10.
     * @param number This is the integer or decimal value you want to convert.
     * @param base This is the number base you want to convert to. 
     * @return String A String containing the converted number.
     */
    public static String decimalToHigherBase(Integer number, int base){

        ArrayList<Integer> numberBase = new ArrayList();
        char[] charArray = null;
        if(base <= 10){
            System.out.println("Do not use this method to convert to other bases below 10.");
        }
        else{
            while(number != 0){
                int remainder = number%base;
                number/=base;
                numberBase.add(remainder);

                if(number == 1){
                    numberBase.add(number);
                    break;
                }
            }
            String[] stringArray = new String[numberBase.size()];
            for(int i=0; i<stringArray.length; i++){
                String[] specialValues = {"A", "B", "C", "D", "E", "F"};

                if(numberBase.get(stringArray.length-i-1) < 10){
                    stringArray[i] = numberBase.get(stringArray.length-i-1).toString();
                }
                else{
                    switch(numberBase.get(stringArray.length-i-1)){
                        case 10:
                        stringArray[i] = specialValues[0];
                        break;

                        case 11:
                        stringArray[i] = specialValues[1];
                        break;

                        case 12:
                        stringArray[i] = specialValues[2];
                        break;

                        case 13:
                        stringArray[i] = specialValues[3];
                        break;

                        case 14:
                        stringArray[i] = specialValues[4];
                        break;

                        case 15:
                        stringArray[i] = specialValues[5];
                        break;
                    }
                }
            }

            charArray = new char[stringArray.length];
            for(int i = 0; i<charArray.length; i++){
                charArray[i] = stringArray[i].charAt(0);
            }
        }
        return new String(charArray);
    }
}
