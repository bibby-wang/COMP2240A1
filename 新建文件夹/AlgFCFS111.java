import java.util.*;
public class AlgFCFS extends SchedulingAlgorithms{
	
	private static int jobsQuantity;
	private Process[] jobsStack;
	
	private Process currentJob;	
	
	private Queue<Process> jobsQueue= new LinkedList<Process>();

//
	public AlgFCFS(Process[] jobsStack,int DISP){
		super(jobsStack,DISP);
		
		this.jobsQuantity=jobsStack.length;
		for (int i=0;i<jobsQuantity;i++){
			jobsQueue.offer(jobsStack[i]);
		}
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
