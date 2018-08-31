public class Process{

	private int pID;
	private int	arriveTime;
	private int	execSize;
//	int	surplusSize;//Remaining time

	private int turnaroundTime = 0;
	private int waitingTime = 0;	
	Process(int processID,int processArriveTime,int processExecSize){
		this.pID=processID;
		this.arriveTime=processArriveTime;
		this.execSize=processExecSize;
		
	
	}
	
	//set Turnaround Time	
	public void setTurnaroundTime(int theTime){
		turnaroundTime = arriveTime - theTime;
		
		
	}
	//set Turnaround Time	
	public void setWaitingTime(int theTime){
		////////
		waitingTime+=theTime;/////////
		/////////
		///////////
		
		
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
	//get Turnaround Time 
	public int getTurnaroundTime(){
		return turnaroundTime;
	}
	//get Waiting Time 	
	public int getWaitingTime(){
		return waitingTime;
	}
	
	
}
