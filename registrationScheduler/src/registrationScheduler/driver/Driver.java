package registrationScheduler.driver;

import registrationScheduler.store.*;
import registrationScheduler.threadMgmt.*;
import registrationScheduler.util.*;

public class Driver {
    private static int NUM_THREADS;
    private static int DEBUG_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//check for number of arguments passed
		if(args.length !=4)
		{
			System.out.println("Please pass 4 arguments");
			System.exit(1);
		}
		
		if(!args[2].matches("-?\\d+(\\.\\d+)?"))
		{
			System.out.println("Please pass Number of threads argument as numeric");
			System.exit(1);
		}
		
		if(!args[3].matches("-?\\d+(\\.\\d+)?"))
		{
			System.out.println("Please pass Debug value argument as numeric");
			System.exit(1);
		}
		
		NUM_THREADS=Integer.parseInt(args[2]);
	
		
		//check for valid number of threads
		if((NUM_THREADS >3) || (NUM_THREADS <1))
		{
			System.out.println("Please pass number of threads between 1 and 3");
			System.exit(1);
		}
		
		//check for valid debug value
		DEBUG_VALUE = Integer.parseInt(args[3]);
		if((DEBUG_VALUE >4) || (DEBUG_VALUE<0 ))
		{
			System.out.println("Please pass Debug value between 0 and 4");
			System.exit(1);
		}
		
		FileProcessor fpobj = new FileProcessor(args[0]);
		Results resobj=new Results(args[1]);
		
		Logger.setDebugValue(DEBUG_VALUE);
		CourseScheduler csobj = new CourseScheduler();
		ObjectPool poolobj= ObjectPool.getInstance();
		CreateWorkers cwobj=new CreateWorkers(fpobj,resobj,csobj,poolobj);
		cwobj.startWorkers(NUM_THREADS);
		
		resobj.writeScheduleToScreen();
		resobj.writeSchedulesToFile();
		

	}

}
