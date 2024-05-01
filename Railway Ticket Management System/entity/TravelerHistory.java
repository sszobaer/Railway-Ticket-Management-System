package entity;

public class TravelerHistory extends History
{
	private String name;
	private String nid;
	private String email;
	private String phoneNumber;
	private String password;
	private double balance;
	
	public TravelerHistory(String name,String nid,String email,String phoneNumber,String password,double balance)
	{
		super();
		this.name=name;
		this.nid=nid;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.password=password;
		this.balance=balance;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setNID(String nid)
	{
		this.nid=nid;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber=phoneNumber;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	public String getName()
	{
		return name;
	}
	public String getNID()
	{
		return nid;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public String getPassword()
	{
		return password;
	}
	public double getBalance()
	{
		return balance;
	}
	public String toString()
	{
		return getName()+"/"+getNID()+"/"+getEmail()+"/"+getPhoneNumber()+"/"+getPassword()+"/"+getBalance()+"\n";
	}
}