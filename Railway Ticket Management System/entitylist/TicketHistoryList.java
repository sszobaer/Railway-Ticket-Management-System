package entitylist;

import entity.TicketHistory;

public class TicketHistoryList
{
	private TicketHistory [] tickethistorylist;
	
	public TicketHistoryList()
	{
		tickethistorylist=new TicketHistory[1000];
	}
	public TicketHistoryList(int size)
	{
		tickethistorylist=new TicketHistory[size];
	}
	public void insertTicketHistory(TicketHistory th)
	{
		boolean flag=false;
		for(int i=0; i<tickethistorylist.length; i++)
		{
			if(tickethistorylist[i]==null)
			{
				tickethistorylist[i]=th;
				flag=true;
				break;
			}
			
		}
		if(flag){
			System.out.println("Ticket History Inserted Successfully");
		}
		else{
			System.out.println("Not Enough Space to Store the Ticket History");			
		}
		
	}
	public TicketHistory[] getAllTicketHistory()
	{
		return tickethistorylist;
	}
}