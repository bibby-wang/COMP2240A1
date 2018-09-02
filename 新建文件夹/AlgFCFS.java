
import java.util.*;
public class AlgFCFS{
	private static int DISP;
	private static int jobsQuantity;
	private Process[] jobsStack;
	
	private Process currentJob;	
	
	private Queue<Process> jobsQueue= new LinkedList<Process>();
	private float allJobsTurnaroundTime=0;
	private float allJobsWaitingTime=0;	
	private float averageTurnaroundTime=0;
	private float averageWaitingTime=0;

//
	public AlgFCFS(Process[] jobsStack,int DISP){
		
		this.jobsStack=jobsStack;		
		this.DISP=DISP;
		this.jobsQuantity=jobsStack.length;
		
		for (int i=0;i<jobsQuantity;i++){
			jobsQueue.offer(jobsStack[i]);
		}

	}

	//模拟运行FCFS算法
	public void simulateRunning(){
		int cpuTime=0;
		
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



	//list the order and time of the jobs being processed
	public String getJobsInformation(){
		String jobsInformation="";
		for (int i=0;i<jobsQuantity;i++){
			

			//System.out.println("p"+i+"\t"+jobsStack[i].getTurnaroundTime()+"\t"+jobsStack[i].getWaitingTime());
			jobsInformation+="p"+jobsStack[i].getID()+"\t"+jobsStack[i].getTurnaroundTime()+"\t"+jobsStack[i].getWaitingTime()+"\r\n";
			allJobsTurnaroundTime+=jobsStack[i].getTurnaroundTime();
			allJobsWaitingTime+=jobsStack[i].getWaitingTime();
		}

		
		
		return jobsInformation;
	}
	
		
	//get summary information Average Turnaround Time and Average Waiting Time
	public String getSummary(){
		String sumString="";
		if (jobsQuantity!=0){
			averageTurnaroundTime=allJobsTurnaroundTime/jobsQuantity;
			averageWaitingTime=allJobsWaitingTime/jobsQuantity;
			sumString+=String.format("%.2f",averageTurnaroundTime)+"\t"+String.format("%.2f",averageWaitingTime);
		}else{
			sumString+="No Jos Count!";	
		}
		return sumString;
	}
	//format output String
	public String stringFormat(String formatBreak,int length){
        int aLength = formatBreak.length();
        if(length>aLength){
            int i = length-aLength;
			formatBreak ="";
            for (int j = 0; j < i; j++) {
                formatBreak +=" ";
            }
        }
        return formatBreak;
	}	
	
}