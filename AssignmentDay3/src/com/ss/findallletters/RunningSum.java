package com.ss.findallletters;

public class RunningSum
{
	Integer runSum = 0;
	
	public void add(Integer operand) 
	{
		runSum += operand;
	}
	
	public Integer getRunSum() 
	{
		return runSum;
	}
}