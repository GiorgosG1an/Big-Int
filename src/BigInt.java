import java.util.InputMismatchException;
import java.util.Iterator;
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

    /**
         * Returns the digits of the BigInt as a LinkedList of integers.
         *
         * @return the digits of the BigInt as a LinkedList of integers
         */
        public LinkedList<Integer> getDigits() {
            return digits;
        }

    /**
        * Count the number of digits in the BigInt.
        *
        * @return the number of digits in the BigInt
    */    
    public int countDigits() {
        int count = 0;
        for (int digit : digits) {
            count++;
        }
        return count;
    }

    /**
         * Compares this {@code BigInt} object with the specified object for equality.
         * Returns {@code true} if the specified object is also a {@code BigInt} object and
         * has the same digits in the same order as this {@code BigInt} object.
         *
         * @param obj the object to be compared for equality with this {@code BigInt} object
         * @return {@code true} if the specified object is equal to this {@code BigInt} object, {@code false} otherwise
         */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (obj instanceof BigInt == false) {
            return false;
        }

        BigInt objNumber = (BigInt)obj;
        Iterator<Integer> thisIter = digits.descendingIterator();
        Iterator<Integer> objIter = objNumber.digits.descendingIterator();
        
        while(thisIter.hasNext()) {

            if (!thisIter.next().equals(objIter.next())) {
                return false;
            }
        }
        return true;

    }

    public static BigInt add(BigInt a, BigInt b) {

        BigInt result;
        StringBuilder resultSB = new StringBuilder();
        int carry = 0;
        int sum = 0;
        int digitA = 0;
        int digitB = 0;

        Iterator<Integer> aIter = a.digits.iterator();
        Iterator<Integer> bIter = b.digits.iterator();

        while (aIter.hasNext() || bIter.hasNext()) {
            sum = 0;
            carry = 0;

            if (aIter.hasNext()) {
                digitA = aIter.next();
            }
            else {
                digitA = 0;
            }

            if (bIter.hasNext()) {
                digitB = bIter.next();
            }
            else {
                digitB = 0;
            }

            // check if there is a carry and add it
			if (digitA + digitB >= 10){
				carry = 1;
				sum = (digitA + digitB) % 10 + carry;
			}
			else{
				carry = 0;
				sum = digitA + digitB + carry;
            }
            resultSB.append(sum);
        }
        result = new BigInt(resultSB.toString());
        return result;
    }

    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder(); 
       Iterator<Integer> descIter = digits.descendingIterator();

       while(descIter.hasNext()) {
        sb.append(descIter.next());
       }

       return sb.toString();
    }
}
