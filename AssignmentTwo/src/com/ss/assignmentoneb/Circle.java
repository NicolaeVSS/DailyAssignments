package com.ss.assignmentoneb;

public class Circle implements Shape 
{
	private Double radius;
	
	public Circle(Double rad) 
	{
		// TODO improve comedic documentation
		radius = rad; // I agree
	}
	
	@Override
	public Double calculateArea() 
	{
		return Math.PI * radius * radius;
	}

}
