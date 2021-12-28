package com.sist.temp;
// ºñµ¿±â 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainClass2 extends JFrame{
    JLabel la;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JButton b1,b2;
    public MainClass2()
    {
    	la=new JLabel("·Î¶Ç »ý¼º",JLabel.CENTER);
    	la.setFont(new Font("±Ã¼­Ã¼",Font.BOLD,35));
    	add("North",la);
    	JPanel p=new JPanel();
    	tf1=new JTextField("1   ",JLabel.CENTER); 
    	//tf1.setFont(new Font("±Ã¼­Ã¼",Font.BOLD,35));
    	
    	tf2=new JTextField("2   ",JLabel.CENTER); 
    	//tf2.setFont(new Font("±Ã¼­Ã¼",Font.BOLD,35));
    	
    	tf3=new JTextField("3   ",JLabel.CENTER); 
    	//tf3.setFont(new Font("±Ã¼­Ã¼",Font.BOLD,35));
    	
    	tf4=new JTextField("4   ",JLabel.CENTER); 
    	//tf4.setFont(new Font("±Ã¼­Ã¼",Font.BOLD,35));
    	
    	tf5=new JTextField("5   ",JLabel.CENTER); 
    	//tf5.setFont(new Font("±Ã¼­Ã¼",Font.BOLD,35));
    	
    	tf6=new JTextField("6   ",JLabel.CENTER); 
    	//tf6.setFont(new Font("±Ã¼­Ã¼",Font.BOLD,35));
    	
    	p.add(tf1);p.add(tf2);p.add(tf3);
    	p.add(tf4);p.add(tf5);p.add(tf6);
    	
    	add("Center",p);
    	
    	b1=new JButton("½ÃÀÛ");
    	b2=new JButton("Á¾·á");
    	
    	JPanel p2=new JPanel();
    	p2.add(b1);p2.add(b2);
    	
    	add("South",p2);
    	setSize(450,350);
    	setVisible(true);
    	
    	go();
    }
    
    public void go()
    {
    	LottoThread t1=new LottoThread(tf1);
    	t1.start();
    	
    	LottoThread t2=new LottoThread(tf2);
    	t2.start();
    	
    	LottoThread t3=new LottoThread(tf3);
    	t3.start();
    	
    	LottoThread t4=new LottoThread(tf4);
    	t4.start();
    	
    	LottoThread t5=new LottoThread(tf5);
    	t5.start();
    	
    	LottoThread t6=new LottoThread(tf6);
    	t6.start();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass2();
	}

	class LottoThread extends Thread
	{
		JTextField tf;
		public LottoThread(JTextField tf)
		{
			this.tf=tf;
		}
		public void run()
		{
			
			while(true)
			{
			   for(int i=1;i<=45;i++)
			   {
				   if(i==45)
				   {
					   i=1;
				   }
			       tf.setText(String.valueOf(i));
				   try
				   {
					   Thread.sleep((int)(Math.random()*100)+50);
				   }catch(Exception ex) {}
			   }
			}
		}
	}
}
