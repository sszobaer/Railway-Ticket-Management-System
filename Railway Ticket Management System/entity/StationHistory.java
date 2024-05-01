package entity;

public class StationHistory extends History
{
	public StationHistory(String fromStation)
	{
		super(fromStation);
	}
	public String toString()
	{
		return super.getFromStation()+"\n";
	}
}