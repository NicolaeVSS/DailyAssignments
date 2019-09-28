package com.ss.LambdasAndStreams;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ss.myutils.MyUtils;

// Nicolae Vasile

public class LambdasAndStreams 
{
	public static void main(String[] args) 
	{
		String[] mySandwichesArray = new String[] {"Cubano", "BLT", "Hamburger", "CheeseBurger", "Hot Dog", "Jucy Lucy", "Lobster Roll", "Luther Burger"};
		List<String> mySandwichesList = Arrays.asList(mySandwichesArray);
		
		System.out.println("Sorted by length:");
		Comparator<String> compareLengths = (first, second) -> first.length() - second.length();
		mySandwichesList.stream().sorted(compareLengths).forEach(System.out::println);
		
		System.out.println("\nSorted alphabetically by first letter:");
		Comparator<String> compareFirstChar = (first, second) -> first.charAt(0) - second.charAt(0);
		mySandwichesList.stream().sorted(compareFirstChar).forEach(System.out::println);

		// TODO why doesnt this work?
		System.out.println("\nPrioritizing \"e\":");
		mySandwichesList.stream().sorted((first, second) -> 
		{
			boolean firstConstains = first.contains("e");
			boolean secondContains = second.contains("e");
			
			if( firstConstains && secondContains)
				return 0; // if both have "e", they are equal
			else if(firstConstains)
				return -1; // if only first has "e", first is greater
			else if(secondContains)
				return 1;// if only second has "e", first is less than
			else
				return 0; // if neither have "e", they're equal
		}).forEach(System.out::println);

		// TODO why deosnt this work?
		System.out.println("\nPrioritizing \"e\" with static helper method:");
		Arrays.sort(mySandwichesArray, (first, second) -> MyUtils.comparePrioritizeLowerCaseEStatic(first, second));
		System.out.println(Arrays.toString(mySandwichesArray));

		
		Integer[] inputIntegerArray = new Integer[] {50,51,-50,-51};
		List<Integer> inputIntegerArrayList = Arrays.asList(inputIntegerArray);
		System.out.println("\nUsing toOddEvenString() on inputIntegerArrayList:\n" + Arrays.toString(inputIntegerArray));
		System.out.println(MyUtils.toOddEvenString(inputIntegerArrayList));

		
		String[] inputStringArray = new String[] {"lambdas","lAmbdas","lam","lAm","amb","Amb"};
		List<String> inputStringArrayList = Arrays.asList(inputStringArray);
		System.out.println("\nUsing getLengthThreeContainsLowerCaseA() on inputStringArrayList:\n" + Arrays.toString(inputStringArray));
		System.out.println(MyUtils.getLengthThreeContainsLowerCaseA(inputStringArrayList));

	}
	


}
