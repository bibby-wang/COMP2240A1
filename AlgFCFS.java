import java.util.*;
public class AlgFCFS extends SchedulingAlgorithms{
	
	
	private Process currentJob;	
	
	private Queue<Process> jobsQueue= new LinkedList<Process>();
	int cpuTime;

//
	public AlgFCFS(Process[] jobsStack,int DISP){
		super(jobsStack,DISP);
		cpuTime=0;
		for (int i=0;i<super.jobsQuantity;i++){
			jobsQueue.offer(jobsStack[i]);
		}
		cpuTime=jobsQueue.element().getArriveTime();
	}

	//模拟运行FCFS算法
	public void simulateRunning(){
		
		do{

			currentJob=jobsQueue.poll();//get the job from queue
			int jobID=currentJob.getID();
			int jobArriveTime=currentJob.getArriveTime();
			int jobExecSize=currentJob.getExecSize();
			if (jobArriveTime<=cpuTime){
				cpuTime+=DISP;//add the dispatcher running time
				System.out.println("T"+cpuTime+": p"+jobID);//test
				cpuTime+=jobExecSize;
				currentJob.setTWTime(cpuTime);
				
	
			}else{
				jobsQueue.offer(currentJob);//
				cpuTime++;
			}

		}while(!jobsQueue.isEmpty());
		
	}

}
