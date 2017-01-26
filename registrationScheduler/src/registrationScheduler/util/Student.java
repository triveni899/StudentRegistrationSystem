package registrationScheduler.util;

import registrationScheduler.driver.*;
import registrationScheduler.store.*;
import registrationScheduler.threadMgmt.*;

public class Student{

	//it will contains preference for A in 0th index and so on.
	String iPrefer[]=new String[7]; 
	
	//it will store output preference value, in Oth index as "A" etc.
	String oPrefer[]=new String[5]; 
	
	int stid;
	int preferScore;
	Student(int stidIn)
	{
		preferScore=0;
		this.stid=stidIn;
		for(int i=0;i<7;i++)
		{
			iPrefer[i]="";
		}
		for(int j=0;j<5;j++)
		{
			oPrefer[j]="";
		}
	
		if(Logger.DebugLevel.CONSTRUCTOR != null)
		{
			if(Logger.getDebugValue()==Logger.DebugLevel.CONSTRUCTOR)
			System.out.println("Student Constructor is called");
		}
		
	}
	
	
	
	
	
}//Student class ends