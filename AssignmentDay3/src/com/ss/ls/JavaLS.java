package com.ss.ls;

import java.io.File;
import java.util.Arrays;

public class JavaLS {

	public static void main(String[] args) {
		
		String targetDirectory = "./src/com/ss";
		
		if(args.length > 0) 
		{
			targetDirectory = args[0];
		}
		
		File directory = new File(targetDirectory);
		String[] allFiles = directory.list();
		System.out.println(Arrays.toString(allFiles));
	}

}
