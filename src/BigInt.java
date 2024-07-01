import java.util.InputMismatchException;
import java.util.LinkedList;
/**
    * Represents a large integer number.
     
    * @author Giannopoulos Georgios
    * 
    * @version 1.0
    
**/
public class BigInt {
    private LinkedList<Integer> digits;
    /**
         * Constructs a BigInt object from a string representation of a number.
         * 
         * @param number the string representation of the number
         * @throws InputMismatchException if the input contains non-digit characters
         */
    public BigInt(String number) {
        for (char c : number.toCharArray()){
            if (!Character.isDigit(c)) {
                throw new InputMismatchException("Invalid input: " + number + " contains non-digit characters!!!");
            }
        }

        digits = new LinkedList<>();

        for(int i = number.length() - 1; i>=0; i--) {
            digits.add(Character.getNumericValue(number.charAt(i))); 
        }
    }
}
