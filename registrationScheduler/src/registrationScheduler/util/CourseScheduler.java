package registrationScheduler.util;

import registrationScheduler.driver.*;
import registrationScheduler.store.*;
import registrationScheduler.threadMgmt.*;
public class CourseScheduler {
	

	String []splitStr; String stud=null;int studid;

      public CourseScheduler()
      {
    	  if(Logger.DebugLevel.CONSTRUCTOR != null)
  		{
    		  if(Logger.getDebugValue()==Logger.DebugLevel.CONSTRUCTOR)
  			System.out.println("CourseScheduler Constructor is called");
  		}
      }
      
    //@return None
	public synchronized void allotCourse(String data,Results objres,ObjectPool objpool)
	{
        if(data != null)
        {
		splitStr=data.split(" ");
		stud=splitStr[0];
		
		//Get student id
		String []stud1=stud.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		studid=Integer.parseInt(stud1[1]);
		
		studid=studid-1;
		
		//put id details
		objres.putStudentId(studid);
		
		stud=splitStr[1]; //firstPreference
		if(stud !=null)
		{
			objres.putStudentPrefer(studid,stud,"A");
		}
		
		stud=splitStr[2]; //secondPreference
		if(stud !=null)
		{
			objres.putStudentPrefer(studid,stud,"B");
		}
		
		stud=splitStr[3]; //thirdPreference
		if(stud !=null)
		{
			objres.putStudentPrefer(studid,stud,"C");
		}
		
		stud=splitStr[4]; //fourthPreference
		if(stud !=null)
		{
			objres.putStudentPrefer(studid,stud,"D");
		}
		
		stud=splitStr[5]; //fifthPreference
		if(stud !=null)
		{
			objres.putStudentPrefer(studid,stud,"E");
		}
		
		stud=splitStr[6]; //sixthPreference
		if(stud !=null)
		{
			objres.putStudentPrefer(studid,stud,"F");
		}
		
		stud=splitStr[7]; //seventhPreference
		if(stud !=null)
		{
			objres.putStudentPrefer(studid,stud,"G");
		}
		
		
		
        }// data null check ends
        
      if((objres.stdobj[studid].oPrefer[0]=="")||
    		  (objres.stdobj[studid].oPrefer[1]=="") ||
    		  (objres.stdobj[studid].oPrefer[2]=="") ||
    		  (objres.stdobj[studid].oPrefer[3]=="") 
    		  )  {
      objres.checkStudentPrefer(studid,objpool,11);}
      
      if((objres.stdobj[studid].oPrefer[0]=="")||
    		  (objres.stdobj[studid].oPrefer[1]=="") ||
    		  (objres.stdobj[studid].oPrefer[2]=="") ||
    		  (objres.stdobj[studid].oPrefer[3]=="") 
    		  )
      {
      objres.checkStudentPrefer(studid,objpool,31);
      }
      
      if((objres.stdobj[studid].oPrefer[0]=="")||
    		  (objres.stdobj[studid].oPrefer[1]=="") ||
    		  (objres.stdobj[studid].oPrefer[2]=="") ||
    		  (objres.stdobj[studid].oPrefer[3]=="") 
    		  )
      {
      objres.checkStudentPrefer(studid,objpool,61);}
     
     
        
        
        
        
        
		
	}//method allotcourse ends
	
	
	
	
	

	
	
}
