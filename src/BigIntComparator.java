import java.util.Comparator;
import java.util.Iterator;
/**
 * A comparator for comparing two {@code BigInt} objects based on their values.
 * The comparison is done by comparing the number of digits first, and then comparing the digits themselves.
 * A {@code BigInt} object with more digits is considered greater than a BigInt object with fewer digits.
 * If two {@code BigInt} objects have the same number of digits, the comparison is done by comparing the digits from the end to the beginning.
 * The first different digit encountered determines the result of the comparison.
 * If all digits are equal, the two {@code BigInt} objects are considered equal.
 * 
 */
public class BigIntComparator implements Comparator<BigInt>{
    /**
	 * Compares two {@code BigInt} objects based on their values.
	 * @param num1 the first {@code BigInt} object
	 * @param num2 the second {@code BigInt} object
	 * @return 
	 * 
	 *  <b>1</b> if the first {@code BigInt} object is greater than the second {@code BigInt} object,
	 *  
	 * <b>-1</b> if the first {@code BigInt} object is smaller than the second {@code BigInt} object, 
	 * 
	 *  <b>0</b> if the two {@code BigInt} objects are equal
	 */
    @Override
    public int compare(BigInt num1, BigInt num2) {
        // compare number of digits
        if(num1.countDigits() > num2.countDigits()) {
            // num1 has more digits than num2, so its value is greater
            return 1;
        }
        else if (num1.countDigits() < num2.countDigits()) {
            // num1 has fewer digits than num2, so its value is smaller
            return -1;
        }
        else {
            // they have the same number of digits
            // compare the digits using descending iterators
            Iterator<Integer> num1Iter = num1.getDigits().descendingIterator();
            Iterator<Integer> num2Iter = num2.getDigits().descendingIterator();

            while(num1Iter.hasNext()) {
               int digit1 = num1Iter.next();
               int digit2 = num2Iter.next();

               if(digit1 > digit2) {
                return 1;
               }
               else if (digit1 < digit2) {
                return -1;
               }
               else {
                continue;
               }

            }
        }
        // the two BigInt numbers are equal
        return 0;
    }
}
