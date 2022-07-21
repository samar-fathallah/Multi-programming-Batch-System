import java.util.ArrayList;
public class SemWrite {
 public static int semwrite;
 public static ArrayList<Process>blocked;
public SemWrite(){
	semwrite=1;
	blocked=new ArrayList<Process>();
}
@SuppressWarnings({ "deprecation", "static-access" })
public static void semWriteWait(Process p){
	if(semwrite==1){
		semwrite=0;
	
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
public static void semWritePost(){
	if (blocked.isEmpty())
		semwrite=1; 
		else {
			Scheduler.Ready.add(blocked.get(0));
			blocked.remove(0);
		}
	    semwrite=1;
	
}
}
