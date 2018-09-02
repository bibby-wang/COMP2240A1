public class Process{

	private int pID;
	private int	arriveTime;
	private int	execSize;
	private int	surplusTime;
//	int	surplusSize;//Remaining time

	private int turnaroundTime = 0;
	private int waitingTime = 0;	

	Process(int processID,int processArriveTime,int processExecSize){
		this.pID=processID;
		this.arriveTime=processArriveTime;
		this.execSize=processExecSize;
		this.surplusTime=processExecSize;
		
	
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
	
	
}
