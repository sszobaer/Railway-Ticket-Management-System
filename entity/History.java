package entity;

public class History 
{
	private String trainName;
	private String fromStation;
	private String toStation;	
	private String time;
	private String trainCoach;
	public History()
	{
		
	}
	public History(String trainName,String fromStation,String toStation,String time)
	{
		this.trainName=trainName;
		this.fromStation=fromStation;
		this.toStation=toStation;
		this.time=time;
	}
	public History(String fromStation)
	{
		this.fromStation=fromStation;
	}
	public History(String trainName,String trainCoach)
	{
		this.trainName=trainName;
		this.trainCoach=trainCoach;
	}
	public void setTrainName(String trainName)
	{
		this.trainName=trainName;
	}
	public void setFromStation(String fromStation)
	{
		this.fromStation=fromStation;
	}
	public void setToStation(String toStation)
	{
		this.toStation=toStation;
	}
	public void setTime(String time)
	{
		this.time=time;
	}
	public void setTrainCoach(String trainCoach)
	{
		this.trainCoach=trainCoach;
	}
	public String getTrainName()
	{
		return trainName;
	}
	public String getFromStation()
	{
		return fromStation;
	}
	public String getToStation()
	{
		return toStation;
	}
	public String getTime()
	{
		return time;
	}
	public String getTrainCoach()
	{
		return trainCoach;
	}
}