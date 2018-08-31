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
		ArrayList<Process> processList = new ArrayList<Process>();//����һ�������б�,ʵ���Ƕ����б�
		try{
			  //C:\Users\bibby\Desktop\java\datafile2.txt
			fileReader = new FileReader("."+File.separator+args[0]);//�ļ���ַ
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
						//�������ݽ�������б�
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
		
/////////////////////////��Χ��CPUʱ��ѭ�� 
/////////FCFS
//////�Ȱ����ݴ浽�µ�arry��
//////Ȼ��ִ��FCFS
//////FCSF�õ�����f
/////
///Ϊ��ͬ�㷨�ֱ�������
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

		Process[] FCFSProcess;//����һ��process����
		FCFSProcess= new Process[processQuantity];
		FCFSProcess[0]= new Process(0,1,5);
		FCFSProcess[1]= new Process(0,3,7);
		FCFSProcess[2]= new Process(0,3,5);
        
        LinkedList<Process> dispFCFS = new LinkedList<Process>();

        //���Ԫ��
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
				fileReader = new FileReader("."+File.separator+"datafile1.txt");//�ļ���ַ
				bufferedReader = new BufferedReader(fileReader);
				
				String lineData= null;
				//System.out.println(lineData+"END");
				String processData= null;
				int processCount=0;//��������
				
				ArrayList<Process> processList = new ArrayList<Process>();//����һ�������б�,ʵ���Ƕ����б�
				
				
				
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
						
					
							//�������ݽ�������б�
							Process process= new Process(processID,processArriveTime,processExecSize);
							processList.add(process);
						
						
						//System.out.println(processList.get(processCount));
						processCount=processCount+1;//������ �ܹ��������
						//������ȷ��
						//System.out.println("��"+ processCount +"��");
						//System.out.println(processID+"-"+processArriveTime+"-"+processExecSize);
					}
						
					processData= null;
					}
					
					
				}
				//�ж��Ƿ�ɹ��������
				//���Ѿ�����Ķ���ֵ��һ���½��Ķ���
				//ArrayList<String> ProcessLS = new ArrayList<String>(); //�����б�
				//���� ProcessLS.size(); ��ȡ���� String a=ProcessLS.get(i); 
				//ɾ������ProcessLS.remove(i);//�޸�processLS.set(0, "�޸�֮�������")
				//Process process1=processList.get(4);//��ֵ��һ���½��Ķ���
				//System.out.println("p-"+process1.pID+"-"+process1.ArriveTime+"-"+process1.ExecSize);//�������̵�����
				//System.out.println("��"+ processCount +"����96");
				
				
				
				

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
					// System.out.println("��"+ i +"��111��"+processCount);
					// System.out.println("����"+ processIdList[i] );
				// }	
// �������ݴ����Ч��������

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
				// for (int i=0; i<=processCount ;i++ ){System.out.println("��"+ i +"��");}	 
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