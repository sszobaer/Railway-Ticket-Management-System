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
import java.util.Scanner;
import java.util.Arrays;

public class AddStation extends JFrame implements ActionListener
{
	private JLabel label1,label2,label3,label4,
	label5,label6,label7,label8,label9,label10,label11;
	private JPanel panel;
	private JButton button1,button2,button3,
	button4,button5,button6,button7,button8,
	button9,button10,button11,button12;
	private JTextField text1,text2,text3;
	//private JComboBox cb1,cb2;
	
	private JTable table1,table2,table3;
	private DefaultTableModel model1,model2,model3;
	private JScrollPane scroll1,scroll2,scroll3;
	private JRadioButton radiobtn1,radiobtn2,radiobtn3;
	private ButtonGroup grp;
	Font font1=new Font("cambria",Font.BOLD+Font.ITALIC,25);
	Font font2=new Font("cambria",Font.BOLD,20);
	
	private UpdateIntercityTrainInfoFrame updateinter;
	private LogInFrame login;
	private HistoryList historyList;
	private String str [] = new String[100000];
	int select1 = 0;
	int select2 = 0;
	int select3 = 0;
	int p = 0;
	String newStation="";
	String fromStation ="";
	String toStation = "";
	String fromStation1 ="";
	String toStation1 = "";
	String stationTrain1 ="";
	String fromStation2 ="";
	String toStation2 = "";
	String stationTrain2 ="";
	//String timeschedule = "";
	static int num1=0;
	static int num2=0;
	static int count = 1;
	static int count1 = 1;
	static int count2 = 1;
	static int count3 = 1;
	static int count4 = 1;
	static int count5 = 0;
	boolean flag = false;
	String s1 ="";
	String s2 ="";
	String s3 ="";
	String s4 ="";
	String s5 ="";
	String s6 ="";
	String s7 ="";
	String s8 ="";
	String Class = "";
	File f1 = new File("files/temp1.txt");
	//f1.createNewFile();
	File f2 = new File("files/temp2.txt");
	//f2.createNewFile();
	File f3 = new File("files/temp3.txt");
	//f3.createNewFile();
	
