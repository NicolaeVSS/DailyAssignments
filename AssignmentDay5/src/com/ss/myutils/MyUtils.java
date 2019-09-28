package com.ss.myutils;

import java.util.*;
import java.util.stream.Collectors;

public class MyUtils 
{
	public static Integer comparePrioritizeLowerCaseEStatic(String first, String second) {
		boolean firstConstains = first.contains("e");
		boolean secondContains = second.contains("e");
				
		if( firstConstains && secondContains)
			return 0; // if both have "e", they are equal
		else if(firstConstains)
			return -1; // if only first has "e", first is greater
		else if(secondContains)
			return 1;// if only second has "e", second is less than
		else
			return 0; // if neither have "e", they're equal
	}
	
	public static String toOddEvenString(List<Integer> inputList) 
	{
		StringBuilder outputString = new StringBuilder();
		
		inputList.stream().forEach(ele -> 
		{
			if(ele%2 == 0)
				outputString.append("e" + ele + ",");
			else
				outputString.append("o" + ele + ",");
		});
		
		if(outputString.length() > 0) 
		{
			outputString.setLength(outputString.length()-1); // remove the last ","
		}
		
		return outputString.toString();
	}
	
	public static List<String> getLengthThreeContainsLowerCaseA(List<String> inputList)
	{
		List<String> outputList = new ArrayList<String>();
		
		inputList.stream().forEach(ele -> 
		{
			if(ele.charAt(0) == 'a' && ele.length() == 3)
				outputList.add(ele);
		});
		
		return outputList;
	}
}
