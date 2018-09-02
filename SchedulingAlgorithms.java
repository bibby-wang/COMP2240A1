
import java.util.*;
public class SchedulingAlgorithms{
	public static int DISP;
	public static int jobsQuantity;
	public Process[] jobsStack;

	public int cpuTime;
	public float allJobsTurnaroundTime;
	public float allJobsWaitingTime;	
	public float averageTurnaroundTime;
	public float averageWaitingTime;
	public Queue<Process> jobsQueue= new LinkedList<Process>();
//
	public SchedulingAlgorithms(Process[] jobsStack,int DISP){
		
		this.jobsStack=jobsStack;		
		this.DISP=DISP;
		this.jobsQuantity=jobsStack.length;
		for (int i=0;i<jobsQuantity;i++){
			jobsQueue.offer(jobsStack[i]);
		}
		cpuTime=jobsQueue.element().getArriveTime();	
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
