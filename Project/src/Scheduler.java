import java.util.ArrayList;


public class Scheduler {
	 public static ArrayList<Thread>Ready;
public Scheduler(){
	Ready=new ArrayList<Thread>();
}

@SuppressWarnings("deprecation")
public static void FCFS(){
	while(!Ready.isEmpty()){
		Process p=(Process)Ready.get(0);
		if(p.status.equals(ProcessState.Ready)){
			System.out.println("Process:"+ p.processID+" is ready");
			Process.setProcessState(p,ProcessState.Running);
			System.out.println("Process:"+ p.processID+" is running");
			p.start();
		}
		if(p.status.equals(ProcessState.Waiting)){
		  Process.setProcessState(p,ProcessState.Running);
			System.out.println("Process:"+ p.processID+" is back to running");
		  p.resume();
		  
		}
		while(true){
		if(p.status.equals(ProcessState.Terminated)){
			System.out.println("Process:"+ p.processID+" finished");
		 Ready.remove(p);
		 break;
		}
	}
		
}
}
}