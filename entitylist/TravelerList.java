package entitylist;

import entity.Traveler;

public class TravelerList
{
	private Traveler [] travelers;
	
	public TravelerList()
	{
		travelers=new Traveler[10000];
	}
    public TravelerList(int size)
	{
		travelers=new Traveler[size];
	}
	public void insertTravelers(Traveler tv)
	{
		boolean flag=false;
		for(int i=0; i<travelers.length; i++)
		{
			if(travelers[i]==null)
			{
				travelers[i]=tv;
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Traveler Information Successfully Saved");
		}
		else
		{
			System.out.println("Traveler Information is not Saved");
		}
		
	}
	public Traveler[] getAllTravelers()
	{
		return travelers;
	}
}