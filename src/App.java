import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
		String number1, number2;
		BigInt num1, num2;
		BigIntComparator comparator = new BigIntComparator();

		System.out.println("\t\t\tWelcome to the BigInt Class!!!");

		System.out.println("Enter the first number:");
		number1 = input.nextLine();
		System.out.println("Enter the second number:");
		number2 = input.nextLine();

		try {
			num1 = new BigInt(number1);
			num2 = new BigInt(number2);

			// add the two BigInt objects 
			BigInt sum = BigInt.add(num1, num2);
			System.out.println("The sum of the two numbers is: " + sum.toString());

			// initialize the BigIntComparator object to compare the two BigInt objects
			
			int comparison = comparator.compare(num1, num2);
			
			if (comparison == 1) {
				System.out.println("Number2: " + num2.toString() + " is smaller than Number1: " + num1.toString());
			} 
			else if (comparison == -1) {
				System.out.println("Number1: " + num1.toString() + " is smaller than Number2: " + num2.toString());
			} 
			else {
				System.out.println("The two numbers are equal.");
			}

		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
    }
}
