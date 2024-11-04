package AdminGUI;

import userGUI.LogInFrame;
import files.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.*;
import java.io.*;
import java.util.Scanner;

public class TicketPriceSetupFrame extends JFrame implements ActionListener
{
	private JLabel label1,label2,label3;
	private JPanel panel;
	private JRadioButton radiobtn1,radiobtn2,radiobtn3;
	private ButtonGroup grp;
	private JButton button1,button2,button3;
	private JTextField text;
	Font font1=new Font("cambria",Font.BOLD+Font.ITALIC,20);
	Font font2=new Font("cambria",Font.BOLD,15);
	
	private LogInFrame login;
	UpdateIntercityTrainInfoFrame uintercity;
	static int count = 1;
	static int countdown = 0;
	static int nextcount = 2;	
	static boolean flag = false;
	String sta = UpdateIntercityTrainInfoFrame.station;
	
	public TicketPriceSetupFrame(UpdateIntercityTrainInfoFrame uintercity,LogInFrame login)
	{
		super("Bangladesh Railway");
		this.login=login;
		this.uintercity=uintercity;
		initializeForm();
		
		this.setVisible(true);
	}
	public void initializeForm()
	{
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		panel=new JPanel();
		panel.setBounds(0,0,500,500);
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBackground(new Color(255,255,255));
		
		label1=new JLabel("Ticket Price Setup");
		label1.setBounds(80,50,300,50);
		label1.setFont(font1);
		
		button1=new JButton("Sing Out");
		button1.setBounds(350,60,120,40);
		button1.setFont(font2);
		button1.addActionListener(this);
		
		label2=new JLabel("Choose Class");
		label2.setBounds(50,120,150,50);
		label2.setFont(font1);
		
		radiobtn1 = new JRadioButton("Shovon");
		radiobtn1.setBounds(80,180,80,40);
		radiobtn1.setFont(font2);
		radiobtn1.addActionListener(this);
		
		radiobtn2 = new JRadioButton("Snigdha");
		radiobtn2.setBounds(170,180,95,40);
		radiobtn2.setFont(font2);
		radiobtn2.addActionListener(this);
		
		radiobtn3 = new JRadioButton("Berth");
		radiobtn3.setBounds(275,180,80,40);
		radiobtn3.setFont(font2);
		radiobtn3.addActionListener(this);
		
		label3=new JLabel();
		label3.setBounds(120,300,180,40);
		label3.setText(sta+" to Dhaka");
		label3.setFont(font2);
		
		text = new JTextField();
		text.setBounds(310,300,150,40);
		text.setFont(font2);
		
		button2=new JButton("Update");
		button2.setBounds(350,380,90,40);
		button2.addActionListener(this);
		
		button3=new JButton("Next");
		button3.setBounds(260,380,80,40);
		button3.addActionListener(this);
		
		grp = new ButtonGroup();
		grp.add(radiobtn1);
		grp.add(radiobtn2);
		grp.add(radiobtn3);
		
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(radiobtn1);
		panel.add(radiobtn2);
		panel.add(radiobtn3);
		panel.add(text);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		this.add(panel);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button1)
		{
			
		}
		
		if(e.getSource()==button2)
		 {	
		  try
		{
		Scanner sc=new Scanner(new File("files/AdminSetup.txt"));
		while(sc.hasNextLine())
		{
			String sp[]=sc.nextLine().split("/");
			if(count==1)
			{
			if(sp[0].equals("fromStation") && sp[1].equals("Dhaka")){
				count++;
				try{
			  String str = radiobtn1.getText()+"-"+"Dhaka-"+sta+"-"+text.getText()+"\n"+
			  radiobtn1.getText()+"-"+sta+"-"+"Dhaka-"+text.getText()+"\n";
			  FileWriter fw=new FileWriter("files/TicketPriceList.txt",true);
			  fw.write(str);
			  fw.flush();
			  fw.close();
				}
				catch(IOException exc)
				{
					exc.printStackTrace();
				}
			  break;
			}
			}
			if(count!=0)
			{
            if(sp[0].equals("fromStation") && !sp[1].equals("Dhaka")){
			  
			  countdown = Integer.parseInt(sp[2]);
			  if(count==countdown)
			  {
				  count++;
				 try{
			  String str = radiobtn1.getText()+"-"+sp[1]+"-"+sta+"-"+text.getText()+"\n"+
			  radiobtn1.getText()+"-"+sta+"-"+sp[1]+"-"+text.getText()+"\n";
			  FileWriter fw=new FileWriter("files/TicketPriceList.txt",true);
			  fw.write(str);
			  fw.flush();
			  fw.close();
				}
				catch(IOException exc)
				{
					exc.printStackTrace();
				}
			  break; 
				  
			  }
			
			}
			}
		}
		 sc.close();
		}
		
		catch(IOException ioex)
		{
			ioex.printStackTrace();
		}
		
	}
		
		 if(e.getSource()==button3)
		 {
	
		  try
		{
		Scanner stp=new Scanner(new File("files/AdminSetup.txt"));
		while(stp.hasNextLine())
		{
			String sp[]=stp.nextLine().split("/");

            if(sp[0].equals("fromStation") && !sp[1].equals("Dhaka")){
			  
			int scount = Integer.parseInt(sp[2]);
			  if(nextcount==scount)
			  {
				  label3.setText(sta+" to "+sp[1]);
				  nextcount++;
				  break;
			  }
			
			}
			}
			stp.close();
		}
		catch(IOException ioex)
		{
			ioex.printStackTrace();
		}
		 
		}
		
		 
	}

	
}
		

