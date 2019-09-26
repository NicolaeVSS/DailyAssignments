package com.ss.juint.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.ss.junit.Line;

class Linetest 
{
	public static final double epsilon = 1e-5;
	
	@Test
	final void testGetSlope() 
	{
		double expectedValue = 2;
		double actualValue = new Line(0,0,1,2).getSlope();
		
		assertEquals(expectedValue, actualValue, epsilon);
	}
	
	@Test
	final void testGetDistance() 
	{
		double expectedValue = Math.sqrt(2);
		double actualValue = new Line(0,0,1,1).getDistance();
		
		assertEquals(expectedValue, actualValue, epsilon);
	}
	
	@Test
	final void testParallelTo() 
	{
		boolean expectedValue = true;
		boolean actualValue = new Line(0,0,1,1).parallelTo(new Line(0,0,1,1));
		
		assertEquals(expectedValue, actualValue);
		
		
	}

}
