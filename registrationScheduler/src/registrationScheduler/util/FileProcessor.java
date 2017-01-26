package registrationScheduler.util;


import registrationScheduler.driver.*;
import registrationScheduler.store.*;
import registrationScheduler.threadMgmt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class FileProcessor {
	
	String finput;


	BufferedReader br = null;
	public FileProcessor(String input)
	{
		this.finput=input;
		//this.foutput=output;
		File inputFile = new File(finput);
		try {
			br = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		if(Logger.DebugLevel.CONSTRUCTOR != null)
		{
			if(Logger.getDebugValue()==Logger.DebugLevel.CONSTRUCTOR)
			System.out.println("FileProcessor Constructor is called");
		}
		
	}
	
	
	//@return String
	public synchronized String readLine()
	{
		  //open input file
		
		String inputLine = null;
		
		
	
		try {
			
			
			inputLine=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
  
	
		return inputLine;
	}

	
}//Class ends
