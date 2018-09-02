import java.util.*;
public class AlgRR extends AlgNRR{
	private Process currentJob;	

	private Queue<Process> readyQueue= new LinkedList<Process>();


//
	
	public AlgRR(Process[] jobsStack,int DISP,int decreaseTimeQ){
		super(jobsStack,DISP,decreaseTimeQ);
	}



}
