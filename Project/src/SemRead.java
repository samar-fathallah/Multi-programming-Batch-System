import java.util.ArrayList;
public class SemRead {
 public static int semread;
 public static ArrayList<Process>blocked;
public SemRead(){
	semread=1;
	blocked=new ArrayList<Process>();
}
@SuppressWarnings({ "deprecation", "static-access" })
public static void semReadWait(Process p){
	if(semread==1){
		semread=0;
		
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
public static void semReadPost(){
	if (blocked.isEmpty())
		semread=1; 
		else {
			Scheduler.Ready.add(blocked.get(0));
			blocked.remove(0);
		}
	    semread=1;
	
}

}
