import java.util.*;
public class AlgFCFS extends SchedulingAlgorithms{
	
	
	private Process currentJob;	
	


//
	public AlgFCFS(Process[] jobsStack,int DISP){
		super(jobsStack,DISP);
		cpuTime=0;
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
