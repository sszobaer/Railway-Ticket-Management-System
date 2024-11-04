package entity;

public class TrainHistory extends History
{
	private String Class;
	private double ticketPrice;
    
    public TrainHistory()
    {

		
	}
	public TrainHistory(String trainName,String fromStation,String toStation,String time,String Class,double ticketPrice)
    {
      super(trainName,fromStation,toStation,time);
	  this.Class=Class;
	  this.ticketPrice=ticketPrice;
		
	}
	public void setclass(String Class)
	{
		this.Class=Class;
	}
	public void setTicketPrice(double ticketPrice)
	{
		this.ticketPrice=ticketPrice;
	}
	public String getclass()
	{
		return Class;
	}
	public double getTicketPrice()
	{
		return ticketPrice;
	}
	public String toString()
	{
		return super.getFromStation()+"/"+super.getToStation()+"/"+super.getTrainName()+"/"+getclass()+"/"+super.getTime()+"/"+getTicketPrice()+"\n";
	}
}