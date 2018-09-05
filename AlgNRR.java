import java.util.*;
public class AlgNRR extends AlgRR{
	private Process currentJob;	
	private String outputString="";
	private Queue<Process> readyQueue= new LinkedList<Process>();
	//Construction
	public AlgNRR(Process[] jobsStack,int DISP,int decreaseTimeQ){
		super(jobsStack,DISP,decreaseTimeQ);
	}



}