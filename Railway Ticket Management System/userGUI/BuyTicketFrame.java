package userGUI;

import files.*;
import entity.*;
import entitylist.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

public class BuyTicketFrame extends JFrame implements ActionListener
{
	private JPanel panel,panel1,panel2;
	private JLabel label1,label2,label3,
	label4,label5,label6,label7,
	label8,label9,label10,label11,
	label12,label13,label14;
	private JButton button1,button11,button12,button13;
	private JButton button2,
	button3,button4,button5,
	button6,button7,button8,
	button9,button10;
	Font font1=new Font("cambria",Font.BOLD+Font.ITALIC,35);
	Font font2=new Font("cambria",Font.BOLD,25);
	Font font3=new Font("cambria",Font.BOLD,15);
	private LogInFrame login;
	private HomePageFrame hp;
	private HistoryList historyList;
	public static int count=0;
	private static String trainName="Metro Rail";
	private boolean flag=false;
	public static double ticketPrice;
	private String fromStation="";
	private String toStation="";
	private String currentDate="";
	
	public BuyTicketFrame(HomePageFrame hp,LogInFrame login,HistoryList historyList)
	{
		super("Metro Rail");
		this.login=login;
		this.hp=hp;
		this.historyList=historyList;
		initializeForm();
		
		this.setVisible(true);
	}
	
