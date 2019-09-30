package com.ss.findallletters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;


public class FindALlLetters {

	public static void main(String[] args) 
	{
		String targetLetter = "e";
		String filePath = "./src/com/ss/findallletters/aTaleOfTwoCities.txt";
		
		if(args.length > 0) 
		{
			targetLetter = args[0];
		}
		
		// this has to be final to be used in a lambda, kind of annoying
		final String matchMe = targetLetter.toLowerCase();
		// this had to be a class because it had to be final as well.
		RunningSum runSum = new RunningSum();
		
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			reader.lines().forEach(line -> runSum.add(StringUtils.countMatches(line.toLowerCase(), matchMe)));
			
			System.out.println(runSum.getRunSum());
			
			reader.close();
		} 
		catch (IOException e) 
		{
			System.err.println("Couldnt find " + filePath);
			e.printStackTrace();
		}
	}
}
