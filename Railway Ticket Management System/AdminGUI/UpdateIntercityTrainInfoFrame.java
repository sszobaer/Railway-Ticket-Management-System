package AdminGUI;

import userGUI.LogInFrame;
import entitylist.*;
import entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.*;
import java.io.*;
import java.util.Scanner;

public class UpdateIntercityTrainInfoFrame extends JFrame implements ActionListener
{
	private JLabel label1,label2;
	private JPanel panel1,panel2,panel3,panel4,panel5;
	private JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12;
	Font font1=new Font("cambria",Font.BOLD+Font.ITALIC,25);
	Font font2=new Font("cambria",Font.BOLD,15);
	private CardLayout cl;
	private JTable table;
	private DefaultTableModel model;
	
	private LogInFrame login;
	private HistoryList historyList;
	
	public UpdateIntercityTrainInfoFrame(LogInFrame login,HistoryList historyList)
	{
		super("Bangladesh Railway");
		this.login=login;
		this.historyList=historyList;
		
		initializeForm();
		createTable();
		
		this.setVisible(true);
	}
	public void initializeForm()
	{
		
		this.setSize(900,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setResizable(false);
		this.setLayout(null);
		
		panel1=new JPanel();
		panel1.setBounds(0,0,900,720);
		panel1.setLayout(null);
		//panel1.setOpaque(false);
		panel1.setBackground(new Color(255,255,255));
		
		ImageIcon img=new ImageIcon("./userGUI/Resources/LOGO2.png");
		JLabel logo=new JLabel("",img,JLabel.CENTER);
		logo.setBounds(20,15,60,60);
		
		label1=new JLabel("InterCity Train Information");
		label1.setBounds(80,15,500,50);
		label1.setFont(font1);
		
		button1=new JButton("Sing Out");
		button1.setBounds(760,25,100,30);
		button1.setFont(font2);
		button1.addActionListener(this);
		
		button2=new JButton("Add Info");
		button2.setBounds(100,80,100,40);
		button2.setFont(font2);
		button2.addActionListener(this);
		
		button3=new JButton("Update Info");
		button3.setBounds(250,80,120,40);
		button3.setFont(font2);
		button3.addActionListener(this);
		
		button4=new JButton("Delete Info");
		button4.setBounds(420,80,110,40);
		button4.setFont(font2);
		button4.addActionListener(this);
		
		
		panel2=new JPanel();
		panel2.setBounds(60,145,210,250);
		cl = new CardLayout();
		panel2.setLayout(cl);
		panel2.setBackground(new Color(137,201,237));
		
		panel3=new JPanel();
		panel3.setBounds(60,145,210,250);
		panel3.setLayout(null);
		panel3.setBackground(new Color(137,201,237));
		
		panel4=new JPanel();
		panel4.setBounds(60,145,210,250);
		panel4.setLayout(null);
		panel4.setBackground(new Color(137,201,237));
		
		panel5=new JPanel();
		panel5.setBounds(60,145,210,250);
		panel5.setLayout(null);
		panel5.setBackground(new Color(137,201,237));
		
		button5=new JButton("Add Station");
		button5.setBounds(20,60,140,30);
		button5.setFont(font2);
		button5.addActionListener(this);
		
		
		button6=new JButton("Add New Train");
		button6.setBounds(20,130,150,30);
		button6.setFont(font2);
		button6.addActionListener(this);
		
		panel3.add(button5);
		panel3.add(button6);
		
		button8=new JButton("Update Ticket Price");
		button8.setBounds(10,20,170,30);
		button8.setFont(font2);
		button8.addActionListener(this);
		
		button9=new JButton("Update Time Schedule");
		button9.setBounds(10,80,190,30);
		button9.setFont(font2);
		button9.addActionListener(this);
		
		button7=new JButton("Update Train Coach");
		button7.setBounds(10,150,170,30);
		button7.setFont(font2);
		button7.addActionListener(this);
		
		button10=new JButton("Update Train Route");
		button10.setBounds(10,210,170,30);
		button10.setFont(font2);
		button10.addActionListener(this);
		
		panel4.add(button7);
		panel4.add(button8);
		panel4.add(button9);
		panel4.add(button10);
		
		button11=new JButton("Delete Station");
		button11.setBounds(30,50,140,30);
		button11.setFont(font2);
		button11.addActionListener(this);
		
		button12=new JButton("Remove Train");
		button12.setBounds(30,120,140,30);
		button12.setFont(font2);
		button12.addActionListener(this);
		
		panel5.add(button11);
		panel5.add(button12);
		
		cl.addLayoutComponent(panel3,"First");
		cl.addLayoutComponent(panel4,"Second");
		cl.addLayoutComponent(panel5,"Third");
		
		ImageIcon image = new ImageIcon("./userGUI/Resources/admin.png");
		JLabel background = new JLabel("",image,JLabel.CENTER);
		background.setBounds(300,155,580,300);
		
		label2 = new JLabel("All Train History");
		label2.setBounds(40,420,200,30);
		label2.setFont(font2);
		label2.setForeground(new Color(2,11,33));
		
		panel2.add(panel3);
		panel2.add(panel4);
		panel2.add(panel5);
		panel1.add(logo);
		panel1.add(label1);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.add(label2);
		panel1.add(background);
		panel1.add(panel2);
		this.add(panel1);
		
		
	}
	
	public void createTable()
	{
		
		model= new DefaultTableModel();
        table=new JTable(model);
       	JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(40,470,650,190);
		
		model.addColumn("From Station");
		model.addColumn("To Station");
		model.addColumn("Train");
		model.addColumn("Class");
		model.addColumn("Time Schedule");
		model.addColumn("Ticket Price");
		
		table.setFont(new Font("cambria",Font.BOLD,10));
		table.setBackground(new Color(174,247,255));
		table.setSelectionBackground(new Color(255,153,51));
		table.getTableHeader().setFont(font2);
		table.setRowHeight(25);
		//table.setEnabled(false);
		
		TrainHistory [] history=historyList.getAllTrainHistory();
		for(int i=0; i<history.length; i++)
		{
			if(history[i]!=null)
			{
		   model.addRow(new Object[]{
				history[i].getFromStation(),
				history[i].getToStation(),
				history[i].getTrainName(),
				history[i].getclass(),
				history[i].getTime(),
				history[i].getTicketPrice()
		    });
		
		}
		}
	    panel1.add(scroll);
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
			cl.show(panel2,"First");
		}
		if(e.getSource()==button3)
		{
			cl.show(panel2,"Second");
		}
		if(e.getSource()==button4)
		{
			cl.show(panel2,"Third");
		}
		if(e.getSource()==button5)
		{
			this.setVisible(false);
			AddStation addstation = new AddStation(this,login,historyList);
		}
		if(e.getSource()==button6)
		{
			
		}
		if(e.getSource()==button7)
		{
			
		}
		if(e.getSource()==button8)
		{
			
		}
		if(e.getSource()==button9)
		{
			
		}
		if(e.getSource()==button10)
		{
			
		}
		if(e.getSource()==button11)
		{
			
		}
		if(e.getSource()==button12)
		{
			
		}
		
	}
}