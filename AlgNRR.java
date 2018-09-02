import java.util.*;
public class AlgNRR extends AlgRR{
	private Process currentJob;	
	private Queue<Process> readyQueue= new LinkedList<Process>();
	public AlgNRR(Process[] jobsStack,int DISP,int decreaseTimeQ){
		super(jobsStack,DISP,decreaseTimeQ);
	}



}