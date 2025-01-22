/**
 * Program: TestMyDate.java
 * Author: Zach Hagstrom-Jones
 * Purpose: This program's purpose is to demonstrate how classes operate. The program outputs the year, 
 * month, and day of two dates: one for the current date and another for the date based on the elapse 
 * of a specific number of milliseconds since January 1, 1970.
 */

public class TestMyDate {

	public static void main(String[] args) {
		
		//Create test objects
		MyDate date1 = new MyDate();
		MyDate date2 = new MyDate(34355555133101L);
		
		// Display year, month, and day for date1 and date2
		System.out.println(date1.getYear() + " " + date1.getMonth() + " " + date1.getDay());
		System.out.println(date2.getYear() + " " + date2.getMonth() + " " + date2.getDay());

	}

}
