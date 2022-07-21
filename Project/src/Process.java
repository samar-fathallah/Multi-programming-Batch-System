import java.time.LocalDateTime;
import java.util.Date;

//import java.util.concurrent.Semaphore;


public class Process extends Thread {
	
	public int processID;
    ProcessState status=ProcessState.New;	
    public LocalDateTime time;
	public static SemPrint SP=new SemPrint();
	public static SemRead SR=new SemRead();
	public static SemWrite SW=new SemWrite();
	public static SemInput SI=new SemInput();
	public Process(int m) {
		processID = m;
	}
	@Override
	public void run() {
		switch(processID)
		{
		case 1:process1();break;
		case 2:process2();break;
		case 3:process3();break;
		case 4:process4();break;
		case 5:process5();break;
		}

	}
	
	private void process1() {
		SP.semPrintWait(this);
		SI.semInputWait(this);
		SR.semReadWait(this);
		OperatingSystem.printText("Enter File Name: ");
		OperatingSystem.printText(OperatingSystem.readFile(OperatingSystem.TakeInput()));
		SR.semReadPost();
		SI.semInputPost();
		SP.semPrintPost();
		setProcessState(this,ProcessState.Terminated);
		}
	
	private void process2() {
		SP.semPrintWait(this);
		SI.semInputWait(this);
		OperatingSystem.printText("Enter File Name: ");
		String filename= OperatingSystem.TakeInput();
		SI.semInputPost();
		SP.semPrintPost();
		//////////////////////////////////////////////////
		SP.semPrintWait(this);
		SI.semInputWait(this);
		OperatingSystem.printText("Enter Data: ");
		String data= OperatingSystem.TakeInput();
		SI.semInputPost();
		SP.semPrintPost();
		SW.semWriteWait(this);
		OperatingSystem.writefile(filename,data);
		SW.semWritePost();
		setProcessState(this,ProcessState.Terminated);
		}
	private void process3() {
		int x=0;
		SP.semPrintWait(this);
		while (x<301)
		{ 
			OperatingSystem.printText(x+"\n");
			x++;
		}
		SP.semPrintPost();
		setProcessState(this,ProcessState.Terminated);
		}
	
	private void process4() {
	
		int x=500;
		SP.semPrintWait(this);
		while (x<1001)
		{
			OperatingSystem.printText(x+"\n");
			x++;
		}
		SP.semPrintPost();
		setProcessState(this,ProcessState.Terminated);
		}
	private void process5() {
		SP.semPrintWait(this);
		SI.semInputWait(this);
		OperatingSystem.printText("Enter LowerBound: ");
		String lower= OperatingSystem.TakeInput();
		SI.semInputPost();
		SP.semPrintPost();
		////////////////////////////////////////////////////
		SP.semPrintWait(this);
		SI.semInputWait(this);
		OperatingSystem.printText("Enter UpperBound: ");
		String upper= OperatingSystem.TakeInput();
		SI.semInputPost();
		SP.semPrintPost();
		
		int lowernbr=Integer.parseInt(lower);
		int uppernbr=Integer.parseInt(upper);
		String data="";
		
		while (lowernbr<=uppernbr)
		{
			data+=lowernbr++ +"\n";
		}
		SW.semWriteWait(this);
		OperatingSystem.writefile("P5.txt", data);
		SW.semWritePost();
		setProcessState(this,ProcessState.Terminated);
	}
	
	 public static void setProcessState(Process p, ProcessState s) {
		 p.status=s;
//		 if (s == ProcessState.Terminated)
//		 {
//			 OperatingSystem.ProcessTable.remove(OperatingSystem.ProcessTable.indexOf(p));
//		 }
	}
	 
	 public static ProcessState getProcessState(Process p) {
		 return p.status;
	}
}
