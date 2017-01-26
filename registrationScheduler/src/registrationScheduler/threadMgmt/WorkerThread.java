package registrationScheduler.threadMgmt;

import registrationScheduler.driver.*;
import registrationScheduler.store.*;
import registrationScheduler.util.*;
public class WorkerThread implements Runnable {
	
	FileProcessor objfp;
	Results objres;
	CourseScheduler objcs;
	ObjectPool objpool;
	 
	
	public WorkerThread(FileProcessor objfpIn,Results objresIn,CourseScheduler objcsIn,ObjectPool objpoolIn)
	{
		this.objfp=objfpIn;
		this.objres=objresIn;
		this.objcs=objcsIn;
		this.objpool=objpoolIn;
		if(Logger.DebugLevel.CONSTRUCTOR != null)
		{
			if(Logger.getDebugValue()==Logger.DebugLevel.CONSTRUCTOR)
			System.out.println("Worker Constructor is called");
		}
		
	}
	@Override
	public void run()
	{
		String data="";
		while(data !=null)
		{
		
			data=objfp.readLine();
			objcs.allotCourse(data,objres,objpool);
			
			
			
		}
		
	}
	

}
