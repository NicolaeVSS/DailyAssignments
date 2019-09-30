package com.ss.append;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile {

	public static void main(String[] args) 
	{
		String targetFilePath = "./src/com/ss/append/targetFile.txt";
		
		if(args.length > 0) 
		{
			targetFilePath = args[0];
		}
		
		String textToAppend = "I am apending this text to " + targetFilePath;
		
		File target = new File(targetFilePath);
		BufferedWriter writer;
		try
		{
			writer = new BufferedWriter(new FileWriter(targetFilePath, true));
			writer.write(textToAppend);
			writer.newLine();
			writer.close();
		} 
		catch (IOException e) 
		{
			System.err.println("Couldn't find your file at: " + targetFilePath);
			e.printStackTrace();
		}
	}
}
