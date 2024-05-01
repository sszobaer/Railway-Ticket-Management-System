package entity;

public class TrainCoachHistory extends History
{
	public TrainCoachHistory(String trainName,String trainCoach)
	{
		super(trainName,trainCoach);
	}
	public String toString()
	{
		return super.getTrainName()+"/"+super.getTrainCoach()+"\n";
	}
}