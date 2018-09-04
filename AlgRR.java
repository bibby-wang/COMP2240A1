
import java.util.*;
public class AlgRR extends SchedulingAlgorithms{
	private Process currentJob;	
	private Queue<Process> readyQueue= new LinkedList<Process>();
	private int decreaseTimeQ;


	//Construction
	public AlgRR(Process[] jobsStack,int DISP,int decreaseTimeQ){
		super(jobsStack,DISP);
		this.decreaseTimeQ=decreaseTimeQ;

	}

	//satar running algorithm
	public void runningAlgorithm(){

		do{
			
			while(!jobsQueue.isEmpty()){
				int arrTime=jobsQueue.element().getArriveTime();
				int timeQ=0;
				int tempTime=0;
				if (!readyQueue.isEmpty()){
					timeQ=readyQueue.element().getTimeQ();
					tempTime=readyQueue.element().getSurplusTime();
				}
				//get the arrival job 
				if (tempTime>timeQ){tempTime=timeQ;}

				if (arrTime<=cpuTime+tempTime){
					readyQueue.offer(jobsQueue.poll());//inster to the ready Queue
				}else{
					break;
				}
			}
			
			if (!readyQueue.isEmpty()){
				currentJob=readyQueue.poll();//get the job from queue
				int jobID=currentJob.getID();
				int jobArriveTime=currentJob.getArriveTime();
				int jobExecSize=currentJob.getSurplusTime();
				
				cpuTime+=DISP;//add the dispatcher running time
				if (jobExecSize<=currentJob.getTimeQ() || readyQueue.isEmpty()){
					
					System.out.println("T"+cpuTime+": p"+jobID);//print the cpu time and the ready process
					cpuTime+=jobExecSize;
					currentJob.setTWTime(cpuTime);
					
					
				}else{
					
					
					System.out.println("T"+cpuTime+": p"+jobID);//print the cpu time and the ready process
					cpuTime+=currentJob.getTimeQ();
					currentJob.setSurplusTime(jobExecSize-currentJob.getTimeQ());
					currentJob.shortTimeQ(decreaseTimeQ);//short Time Quantum

					readyQueue.offer(currentJob);//inster to the end of ready Queue
				}

				
			}else{
				cpuTime++;
			}
			
		}while(!readyQueue.isEmpty() || !jobsQueue.isEmpty());
		
	}

}
