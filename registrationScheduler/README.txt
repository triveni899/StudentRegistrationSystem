
CS542 Design Patterns
Fall-2016
Assignment 2

README FILE

Due Date: Friday, September 30, 2016.
Submission Date: Friday, September 30, 2016.
Author: Triveni Banpela
e-mail: tbanpel1@binghamton.edu

Assignment Goal: Develop a program, using Java, to assign courses using multithreding to students based on their preferences. 
PERCENT COMPLETE: completed 100% of this project.

FILES:
		------driver:
				  --Driver.java [Base Class]
		------store:
				  --Results.java
				  --FileDsiplayInterface.java [Interface]
				  --StdOutDisplayInterface.java [Interface]
		------threadMgmt:
				  --CreateWorkers.java 
				  --WorkerThread.java 
		------util:
				  --Courses.java
				  --FileProcessor.java
				  --Logger.java
				  --ObjectPool.java
				  --CourseScheduler.java			  
				  —Student.java
				  
SAMPLE OUTPUT:
***************************************************
Student_1 A B C D E 15
Student_2 B C D E F 15
Student_3 C D E F G 15
Student_4 D E F G A 15
Student_5 E F G A B 15
Student_6 F G A B C 15
Student_7 G A B C D 15
Student_8 A B C D E 15
Student_9 B C D E F 15
Student_10 C D E F G 15
..........................
..........................

Average preference_score is: 15.00
***************************************************

TO COMPILE:
ant -buildfile build.xml all

NOTE: Please Place the Input file parallel to the src directory

TO RUN:
Navigate to directory where build.xml is present and run 

ant -buildfile build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3=4 

To CLEAN:
ant clean
 
TO UN-TAR:
tar xvzf triveni_banpela_assign2.tar.gz


Data Structure Used:
***************************************************
Using Student class and its attributes to store the values.
No need of any array list. Simple object arrays are used to store values.

Time Complexity is 0(n).			   
			   
***************************************************			  
			  
			