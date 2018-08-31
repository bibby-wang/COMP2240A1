import java.io.*;
import java.util.*;

public class C3214157A1{
	
	public static void main(String args []){
		
//start loading Process data 
		int DISP=0;
		int processID=0;
		int processArriveTime=0;
		int processExecSize=0;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		ArrayList<Process> processList = new ArrayList<Process>();//建立一个进程列表,实际是对象列表
		try{
			  //C:\Users\bibby\Desktop\java\datafile2.txt
			fileReader = new FileReader("."+File.separator+args[0]);//文件地址
			bufferedReader = new BufferedReader(fileReader);
			String lineData= bufferedReader.readLine();
			//System.out.println(lineData+"END");
			String processData= null;
			
			//start loading data from file
			
			while(!lineData.equals("EOF")){


//System.out.println(lineData);
				if (lineData.length() > 5) {
					processData= lineData.substring(0,4);

				} 
				
				if (processData != null){
					//get data
					
					//get process number
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
		
		System.out.println("Prcoess Quantity="+processList.size());
		
/////////////////////////外围是CPU时间循环 
/////////FCFS
//////先把数据存到新的arry中
//////然后执行FCFS
//////FCSF得到数据f
/////
///为不同算法分别建立队列
Queue<Process> processQueueFCFS = new LinkedList<Process>();
Queue<Process> processQueueRR = new LinkedList<Process>();
Queue<Process> processQueueFB = new LinkedList<Process>();
Queue<Process> processQueueNRR = new LinkedList<Process>();
///
for (int i=0; i < processList.size(); i++){

	
	processID=processList.get(i).getID();
	processArriveTime=processList.get(i).getArriveTime();
	processExecSize=processList.get(i).getExecSize();

	//make process and process Queue for each algorithms 
	//FCFS
	Process processFCFS= new Process(processID,processArriveTime,processExecSize);
	//Insert to processQueueFCFS
	processQueueFCFS.offer(processFCFS);
	//RR
	Process processRR= new Process(processID,processArriveTime,processExecSize);
	//Insert to processQueueRR
	processQueueRR.offer(processRR);
	//FB
	Process processFB= new Process(processID,processArriveTime,processExecSize);
	//Insert to processQueueFB
	processQueueFB.offer(processFB);
	//NRR
	Process processNRR= new Process(processID,processArriveTime,processExecSize);
	//Insert to processQueueNRR
	processQueueNRR.offer(processNRR);
	

//System.out.println("HAO"+processID+"-"+processArriveTime+"-"+processExecSize);

}

//processQueueNRR.poll().getExecSize();

//////////////////////
//////////////////////
//////////////////////
//////////////////////
//////////////////////

		System.out.println("-----------------------------------");

		Process[] FCFSProcess;//定义一个process数组
		FCFSProcess= new Process[processQuantity];
		FCFSProcess[0]= new Process(0,1,5);
		FCFSProcess[1]= new Process(0,3,7);
		FCFSProcess[2]= new Process(0,3,5);
        
        LinkedList<Process> dispFCFS = new LinkedList<Process>();

        //添加元素
        dispFCFS.addLast(FCFSProcess[0]);
        dispFCFS.addLast(FCFSProcess[1]);
        dispFCFS.addLast(FCFSProcess[2]);
		Process[] tempP1 = new Process[3];
		tempP1[0] = dispFCFS.getFirst();
		System.out.println("-----------------------------------");
		System.out.println("P"+ tempP1[0].getID()+ ": "+"\t ArrT:"+ tempP1[0].getArriveTime()+"ExT:"+tempP1[0].getExecSize());
		



//////////////////////////////////////
		System.out.println("-----------------------------------");
		System.out.println("-----------------------------------");

		System.out.println("---A" + "\t" + "B" + "\t" + "C");
		System.out.println("-------------------");
		
		
		System.out.println("The END");
		
	}

	
}





/*
public class c3214157A1{
	public static void main(String args []){

			int processID=0;
			int processArriveTime=0;
			int processExecSize=0;
			
			
			
			
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			
			
			try{
				  //C:\Users\bibby\Desktop\java\datafile2.txt
				fileReader = new FileReader("."+File.separator+"datafile1.txt");//文件地址
				bufferedReader = new BufferedReader(fileReader);
				
				String lineData= null;
				//System.out.println(lineData+"END");
				String processData= null;
				int processCount=0;//进程数量
				
				ArrayList<Process> processList = new ArrayList<Process>();//建立一个进程列表,实际是对象列表
				
				
				
				while(true){
					lineData= bufferedReader.readLine();
					
					
					if (lineData==null){
						break;
					}
					if (lineData.length() > 5) {
						processData= lineData.substring(0,4);
						//System.out.println(processData);
						} 
					
					
					
					if (processData != null){
						
// 					if (processData.equals("BEGI")){
//						//System.out.println("BEGIN:");
//					}					
//					if (processData.equals("DISP")){
//						//System.out.println("DISP");
//					} 
//
					//get data
					
					//get process number
					if (processData.equals("ID: ")){
						processID = Integer.parseInt(lineData.substring(5));
						//System.out.println(processID);
						
					}
					//get process arrive time
					if (processData.equals("Arri")){
						processArriveTime =  Integer.parseInt(lineData.substring(8));
						//System.out.println(processArriveTime);
						
					}
					//get process exec size
					if (processData.equals("Exec")){
						processExecSize =  Integer.parseInt(lineData.substring(10));
						//System.out.println(processExecSize);
					//format data	
						
					
							//保存数据进入对象列表
							Process process= new Process(processID,processArriveTime,processExecSize);
							processList.add(process);
						
						
						//System.out.println(processList.get(processCount));
						processCount=processCount+1;//计数器 总共对象个数
						//测试正确性
						//System.out.println("第"+ processCount +"次");
						//System.out.println(processID+"-"+processArriveTime+"-"+processExecSize);
					}
						
					processData= null;
					}
					
					
				}
				//判断是否成功保存对象
				//把已经保存的对象赋值给一个新建的对象
				//ArrayList<String> ProcessLS = new ArrayList<String>(); //进程列表
				//长度 ProcessLS.size(); 提取数据 String a=ProcessLS.get(i); 
				//删除数据ProcessLS.remove(i);//修改processLS.set(0, "修改之后的数据")
				//Process process1=processList.get(4);//赋值给一个新建的对象
				//System.out.println("p-"+process1.pID+"-"+process1.ArriveTime+"-"+process1.ExecSize);//调出进程的数据
				//System.out.println("共"+ processCount +"次行96");
				
				
				
				

				//////Start simulates FCFS, RR, SRT, FB constant and NRR scheduling algorithms.//////
				int cpuTime = 0;
				int cpuDis = 1;
				int cpuBlock = 4;
				int timeQuantum = 0;
				int processName = 0;
				int waitingTime = 0;
				int turnaroundTime = 0;
				String formatBreakA = "";
				String formatBreakB = "";
				
				
 				int processIdList[] = new int[processCount]; 

				// for (int i = 0; i < processCount ;i++ ){
					// processIdList[i]=processList.get(i).pID;
					// System.out.println("第"+ i +"次111行"+processCount);
					// System.out.println("数据"+ processIdList[i] );
				// }	
// 测试数据传输的效果和内容

///////////////////////////////
////////////FCFS//////////////
//////////////////////////////
			
				System.out.println("FCFS:");	
				cpuTime=0;				
				for (int iForFCFS = 0; iForFCFS < processCount ;iForFCFS++ ){
					
					processIdList[iForFCFS]=processList.get(iForFCFS).pID;
					
					cpuTime=cpuTime + cpuDis;
					System.out.println("T"+ cpuTime +": p"+processIdList[iForFCFS]);
					cpuTime=cpuTime + processList.get(iForFCFS).ExecSize;
					
					
					
				}	
				System.out.println("");
				System.out.println("Process Waiting Time Turnaround Time");
				cpuTime = 0;
				waitingTime = 0;
				turnaroundTime = 0;
				
				for (int jForFCFS = 0; jForFCFS < processCount ;jForFCFS++ ){
					
					processIdList[jForFCFS] = processList.get(jForFCFS).pID;
					
					cpuTime=cpuTime + cpuDis;
					waitingTime = cpuTime - processList.get(jForFCFS).ArriveTime;
					turnaroundTime = cpuTime + processList.get(jForFCFS).ExecSize - processList.get(jForFCFS).ArriveTime;
					
					//////format output data

						Process getFormatA = new Process(String.valueOf(processIdList[jForFCFS]),7);

						Process getFormatB = new Process(String.valueOf(waitingTime),13);


					//////outpur 
					System.out.println("p" + processIdList[jForFCFS]+ getFormatA.getformatBreak + waitingTime + getFormatB.getformatBreak  + turnaroundTime);
					
					cpuTime=cpuTime + processList.get(jForFCFS).ExecSize;
					
					
					
				}	
				System.out.println("");
				// for (int i=0; i<=processCount ;i++ ){System.out.println("共"+ i +"次");}	 
///////////////////////////////
////////////RR//////////////
//////////////////////////////			






///////////////////////////////
////////////FCFS//////////////
//////////////////////////////
	
///////////////////////////////
////////////FCFS//////////////
//////////////////////////////	



///////////////////////////////
////////////FCFS//////////////
//////////////////////////////						
					
				
			
			
			
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
		
		
		
		
		System.out.println("-----------------------------------");
		System.out.println("The END");
		
	}

	
}


*/