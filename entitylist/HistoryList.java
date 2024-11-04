package entitylist;

import entity.*;

public class HistoryList  implements iTrainHistory
{
	private History [] historyList;
	
	public HistoryList()
	{
		historyList = new History[10000000]; 
	}
	public HistoryList(int size)
	{
		historyList = new History[size]; 
	}
	public void insertHistory(History h)
	{
		
		boolean flag=false;
		for(int i=0; i<historyList.length; i++)
		{
			if(historyList[i]==null)
			{
				historyList[i]=h;
				flag=true;
				break;
			}
			
		}
		if(flag){
			System.out.println("History Inserted Successfully");
		}
		else{
			System.out.println("Not Enough Space to Store the History");			
		}
		
	}
	
	public TravelerHistory [] getAllTravelerHistory()
	{
		TravelerHistory [] travelerhistory = new TravelerHistory[100000];
		for(int i=0; i<historyList.length; i++)
		{
			if(historyList[i]!=null && historyList[i] instanceof TravelerHistory)
			{
				TravelerHistory obj = (TravelerHistory)historyList[i];
				for(int j=0; j<travelerhistory.length; j++)
				{
					if(travelerhistory[j]==null)
					{
						travelerhistory[j]=obj;
						break;
					}
				}
			}
		}
		return travelerhistory;
	}
	public TrainHistory [] getAllTrainHistory()
	{
		TrainHistory [] trainhistory = new TrainHistory[100000];
		for(int i=0; i<historyList.length; i++)
		{
			if(historyList[i]!=null && historyList[i] instanceof TrainHistory)
			{
				TrainHistory obj = (TrainHistory)historyList[i];
				for(int j=0; j<trainhistory.length; j++)
				{
					if(trainhistory[j]==null)
					{
						trainhistory[j]=obj;
						break;
					}
				}
			}
		}
		return trainhistory;
	}
	public TicketHistory [] getAllTicketHistory()
	{
		TicketHistory [] tickethistory = new TicketHistory[100000];
		for(int i=0; i<historyList.length; i++)
		{
			if(historyList[i]!=null && historyList[i] instanceof TicketHistory)
			{
				TicketHistory obj = (TicketHistory)historyList[i];
				for(int j=0; j<tickethistory.length; j++)
				{
					if(tickethistory[j]==null)
					{
						tickethistory[j]=obj;
						break;
					}
				}
			}
		}
		return tickethistory;
	}
	
	public StationHistory [] getAllStationHistory()
	{
		StationHistory [] stationhistory = new StationHistory[100000];
		for(int i=0; i<historyList.length; i++)
		{
			if(historyList[i]!=null && historyList[i] instanceof StationHistory)
			{
				StationHistory obj = (StationHistory)historyList[i];
				for(int j=0; j<stationhistory.length; j++)
				{
					if(stationhistory[j]==null)
					{
						stationhistory[j]=obj;
						break;
					}
				}
			}
		}
		return stationhistory;
	}
	
	public TrainCoachHistory [] getAllTrainCoachHistory()
	{
		TrainCoachHistory [] trainCoachHistory = new TrainCoachHistory[100000];
		for(int i=0; i<historyList.length; i++)
		{
			if(historyList[i]!=null && historyList[i] instanceof TrainCoachHistory)
			{
				TrainCoachHistory obj = (TrainCoachHistory)historyList[i];
				for(int j=0; j<trainCoachHistory.length; j++)
				{
					if(trainCoachHistory[j]==null)
					{
						trainCoachHistory[j]=obj;
						break;
					}
				}
			}
		}
		return trainCoachHistory;
	}
}
