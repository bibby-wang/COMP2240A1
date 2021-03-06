// - University of Newcastle
// - School of Electrical Engineering and Computer Science
// - COMP2240 Operating Systems
// - Assignment 1
// - Scheduling Algorithms
// - Process
// - Name: Binbin Wang
// - Student No: 3214157
// - Date: 03-09-2018

public class Process{

	private int pID;
	private int	arriveTime;
	private int	execSize;
	private int	surplusTime;
	private int	timeQ;

	
	private int turnaroundTime = 0;
	private int waitingTime = 0;	
	//Construction
	Process(int processID,int processArriveTime,int processExecSize){
		this.pID=processID;
		this.arriveTime=processArriveTime;
		this.execSize=processExecSize;
		this.surplusTime=processExecSize;
		this.timeQ=4;
		
	
	}
	
	//set Turnaround and waiting Time	
	public void setTWTime(int finishTime){
		turnaroundTime = finishTime - arriveTime;
		waitingTime = turnaroundTime - execSize;
		
	}
		
	//get id 	
	public int getID(){
		return pID;
	}
	//get Arrive Time 	
	public int getArriveTime(){
		return arriveTime;
	}

	//get Exec Size 	
	public int getExecSize(){
		return execSize;
	}
	//get Surplus Time 	
	public int getSurplusTime(){
		return surplusTime;
	}
	//set Surplus Time 	
	public void setSurplusTime(int surplusTime){
		this.surplusTime=surplusTime;
	}
	//get Turnaround Time 
	public int getTurnaroundTime(){
		return turnaroundTime;
	}
	//get Waiting Time 	
	public int getWaitingTime(){
		return waitingTime;
	}
	//get timeQ 	
	public int getTimeQ(){
		return timeQ;
	}
	//set shortTimeQ 	
	public void shortTimeQ(int q){
		if (timeQ>2)timeQ-=q;
	}	

}
