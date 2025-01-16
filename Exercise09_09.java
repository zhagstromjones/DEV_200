/**
 * Program: Exercise09_09
 * Author: Zach Hagstrom-Jones
 * Purpose: This program utilizes the RegularPolygon custom class and creates three polygons, the first of which
 * uses the default no-arg constructor, the second of which provides just the number and length of the sides, and
 * the third of which provides the number and length of the sides as well as the x and y coordinates.
 */
public class Exercise09_09 {
  public static void main(String[] args) {

	  //Create all required polygon objects
	  RegularPolygon polygon1 = new RegularPolygon();
	  RegularPolygon polygon2 = new RegularPolygon(6, 4);
	  RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);
	  
	  //Display the perimeter and area of all polygon objects
	  System.out.println("Perimeter of polygon 1: " + polygon1.getPerimeter());
	  System.out.println("Area of polygon 1: " + polygon1.getArea());
	  System.out.println("Perimeter of polygon 2: " + polygon2.getPerimeter());
	  System.out.println("Area of polygon 2: " + polygon2.getArea());
	  System.out.println("Perimeter of polygon 3: " + polygon3.getPerimeter());
	  System.out.println("Area of polygon 3: " + polygon3.getArea());
  }
}

class RegularPolygon {

	private int n;			//The number of sides the polygon has.
	private double side;	//The length of the side
	private double x;		//The x coordinate of the polygon's center.
	private double y;		//The y coordinate of the polygon's center.
	
	//Default constructor
	public RegularPolygon() {
		this.setNumSides(3);
		this.setSideLength(1);
		this.setX(0);
		this.setY(0);
	}
	
	//Constructor with specified number of sides and side length
	public RegularPolygon(int n, double side) {
		this.setNumSides(n);
		this.setSideLength(side);
		this.setX(0);
		this.setY(0);
	}
	
	//Constructor with all parameters specified.
	public RegularPolygon(int n, double side, double x, double y) {
		this.setNumSides(n);
		this.setSideLength(side);
		this.setX(x);
		this.setY(y);
	}

	public int getNumSides() {
		return n;
	}

	public void setNumSides(int n) {
		this.n = n;
	}

	public double getSideLength() {
		return side;
	}

	public void setSideLength(double side) {
		this.side = side;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	//Return the perimeter of the polygon
	public double getPerimeter() {
		return this.n * this.side;
	}
	
	//Return the area of the polygon
	public double getArea() {
		return ((this.n * (this.side * this.side)) / (4 * Math.tan(Math.PI/this.n)));
	}
}
