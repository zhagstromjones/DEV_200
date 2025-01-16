/**
 * Program: FootMeterConversion.java
 * Author: Zach Hagstrom-Jones
 * Purpose: This program converts a value of feet to its equivalent in meters and outputs the result,
 * and also does the same thing with meters.
 */
public class FootMeterConversion {

	public static void main(String[] args) {
		//Initialize variables
		double feetToConvert = 1.0;
		double meterToConvert = 20.0;
		
		//Output first section of the chart
		System.out.println("Feet  Meters        Meters      Feet");
		System.out.println("------------------------------------");
		
		//Loop ten times through the conversion output
		for (int i = 0; i < 10; i++) {
			double feetResult = footToMeter(feetToConvert);
			double meterResult = meterToFoot(meterToConvert);
			
			//Output the results in a formatted print line
			System.out.printf("%4.1f" + "   " + "%4.3f" + "          " + "%4.1f" + "   " + "%7.3f" + "\n", feetToConvert, feetResult, meterToConvert, meterResult);
			feetToConvert += 1.0;
			meterToConvert += 5.0;
			
		}
	}
	
	public static double footToMeter(double foot) {
		return foot * 0.305;
	}
	
	public static double meterToFoot(double meter) {
		return meter * 3.279;
	}
	
}
