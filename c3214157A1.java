import java.io.*;
import java.util.*;

public class C3214157A1{
	
	public static void main(String args []){
		
		
		int DISP=0;
		int processID=0;
		int processArriveTime=0;
		int processExecSize=0;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		ArrayList<Process> processList = new ArrayList<Process>();//建立一个进程列表,实际是对象列表
		//loading Process data 
		try{
////datafile1.txt
////datafile2.txt
			fileReader = new FileReader("."+File.separator+args[0]);//文件地址
			bufferedReader = new BufferedReader(fileReader);
			String lineData= bufferedReader.readLine();
//System.out.println(lineData+"END");
			String processData= null;
			
			//start loading data from file
			//System.out.println("==File name:"+args[0]);
			while(!lineData.equals("EOF")){


//System.out.println(lineData);
				if (lineData.length() > 5) {
					processData= lineData.substring(0,4);

				} 
				
				if (processData != null){
					//get data
					
					//get DISP
					if (processData.equals("DISP")){
						DISP = Integer.parseInt(lineData.substring(6));
					}						
					//get process number
					if (processData.equals("ID: ")){
						processID = Integer.parseInt(lineData.substring(5));
					}
					//get process arrive time
					if (processData.equals("Arri")){
						processArriveTime =  Integer.parseInt(lineData.substring(8));
					}
					//get process exec size
					if (processData.equals("Exec")){
						processExecSize =  Integer.parseInt(lineData.substring(10));
						//保存数据进入对象列表
						// saving data to process list
						Process process= new Process(processID,processArriveTime,processExecSize);
						processList.add(process);

						
					}

					processData= null;
				}
			lineData= bufferedReader.readLine();
//				System.out.println(DISP+"-"+processID+"-"+processArriveTime+"-"+processExecSize);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try{
				bufferedReader.close();
				fileReader.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		} 
		//end of loading process data



		
		int processQuantity=processList.size();	
		
		//System.out.println("Prcoess Quantity="+processList.size());
		//make stack for each Algorithm
		Process[] jobsStackFCFS=new Process[processQuantity];
		Process[] jobsStackRR=new Process[processQuantity];
		Process[] jobsStackFB=new Process[processQuantity];
		Process[] jobsStackNRR=new Process[processQuantity];
		for (int i=0; i < processList.size(); i++){

			
			processID=processList.get(i).getID();
			processArriveTime=processList.get(i).getArriveTime();
			processExecSize=processList.get(i).getExecSize();

			//make process and jobs Queue for each algorithms 
			//FCFS
			Process processFCFS= new Process(processID,processArriveTime,processExecSize);
			//Insert to jobsStackFCFS
			jobsStackFCFS[i]=processFCFS;
			//RR
			Process processRR= new Process(processID,processArriveTime,processExecSize);
			//Insert to jobsStackRR
			jobsStackRR[i]=processRR;
			//FB
			Process processFB= new Process(processID,processArriveTime,processExecSize);
			//Insert to jobsStackFB
			jobsStackFB[i]=processFB;
			//NRR
			Process processNRR= new Process(processID,processArriveTime,processExecSize);
			//Insert to jobsStackNRR
			jobsStackNRR[i]=processNRR;
			

		//System.out.println("HAO"+processID+"-"+processArriveTime+"-"+processExecSize);

		}


//////////////////////
////// FCFS ///////
//////////////////////
		AlgFCFS jobsOnFCFS= new AlgFCFS(jobsStackFCFS,DISP);
		System.out.println("FCFS:");
		jobsOnFCFS.simulateRunning();
		System.out.println("");		

		System.out.println("Process\t"+"Turnaround Time\t"+"Waiting Time");
		
		System.out.println(jobsOnFCFS.getJobsInformation());
		
//////////////////////
////// RR /////
//////////////////////
		AlgRR jobsOnRR= new AlgRR(jobsStackRR,DISP,0);
		System.out.println("RR:");
		jobsOnRR.simulateRunning();
		System.out.println("");
		System.out.println("Process\t"+"Turnaround Time\t"+"Waiting Time");
		
		System.out.println(jobsOnRR.getJobsInformation());
		
//////////////////////
////// FB ///////////
//////////////////////


//////////////////////
//////// NRR ////////
//////////////////////
		AlgNRR jobsOnNRR= new AlgNRR(jobsStackNRR,DISP,1);
		System.out.println("NRR:");
		jobsOnNRR.simulateRunning();
		System.out.println("");
		System.out.println("Process\t"+"Turnaround Time\t"+"Waiting Time");
		
		System.out.println(jobsOnNRR.getJobsInformation());


		System.out.println("SUMMARY");
		System.out.println("Algorithm"+"\t"+"Average Turnaround Time\t"+"Average Waiting Time");
		
		System.out.println("FCFS\t"+jobsOnFCFS.getSummary());
		System.out.println("RR\t"+jobsOnRR.getSummary());
		System.out.println("NRR\t"+jobsOnNRR.getSummary());

		
	}

	
}
