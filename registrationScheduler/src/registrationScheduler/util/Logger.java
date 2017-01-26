package registrationScheduler.util;

import registrationScheduler.driver;
import registrationScheduler.store;
import registrationScheduler.threadMgmt;
public class Logger{

    
    public static enum DebugLevel { CONSTRUCTOR ,THREADRUN,ADDRESULTS,STORE,NONE
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	  case 3: debugLevel = DebugLevel.THREADRUN; break;
	  case 2: debugLevel = DebugLevel.ADDRESULTS; break;
	  case 1: debugLevel = DebugLevel.STORE; break;
	  case 0: debugLevel = DebugLevel.NONE; break;
	  
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }
    
    public static DebugLevel getDebugValue()
    {
    	return debugLevel;
    }

    // @return None
    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
