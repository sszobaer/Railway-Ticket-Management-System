package userGUI;

import entitylist.*;
import entity.TicketHistory;
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

public class HomePageFrame extends JFrame implements ActionListener
{
	private JLabel label1,label2,label3,label4,label5,label6;
	private JPanel panel;
	private JButton button1,button2,button3;
	Font font1=new Font("cambria",Font.BOLD+Font.ITALIC,20);
	Font font2=new Font("cambria",Font.BOLD,15);
	private JTable table;
	private DefaultTableModel model;
	
	private LogInFrame login;
	private HistoryList historyList;
	private TicketHistory history[];
	
	public HomePageFrame(LogInFrame login,HistoryList historyList)
	{
		super("Bangladesh Railway e-Ticket System");
		this.login=login;
		this.historyList=historyList;
		initializeForm();
		createTable();
		
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
		
		label1=new JLabel("Bangladesh Railway e-Ticket System");
		label1.setBounds(80,50,350,50);
		label1.setFont(font1);
		
		label2=new JLabel();
		label2.setBounds(30,120,150,50);
		label2.setFont(font1);
		
		Date date = new Date();
		
		DateFormat dateformat = new SimpleDateFormat("HH");
		String currentHour = dateformat.format(date);
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
		
		label3=new JLabel("Recent History");
		label3.setBounds(30,240,120,30);
		label3.setFont(font2);
		
		label4=new JLabel("Choice Your Service");
		label4.setBounds(500,210,150,30);
		label4.setFont(font2);
		
		label5=new JLabel("Balance "+login.balance+" TK ");
		label5.setBounds(650,120,200,50);
		label5.setFont(font1);
		
		label6=new JLabel(login.name);
		label6.setBounds(30,150,170,50);
		label6.setFont(font1);
		
		button1=new JButton(" Inter City ");
		button1.setBounds(500,250,150,150);
		button1.setFont(font1);
		button1.addActionListener(this);
		
		button2=new JButton(" Metro Rail ");
		button2.setBounds(660,250,150,150);
		button2.setFont(font1);
		button2.addActionListener(this);
		
		button3=new JButton(" Recharge ");
		button3.setBounds(700,450,120,40);
		button3.setFont(font2);
		button3.setBackground(new Color(137,201,237));
		button3.addActionListener(this);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
        panel.add(label5);
		panel.add(label6);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		this.add(panel);
		
	}
	
	public void createTable()
	{
		
		model= new DefaultTableModel();
        table=new JTable(model);
       	JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(40,280,350,180);
		
		model.addColumn("Train");
		model.addColumn("From Station");
		model.addColumn("To Station");
		model.addColumn("Time");
		
		table.setFont(new Font("cambria",Font.BOLD,10));
		table.setBackground(new Color(174,247,255));
		table.setSelectionBackground(new Color(255,153,51));
		table.getTableHeader().setFont(font2);
		table.setRowHeight(25);
		table.setEnabled(false);
		
		history=historyList.getAllTicketHistory();
		for(int i=0; i<history.length; i++)
		{
			if(history[i]!=null)
			{
		   model.addRow(new Object[]{
			    history[i].getTrainName(),
				history[i].getFromStation(),
				history[i].getToStation(),
				history[i].getTime()
		    });
		
		}
		}
	 panel.add(scroll);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button1)
		{
			IntercityBuyTicketFrame intercity=new IntercityBuyTicketFrame(this,login,historyList);
			this.setVisible(false);
			
		}
		if(e.getSource()==button2)
		{
			BuyTicketFrame btf=new BuyTicketFrame(this,login,historyList);
			this.setVisible(false);
		}
	}
	
}