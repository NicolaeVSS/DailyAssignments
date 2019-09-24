package com.ss.assignmentone;

/**
 * @author nicolae
 * This assignment was to generate a pattern of '*'s 
 */
public class Star 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		final String star = "*";
		String separator = "- - - - - - - - - ";
		
		// this for loop exists just to "automate" the counting from 1-4
		for(int i = 1; i<=4; ++i) 
		{
			System.out.println(i + ")");
			String output = "";
			
			// these vars are for the pyramid
			final int offset = 2;
			final int height = 4;
			int starCount; // how many stars the first row will have
			
			switch(i) 
			{
			case 1: // this pattern looks like a left justified right triangle 
				for(int j = 1; j <= 4; ++j) 
				{
					output += repeatString(star, j) + "\n";
				}
				
				output += separator;
				System.out.println(output);
				break;
			case 2: // this pattern is just the upside-down version of case 1
				output += separator + "\n";
				for(int j = 4; j > 0; --j) 
				{
					output += repeatString(star, j) + "\n";
				}
				
				System.out.println(output);
				break;
			case 3: // this pattern is a pyramid with height 4 and is offset by two spaces 
				starCount = 1;

				for(int j = 1; j <= height; ++j) 
				{
					int spaceCount = offset + height - j;
					output += repeatString(" ",spaceCount) + repeatString(star, starCount) + "\n";
					starCount += 2; // adding two stars for each "level"
				}
				
				output += separator;
				System.out.println(output);
				break;
			case 4: // this pattern is just the upside down version of case 3
				starCount = 7; 
				
				output += separator + "\n";
				
				for(int j = height; j >= 1; --j) 
				{
					int spaceCount = offset + height - j;
					output += repeatString(" ", spaceCount) + repeatString(star, starCount) + "\n";
					starCount -= 2;
				}
				
				System.out.println(output);
				break;
			}
			
			// in the pattern example, the dashes increase by one for every case
			separator += "- ";
		}
	}
	
	/*
	 * This function will return the string passed in repeated n-many times
	 */
	public static String repeatString(String s, int n) 
	{
		String output = "";
		for(int i = 0; i < n; ++i) 
		{
			output += s;
		}
		
		return output;
	}
}
