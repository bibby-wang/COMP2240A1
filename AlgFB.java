import java.util.*;
public class AlgFB extends SchedulingAlgorithms{
	private Process currentJob;	
	//private Queue<Process> readyQueue= new LinkedList<Process>();
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
			//priorityQueue.get(i);
			//priorityQueue.get(i).isEmpty();//空否
			//priorityQueue.get(i).element();//查看队头
			//priorityQueue.get(i).poll();//出队
			//priorityQueue.get(i).offer();//入队
		}
		boolean signOfLoop = true;
		
		int priorityPoint=0;
		do{
			priorityPoint=0;
			while(!jobsQueue.isEmpty()){
				
				int arrTime=jobsQueue.element().getArriveTime();
				//chack arrvial time
				if (arrTime<=cpuTime){
					priorityQueue.get(priorityPoint).offer(jobsQueue.poll());//inster to the ready Queue
					//readyQueue.offer(jobsQueue.poll());//inster to the ready Queue
				}else{
					break;
				}
			}

			
			//check all priority Queues get the high priorityQueue that has process to do
			while(priorityPoint<6 && priorityQueue.get(priorityPoint).isEmpty()){
				priorityPoint++;
			}
			
			//System.out.println("Queue: "+priorityPoint);
			
			
			
			
			if (!this.checkEmpty(priorityQueue)){
				currentJob=priorityQueue.get(priorityPoint).poll();//get the job from queue
				int jobID=currentJob.getID();
				int jobArriveTime=currentJob.getArriveTime();
				int jobExecSize=currentJob.getSurplusTime();
				
				cpuTime+=DISP;//add the dispatcher running time
			//	if (jobExecSize<=currentJob.getTimeQ() || priorityQueue.get(priorityPoint).isEmpty()){
			//	if (jobExecSize<=currentJob.getTimeQ() || this.checkEmpty(priorityQueue)){
				if (jobExecSize<=currentJob.getTimeQ()){
					
					//System.out.println("T"+cpuTime+": p"+jobID);//print the cpu time and the ready process
					outputString+=getTPString(cpuTime,jobID);//output String Ti: pj
					cpuTime+=jobExecSize;
					currentJob.setTWTime(cpuTime);
					
					
				}else{

					
					//System.out.println("T"+cpuTime+": p"+jobID);//print the cpu time and the ready process
					outputString+=getTPString(cpuTime,jobID);//output String Ti: pj
					cpuTime+=currentJob.getTimeQ();
					currentJob.setSurplusTime(jobExecSize-currentJob.getTimeQ());
					currentJob.shortTimeQ(decreaseTimeQ);//short Time Quantum

					priorityQueue.get(priorityPoint+1).offer(currentJob);//入队
					//readyQueue.offer(currentJob);//inster to the end of ready Queue
				}

				
			}else{
				cpuTime++;
			}
			

			
		}while(!this.checkEmpty(priorityQueue) || !jobsQueue.isEmpty());
		return outputString;
	}



}