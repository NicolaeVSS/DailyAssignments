package com.ss.assignmentonea;

/**
 * @author nicolae
 *
 */
public class MainA 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		if(args.length == 0) 
		{
			System.out.println("No arguments sent. Exiting program.");
			return;
		}
		
		// Finding the sum of the args and finding the max
		Double sum = 0.0;
		Double max = Double.NEGATIVE_INFINITY;
		Integer maxIndex = null;
		for(int i = 0; i <args.length; ++i) 
		{
			Double argument;
			try
			{
				argument = Double.valueOf(args[i]);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid argument: " + args[i] + "\nPrinting stack trace, ignoring, and coninuing");
				e.printStackTrace();
				continue;
			}
			
			sum = sum + argument;
			
			if(argument > max) 
			{
				max = argument;
				maxIndex = i;
			}
		}
		
		// if all arguments were invalid, max and maxIndex will still have their default values
		if(max == Double.NEGATIVE_INFINITY && maxIndex == null) 
		{
			System.out.println("None of your inputs were valid, please try again. Exiting program");
			return;
		}
		
		System.out.println("The sum of your valid arguments is: " + sum + "\nAnd the largest value input was: " + max + "\nAnd the index of the largest value is: " + maxIndex);
	}
}
