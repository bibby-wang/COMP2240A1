import java.util.*;
public class AlgFB extends AlgRR{
	private Process currentJob;	
	
	private Queue<Process> readyQueue = new LinkedList<Process>();
	public AlgFB(Process[] jobsStack,int DISP,int decreaseTimeQ){
		super(jobsStack,DISP,decreaseTimeQ);
	}



}