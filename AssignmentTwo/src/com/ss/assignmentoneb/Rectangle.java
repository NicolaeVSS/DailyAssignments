package com.ss.assignmentoneb;

public class Rectangle implements Shape 
{
	private Double topBottomLength;
	private Double leftRightLength;
	
	public Rectangle(Double topBottom, Double leftRight) 
	{
		topBottomLength = topBottom;
		leftRightLength = leftRight;
	}
	
	@Override
	public Double calculateArea() 
	{
		return topBottomLength * leftRightLength;
	}

}
