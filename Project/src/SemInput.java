import java.util.ArrayList;
public class SemInput {
 public static int seminput;
 public static ArrayList<Process>blocked;
public SemInput(){
	seminput=1;
	blocked=new ArrayList<Process>();
}
@SuppressWarnings({ "deprecation", "static-access" })
public static void semInputWait(Process p){
	if(seminput==1){
		seminput=0;
	
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
public static void semInputPost(){
	if (blocked.isEmpty())
		seminput=1; 
		else {
			Scheduler.Ready.add(blocked.get(0));
			blocked.remove(0);
		}
	    seminput=1;
	
}
}

