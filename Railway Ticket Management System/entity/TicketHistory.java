package entity;

public class TicketHistory extends History
{
	public TicketHistory()
	{
		
	}
	public TicketHistory(String trainName,String fromStation,String toStation,String time)
	{
		super(trainName,fromStation,toStation,time);
	}
	public String toString()
	{
		return super.getTrainName()+"/"+super.getFromStation()+"/"+super.getToStation()+"/"+super.getTime()+"\n";
	}
	
}