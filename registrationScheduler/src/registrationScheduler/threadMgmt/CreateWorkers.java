package registrationScheduler.threadMgmt;

import registrationScheduler.driver.*;
import registrationScheduler.store.*;
import registrationScheduler.util.*;

public class CreateWorkers {
	
	
	
	WorkerThread objcw[];
	Thread objth[];
	FileProcessor objfp;
	Results objres;
	CourseScheduler objcs;
	ObjectPool objpool;
	
	public CreateWorkers(FileProcessor objfpIn,Results objresIn, CourseScheduler objcsIn,ObjectPool objpoolIn)
	{
		this.objfp=objfpIn;
		this.objres=objresIn;
		this.objcs=objcsIn;
		this.objpool=objpoolIn;
		
		if(Logger.DebugLevel.CONSTRUCTOR != null)
		{
			if(Logger.getDebugValue()==Logger.DebugLevel.CONSTRUCTOR)
			System.out.println("CreateWorkers Constructor is called");
		}
	}
	
	
	public void startWorkers(int numOfThreads)
	{
		
		objcw = new WorkerThread[numOfThreads];
		objth = new Thread[numOfThreads];
		
		for(int i=0;i<numOfThreads;i++)
		{
			objcw[i] = new WorkerThread(objfp,objres,objcs,objpool);
			objth[i] = new Thread(objcw[i]);
			
			if(Logger.DebugLevel.THREADRUN != null)
			{
				if(Logger.getDebugValue().equals(Logger.DebugLevel.THREADRUN))
				{
				System.out.println("Thread "+i+" is running");}
			}
			
				objth[i].start();
			
			
			
		}
		
		for(int i=0;i<numOfThreads;i++)
		{
			try {
				
				objth[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		
	}

}
