package registrationScheduler.util;


import registrationScheduler.driver.*;
import registrationScheduler.store.*;
import registrationScheduler.threadMgmt.*;
public class Courses {
	
	int num_of_seats;
	String name;
	
	Courses(String nameIn){
		num_of_seats=0;
		this.name=nameIn;
		
		if(Logger.DebugLevel.CONSTRUCTOR != null)
		{
			if(Logger.getDebugValue()==Logger.DebugLevel.CONSTRUCTOR)
			{
				System.out.println("Courses Constructor is called");
			}
		}
	}
	
	//@return boolean
	public synchronized boolean allotseat()
	{
		if(num_of_seats <60)
		{
			num_of_seats++;
			return true;
		}
		return false;
	}

}
