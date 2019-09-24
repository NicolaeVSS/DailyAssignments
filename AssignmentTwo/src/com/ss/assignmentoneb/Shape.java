package com.ss.assignmentoneb;

public interface Shape 
{
	Double[] position = new Double[] {0.0, 0.0}; // x, y
	
	public Double calculateArea();
	
	default public String display() 
	{
		return position[0].toString() + ", " + position[1].toString();
	}
	
	default public void translate(Double x, Double y) 
	{
		position[0] = position[0] + x;
		position[1] = position[1] + y;
	}
}
