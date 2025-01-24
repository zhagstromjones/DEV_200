/**
 * Program: BinaryToDecimal.java
 * Author: Zach Hagstrom-Jones
 * Purpose: This program converts a user-defined string of binary numbers into its decimal
 * equivalent. If the user does not put in a binary number the program will throw an
 * exception.
 */
import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) throws BinaryFormatException {
		//Initialize scanner
		Scanner input = new Scanner(System.in);
		System.out.println("Input binary number: ");
		String binString = input.next();
		int result = bin2Dec(binString);
		System.out.println(result);

	}
	
	public static int bin2Dec(String binString) throws BinaryFormatException {
		//Check each digit in the string and throw an exception if it is not a 0 or 1
		for (int i = 0; i < binString.length(); i++) {
			if (binString.charAt(i) != '0' && binString.charAt(i) != '1') {
				throw new BinaryFormatException();
			}
		}
		//Initialize variables
		int result = 0;
		int i = 0;
		int base = 1; // Start on base 1, which can increase to 2, 4, 8, etc.
		int length = binString.length();
		
		//Use a for-loop to go through the string in a first-to-last-character manner
		for (i = length - 1; i >= 0; i--) {
			//If the character in question is a 1, add the base to the result
			if (binString.charAt(i) == '1') {
				result += base;
			}
			//Increment the base
			base *= 2;
		}
		return result;
	}

}

class BinaryFormatException extends Exception {
	
	BinaryFormatException(){
		super("Not a binary number");
	}
	
	BinaryFormatException(String message){
		super(message);
	}
}
