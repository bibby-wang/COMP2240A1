// - University of Newcastle
// - School of Electrical Engineering and Computer Science
// - COMP2240 Operating Systems
// - Assignment 1
// - Scheduling Algorithms
// - First Come First Served
// - Name: Binbin Wang
// - Student No: 3214157
// - Date: 04-09-2018
import java.util.*;
public class AlgFCFS extends SchedulingAlgorithms{
	
	private Process currentJob;	

	//Construction
	public AlgFCFS(Process[] jobsStack,int DISP){
		super(jobsStack,DISP);
	}

	//satar running algorithm
	public String runningAlgorithm(){
		String outputString="";
		do{

			currentJob=jobsQueue.peek();//get the job from queue
			int jobID=currentJob.getID();
			int jobArriveTime=currentJob.getArriveTime();
			int jobExecSize=currentJob.getExecSize();
			if (jobArriveTime<=cpuTime){
				jobsQueue.poll();
				cpuTime+=DISP;//add the dispatcher running time
				outputString+=getTPString(cpuTime,jobID);//output String Ti: pj
				cpuTime+=jobExecSize;
				currentJob.setTWTime(cpuTime);
				
	
			}else{
				cpuTime++;
			}

		}while(!jobsQueue.isEmpty());
		return outputString;
	}

}
