import java.util.*;
public class AlgFB extends SchedulingAlgorithms{
	private Process currentJob;	
	private LinkedList<Queue<Process>> priorityQueue= new LinkedList<Queue<Process>>();

	
	
	private int decreaseTimeQ;
	//Construction
	public AlgFB(Process[] jobsStack,int DISP,int decreaseTimeQ){
		super(jobsStack,DISP);
		this.decreaseTimeQ=decreaseTimeQ;

	}
	private boolean checkEmpty(LinkedList<Queue<Process>> Queue){
		boolean val=true;

		for(int i=0;i<=5;i++){
			if (!priorityQueue.get(i).isEmpty()){val=false;}
		}		
		return val;
	}
	//satar running algorithm
	public String runningAlgorithm(){
		String outputString="";
		for (int i=0; i<6;i++){
			Queue<Process> readyQueue= new LinkedList<Process>();
			priorityQueue.add(readyQueue);

		}

		
		int priorityPoint=0;
		do{
			priorityPoint=0;
			while(!jobsQueue.isEmpty()){
				
				int arrTime=jobsQueue.element().getArriveTime();
				int timeQ=0;
				int tempTime=0;
				if (!this.checkEmpty(priorityQueue)){
					int queueNum=0;
					while(priorityQueue.get(queueNum).isEmpty()){
						queueNum++;
					}
					timeQ=priorityQueue.get(queueNum).element().getTimeQ()+DISP;
					tempTime=priorityQueue.get(queueNum).element().getSurplusTime()+DISP;
				}
				//get the arrival job 
				if (tempTime>timeQ){tempTime=timeQ;}
				if (arrTime<=cpuTime+tempTime){
					priorityQueue.get(0).offer(jobsQueue.poll());//inster to the ready Queue
				}else{
					break;
				}
			}

			
			//check all priority Queues get the high priorityQueue that has process to do
			while(priorityPoint<6 && priorityQueue.get(priorityPoint).isEmpty()){
				priorityPoint++;
			}
			
	
			
			
			if (priorityPoint<6 && !this.checkEmpty(priorityQueue)){
				currentJob=priorityQueue.get(priorityPoint).poll();//get the job from priority Queue
				int jobID=currentJob.getID();
				int jobArriveTime=currentJob.getArriveTime();
				int jobExecSize=currentJob.getSurplusTime();

				cpuTime+=DISP;//add the dispatcher running time				
				
				
				
				if (jobExecSize<=currentJob.getTimeQ()||this.checkEmpty(priorityQueue)){
					

					outputString+=getTPString(cpuTime,jobID);//output String Ti: pj
					cpuTime+=jobExecSize;
					currentJob.setTWTime(cpuTime);
					
					
				}else{

					
					outputString+=getTPString(cpuTime,jobID);//output String Ti: pj
					cpuTime+=currentJob.getTimeQ();
					currentJob.setSurplusTime(jobExecSize-currentJob.getTimeQ());
					currentJob.shortTimeQ(decreaseTimeQ);//short Time Quantum
					if(priorityPoint<5){
						priorityQueue.get(priorityPoint+1).offer(currentJob);//inster to next priority Queue
					}else{
						priorityQueue.get(5).offer(currentJob);//inster to end Queue
					}
				}
		
			}else{
				cpuTime++;
			}
			

			
		}while(!this.checkEmpty(priorityQueue) || !jobsQueue.isEmpty());
		return outputString;
	}



}