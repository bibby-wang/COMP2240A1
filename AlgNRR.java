import java.util.*;
public class AlgNRR extends SchedulingAlgorithms{
	private Process currentJob;	
	private static int timeQ = 4;	
	
	private Queue<Process> jobsQueue= new LinkedList<Process>();
	private Queue<Process> serviceQueue= new LinkedList<Process>();
	private int cpuTime;

//
	public AlgNRR(Process[] jobsStack,int DISP){
		super(jobsStack,DISP);

		for (int i=0;i<super.jobsQuantity;i++){
			jobsQueue.offer(jobsStack[i]);
		}
		cpuTime=jobsQueue.element().getArriveTime();		
	}

	//模拟运行NRR算法
	public void simulateRunning(){

		do{
			
			while(!jobsQueue.isEmpty()){
			
				if (jobsQueue.element().getArriveTime()<=cpuTime+timeQ){
					serviceQueue.offer(jobsQueue.poll());//inster to the service Queue
				}else{
					break;
				}
			}
			
			if (!serviceQueue.isEmpty()){
				currentJob=serviceQueue.poll();//get the job from queue
				int jobID=currentJob.getID();
				int jobArriveTime=currentJob.getArriveTime();
				int jobExecSize=currentJob.getSurplusTime();
				
				cpuTime+=DISP;//add the dispatcher running time
				if (jobExecSize<=timeQ || serviceQueue.isEmpty()){
					
					System.out.println("T"+cpuTime+": p"+jobID);//print the cpu time and the service process
					cpuTime+=jobExecSize;
					currentJob.setTWTime(cpuTime);
					
					
				}else{
					
					
					System.out.println("T"+cpuTime+": p"+jobID);//print the cpu time and the service process
					cpuTime+=timeQ;
					currentJob.setSurplusTime(jobExecSize-timeQ);
					serviceQueue.offer(currentJob);//inster to the end of service Queue
				}

				
			}else{
				cpuTime++;
			}
			
		}while(!serviceQueue.isEmpty() || !jobsQueue.isEmpty());
		
	}

}
