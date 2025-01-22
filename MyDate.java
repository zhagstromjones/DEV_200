import java.util.*;

public class MyDate {
	int year = 0;
	int month = 0;		//0 = January, 1 = February, etc.
	int day = 0;			
	
	/**No-arg constructor */
	public MyDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		long currentTime = calendar.getTimeInMillis();
		setDate(currentTime);
	}
	
	/** Constructor that sets parameters to the date equivalent to the elapsed time */
	public MyDate(long elapsedTime) {
		setDate(elapsedTime);
	}
	
	/**Constructor that accepts the year, month, and day*/
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	//* Returns year */
	public int getYear() {
		return this.year;
	}
	
	//* Returns month */
	public int getMonth() {
		return this.month;
	}
	
	//* Returns day */
	public int getDay() {
		return this.day;
	}
	
	//* Sets the date based on the elapsed time in milliseconds that are passed to the method */
	public void setDate(long elapsedTime) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(elapsedTime);
		this.year = calendar.get(1);
		this.month = calendar.get(2);
		this.day = calendar.get(5);
	}
}
