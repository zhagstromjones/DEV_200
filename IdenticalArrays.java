import java.util.Scanner;
/*
 * Program: IdenticalArrays.java
 * Author: Zach Hagstrom-Jones
 * Purpose: The program compares two separate two-dimensional arrays to check whether or not they
 * are identical to each other.
 */

public class IdenticalArrays {

	public static void main(String[] args) {
		int list1[][] = new int[3][3];
		int list2[][] = new int[3][3];
		Scanner input = new Scanner(System.in);
		
		//Input first list of numbers
		System.out.print("Input a list of 9 numbers for the first list: ");
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				list1[row][col] = input.nextInt();
			}
		}
		
		//Input second list of numbers
		System.out.print("Input a list of 9 numbers for the second list: ");
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				list2[row][col] = input.nextInt();
			}
		}
		
		//Compare the lists, print the results, and close the scanner
		boolean result = equals(list1, list2);
		
		if (result == true) {
			System.out.println("The two arrays are identical");
		}
		else {
			System.out.println("The two arrays are not identical");
		}
		input.close();
	}

	public static boolean equals(int[][] m1, int[][] m2) {

		int numMatches = 0;
		//Check each element on list1 against each element of list2, incrementing
		//numMatches if a match occurs.
		for (int row1 = 0; row1 < 3; row1++) {
			for (int col1 = 0; col1 < 3; col1++) {
				//For simplicity, assign a test value for each element of m1
				int testValue1 = m1[row1][col1];
				for (int row2 = 0; row2 < 3; row2++) {
					for (int col2 = 0; col2 < 3; col2++) {
						//Assign a test value for each element of m2
						int testValue2 = m2[row2][col2];
						//If both test values are identical, numMatches increments by 1
						if (testValue1 == testValue2) {
							numMatches++;
							break;
						}
					}
				}
			}
		}
		//Return true if at least 9 matches are found. If there are multiple elements of the same number, numMatches
		//will be greater than 9.
		if (numMatches >= 9) return true;
		else return false;
	}
}
