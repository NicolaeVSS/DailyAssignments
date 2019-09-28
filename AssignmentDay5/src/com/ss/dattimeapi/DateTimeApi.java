package com.ss.dattimeapi;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class DateTimeApi 
{

	public static void main(String[] args) 
	{
		/*
		 * Which class would you use to store your birthday
		 * in years, months, days, seconds, and nanoseconds?
		 * */
		
		LocalDateTime myBirthday = LocalDateTime.of(1997, Month.NOVEMBER, 20, 6, 30);
		
		/*
		 * Given a random date, how would you find the date of the previous Thursday?
		 * */
		LocalDate randomDay = LocalDate.of(1585, Month.DECEMBER, 14);
		
		int howManyDaysBack = 0;
		while(randomDay.minusDays(howManyDaysBack).getDayOfWeek() != DayOfWeek.THURSDAY) 
		{
			howManyDaysBack++;
			System.out.println("going back " + howManyDaysBack + " days.");
		}
		
		System.out.println("The previous thursday is " + randomDay.minusDays(howManyDaysBack).toString());
		
		
		/*
		 * What is the difference between a ZoneId and a ZoneOffset?
		 * */
		System.out.println("\nZoneId represents a geographical reigon which may have its own rules to calculate it's offset from GMT");
		System.out.println("ZoneOffset extends ZoneId and is the differemce, in hours and minutes, between the current time zone and GMT");
		
		/*
		 * How would you convert an Instant to a ZonedDateTime? 
		 * How would you convert a ZonedDateTime to an Instant?
		 * */
		
		Instant myInstant = Instant.now();
		ZonedDateTime timeInDetroit = myInstant.atZone(ZoneId.of("America/Detroit"));
		
		System.out.println("\nThe current time is:\t" + myInstant.toString() + "\nIt is\t\t\t" + timeInDetroit.toString());

		Instant myOtherInstant = timeInDetroit.toInstant();
		
		System.out.println("Going back ZonedDateTime to Instant " + myOtherInstant.toString());
		
		
		/*
		 * Write an example that, for a given year, 
		 * reports the length of each month within that year.
		 * */
		Scanner input = new Scanner(System.in);
		System.out.println("\nInput a year to see all its months:");
		
		Integer selectedYear = input.nextInt();
		
		System.out.println("All the months for the year " + selectedYear + ":");
		LocalDate getAllMonths = LocalDate.of(selectedYear, 1, 1);
		
		Integer howManyMonths = 0;
		while(getAllMonths.plusMonths(howManyMonths).getYear() == selectedYear) 
		{
			System.out.println(getAllMonths.plusMonths(howManyMonths).getMonth());
			howManyMonths++;
		}
		
		/*
		 * Write an example that, for a given month of the current year, 
		 * lists all of the Mondays in that month.
		 * */
		System.out.println("\nInput the month (1-12) that you would like to see all Mondays");
		
		Integer selectedMonth = input.nextInt();
		LocalDateTime getAllMondays = LocalDateTime.now();
		Integer currentYear = getAllMondays.getYear();
		
		System.out.println("All the Mondays in " + selectedMonth);
		
		getAllMondays = LocalDateTime.of(currentYear, selectedMonth, 1, 0, 0);
		
		Integer howManyDaysForward = 0;
		while(getAllMondays.plusDays(howManyDaysForward).getMonthValue() == selectedMonth) 
		{
			if(getAllMondays.plusDays(howManyDaysForward).getDayOfWeek() == DayOfWeek.MONDAY) 
			{
				System.out.println(getAllMondays.plusDays(howManyDaysForward).toString());
			}
			howManyDaysForward++;
		}
		

		/*
		 * Write an example that tests whether a given date occurs on Friday the 13th.
		 * */
		System.out.println("\nInsert a date to check if it is a Friday on the 13th of the month");
		System.out.println("YEAR: ");
		Integer checkYear = input.nextInt();
		System.out.println("MONTH: ");
		Integer checkMonth = input.nextInt();
		System.out.println("DAY: ");
		Integer checkDay = input.nextInt();
		
		LocalDateTime isFriday13th = LocalDateTime.of(checkYear, checkMonth, checkDay, 0, 0);
		
		if(isFriday13th.getDayOfMonth() == 13 && isFriday13th.getDayOfWeek() == DayOfWeek.FRIDAY) 
		{
			System.out.println("It is friday the 13th on " + isFriday13th.toString());
		}
		else 
		{
			System.out.println("It is NOT friday the 13th on " + isFriday13th.toString());
		}
	}

}
