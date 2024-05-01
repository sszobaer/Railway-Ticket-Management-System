package AdminGUI;

import userGUI.LogInFrame;
import entitylist.*;
import entity.*;
import files.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.*;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AdminHomePageFrame extends JFrame implements ActionListener
{
	private JLabel label1,label2,label3,label4,label5,label6;
	private JPanel panel1,panel2,panel3;
	private JButton button1,button2,button3;
	Font font1=new Font("cambria",Font.BOLD+Font.ITALIC,25);
	Font font2=new Font("cambria",Font.BOLD,15);
	
	private LogInFrame login;
	
	public AdminHomePageFrame(LogInFrame login)
	{
		super("Bangladesh Railway");
		this.login=login;
		initializeForm();
		
		this.setVisible(true);
	}
	public void initializeForm()
	{
		this.setSize(900,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		panel1=new JPanel();
		panel1.setBounds(0,0,900,700);
		panel1.setLayout(null);
		panel1.setOpaque(false);
		panel1.setBackground(new Color(255,255,255));
		
		
		panel2=new JPanel();
		panel2.setBounds(0,0,500,700);
		panel2.setLayout(null);
		//panel2.setOpaque(false);
		panel2.setBackground(new Color(255,255,255));
		
		panel3=new JPanel();
		panel3.setBounds(500,100,370,555);
		panel3.setLayout(null);
		//panel3.setOpaque(false);
		panel3.setBackground(new Color(2,11,33));
		
		ImageIcon img=new ImageIcon("./userGUI/Resources/LOGO2.png");
		JLabel logo=new JLabel("",img,JLabel.CENTER);
		logo.setBounds(20,40,60,60);
		
		label1=new JLabel("Bangladesh Railway");
		label1.setBounds(80,43,300,50);
		label1.setFont(font1);
		
		label2=new JLabel();
		label2.setBounds(30,100,150,50);
		label2.setFont(new Font("cambria",Font.BOLD+Font.ITALIC,20));
		
		Date date = new Date();
		
		DateFormat dateformat = new SimpleDateFormat("HH");
		String currentHour = dateformat.format(date);
		//System.out.println(currentHour);
		if(Integer.parseInt(currentHour)>=4 && Integer.parseInt(currentHour)<12)
		{
			label2.setText("Good Morning");
		}
		else if(Integer.parseInt(currentHour)>=12 && Integer.parseInt(currentHour)<=17)
		{
			label2.setText("Good Afternoon");
		}
		else if(Integer.parseInt(currentHour)>17 && Integer.parseInt(currentHour)<=23)
		{
			label2.setText("Good Evening");
		}
		else
		{
			label2.setText("Good Morning");
		}
		
		ImageIcon image = new ImageIcon("./userGUI/Resources/admin.png");
		JLabel background = new JLabel("",image,JLabel.CENTER);
		background.setBounds(50,220,400,300);
		
		button1=new JButton("Sign out");
		button1.setBounds(750,50,100,30);
		button1.setFont(font2);
		button1.addActionListener(this);
		
		label3=new JLabel("Admin Panel");
		label3.setBounds(10,5,180,50);
		label3.setFont(font1);
		label3.setForeground(new Color(240,229,223));
		
		
		label4=new JLabel("_______________________");
		label4.setBounds(10,27,350,60);
		label4.setFont(new Font("cambria",Font.BOLD,40));
		label4.setForeground(new Color(153,150,142));
		 
		
		button2=new JButton();
		button2.setBounds(25,120,200,200);
		button2.setLayout(null);
		//button2.setOpaque(false);
		button2.setBackground(new Color(255,255,255));
		
		ImageIcon imag1 = new ImageIcon("./userGUI/Resources/userinfo.jpg");
		JLabel buttonimage1 = new JLabel("",imag1,JLabel.CENTER);
		buttonimage1.setBounds(10,10,180,150);
		button2.add(buttonimage1);
		
		label5 = new JLabel("User Information");
		label5.setBounds(40,150,140,30);
		label5.setFont(new Font("cambria",Font.BOLD+Font.ITALIC,15));
		button2.add(label5);
		button2.addActionListener(this);
		
		button3=new JButton();
		button3.setBounds(145,340,200,200);
		button3.setLayout(null);
		button3.setBackground(new Color(255,255,255));
		
		ImageIcon imag2 = new ImageIcon("./userGUI/Resources/intercityTrain.png");
		Image oldimag = imag2.getImage();
		Image newimag = oldimag.getScaledInstance(140,120,Image.SCALE_SMOOTH);
	    imag2 = new ImageIcon(newimag);
		
		JLabel buttonimage2 = new JLabel("",imag2,JLabel.CENTER);
		buttonimage2.setBounds(30,30,140,120);
		button3.add(buttonimage2);
		
		label6 = new JLabel("Update InterCity Train");
		label6.setBounds(23,150,160,30);
		label6.setFont(new Font("cambria",Font.BOLD+Font.ITALIC,15));
		button3.add(label6);
		
		button3.addActionListener(this);
		
		
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(logo);
		panel2.add(background);
		panel3.add(label3);
		panel3.add(label4);
		panel3.add(button2);
		panel3.add(button3);
		panel1.add(button1);
		panel1.add(panel2);
		panel1.add(panel3);
		this.add(panel1);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button1)
		{
			this.dispose();
			login.setVisible(true);
		}
		if(e.getSource()==button2)
		{
			//HistoryList historyList = new HistoryList(100000000);
            // FileIO.readFromFile("files/ticketHistory.txt",historyList);	
		}
		if(e.getSource()==button3)
		{
			HistoryList historyList = new HistoryList(1000000);
			FileIO.readFromStationHistoryFile("files/StationHistory.txt",historyList);
			FileIO.readFromTrainCoachHistoryFile("files/TrainCoachHistory.txt",historyList);
            FileIO.readFromTrainHistoryFile("files/TrainHistory.txt",historyList);	
			UpdateIntercityTrainInfoFrame uitif = new UpdateIntercityTrainInfoFrame(login,historyList);
			this.setVisible(false);
		}
	}
	
}