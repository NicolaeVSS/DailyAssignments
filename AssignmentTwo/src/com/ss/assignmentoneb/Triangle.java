package com.ss.assignmentoneb;

public class Triangle implements Shape 
{
	private Double base;
	private Double height;
	
	public Triangle(Double base, Double height) 
	{
		this.base = base;
		this.height = height;
	}
	
	@Override
	public Double calculateArea()
	{
		return (base * height)/2.0;
	}

}
