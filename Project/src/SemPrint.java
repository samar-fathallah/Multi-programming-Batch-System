

import java.util.ArrayList;

public class SemPrint {
 public static int semprint;
 
 public static ArrayList<Process>blocked;
public SemPrint(){
	semprint=1;
	blocked=new ArrayList<Process>();
}
@SuppressWarnings({ "deprecation", "static-access" })
public static void semPrintWait(Process p){
	if(semprint==1){
		semprint=0;
		
	}
	
	else{
		//add to blocked queue
	   p.setProcessState(p,ProcessState.Waiting);
	   System.out.println("Process:"+ p.processID+" is suspended");
	   blocked.add(p);
	   p.suspend();
		//change state to blocked	
		
       	
	}
}
public static void semPrintPost(){
	if (blocked.isEmpty())
		semprint=1; 
		else {
			Scheduler.Ready.add(blocked.get(0));
			blocked.remove(0);
		}
	    semprint=1;
	
}
}