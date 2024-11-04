package files;

import entitylist.*;
import entity.*;
import userGUI.LogInFrame;
import java.io.*;
import java.util.Scanner;

public class FileIO
{
	public static void writeInFile(String line,String fname,boolean append)
	{
		try
		{
		line=LogInFrame.emailId+"/"+line;
		FileWriter fw=new FileWriter(fname,append);
		fw.write(line);
		fw.flush();
		fw.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	public static void readFromFile(String fname,HistoryList historyList)
	{
		try
		{
		Scanner sc=new Scanner(new File(fname));
		while(sc.hasNextLine())
		{
			String sp[]=sc.nextLine().split("/");
			if(sp[0].equals(LogInFrame.emailId))
			{
			String trainName=sp[1];
			String fromStation=sp[2];
			String toStation=sp[3];
			String currentDate=sp[4];
			
			TicketHistory th=new TicketHistory(trainName,fromStation,toStation,currentDate);
			historyList.insertHistory(th);
			}
		}
		sc.close();
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public static void readFromStationHistoryFile(String fname,HistoryList historyList)
	{
		try
		{
		Scanner sc=new Scanner(new File(fname));
		while(sc.hasNextLine())
		{
			String sp[]=sc.nextLine().split("-");
			
			
			String fromStation=sp[1];
			
			
			StationHistory sh=new StationHistory(fromStation);
			historyList.insertHistory(sh);
			
		}
		sc.close();
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	/*public static void readFromTravelerHistoryFile(String fname,HistoryList historyList)
	{
		try
		{
		Scanner sc=new Scanner(new File(fname));
		while(sc.hasNextLine())
		{
			String sp[]=sc.nextLine().split("-");
			
			
			String fromStation=sp[1];
			
			
			TravelerHistory sh=new TravelerHistory(fromStation);
			historyList.insertHistory(sh);
			
		}
		sc.close();
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}*/
	
	public static void readFromTrainCoachHistoryFile(String fname,HistoryList historyList)
	{
		try
		{
		Scanner sc=new Scanner(new File(fname));
		while(sc.hasNextLine())
		{
			String sp[]=sc.nextLine().split("/");
			
			String trainName=sp[0];
			String trainCoach=sp[1];
			
			TrainCoachHistory tch=new TrainCoachHistory(trainName,trainCoach);
			historyList.insertHistory(tch);
			
		}
		sc.close();
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public static void readFromTrainHistoryFile(String fname,HistoryList historyList)
	{
		try
		{
		Scanner sc=new Scanner(new File(fname));
		while(sc.hasNextLine())
		{
			String sp[]=sc.nextLine().split("/");
			
			String fromStation=sp[0];
			String toStation=sp[1];
			String trainName=sp[2];
			String Class=sp[3];
			String time=sp[4];
			double ticketPrice=Double.parseDouble(sp[5]);
			
			TrainHistory trh=new TrainHistory(trainName,fromStation,toStation,time,Class,ticketPrice);
			historyList.insertHistory(trh);
			
		}
		sc.close();
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	/*public static void saveFromTicketHistoryList(String fname,TicketHistoryList thlist,boolean append)
	{
		try
		{
		FileWriter fw=new FileWriter(fname,append);
		TicketHistory ticketHistory[]=thlist.getAllTicketHistory();
		for(int i=0; i<ticketHistory.length; i++)
		{
			if(ticketHistory[i]!=null)
			{
				fw.write(ticketHistory[i].toString());
			}
		}
		fw.flush();
		fw.close();
		
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}*/
}