	public AddStation(UpdateIntercityTrainInfoFrame updateinter,LogInFrame login,HistoryList historyList)
	{
		super("Bangladesh Railway");
		this.updateinter=updateinter;
		this.login=login;
		this.historyList=historyList;
		
		initializeForm();
		createTable1();
		createTable2();
		//createTable3();
		
		this.setVisible(true);
	}
	public void initializeForm()
	{
		
		this.setSize(900,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		
		panel=new JPanel();
		panel.setBounds(0,0,900,720);
		panel.setLayout(null);
		//panel.setOpaque(false);
		panel.setBackground(new Color(255,255,255));
		
		ImageIcon img=new ImageIcon("./userGUI/Resources/LOGO2.png");
		JLabel logo=new JLabel("",img,JLabel.CENTER);
		logo.setBounds(20,15,60,60);
		
		label1=new JLabel("InterCity New Station Setup");
		label1.setBounds(80,15,500,50);
		label1.setFont(font1);
		
		button11=new JButton("<Back");
		button11.setBounds(640,25,80,30);
		button11.setFont(new Font("cambria",Font.BOLD,15));
		button11.addActionListener(this);
		
		button1=new JButton("Sing Out");
		button1.setBounds(750,25,100,30);
		button1.setFont(new Font("cambria",Font.BOLD,15));
		button1.addActionListener(this);
		
		label2=new JLabel("Add New Station");
		label2.setBounds(60,100,150,20);
		label2.setFont(font2);
		
		text1 = new JTextField();
		text1.setBounds(60,125,210,35);
		text1.setFont(font2);
		text1.setForeground(new Color(29,61,87));
		text1.setHorizontalAlignment(JTextField.CENTER);
		text1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		
		label3=new JLabel("Add Connecting Station");
		label3.setBounds(500,100,300,23);
		label3.setFont(font2);
		
		button12=new JButton("Confirm");
		button12.setBounds(640,276,100,30);
		button12.setFont(new Font("cambria",Font.BOLD,15));
		button12.addActionListener(this);
		
		label4=new JLabel("Add Station's Train");
		label4.setBounds(60,180,250,23);
		label4.setFont(font2);
		
		label5=new JLabel();
		label5.setBounds(60,208,250,28);
		label5.setFont(font2);
		
		button2=new JButton("previous");
		button2.setBounds(100,380,100,33);
		button2.setFont(new Font("cambria",Font.BOLD,15));
		button2.addActionListener(this);
		
		button3=new JButton("next");
		button3.setBounds(210,380,65,33);
		button3.setFont(new Font("cambria",Font.BOLD,15));
		button3.addActionListener(this);
		
		button4=new JButton("update");
		button4.setBounds(285,380,90,33);
		button4.setFont(new Font("cambria",Font.BOLD,15));
		button4.addActionListener(this);
		
		label6=new JLabel("Add Time Schedule");
		label6.setBounds(60,440,250,23);
		label6.setFont(font2);
		
		
		label7=new JLabel();
		label7.setBounds(60,470,400,28);
		label7.setFont(font2);
		
		text3 = new JTextField();
		text3.setBounds(60,505,210,35);
		text3.setFont(font2);
		text3.setForeground(new Color(29,61,87));
		text3.setHorizontalAlignment(JTextField.CENTER);
		text3.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		
		button5=new JButton("previous");
		button5.setBounds(100,570,100,33);
		button5.setFont(new Font("cambria",Font.BOLD,15));
		button5.addActionListener(this);
		
		button6=new JButton("next");
		button6.setBounds(210,570,65,33);
		button6.setFont(new Font("cambria",Font.BOLD,15));
		button6.addActionListener(this);
		
		button7=new JButton("update");
		button7.setBounds(285,570,90,33);
		button7.setFont(new Font("cambria",Font.BOLD,15));
		button7.addActionListener(this);
		
		label8=new JLabel("Ticket Price Setup");
		label8.setBounds(500,320,300,23);
		label8.setFont(font2);
		
		label9=new JLabel("Choose Class");
		label9.setBounds(500,350,240,30);
		label9.setFont(font2);
		
		radiobtn1=new JRadioButton("Shovon");
		radiobtn1.setBounds(510,385,80,30);
		radiobtn1.addActionListener(this);
		//radiobtn1.setEnabled(false);
		
		radiobtn2=new JRadioButton("Snigdha");
		radiobtn2.setBounds(600,385,80,30);
		radiobtn2.addActionListener(this);
		radiobtn2.setEnabled(false);
		
		radiobtn3=new JRadioButton("Berth");
		radiobtn3.setBounds(690,385,70,30);
		radiobtn3.addActionListener(this);
		radiobtn3.setEnabled(false);
		
		grp=new ButtonGroup();
		grp.add(radiobtn1);
		grp.add(radiobtn2);
		grp.add(radiobtn3);
		
		label10=new JLabel();
		label10.setBounds(500,460,170,23);
		label10.setFont(new Font("cambria",Font.BOLD,15));
		
		text2 = new JTextField();
		text2.setBounds(680,454,150,35);
		text2.setFont(font2);
		text2.setForeground(new Color(29,61,87));
		text2.setHorizontalAlignment(JTextField.CENTER);
		text2.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		text2.setEditable(false);
		//text2.setBorder(null);
		
		/*label11=new JLabel("_______________");
		label11.setBounds(680,440,150,25);
		label11.setFont(new Font("cambria",Font.BOLD,25));*/
		
		button8=new JButton("previous");
		button8.setBounds(550,520,100,33);
		button8.setFont(new Font("cambria",Font.BOLD,15));
		button8.addActionListener(this);
		button8.setEnabled(false);
		
		button9=new JButton("next");
		button9.setBounds(660,520,65,33);
		button9.setFont(new Font("cambria",Font.BOLD,15));
		button9.addActionListener(this);
		button9.setEnabled(false);
		
		button10=new JButton("update");
		button10.setBounds(735,520,90,33);
		button10.setFont(new Font("cambria",Font.BOLD,15));
		button10.addActionListener(this);
		button10.setEnabled(false);
		
		panel.add(logo);
		panel.add(label1);
		panel.add(button1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		panel.add(label10);
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
		panel.add(radiobtn1);
		panel.add(radiobtn2);
		panel.add(radiobtn3);
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		this.add(panel);
		
	}
	
	public void createTable1()
	{
		model1= new DefaultTableModel();
        table1=new JTable(model1);
       	scroll1=new JScrollPane(table1);
		scroll1.setBounds(500,132,250,140);
		
		model1.addColumn("Available Station");
		
		table1.setFont(new Font("cambria",Font.BOLD,18));
		table1.setBackground(new Color(174,247,255));
		table1.setSelectionBackground(new Color(65,131,163));
		table1.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,23));
		table1.setRowHeight(25);
		//table1.addActionListener(this);
		//table1.setEnabled(false);
		//table1.setHorizontalAlignment(new GridBagConstraints());
		
		StationHistory [] history=historyList.getAllStationHistory();
		for(int i=0; i<history.length; i++)
		{
			if(history[i]!=null)
			{
		   model1.addRow(new Object[]{
				history[i].getFromStation()
		    });
		
		}
		}
	    panel.add(scroll1);
	}
	
