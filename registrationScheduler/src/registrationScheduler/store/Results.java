package registrationScheduler.store;

import registrationScheduler.driver.*;
import registrationScheduler.threadMgmt.*;
import registrationScheduler.util.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Results implements StdoutDisplayInterface,FileDisplayInterface {
	//static ArrayList<String> list=new ArrayList<String>();
	String foutput;
	PrintStream writer;
	static Student stdobj[]=new Student[80];
	public static Courses course_A = new Courses("A");
	public static Courses course_B = new Courses("B");
	public static Courses course_C = new Courses("C");
	public static Courses course_D = new Courses("D");
	public static Courses course_E = new Courses("E");
	public static Courses course_F = new Courses("F");
	public static Courses course_G = new Courses("G");
	public static double avg_score=0.0;
	
	
	
	public Results(String outputIn)
	{
		this.foutput=outputIn;
		if(Logger.DebugLevel.CONSTRUCTOR != null)
		{
			if(Logger.getDebugValue()==Logger.DebugLevel.CONSTRUCTOR)
			System.out.println("Results Constructor is called");
		}
	}

	@Override
	public void writeScheduleToScreen() {
		// TODO Auto-generated method stub
		if(Logger.DebugLevel.STORE != null)
		{
			if(Logger.getDebugValue()==Logger.DebugLevel.STORE)
			{
		
		
		for(int i=0;i<stdobj.length;i++)
		{
			if(stdobj[i] !=null)
			{
			System.out.print("Student_"+(i+1)+" "+stdobj[i].oPrefer[0] + " " 
					+stdobj[i].oPrefer[1] + " " 
					+stdobj[i].oPrefer[2] + " " 
					+stdobj[i].oPrefer[3] + " " 
					+stdobj[i].oPrefer[4] + " " 
					
					);
			avg_score=stdobj[i].preferScore+avg_score;
			System.out.println();
			}
		}
		System.out.println(avg_score/80);
		
			}//STORE CHECK
		}//logger NULL check ended
		
		
		if(Logger.DebugLevel.NONE != null)
		{
		
			for(int i=0;i<stdobj.length;i++)
			{
				if(stdobj[i] !=null)
				{
				
				avg_score=stdobj[i].preferScore+avg_score;
			
				}
			}
			
		avg_score=avg_score/80;
		if(Logger.getDebugValue()==Logger.DebugLevel.NONE){
			System.out.println("The average score is "+avg_score);}
		
		}
		
		
	}

	@Override
	public void writeSchedulesToFile() {
		// TODO Auto-generated method stub
		//write output
		
		try {
			writer = new PrintStream(foutput);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			System.exit(1);
		}
		
		if(Logger.DebugLevel.NONE != null)
		{
		
				
		if(Logger.getDebugValue()==Logger.DebugLevel.NONE){
			
			for(int i=0;i<stdobj.length;i++)
			{
				if(stdobj[i] !=null)
				{
				writer.print("Student_"+(i+1)+" "+stdobj[i].oPrefer[0] + " " 
						+stdobj[i].oPrefer[1] + " " 
						+stdobj[i].oPrefer[2] + " " 
						+stdobj[i].oPrefer[3] + " " 
						+stdobj[i].oPrefer[4] + " " 
						);
				avg_score=stdobj[i].preferScore+avg_score;
				writer.println();
				}
				
				
				}//for loop
			
			avg_score=avg_score/80;
			if(Logger.getDebugValue()==Logger.DebugLevel.NONE){
				writer.println("The average score is "+avg_score);}		
			}//none logger check
			
			
			
		
		}//null check logger
		
		
		
		 writer.flush();
		    writer.close(); 
		
		
	}
	
	public void putStudentId(int studid)
	{
		
		if(stdobj[studid] == null)
		{
			stdobj[studid] = new Student(studid);
			
			
		}
			
	}
		
	
	
	public void putStudentPrefer(int stdid,String prefVal,String courseName)
	{
		if((prefVal !=null) || (stdobj[stdid] !=null))
		{

			switch(Integer.parseInt(prefVal))
			{
			case 1:
				if(stdobj[stdid].iPrefer[0] !=null)
				stdobj[stdid].iPrefer[0]=courseName;
				break;
			case 2:
				if(stdobj[stdid].iPrefer[1] !=null)
					stdobj[stdid].iPrefer[1]=courseName;
					break;
				
			case 3:
				if(stdobj[stdid].iPrefer[2] !=null)
					stdobj[stdid].iPrefer[2]=courseName;
					break;
			
			case 4:
				if(stdobj[stdid].iPrefer[3] !=null)
					stdobj[stdid].iPrefer[3]=courseName;
					break;
					
			case 5:
				if(stdobj[stdid].iPrefer[4] !=null)
					stdobj[stdid].iPrefer[4]=courseName;
					break;
				
			case 6:
				if(stdobj[stdid].iPrefer[5] !=null)
					stdobj[stdid].iPrefer[5]=courseName;
					break;
			
			case 7:
				if(stdobj[stdid].iPrefer[6] !=null)
					stdobj[stdid].iPrefer[6]=courseName;
					break;
			default:
				break;
				
			}	//switch ends
		}//if ends
	}//method putStudentPrefer ends
	
	
	public void checkStudentPrefer(int id,ObjectPool objpool,int limit)
	{
		Boolean boolval; int idle;
		if(stdobj[id] !=null)
		{
			//call objectpool for the prefered courses
			idle=objpool.getNumIdle(course_A,course_B,course_C,course_D,course_E,course_F,course_G);
		
			for(int i=0;i<7;i++)
			{
				switch(stdobj[id].iPrefer[i])
				{
				case "A":
					boolval=objpool.borrow(course_A);
					
					if(boolval=true)
					{
						//call logic for allot courses
						allotSubject(course_A,id,i+1,limit);
					}
					break;
					
				case "B":
					boolval=objpool.borrow(course_B);
					if(boolval=true)
					{
						//call logic for allot courses
						allotSubject(course_B,id,i+1,limit);
					}
					break;
					
				case "C":
					boolval=objpool.borrow(course_C);
					if(boolval=true)
					{
						//call logic for allot courses
						allotSubject(course_C,id,i+1,limit);
					}
					break;
				
				case "D":
					boolval=objpool.borrow(course_D);
					if(boolval=true)
					{
						//call logic for allot courses
						allotSubject(course_D,id,i+1,limit);
					}
					break;	
					

				case "E":
					boolval=objpool.borrow(course_E);
					if(boolval=true)
					{
						//call logic for allot courses
						allotSubject(course_E,id,i+1,limit);
					}
					break;
					

				case "F":
					boolval=objpool.borrow(course_F);
					if(boolval=true)
					{
						//call logic for allot courses
						allotSubject(course_F,id,i+1,limit);
					}
					break;
					

				case "G":
					boolval=objpool.borrow(course_G);
					if(boolval=true)
					{
						//call logic for allot courses
						allotSubject(course_G,id,i+1,limit);
					}
					break;
						
					
				default:
					break;
				
				
				}//switch case
			}//for loop
		}//if check
	}//method checkStudentPrefer ends
	
	
	public void allotSubject(Courses course,int id,int preferindex,int limit)
	{
		if(stdobj[id] !=null)
		{
			if(course.num_of_seats<limit)
			{
					for(int j=0;j<5;j++)
					{
						if((stdobj[id].oPrefer[j] == "") && 
								!(stdobj[id].oPrefer[0].equals(course.name)) &&
								!(stdobj[id].oPrefer[1].equals(course.name)) &&
								!(stdobj[id].oPrefer[2].equals(course.name)) &&
								!(stdobj[id].oPrefer[3].equals(course.name)) 
								)
						{
							stdobj[id].oPrefer[j]=course.name;
							
							stdobj[id].preferScore=stdobj[id].preferScore+preferindex;
							
							if(Logger.DebugLevel.ADDRESULTS != null)
							{
								if(Logger.getDebugValue()==Logger.DebugLevel.ADDRESULTS)
								System.out.println("Entry is added in Results Datastructure");
							}
							
						}

					}
			}
		}
		
	}
	
	
}//class ends