	public void initializeForm()
	{
		this.setSize(900,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		panel=new JPanel();
		panel.setBounds(0,0,900,600);
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBackground(new Color(255,255,255));
		
		button1=new JButton();
		button1.setBounds(10,60,60,40);
		button1.addActionListener(this);
		button1.setToolTipText("Back to Homepage");
		
		JLabel label15=new JLabel("<");
		label15.setBounds(0,0,60,40);
		label15.setFont(new Font("Meiryo",Font.BOLD,35));
		button1.add(label15);
		
		ImageIcon img=new ImageIcon("./userGUI/Resources/LOGO2.png");
		JLabel logo=new JLabel("",img,JLabel.CENTER);
		logo.setBounds(90,50,60,60);
		
		label1=new JLabel("Metro Rail");
		label1.setBounds(150,45,250,60);
		label1.setFont(font1);
		
		button11=new JButton("Sign out");
		button11.setBounds(750,65,90,30);
		button11.setBackground(new Color(96,188,209));
		button11.setFont(font3);
		button11.addActionListener(this);
		
		label2=new JLabel("Buy Ticket");
		label2.setBounds(20,130,150,50);
		label2.setFont(font2);
		
		label3=new JLabel("Select Your Starting And Ending Station");
		label3.setBounds(20,190,400,30);
		label3.setFont(font3);
		
		label4=new JLabel("Uttara");
		label4.setBounds(30,250,60,30);
		label4.setFont(font3);
		
		button2=new JButton();
		button2.setBounds(40,300,30,30);
		button2.addActionListener(this);
		
		label5=new JLabel("Mirpur 12");
		label5.setBounds(120,250,80,30);
		label5.setFont(font3);
		
		button3=new JButton();
		button3.setBounds(130,300,30,30);
		button3.addActionListener(this);
		
		label6=new JLabel("Mirpur 10");
		label6.setBounds(225,250,80,30);
		label6.setFont(font3);
		
		button4=new JButton();
		button4.setBounds(235,300,30,30);
		button4.addActionListener(this);
		
		label7=new JLabel("Shewrapara");
		label7.setBounds(330,250,90,30);
		label7.setFont(font3);
		
		button5=new JButton();
		button5.setBounds(345,300,30,30);
		button5.addActionListener(this);
		
		label8=new JLabel("Agargaon");
		label8.setBounds(460,250,90,30);
		label8.setFont(font3);
		
		button6=new JButton();
		button6.setBounds(470,300,30,30);
		button6.addActionListener(this);
		
		label9=new JLabel("Bijay Sarani");
		label9.setBounds(570,250,90,30);
		label9.setFont(font3);
		
		button7=new JButton();
		button7.setBounds(580,300,30,30);
		button7.addActionListener(this);
		
		label10=new JLabel("Shahbag");
		label10.setBounds(690,250,90,30);
		label10.setFont(font3);
		
		button8=new JButton();
		button8.setBounds(700,300,30,30);
		button8.addActionListener(this);
		
		label11=new JLabel("DU");
		label11.setBounds(805,330,50,30);
		label11.setFont(font3);
		
		button9=new JButton();
		button9.setBounds(800,300,30,30);
		button9.addActionListener(this);
		
		label12=new JLabel("Motijheel");
		label12.setBounds(780,170,90,30);
		label12.setFont(font3);
		
		button10=new JButton();
		button10.setBounds(800,200,30,30);
		button10.addActionListener(this);
		
		button12=new JButton("Reset");
		button12.setBounds(650,450,80,30);
		button12.setBackground(new Color(96,188,209));
		button12.setFont(font3);
		button12.addActionListener(this);
		
		button13=new JButton("Buy");
		button13.setBounds(750,450,80,30);
		button13.setBackground(new Color(96,188,209));
	    button13.setFont(font3);
		button13.addActionListener(this);
	
		
		panel1=new JPanel();
		panel1.setBounds(70,300,740,30);
		panel1.setBackground(new Color(96,188,209));
		
		panel2=new JPanel();
		panel2.setBounds(800,230,30,70);
		panel2.setBackground(new Color(96,188,209));
		
		label14=new JLabel();
		label14.setBounds(40,420,250,60);
		label14.setFont(new Font("cambria",Font.BOLD,20));
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		panel.add(label10);
		panel.add(label11);
		panel.add(label12);
		panel.add(label14);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(button10);
		panel.add(button11);
		panel.add(button12);
		panel.add(button13);
		panel.add(logo);
		panel.add(panel1);
		panel.add(panel2);
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button1)
		{
			//FileIO.saveFromTicketHistoryList("files/ticketHistory.txt",ticketHistory,false);
			//FileIO.readFromFile("files/ticketHistory.txt",ticketHistory);
			this.dispose();
		
            HomePageFrame hpf=new HomePageFrame(login,historyList);
			
		}
		if(e.getSource()==button2)
		{
			count++;
			if(count%2!=0)
			{
				fromStation="Uttara";
			}
			if(count%2==0)
			{
				toStation="Uttara";
				
				if(fromStation.equals("Mirpur 12"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 10"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shewrapara"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Agargaon"))
				{
					ticketPrice=60;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Bijay Sarani"))
				{
					ticketPrice=60;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shahbag"))
				{
					ticketPrice=80;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("DU"))
				{
					ticketPrice=90;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Motijheel"))
				{
					ticketPrice=100;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
		    }
			
		}
		if(e.getSource()==button3)
		{
			count++;
			if(count%2!=0)
			{
				fromStation="Mirpur 12";
			}
			if(count%2==0)
			{
				toStation="Mirpur 12";
				
				if(fromStation.equals("Uttara"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 10"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shewrapara"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Agargaon"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Bijay Sarani"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shahbag"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("DU"))
				{
					ticketPrice=60;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Motijheel"))
				{
					ticketPrice=70;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				
				
			}
			
		}
		if(e.getSource()==button4)
		{
			count++;
			if(count%2!=0)
			{
				fromStation="Mirpur 10";
				flag=false;
			}
			if(count%2==0)
			{
				toStation="Mirpur 10";
				
				if(fromStation.equals("Uttara"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 12"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shewrapara"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Agargaon"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Bijay Sarani"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shahbag"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("DU"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Motijheel"))
				{
					ticketPrice=60;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
			}
			
		}
		if(e.getSource()==button5)
		{
			count++;
			if(count%2!=0)
			{
				fromStation="Shewrapara";
				flag=false;
			}
			if(count%2==0)
			{
				toStation="Shewrapara";
				
				if(fromStation.equals("Uttara"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 12"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 10"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Agargaon"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Bijay Sarani"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shahbag"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("DU"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Motijheel"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
			}
			
		}
		if(e.getSource()==button6)
		{
			count++;
			if(count%2!=0)
			{
				fromStation="Agargaon";
			}
			if(count%2==0)
			{
				toStation="Agargaon";
				
				if(fromStation.equals("Uttara"))
				{
					ticketPrice=60;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 12"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 10"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shewrapara"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Bijay Sarani"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shahbag"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("DU"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Motijheel"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				
			}
			
		}
		if(e.getSource()==button7)
		{
			count++;
			if(count%2!=0)
			{
				fromStation="Bijay Sarani";
			}
			if(count%2==0)
			{
				toStation="Bijay Sarani";
				
				if(fromStation.equals("Uttara"))
				{
					ticketPrice=60;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 12"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 10"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shewrapara"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Agargaon"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shahbag"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("DU"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Motijheel"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
			}
			
		}
		if(e.getSource()==button8)
		{
			count++;
			if(count%2!=0)
			{
				fromStation="Shahbag";
			}
			if(count%2==0)
			{
				toStation="Shahbag";
				
				if(fromStation.equals("Uttara"))
				{
					ticketPrice=80;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 12"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 10"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shewrapara"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Agargaon"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Bijay Sarani"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("DU"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Motijheel"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
			}
			
		}
		if(e.getSource()==button9)
		{
			count++;
			if(count%2!=0)
			{
				fromStation="DU";
			}
			if(count%2==0)
			{
				toStation="DU";
				
				if(fromStation.equals("Uttara"))
				{
					ticketPrice=90;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 12"))
				{
					ticketPrice=60;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 10"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shewrapara"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Agargaon"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Bijay Sarani"))
				{
					ticketPrice=30;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shahbag"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Motijheel"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
			}
			
		}
		if(e.getSource()==button10)
		{
			count++;
			if(count%2!=0)
			{
				fromStation="Motijheel";
			}
			if(count%2==0)
			{
				toStation="Motijheel";
				
				if(fromStation.equals("Uttara"))
				{
					ticketPrice=100;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 12"))
				{
					ticketPrice=70;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Mirpur 10"))
				{
					ticketPrice=60;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shewrapara"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Agargaon"))
				{
					ticketPrice=50;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Bijay Sarani"))
				{
					ticketPrice=40;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("Shahbag"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
				else if(fromStation.equals("DU"))
				{
					ticketPrice=20;
					label14.setText("Ticket Price : "+ticketPrice+" TK ");
				}
			}
			
		}
		if(e.getSource()==button12)
		{

			fromStation="";
			toStation="";
			
		}
		if(e.getSource()==button13)
		{
			if(!fromStation.equals("") && !toStation.equals("") && !fromStation.equals(toStation))
			{
				if(Double.parseDouble(login.balance)>=ticketPrice)
				{
				int option=JOptionPane.showConfirmDialog(this,"Are you Sure to Buy a ticket from "+fromStation+" to "+toStation+"?");
				if(option==JOptionPane.YES_OPTION)
			{
				Date date = new Date();
                
				DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				currentDate=dateformat.format(date);
				
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
			fromStation="";
			toStation="";
			currentDate="";
		}
		else if(option==JOptionPane.NO_OPTION)
		{
			fromStation="";
			toStation="";
		}
		else if(option==JOptionPane.CANCEL_OPTION)
		{
			fromStation="";
			toStation="";
		}
		}
		else
		{
			JOptionPane.showMessageDialog(this,"You don't have sufficient Balance","Message",JOptionPane.INFORMATION_MESSAGE);
		}
	    }
		else if(toStation.equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to select Ending Station","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(fromStation.equals("") || toStation.equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to select Start and Ending Station","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(fromStation.equals(toStation))
		{
			JOptionPane.showMessageDialog(this,"You must have to select two Different Start and Ending Station","Warning",JOptionPane.WARNING_MESSAGE);
		}
		}
			
		if(e.getSource()==button11)
		{
			this.dispose();
			login.setVisible(true);
		}
	}
	
}