package userGUI;

import entitylist.*;
import files.*;
import entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class IntercityBuyTicketFrame extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
	private JButton button1,button2,button3,button4;
	private JComboBox cb1,cb2,cb3,cb4,cb5;
	private JRadioButton radiobtn1,radiobtn2,radiobtn3;
	private ButtonGroup grp;
	private JScrollPane scroll1,scroll2,scroll3;
	Font font1=new Font("cambria",Font.BOLD+Font.ITALIC,35);
	Font font2=new Font("cambria",Font.BOLD,25);
	Font font3=new Font("cambria",Font.BOLD,15);
	private LogInFrame login;
	private HomePageFrame hp;
	private HistoryList historyList;
	double ticketPrice ;
	private String trainName = "";
	private String fromStation = "";
	private String toStation = "";
	
	
	public IntercityBuyTicketFrame(HomePageFrame hp,LogInFrame login,HistoryList historyList)
	{
		super("Bangladesh Railway");
		this.login=login;
		this.hp=hp;
		this.historyList=historyList;
		initializeForm();
		
		this.setVisible(true);
	}
	
	public void initializeForm()
	{
		this.setSize(700,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		panel=new JPanel();
		panel.setBounds(0,0,700,600);
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBackground(new Color(255,255,255));
		

		label1=new JLabel("<");
		label1.setBounds(0,0,60,40);
		label1.setFont(new Font("Meiryo",Font.BOLD,35));
		
		button1=new JButton();
		button1.setBounds(10,60,60,40);
		button1.addActionListener(this);
		button1.setToolTipText("Back to Homepage");
		button1.add(label1);
		
		ImageIcon img=new ImageIcon("./userGUI/Resources/LOGO2.png");
		JLabel logo=new JLabel("",img,JLabel.CENTER);
		logo.setBounds(90,50,60,60);
		panel.add(logo);
		
		label2=new JLabel("InterCity Trains");
		label2.setBounds(150,45,350,60);
		label2.setFont(font1);
		label2.setForeground(new Color(41, 37, 94));
		
		button2=new JButton("Sign out");
		button2.setBounds(570,65,90,30);
		button2.setBackground(new Color(96,188,209));
		button2.setFont(font3);
		button2.addActionListener(this);
		
		label3=new JLabel("Buy Ticket");
		label3.setBounds(20,130,150,50);
		label3.setFont(font2);
		
		label4=new JLabel("From Station");
		label4.setBounds(40,200,240,30);
		label4.setFont(font3);
		
		cb1=new JComboBox();
		cb1.setBounds(40,235,240,30);
		cb1.setFont(font3);
		cb1.setEditable(true);
		StationHistory stationHistory [] = historyList.getAllStationHistory();
		
		for(int i=0; i<stationHistory.length; i++)
		{
		    if(stationHistory[i]!=null)
			{
				String st = stationHistory[i].getFromStation();
				cb1.addItem(st);
			}
			
		}
		cb1.setSelectedItem("");
		cb1.addActionListener(this);
		
		label5=new JLabel("To Station");
		label5.setBounds(320,200,240,30);
		label5.setFont(font3);
		
		cb2=new JComboBox();
		cb2.setBounds(320,235,240,30);
		cb2.setFont(font3);
		cb2.setEditable(true);
		
		/*for(int i=0; i<stationHistory.length; i++)
		{
		    if(stationHistory[i]!=null)
			{
				String st = stationHistory[i].getFromStation();
				cb2.addItem(st);
			}
			
		}*/
		cb2.setSelectedItem("");
		cb2.addActionListener(this);
		
		label6=new JLabel("Select Train");
		label6.setBounds(40,270,240,30);
		label6.setFont(font3);
		
		cb3=new JComboBox();
		cb3.setFont(font3);
		cb3.setEditable(true);
		cb3.addActionListener(this);
		
		scroll1=new JScrollPane(cb3);
		scroll1.setBounds(40,305,240,30);
		cb3.setPreferredSize(new Dimension(0,20));
		cb3.setMaximumRowCount(5);
		
		label7=new JLabel("Journey Date");
		label7.setBounds(320,270,240,30);
		label7.setFont(font3);
		
		cb4=new JComboBox();
		cb4.setFont(font3);
		cb4.setEditable(true);
		cb4.addActionListener(this);
		
		scroll2=new JScrollPane(cb4);
		scroll2.setBounds(320,305,240,30);
		cb4.setPreferredSize(new Dimension(0,20));
		cb4.setMaximumRowCount(5);
		
		label8=new JLabel("Choose Class");
		label8.setBounds(40,340,240,30);
		label8.setFont(font3);
		
		radiobtn1=new JRadioButton("Shovon");
		radiobtn1.setBounds(40,375,80,30);
		radiobtn1.addActionListener(this);
		
		radiobtn2=new JRadioButton("Snigdha");
		radiobtn2.setBounds(125,375,80,30);
		radiobtn2.addActionListener(this);
		
		radiobtn3=new JRadioButton("Berth");
		radiobtn3.setBounds(210,375,70,30);
		radiobtn3.addActionListener(this);
		
		grp=new ButtonGroup();
		grp.add(radiobtn1);
		grp.add(radiobtn2);
		grp.add(radiobtn3);
		
		label9=new JLabel("Choose Coach");
		label9.setBounds(320,340,240,30);
		label9.setFont(font3);
		
		cb5=new JComboBox();
		cb5.setFont(font3);
		cb5.setEditable(true);
		cb5.addActionListener(this);
		
		scroll3=new JScrollPane(cb5);
		scroll3.setBounds(320,375,240,30);
		cb5.setPreferredSize(new Dimension(0,20));
		cb5.setMaximumRowCount(5);
		
		/*button3=new JButton("Reset");
		button3.setBounds(450,500,80,30);
		button3.setBackground(new Color(96,188,209));
		button3.setFont(font3);
		button3.addActionListener(this);*/
		
		label10=new JLabel();
		label10.setBounds(40,490,400,40);
		label10.setForeground(new Color(41, 37, 94));
		label10.setFont(font2);
		//label10.setText("Tiket Price : "+1100+" TK ");
		
		
		button4=new JButton("Buy");
		button4.setBounds(560,500,80,30);
		button4.setBackground(new Color(96,188,209));
	    button4.setFont(font3);
		button4.addActionListener(this);
	
		
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		panel.add(label10);
		panel.add(button1);
		panel.add(button2);
		//panel.add(button3);
		panel.add(button4);
		panel.add(cb1);
		panel.add(cb2);
		panel.add(scroll1);
		panel.add(scroll2);
		panel.add(scroll3);
		panel.add(radiobtn1);
		panel.add(radiobtn2);
		panel.add(radiobtn3);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button1)
		{
			this.dispose();
		
            HomePageFrame hpf=new HomePageFrame(login,historyList);
			
		}
		if(e.getSource()==button2)
		{
			this.dispose();
			login.setVisible(true);
		}
		if(e.getSource()==cb1)
		{
				
			boolean flag = false;
			 
			String [] stations = new String[1000000];
			TrainHistory trainhistory [] = historyList.getAllTrainHistory();
			cb2.removeAllItems();
			
			for(int i=0; i<trainhistory.length; i++)
			{
				if(trainhistory[i]!=null)
				{
					if(cb1.getSelectedItem()!=null && 
					cb1.getSelectedItem().equals(trainhistory[i].getFromStation()))
					{
						fromStation = cb1.getSelectedItem().toString();
						for(int w=0; w<stations.length; w++)
						{
							if(stations[w]!=null && stations[w].equals(trainhistory[i].getToStation()))
							{
								
							   flag = true;
								break;
							}
						}
						if(flag==false)
						{
						for(int j=0; j<stations.length; j++)
						{
						   if(stations[j]==null)
						   {
							   stations[j]=trainhistory[i].getToStation();
							   break;
						   }
							
						}
						}
					}
				}
				flag = false;
			}
	
			for(int i=0; i<stations.length; i++)
			{						
         		if(stations[i]!=null)
				{
					
					cb2.addItem(stations[i]);
					
				}
				toStation = cb2.getSelectedItem().toString();
		}
		}
		if(e.getSource()==cb2)
		{
			
			boolean flag = false;
			String [] trains = new String[1000000];
			TrainHistory trainhistory [] = historyList.getAllTrainHistory();
			cb3.removeAllItems();
			
			for(int i=0; i<trainhistory.length; i++)
			{
				if(trainhistory[i]!=null)
				{
					if(cb1.getSelectedItem()!=null && 
					cb2.getSelectedItem()!=null && 
					cb1.getSelectedItem().equals(trainhistory[i].getFromStation()) && 
					cb2.getSelectedItem().equals(trainhistory[i].getToStation()))
					{
						for(int w=0; w<trains.length; w++)
						{
							if(trains[w]!=null && trains[w].equals(trainhistory[i].getTrainName()))
							{
								
							   flag = true;
								break;
							}
						}
						if(flag==false)
						{
						for(int j=0; j<trains.length; j++)
						{
						   if(trains[j]==null)
						   {
							   trains[j]=trainhistory[i].getTrainName();
							   break;
						   }
							
						}
						}
					}
				}
				flag = false;
			}
	
			for(int i=0; i<trains.length; i++)
			{						
         		if(trains[i]!=null)
				{
					cb3.addItem(trains[i]);
				}
				if(cb2.getSelectedItem()!=null && cb3.getSelectedItem()!=null){
				toStation = cb2.getSelectedItem().toString();
				trainName = cb3.getSelectedItem().toString();
				}
		}
			
		}
	  
	if(e.getSource()==cb3)
		{
			boolean flag = false;
			
			String [] trainSchedule = new String[1000000];
			TrainHistory trainhistory [] = historyList.getAllTrainHistory();
			cb4.removeAllItems();
			
			for(int i=0; i<trainhistory.length; i++)
			{
				if(trainhistory[i]!=null)
				{
					if(cb1.getSelectedItem()!=null && 
					cb2.getSelectedItem()!=null && 
					cb3.getSelectedItem()!=null && 
					cb1.getSelectedItem().equals(trainhistory[i].getFromStation()) && 
					cb2.getSelectedItem().equals(trainhistory[i].getToStation()) && 
					cb3.getSelectedItem().equals(trainhistory[i].getTrainName()))
					{
						for(int w=0; w<trainSchedule.length; w++)
						{
							if(trainSchedule[w]!=null && 
							trainSchedule[w].equals(trainhistory[i].getTime()))
							{
								
							   flag = true;
								break;
							}
						}
						if(flag==false)
						{
						for(int j=0; j<trainSchedule.length; j++)
						{
						   if(trainSchedule[j]==null)
						   {
							   trainSchedule[j]=trainhistory[i].getTime();
							   break;
						   }
							
						}
						}
					}
				}
				flag = false;
			}
	
			for(int i=0; i<trainSchedule.length; i++)
			{						
         		if(trainSchedule[i]!=null)
				{
					cb4.addItem(trainSchedule[i]);
				}
		}
		
			String [] trainCoach = new String[1000000];
			TrainCoachHistory trainCoachHistory [] = historyList.getAllTrainCoachHistory();
			cb5.removeAllItems();
			
			for(int i=0; i<trainCoachHistory.length; i++)
			{
				if(trainCoachHistory[i]!=null)
				{
					if(cb1.getSelectedItem()!=null && 
					cb2.getSelectedItem()!=null && 
					cb3.getSelectedItem()!=null && 
					cb4.getSelectedItem()!=null && 
					cb3.getSelectedItem().equals(trainCoachHistory[i].getTrainName()))
					{
						for(int w=0; w<trainCoach.length; w++)
						{
							if(trainCoach[w]==null)
							{
								trainCoach[w]=trainCoachHistory[i].getTrainCoach();
								break;
							}
						}
					}
				}
				
			}
	
			for(int i=0; i<trainCoach.length; i++)
			{						
         		if(trainCoach[i]!=null)
				{
					cb5.addItem(trainCoach[i]);
				}
		}
		if(cb2.getSelectedItem()!=null && cb3.getSelectedItem()!=null){
				toStation = cb2.getSelectedItem().toString();
				trainName = cb3.getSelectedItem().toString();
				}
		}
		
		if(e.getSource()==cb4)
		{
			
		}
		
		if(e.getSource()==cb5)
		{
			
		}
		
		if(radiobtn1.isSelected())
		{
			if(cb1.getSelectedItem()!=null && 
			cb2.getSelectedItem()!=null && 
			cb3.getSelectedItem()!=null && 
			cb4.getSelectedItem()!=null && 
			cb5.getSelectedItem()!=null)
			{
				/*fromStation = cb1.getSelectedItem().toString();
				toStation = cb2.getSelectedItem().toString();
				trainName = cb3.getSelectedItem().toString();*/
				
			TrainHistory trainhistory [] = historyList.getAllTrainHistory();
			
			for(int i=0; i<trainhistory.length; i++)
			{
				if(trainhistory[i]!=null && 
				cb1.getSelectedItem().equals(trainhistory[i].getFromStation()) &&
				cb2.getSelectedItem().equals(trainhistory[i].getToStation()) &&
				cb3.getSelectedItem().equals(trainhistory[i].getTrainName()) && 
				cb4.getSelectedItem().equals(trainhistory[i].getTime()) &&
				radiobtn1.getText().equals(trainhistory[i].getclass()))
				{
					label10.setText("Tiket Price : "+trainhistory[i].getTicketPrice()+" TK ");
					ticketPrice = trainhistory[i].getTicketPrice();
					break;
				}
			}
		}
		
		}

		if(radiobtn2.isSelected())
		{
			if(cb1.getSelectedItem()!=null && 
			cb2.getSelectedItem()!=null && 
			cb3.getSelectedItem()!=null && 
			cb4.getSelectedItem()!=null && 
			cb5.getSelectedItem()!=null)
			{
				/*fromStation = cb1.getSelectedItem().toString();
				toStation = cb2.getSelectedItem().toString();
				trainName = cb3.getSelectedItem().toString();*/
				
			TrainHistory trainhistory [] = historyList.getAllTrainHistory();
			
			for(int i=0; i<trainhistory.length; i++)
			{
				if(trainhistory[i]!=null && 
				cb1.getSelectedItem().equals(trainhistory[i].getFromStation()) &&
				cb2.getSelectedItem().equals(trainhistory[i].getToStation()) &&
				cb3.getSelectedItem().equals(trainhistory[i].getTrainName()) && 
				cb4.getSelectedItem().equals(trainhistory[i].getTime()) &&
				radiobtn2.getText().equals(trainhistory[i].getclass()))
				{
					label10.setText("Tiket Price : "+trainhistory[i].getTicketPrice()+" TK ");
					ticketPrice = trainhistory[i].getTicketPrice();
					break;
				}
			}
		}
		
		}
		
		if(radiobtn3.isSelected())
		{
			if(cb1.getSelectedItem()!=null && 
			cb2.getSelectedItem()!=null && 
			cb3.getSelectedItem()!=null && 
			cb4.getSelectedItem()!=null && 
			cb5.getSelectedItem()!=null)
			{
				/*fromStation = cb1.getSelectedItem().toString();
				toStation = cb2.getSelectedItem().toString();
				trainName = cb3.getSelectedItem().toString();*/
				
			TrainHistory trainhistory [] = historyList.getAllTrainHistory();
			
			for(int i=0; i<trainhistory.length; i++)
			{
				if(trainhistory[i]!=null && 
				cb1.getSelectedItem().equals(trainhistory[i].getFromStation()) &&
				cb2.getSelectedItem().equals(trainhistory[i].getToStation()) &&
				cb3.getSelectedItem().equals(trainhistory[i].getTrainName()) && 
				cb4.getSelectedItem().equals(trainhistory[i].getTime()) &&
				radiobtn3.getText().equals(trainhistory[i].getclass()))
				{
					label10.setText("Tiket Price : "+trainhistory[i].getTicketPrice()+" TK ");
					ticketPrice = trainhistory[i].getTicketPrice();
					break;
				}
			}
		}
		
		}
		
		if(e.getSource()==button4)
		{
			if(cb1.getSelectedItem()!=null && 
			cb2.getSelectedItem()!=null && 
			cb3.getSelectedItem()!=null && 
			cb4.getSelectedItem()!=null && 
			cb5.getSelectedItem()!=null &&
			(radiobtn1.isSelected() || radiobtn2.isSelected() || radiobtn3.isSelected()))
			{
				if(Double.parseDouble(login.balance)>=ticketPrice)
				{
				int option=JOptionPane.showConfirmDialog(this,"Are you Sure to Buy a ticket from "+fromStation+" to "+toStation+"?");
				if(option==JOptionPane.YES_OPTION)
			{
				Date date = new Date();
                
				DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String currentDate=dateformat.format(date);
				
			    TicketHistory th=new TicketHistory(trainName,fromStation,toStation,currentDate);
			    historyList.insertHistory(th);
			    FileIO.writeInFile(th.toString(),"files/ticketHistory.txt",true);
			
			try
			{
				String email="";
				String name="";
				String phone="";
				String pass="";
				String nid="";
				String balanceprice="";
				
				File oldfile=new File("files/TravelerList.txt");
				File newfile=new File("files/temp.txt");
				newfile.createNewFile();
				FileWriter fw=new FileWriter("files/temp.txt",true);
				
				
				FileReader fr=new FileReader(oldfile);
				BufferedReader bfr=new BufferedReader(fr);
				String singleLine;
				
				while((singleLine=bfr.readLine())!=null)
				{
					String sp[]=singleLine.split("/");
					if(sp[2].equals(login.emailId))
					{
						name=sp[0];
						nid=sp[1];
						email=sp[2];
						phone=sp[3];
						pass=sp[4];
						balanceprice=sp[5];
					}
					if(!sp[2].equals(login.emailId))
					{
						fw.write(singleLine+"\n");
					}
						
				}
				fr.close();
				fw.flush();
				fw.close();
				//pw.flush();
				//pw.close();
				oldfile.delete();
				File dump=new File("files/TravelerList.txt");
				newfile.renameTo(dump);
				double countTaka=Double.parseDouble(login.balance)-ticketPrice;
				String s=name+"/"+nid+"/"+email+"/"+phone+"/"+pass+"/"+countTaka+"\n";
				FileWriter fw1=new FileWriter("files/TravelerList.txt",true);
		      for (int i = 0; i < s.length(); i++)
			 {
                fw1.write(s.charAt(i));
	         }
            fw1.close(); 
			}
			catch(IOException ioe)
		    {
				ioe.printStackTrace();
			}
			/*fromStation="";
			toStation="";
			currentDate="";*/
		}
		else if(option==JOptionPane.NO_OPTION)
		{
			/*fromStation="";
			toStation="";*/
		}
		else if(option==JOptionPane.CANCEL_OPTION)
		{
			/*fromStation="";
			toStation="";*/
		}
		}
		else
		{
			JOptionPane.showMessageDialog(this,"You don't have sufficient Balance","Message",JOptionPane.INFORMATION_MESSAGE);
		}
	    }
		else if(fromStation.equals("") || toStation.equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Start and Ending Station","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!radiobtn1.isSelected() || !radiobtn2.isSelected() || !radiobtn2.isSelected())
		{
			JOptionPane.showMessageDialog(this,"You must have to Choose a Class","Error",JOptionPane.ERROR_MESSAGE);
		}
				
		}
		
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==cb1)
		{
			/*if(cb1.getSelectedItem().equals(""))
			{
				
			}
			else if(!cb1.getSelectedItem().equals("") && !cb1.getSelectedItem().equals(select))
			{
				select =cb1.getSelectedItem().toString();*/
			/*boolean flag = false;
			System.out.println(10);
			 a++;
			String [] stations = new String[1000000];
			TrainHistory trainhistory [] = historyList.getAllTrainHistory();
			//cb2.removeAllItems();
			
			for(int i=0; i<trainhistory.length; i++)
			{
				if(trainhistory[i]!=null)
				{
					if(cb1.getSelectedItem()!=null && cb1.getSelectedItem().equals(trainhistory[i].getFromStation()))
					{
						for(int w=0; w<stations.length; w++)
						{
							if(stations[w]!=null && stations[w].equals(trainhistory[i].getToStation()))
							{
								
							   flag = true;
								break;
							}
						}
						if(flag==false)
						{
						for(int j=0; j<stations.length; j++)
						{
						   if(stations[j]==null)
						   {
							   stations[j]=trainhistory[i].getToStation();
							   for(int p=0; p<removestr.length; p++)
							   {
								   if(removestr[p]==null)
								   {
									   removestr[p]=trainhistory[i].getToStation();
									 // System.out.println(removestr[p]);
									   break;
								   }
							   }
							   break;
						   }
							
						}
						}
					}
				}
				flag = false;
			}
	
			for(int i=0; i<stations.length; i++)
			{						
         		if(stations[i]!=null)
				{
					//String stp = stations[i];
					cb2.addItem(stations[i]);
					
					 
				}
		}
		for(int i=0; i<stations.length; i++)
			{						
         		if(stations[i]!=null)
				{
					for(int j=0; j<removestr.length; j++)
					{
						if(removestr[j]!=null && stations[i].equals(removestr[j]))
						{
							//System.out.println(stations[i]);
							removestr[j]=null;
							break;
						}
					}
					
					 
				}
		} 
		/*for(int j=0; j<removestr.length; j++)
			{						
         		if(removestr[j]!=null)
				{
					for(int i=0; i<stations.length; i++)
					{
						if(stations[i]!=null && removestr[j].equals(stations[i]))
						{
							//System.out.println(stations[i]);
							removestr[j]=null;
							break;
						}
					}
					
					 
				}
		}*/
		/*if(a>1){
		for(int i=0; i<removestr.length; i++)
			{						
         		if(removestr[i]!=null)
				{
					//String stp = stations[i];
					System.out.println(removestr[i]);
					cb2.removeItem(removestr[i].toString());
					
					 
				}
			}
		}
		if(!flag1){
		StationHistory stationHistory [] = historyList.getAllStationHistory();
		flag1 = true;
		for(int i=0; i<stationHistory.length; i++)
		{
		    if(stationHistory[i]!=null)
			{
				String st = stationHistory[i].getFromStation();
				cb2.removeItem(st);
			}
			
		}
		}
		
		
			/*else if(cb1.getSelectedItem().equals(select))
			{
			}*/
	//}
		/*if(e.getSource()==cb2)
		{
			
			boolean flag = false;
			String [] station = new String[1000000];
			TrainHistory trainhistorys [] = historyList.getAllTrainHistory();
			
			//cb1.removeAllItems();
			for(int i=0; i<trainhistorys.length; i++)
			{
				if(trainhistorys[i]!=null)
				{
					if(cb2.getSelectedItem()!=null && cb2.getSelectedItem().equals(trainhistorys[i].getToStation()))
					{
						for(int w=0; w<station.length; w++)
						{
							if(station[w]!=null && station[w].equals(trainhistorys[i].getFromStation()))
							{
								
							   flag = true;
								break;
							}
						}
						if(flag==false)
						{
						for(int j=0; j<station.length; j++)
						{
						   if(station[j]==null)
						   {
							   station[j]=trainhistorys[i].getFromStation();
							 
							   break;
						   }
							
						}
						}
					}
				}
				flag = false;
			}
			
			for(int i=0; i<station.length; i++)
			{					
         		if(station[i]!=null)
				{
					//String stp = stations[i];
					cb1.addItem(station[i]);
					
					 
				}
		}
		if(!flag2){
		StationHistory stationHistory [] = historyList.getAllStationHistory();
		flag2 = true;
		for(int i=0; i<stationHistory.length; i++)
		{
		    if(stationHistory[i]!=null)
			{
				String st = stationHistory[i].getFromStation();
				cb1.removeItem(st);
			}
			
		}
		}
		
		
	  }
	
		if(e.getSource()==cb3)
		{
			
		}
		
	}*/