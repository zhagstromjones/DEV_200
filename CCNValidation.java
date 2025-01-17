import java.util.Scanner;

/**
 * Program: CCNValidation.java
 * Author: Zach Hagstrom-Jones
 * Purpose: This program is used to validate credit card numbers using the Luhn check. The user
 * can input a possible credit card number and the program will tell them if it is valid or not.
 */
public class CCNValidation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a credit card number: \n");
		long num = input.nextLong();
		
		System.out.println("Card number: " + num);
		
		if (isValid(num)) {
			System.out.println("This card number is valid.");
		}
		else {
			System.out.println("This card number is invalid.");
		}
	}
	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		//First, try to find a match for the prefix. If unable to find one, return false.
		boolean prefixPass = false;
		
		int test = 4; //Visa
		if (prefixMatched(number, test)) {
			prefixPass = true;
		}
		test = 5; //MasterCard
		if (prefixMatched(number, test)) {
			prefixPass = true;
		}
		test = 6; //Discover
		if (prefixMatched(number, test)) {
			prefixPass = true;
		}
		test = 37; //AmEx
		if (prefixMatched(number, test)) {
			prefixPass = true;
		}
		
		if (prefixPass == false) {
			System.out.println("Did not pass prefix verification.");
			return false;
		}
		
		//Second, ensure the number of digits in the card number are valid. If not, return false.
		//Get number of digits in num. If less than 13 or greater than 16 return false.
		int numDigits = getSize(number);
		if (numDigits < 13 || numDigits > 16) {
			System.out.println("Did not pass digit number verification");
			return false;
		}
		
		
		//Finally, check if the sum of summation algorithm is divisible by 10. If it is, return true.
		int sumEven = sumOfDoubleEvenPlace(number);
		int sumOdd = sumOfOddPlace(number);
		int sumAll = sumEven + sumOdd;
		if (sumAll % 10 == 0) {
			return true;
		}
		else {
			System.out.println("Did not pass summation verification.");
			System.out.println("Summation remainder: " + (sumAll / 10));
			return false;
		}

	}
	
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		//Establish a 'looper' to loop through number, along with an accumulator to return.
		long looper = number;
		int accum = 0;
		//The 'skipper' is used to skip every other digit, ensuring that only the even-placed digits
		//are used during the calculation.
		int skipper = 0;
		//Use a while-loop to iterate through the entire credit card number.
		while (looper > 0) {
			long remainder = looper % 10;
			looper = looper / 10;
			if (skipper % 2 == 1) {
				accum += getDigit((int)remainder);
				skipper++;
			}
			else {
				//skipper increments even when the calculation portion of the code is skipped.
				skipper++;
			}
		}
		
		return accum;
	}
	
	/** Return this number if it is a single digit, otherwise, return the sum of the two digits */
	public static int getDigit(int number) {
		//Multiply number by 2 for further processing.
		int result = number * 2;
		//If result is less than 10, it is guaranteed to be a single digit and thus can be returned.
		if (result < 10) {
			return result;
		}
		//Otherwise, parse the digits by converting number to a string, taking each digit as a substring,
		//and add the digits together as specified in the algorithm.
		String numString = String.valueOf(result);
		int d1 = Integer.valueOf(numString.substring(0, 1));
		int d2 = Integer.valueOf(numString.substring(1, 2));
		return d1 + d2;
		
	}
	
	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		//Establish a 'looper' to loop through number, along with an accumulator to return.
		long looper = number;
		int accum = 0;
		//The 'skipper' is used to skip every other digit, and it starts at 1 to ensure that only
		//odd-placed digits are used in the calculation.
		int skipper = 1;
		//Use a while-loop to iterate through the entire credit card number.
		while (looper > 0) {
			long remainder = looper % 10;
			looper = looper / 10;
			if (skipper % 2 == 1) {
				accum += remainder;
				skipper++;
			}
			else {
				//skipper increments even when the calculation portion of the code is skipped.
				skipper++;
			}
		}
		//System.out.println("Sum of odd digits: " + accum);
		return accum;
	}
	
	/** Return true if the number d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		//Convert both number and d into strings for further processing.
		String numString = String.valueOf(number);
		String numD = String.valueOf(d);
		
		//Initialize a substring whose length depends upon the length of numD. This is to check for
		//an American Express card.
		String numSubstring = new String();
		if (numD.length() == 2) {
			numSubstring = numString.substring(0, 2);
		}
		else {
			numSubstring = numString.substring(0, 1);
		}
		
		//Return true if d is a prefix for number, otherwise return false.
		if (numD.equals(numSubstring)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/** Return the number of digits in d */
	public static int getSize(long d) {
		//Convert d into a string to obtain the number of the digits and return it
		int numDigits = String.valueOf(d).length(); 
		return numDigits;
	}
	
	/** Return the first k number of digits from number. If the
	 * number of digits in number is less than k, return number.
	 */
	public static long getPrefix(long number, int k) {
		return 1; //Dummy value
	}
}