	public void createTable2()
	{
		model2= new DefaultTableModel();
        table2=new JTable(model2);
       	scroll2=new JScrollPane(table2);
		scroll2.setBounds(60,235,300,130);
		
		model2.addColumn("Available Train In BD");
		
		table2.setFont(new Font("cambria",Font.BOLD,18));
		table2.setBackground(new Color(174,247,255));
		table2.setSelectionBackground(new Color(65,131,163));
		table2.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,23));
		table2.setRowHeight(25);
		//table2.setEnabled(false);
		
		boolean flag = false;
		TrainCoachHistory [] history=historyList.getAllTrainCoachHistory();
		for(int i=0; i<history.length; i++)
		{
			if(history[i]!=null)
			{
				for(int w=0; w<str.length; w++)
				{
					if(str[w]!=null && str[w].equals(history[i].getTrainName()))
					{
						flag = true;
						break;
					}
				}
				if(!flag)
				{
					for(int j=0; j<str.length; j++)
					{
						if(str[j]==null)
						{
							str[j]=history[i].getTrainName();
							model2.addRow(new Object[]{
				           history[i].getTrainName()
						   
                                  });
								  break;
								  
						}
						
					}
					
				}
				
				}
				flag = false;
		}
		panel.add(scroll2);
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
			
		}
		if(e.getSource()==button3)
		{
			if(!text1.getText().equals("") && table2.getSelectedRows().length > 0 && select1>0 && text1.getText().equals(newStation) && select2==1)
			{
				
                 select2=0;
				
				try{
			Scanner sc=new Scanner(f1);
			
			while(sc.hasNextLine())
			{
				String sp[]=sc.nextLine().split("/");
				if(Integer.parseInt(sp[2])==count)
				{
					count++;
					fromStation = sp[0];
					toStation = sp[1];
					label5.setText(fromStation+" to "+toStation);
					break;
					
				}
			}
			sc.close();
			if(s1.equals(fromStation) && s2.equals(toStation))
			{
					try{
			Scanner sca=new Scanner(f2);
			while(sca.hasNextLine())
			{
				String spl[]=sca.nextLine().split("/");
				if(Integer.parseInt(spl[3])==count1)
				{ 
			        select2=1;
					count1++;
					stationTrain1 =spl[0];
					fromStation1 = spl[1];
					toStation1 = spl[2];
					label7.setText(stationTrain1+" : "+fromStation+" to "+toStation);
					break;
					
				}
				
				}
				sca.close();
			}
			catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
				table2.setEnabled(false);
				button3.setEnabled(false);
				button4.setEnabled(false);
				text3.setFocusable(true);
			}
				
			}
			catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
				}
			else if(select2>0)
		{
			JOptionPane.showMessageDialog(this,"You Already Selected  Station's Train Once","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select1==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Connecting Stations First","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!(table2.getSelectedRows().length>=0))
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Station's Train","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(text1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add New Stations","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!text1.getText().equals(newStation))
		{
			JOptionPane.showMessageDialog(this,"Does not match the new Adding Station","Error",JOptionPane.ERROR_MESSAGE);
		}
			
		}
		if(e.getSource()==button4)
		{
			if(!text1.getText().equals("") && table2.getSelectedRows().length > 0 && select1>0 && text1.getText().equals(newStation) && select2<=0)
			{
				
			int option = JOptionPane.showConfirmDialog(this,"Are you sure to Confirm Add New Station Train?");
			if(option == JOptionPane.YES_OPTION){
				select2++;
				int selectedRows[] = table2.getSelectedRows(); 
				Arrays.sort(selectedRows);
							
				if(selectedRows!=null){
					for(int i=selectedRows.length-1; i>=0 ;i--){
						String stationstrain = table2.getModel().
										getValueAt(selectedRows[i], 0).
									toString();
				FileWriter fw ;
				
				try{
			
							 
							 
						fw = new FileWriter(f2,true);
					    num2++;
				        String	sttr1 = stationstrain+"/"+fromStation+"/"+toStation+"/"+num2+"\n"; 
						num2++;
						String	sttr2 = stationstrain+"/"+toStation+"/"+fromStation+"/"+num2+"\n";
						s1=fromStation;
						s2=toStation;
						fw.write(sttr1);
						fw.write(sttr2);
						fw.flush();
				       fw.close();
						
				}
				catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
			}
			}
			JOptionPane.showMessageDialog(this,"Successfully Added Station's Train");
			}
		
				}
		else if(select2>0)
		{
			JOptionPane.showMessageDialog(this,"You Already Selected  Station's Train Once","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select1==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Connecting Stations First","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!(table2.getSelectedRows().length>=0))
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Station's Train","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(text1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add New Stations","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!text1.getText().equals(newStation))
		{
			JOptionPane.showMessageDialog(this,"Does not match the new Adding Station","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		}
		
		if(e.getSource()==button5)
		{
			
		}
		if(e.getSource()==button6)
		{
			if(!text1.getText().equals("") && 
			select1>0 && text1.getText().equals(newStation) && select2>0 && 
			!text3.getText().equals("") && count4==count5)
			{
				count4++;
				try{
			Scanner sc=new Scanner(f2);
			
			while(sc.hasNextLine())
			{
				String sp[]=sc.nextLine().split("/");
	
				if(Integer.parseInt(sp[3])==count1)
				{
					
					count1++;
					stationTrain1 =sp[0];
					fromStation1 = sp[1];
					toStation1 = sp[2];
					label7.setText(stationTrain1+" : "+fromStation1+" to "+toStation1);
					break;
					
				}
				
				}
				sc.close();
			if(s3.equals(fromStation1) && s4.equals(toStation1))
			{
					try{
			Scanner sca=new Scanner(f1);
			while(sca.hasNextLine())
			{
				String spl[]=sca.nextLine().split("/");
				if(Integer.parseInt(spl[2])==count3)
				{ 
			     radiobtn1.setEnabled(true);
				 radiobtn1.setSelected(true);
			      text2.setEditable(true);
				  button8.setEnabled(true);
				  button9.setEnabled(true);
				   button10.setEnabled(true);
					count3++;
					fromStation2 = spl[0];
					toStation2 = spl[1];
					Class = radiobtn1.getText();
					label10.setText(fromStation2+" to "+toStation2);
					break;
					
				}
				
				}
				sca.close();
			}
			catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
			}
				table2.setEnabled(false);
				button3.setEnabled(false);
				button4.setEnabled(false);
				text3.setFocusable(true);
			
				
			}
			catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
				
			}
		else if(count4!=count5)
		{
			JOptionPane.showMessageDialog(this,"You must have to update Time Schedule 1st","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(text3.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add Time Schedule","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select2==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Selecte  Station's Train","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select1==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Connecting Stations First","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(text1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add New Stations","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!text1.getText().equals(newStation))
		{
			JOptionPane.showMessageDialog(this,"Does not match the new Adding Station","Error",JOptionPane.ERROR_MESSAGE);
		}
			
	}
		if(e.getSource()==button7)
		{
			if(!text1.getText().equals("") &&
			select1>0 && text1.getText().equals(newStation) && select2>0 && !text3.getText().equals("") )
			{
				
			int option = JOptionPane.showConfirmDialog(this,"Are you sure to Confirm Add New Time?");
			if(option == JOptionPane.YES_OPTION){
				
				count5 = count4;
				try{
			
					 
					FileWriter fw = new FileWriter(f3,true);
					 
				        String	sttr = stationTrain1+"/"+fromStation1+"/"+toStation1+"/"+text3.getText()+"\n"; 
						s3=fromStation1;
						s4=toStation1;
						s5=stationTrain1;
						fw.write(sttr);
						fw.flush();
				       fw.close();
						
				}
				catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
							JOptionPane.showMessageDialog(this,"Successfully Added Time Schedule");
			}
			
			}
			else if(text3.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add Time Schedule","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select2==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Selecte  Station's Train","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select1==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Connecting Stations First","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(text1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add New Stations","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!text1.getText().equals(newStation))
		{
			JOptionPane.showMessageDialog(this,"Does not match the new Adding Station","Error",JOptionPane.ERROR_MESSAGE);
		}
		}
		if(e.getSource()==button8)
		{
			
		}
		if(e.getSource()==button9)
		{
			
			if(!text1.getText().equals("") &&
			select1>0 && text1.getText().equals(newStation) && select2>0 && 
			!text3.getText().equals("") && !text2.getText().equals("") && select3>0)
			{
				select3 = 0;
				try{
			Scanner sc=new Scanner(f1);
			
			while(sc.hasNextLine())
			{
				String sp[]=sc.nextLine().split("/");
	
				if(Integer.parseInt(sp[2])==count3)
				{
					
					count3++;
					fromStation2 =sp[0];
					toStation2 = sp[1];
					
					label10.setText(fromStation2+" to "+toStation2);
					break;
					
				}
				
				}
				sc.close();
			if(s6.equals(fromStation2) && s7.equals(toStation2) && s8.equals(Class))
			{
					try{
			Scanner sca=new Scanner(f1);
			while(sca.hasNextLine())
			{
				String spl[]=sca.nextLine().split("/");
				if(radiobtn1.isSelected()){
			     radiobtn2.setEnabled(true);
				 radiobtn1.setEnabled(false);
				 radiobtn2.setSelected(true);
				 Class = radiobtn2.getText();
					count3=2;
					fromStation2 = spl[0];
					toStation2 = spl[1];
					label10.setText(fromStation2+" to "+toStation2);
					break;
				}
				else if(radiobtn2.isSelected()){
			     radiobtn2.setEnabled(false);
				 radiobtn3.setEnabled(true);
				 radiobtn3.setSelected(true);
				 Class = radiobtn3.getText();
					count3=2;
					fromStation2 = spl[0];
					toStation2 = spl[1];
					label10.setText(fromStation2+" to "+toStation2);
					break;
				}
				else if(radiobtn3.isSelected()){
					sca.close();
			     radiobtn3.setEnabled(false);
				 button10.setEnabled(false);
				 button9.setEnabled(false);
				 f1.delete();
				 f2.delete();
				 f3.delete();
				 if(p==0)
				 {
				 try{
				 FileWriter fw = new FileWriter("files/StationHistory.txt",true);
				 String st = "Station-"+newStation+"\n";
				 fw.write(st);
				 fw.close();
				 }
				 catch(Exception ex)
				 {
					 
				 }
				 this.dispose();
				 new UpdateIntercityTrainInfoFrame(login,historyList);
				 JOptionPane.showMessageDialog(this,"Successfully Compelete Adding New Station");
				 p++;
				 }
				
				}
				
				}
				sca.close();
			}
			catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
			}
			
				
			}
			catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
				
			}
		else if(text2.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add Balance","Error",JOptionPane.ERROR_MESSAGE);
		}
			else if(text3.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add Time Schedule","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select3==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Set a Balance first","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select2==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Selecte  Station's Train","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select1==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Connecting Stations First","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(text1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add New Stations","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!text1.getText().equals(newStation))
		{
			JOptionPane.showMessageDialog(this,"Does not match the new Adding Station","Error",JOptionPane.ERROR_MESSAGE);
		}
		}
		if(e.getSource()==button10)
		{
			if(!text1.getText().equals("") &&
			select1>0 && text1.getText().equals(newStation) && select2>0 && 
			!text3.getText().equals("") && !text2.getText().equals("") && select3<=0)
			{
				
			int option = JOptionPane.showConfirmDialog(this,"Are you sure to Confirm Add Balance?");
			if(option == JOptionPane.YES_OPTION){
				
				select3++;
				try{
			
					
					FileWriter filewriter = new FileWriter("files/TrainHistory.txt",true);
					 
					 try{
			Scanner sc=new Scanner(f3);
			while(sc.hasNextLine())
			{
				String sp[]=sc.nextLine().split("/");
				if((sp[1].equals(fromStation2) && sp[2].equals(toStation2)) || 
				(sp[1].equals(toStation2) && sp[2].equals(fromStation2)))
				{
					s8 = Class;
                     String trainhistory =sp[1]+"/"+sp[2]+"/"+sp[0]+"/"+Class+"/"+sp[3]+"/"+text2.getText()+"\n";			 
					 TrainHistory history =new TrainHistory(sp[0],sp[1],sp[2],sp[3],Class,Double.parseDouble(text2.getText()));
					 historyList.insertHistory(history);
					// FileIO.readFromTrainHistoryFile("files/TrainHistory.txt",historyList);
						s6=fromStation2;
						s7=toStation2;
						filewriter.write(trainhistory);
						

				}
			}
			
					   filewriter.flush();
					   filewriter.close();
					   sc.close();
			 }
			catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
						
				}
				catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
							JOptionPane.showMessageDialog(this,"Successfully Added Balance");
			}
			
			}
		else if(text2.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add Balance","Error",JOptionPane.ERROR_MESSAGE);
		}
			else if(text3.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add Time Schedule","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select3>0)
		{
			JOptionPane.showMessageDialog(this,"You Can not 2 times set Balance","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select2==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Selecte  Station's Train","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(select1==0)
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Connecting Stations First","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(text1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add New Stations","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!text1.getText().equals(newStation))
		{
			JOptionPane.showMessageDialog(this,"Does not match the new Adding Station","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		}
		if(e.getSource()==button11)
		{
			this.dispose();
			new UpdateIntercityTrainInfoFrame (login,historyList);
		}
		if(e.getSource()==button12)
		{
			if(!text1.getText().equals("") && table1.getSelectedRows().length > 0 && select1<=0)
			{
				StationHistory [] history=historyList.getAllStationHistory();
				boolean flag = true;
				for(int j=0; j<history.length; j++)
				{
					if(history[j]!=null && text1.getText().equals(history[j].getFromStation()))
					{
						flag = false; 
						break;
                    }
			}
			if(flag)
			{
				
			int option = JOptionPane.showConfirmDialog(this,"Are you sure to Confirm Connecting Stations?");
			if(option == JOptionPane.YES_OPTION){
				select1++;
				newStation = text1.getText();
				int selectedRows[] = table1.getSelectedRows(); 
				Arrays.sort(selectedRows);

				if(selectedRows!=null){
					for(int i=selectedRows.length-1; i>=0 ;i--){
						String stations = table1.getModel().
										getValueAt(selectedRows[i], 0).
									toString();
								num1++;
							try
							{							
						 String line = text1.getText()+"/"+stations+"/"+num1+"\n";
						FileWriter fw1 = new FileWriter(f1,true);
						fw1.write(line);
						fw1.close();
							}
							catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}
					}
					
					JOptionPane.showMessageDialog(this,"Successfully Added Connecting Stations");
					table1.setEnabled(false);
					button12.setEnabled(false);
					text1.setEditable(false);
						try{
			Scanner sc=new Scanner(f1);
			while(sc.hasNextLine())
			{
				String sp[]=sc.nextLine().split("/");
				if(Integer.parseInt(sp[2])==count)
				{
					count++;
					fromStation = sp[0];
					toStation = sp[1];
					label5.setText(fromStation+" to "+toStation);
					break;
					
				}
				
				}
				sc.close();
			}
			catch(FileNotFoundException fe)
							{
								
							}
							catch(NullPointerException npe)
							{
								
							}
							catch(IOException ioe)
							{
								ioe.printStackTrace();
							}
							catch(Exception exp)
							{
								
							}		
	            }
				
			}
			}
				else
				{
					JOptionPane.showMessageDialog(this,"Your entering Station already exist","Error",JOptionPane.ERROR_MESSAGE);
				}
			
			}
		else if(select1>0)
		{
			JOptionPane.showMessageDialog(this,"You Already Selected Connecting Stations","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!(table1.getSelectedRows().length>=0))
		{
			JOptionPane.showMessageDialog(this,"You must have to Select Connecting Stations","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(text1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"You must have to Add New Stations","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		}
	}
		
}