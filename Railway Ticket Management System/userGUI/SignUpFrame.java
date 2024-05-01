package userGUI;

import entitylist.*;
import entity.*;
import files.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class SignUpFrame extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel label1,label2,label3,
	label4,label5,label6,label7,
	label8,label9,label10,label11,
	label12,label13,label14,label15;
	private JButton button1,button2,button3;
	private JTextField text1,text2,
	text3,text4,text5,text6,text7,
	text8,text9,text10,text11,
	text12,text13;
	private JComboBox cb;
	private JCheckBox checkbox;
	private JScrollPane scroll;
	Font font1=new Font("cambria",Font.BOLD+Font.ITALIC,25);
	Font font2=new Font("cambria",Font.BOLD,15);
	Font font3=new Font("cambria",Font.BOLD,10);
	private String [] question = {"What is your favorite color?","What is your favorite game?","What is your favorite food?","What is your favorite subject?","What is your favorite writer?","What is your favorite singer?"};
	private LogInFrame login;
	
	public SignUpFrame(LogInFrame login)
	{
		super("Bangladesh Railway");
		this.login=login;
		initializeForm();
		
		this.setVisible(true);
	}
	public void initializeForm()
	{
		this.setSize(900,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		panel=new JPanel();
		panel.setBounds(0,0,900,650);
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBackground(new Color(255,255,255));
		
		ImageIcon img=new ImageIcon("./userGUI/Resources/Logo333.png");
		JLabel logo=new JLabel("",img,JLabel.CENTER);
		logo.setBounds(340,45,50,50);
		
		label1=new JLabel("Sign Up");
		label1.setBounds(400,40,150,50);
		label1.setFont(font1);
		label1.setForeground(new Color(41,196,96));
		label1.setBackground(new Color(41,196,96));
		
		
		label2=new JLabel("Already have an account?");
		label2.setBounds(620,50,120,50);
		label2.setFont(font3);
		label2.setBackground(new Color(41,196,96));
		
		button1=new JButton("Sign In");
		button1.setBounds(760,60,90,30);
		button1.setFont(font2);
		button1.setBackground(new Color(41,196,96));
		button1.addActionListener(this);
		
		label3=new JLabel("Name");
		label3.setBounds(340,130,80,30);
		label3.setFont(font2);
		
		text1=new JTextField();
		text1.setBounds(340,165,250,30);
		text1.setFont(font2);
		
		label4=new JLabel("NID");
		label4.setBounds(340,200,80,30);
		label4.setFont(font2);
		
		text2=new JTextField();
		text2.setBounds(340,235,250,30);
		text2.setFont(font2);
		
		label5=new JLabel("Password");
		label5.setBounds(340,270,100,30);
		label5.setFont(font2);
		
		text3=new JTextField();
		text3.setBounds(340,305,250,30);
		text3.setFont(font2);
		
		label6=new JLabel("Security Question");
		label6.setBounds(340,340,150,30);
		label6.setFont(font2);
		
		try{
		 cb=new JComboBox(question);
		cb.setFont(font2);
		cb.setBackground(new Color(255,255,255));
		
		scroll=new JScrollPane(cb);
		scroll.setBounds(340,375,250,30);
		//scroll.setPreferredSize(new Dimension(200,100));
		cb.setPreferredSize(new Dimension(0,20));
		cb.setMaximumRowCount(4);
		panel.add(scroll);
		}
		catch(Exception ex)
		{
			
		}
		
		label7=new JLabel("Captcha");
		label7.setBounds(340,410,80,30);
		label7.setFont(font2);
		
		label8=new JLabel(" 7 + 9 ");
		label8.setBounds(420,450,100,30);
		label8.setFont(font2);
		
		label9=new JLabel("E-mail");
		label9.setBounds(610,130,100,30);
		label9.setFont(font2);
		
		text5=new JTextField();
		text5.setBounds(610,165,250,30);
		text5.setFont(font2);
		
		label10=new JLabel("Phone");
		label10.setBounds(610,200,80,30);
		label10.setFont(font2);
		
		text6=new JTextField();
		text6.setBounds(610,235,250,30);
		text6.setFont(font2);
		
		label11=new JLabel("Confirm Password");
		label11.setBounds(610,270,150,30);
		label11.setFont(font2);
		
		text7=new JTextField();
		text7.setBounds(610,305,250,30);
		text7.setFont(font2);
		
		label12=new JLabel("Your Answer");
		label12.setBounds(610,340,100,30);
		label12.setFont(font2);
		
		text8=new JTextField();
		text8.setBounds(610,375,250,30);
		text8.setFont(font2);
		
		label13=new JLabel("Enter the result here");
		label13.setBounds(610,410,200,30);
		label13.setFont(font2);
		
		text9=new JTextField();
		text9.setBounds(610,445,250,30);
		text9.setFont(font2);
		
		checkbox=new JCheckBox();
		checkbox.setBounds(340,511,17,15);
		checkbox.addActionListener(this);
		
		label14=new JLabel("I accept all the Terms and Condition and Privacy Policy");
		label14.setBounds(365,503,400,30);
		label14.setFont(font3);
		
		button3=new JButton("Sign Up");
		button3.setBounds(340,550,100,30);
		button3.setFont(font2);
		button3.setBackground(new Color(41,196,96));
		button3.addActionListener(this);
		
		label15=new JLabel("Visit Account Settings to enable Password recovery with OTP");
		label15.setBounds(580,550,400,30);
		label15.setFont(font3);
		label15.setForeground(new Color(41,196,96));
		
		ImageIcon image=new ImageIcon("./userGUI/Resources/SignUpFrame.png");
		JLabel background=new JLabel("",image,JLabel.CENTER);
		background.setBounds(0,0,300,650);
		
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
		panel.add(label13);
		panel.add(label14);
		panel.add(label15);
		panel.add(button1);
		panel.add(checkbox);
		panel.add(button3);
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		//panel.add(cb);
		panel.add(text5);
		panel.add(text6);
		panel.add(text7);
		panel.add(text8);
		panel.add(text9);
		panel.add(logo);
		panel.add(background);
		this.add(panel);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button1)
		{
			this.dispose();
			login.setVisible(true);
		}
		if(e.getSource()==button3)
		{
			if(!text1.getText().equals("") && !text2.getText().equals("") &&
			!text5.getText().equals("") && !text6.getText().equals("") &&  
			!text3.getText().equals("") && !text7.getText().equals("") && 
			!text8.getText().equals("") && !text9.getText().equals("") && checkbox.isSelected() &&
			text7.getText().equals(text3.getText()))
			{
				TravelerHistory th = new TravelerHistory(text1.getText(),text2.getText(),
				text5.getText(),text6.getText(),text3.getText(),5000);
				try {
				String st =text1.getText()+"/"+text2.getText()+"/"+
				text5.getText()+"/"+text6.getText()+"/"+text3.getText()+"/"+5000+"\n";
				HistoryList historyList = new HistoryList(100000000);
				historyList.insertHistory(th);
				FileWriter fw = new FileWriter("files/TravelerList.txt",true);
				fw.write(st);
				fw.close();
				}
				catch(Exception ex)
				{
					
				}
				JOptionPane.showMessageDialog(this,"Sing Up Successfull");
				this.dispose();
				login.setVisible(true);
			}
		}
		
	}
	
}