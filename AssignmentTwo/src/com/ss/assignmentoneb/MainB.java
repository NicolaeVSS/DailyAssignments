package com.ss.assignmentoneb;

/**
 * @author nicolae
 *
 */
public class MainB {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Shape s = new Rectangle(2.0,4.0);
		System.out.println("Creating rectangle with width of 2 and height of 4");
		System.out.println("calculateArea(): " + s.calculateArea() + "\tdisplay(): " + s.display() + "\n");

		s = new Circle(5.0);
		System.out.println("Creating circle with radius 5");
		System.out.println("calculateArea(): " + s.calculateArea() + "\tdisplay(): " + s.display() + "\n");
		
		s = new Triangle(3.0, 5.0);
		System.out.println("Creating triangle with base 3.0 and height 5.0");
		System.out.println("calculateArea(): " + s.calculateArea() + "\tdisplay(): " + s.display() + "\n");
	}

}
