package registrationScheduler.util;

import registrationScheduler.driver.*;
import registrationScheduler.store.*;
import registrationScheduler.threadMgmt.*;
public class ObjectPool {
	private static ObjectPool pool;
	
	private ObjectPool()
	{
		if(Logger.DebugLevel.CONSTRUCTOR != null)
		{
			if(Logger.getDebugValue()==Logger.DebugLevel.CONSTRUCTOR)
			System.out.println("ObjectPool Constructor is called");
		}
	}
	public static ObjectPool getInstance()
	{
		if(pool==null)
		{
			pool=new ObjectPool();
		}
		return pool;
	}
	
	//@return boolean
	public boolean borrow(Courses course)
	{
		return course.allotseat();
	
	}
	
	//@return Courses
	public Courses returnCourse(Courses course)
	{
		Courses obj=null;
		if(course.num_of_seats>60)
		{
			obj=course;
		}
		return obj;
	}
	
	//@return int
	public int getNumIdle(Courses c1, Courses c2, Courses c3, Courses c4, Courses c5, Courses c6, Courses c7)
	{
		int count=0;
		if(c1.num_of_seats  < 60)
		{
			count++;	
		}
		if(c2.num_of_seats  < 60)
		{
			count++;	
		}
		if(c3.num_of_seats  < 60)
		{
			count++;	
		}
		if(c4.num_of_seats  < 60)
		{
			count++;	
		}
		if(c5.num_of_seats  < 60)
		{
			count++;	
		}
		if(c6.num_of_seats  < 60)
		{
			count++;	
		}
		if(c7.num_of_seats  < 60)
		{
			count++;	
		}
		return count;
	}

}
