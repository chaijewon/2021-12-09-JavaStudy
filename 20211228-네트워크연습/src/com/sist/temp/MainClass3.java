package com.sist.temp;
// 동기화 
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainClass3 extends JFrame implements Runnable{
    JProgressBar bar1=new JProgressBar();
    JProgressBar bar2=new JProgressBar();
    JProgressBar bar3=new JProgressBar();
    JLabel la1,la2,la3;
    JButton b1,b2;
    
    public MainClass3()
    {
    	la1=new JLabel("금전운");
    	la2=new JLabel("건강운");
    	la3=new JLabel("로또운");
    	
    	bar1.setMaximum(100);
    	bar1.setMinimum(0);
    	bar1.setBackground(Color.white);
    	bar1.setForeground(Color.yellow);
    	bar1.setStringPainted(true);
    	
    	bar2.setMaximum(100);
    	bar2.setMinimum(0);
    	bar2.setBackground(Color.white);
    	bar2.setForeground(Color.yellow);
    	bar2.setStringPainted(true);
    	
    	bar3.setMaximum(100);
    	bar3.setMinimum(0);
    	bar3.setBackground(Color.white);
    	bar3.setForeground(Color.yellow);
    	bar3.setStringPainted(true);
    	
    	b1=new JButton("시작");
    	b2=new JButton("종료");
    	
    	// 배치 ==> HTML (CSS) => Layout 
    	setLayout(null); // 사용자 정의 
    	la1.setBounds(10, 15, 50, 30);
    	bar1.setBounds(65, 15, 350, 30);
    	
    	la2.setBounds(10, 50, 50, 30);
    	bar2.setBounds(65, 50, 350, 30);
    	
    	la3.setBounds(10, 85, 50, 30);
    	bar3.setBounds(65, 85, 350, 30);
    	
    	JPanel p=new JPanel();
    	p.add(b1);p.add(b2);
    	p.setBounds(10, 125, 405, 35);
    	
    	add(la1);add(bar1);
    	add(la2);add(bar2);
    	add(la3);add(bar3);
    	add(p);
    	
    	setSize(445,210);
    	setVisible(true);
    	
    	Thread t=new Thread(this);
    	t.start();
    }
    public void run()
    {
    	int a=(int)(Math.random()*101);
    	int b=(int)(Math.random()*101);
    	int c=(int)(Math.random()*101);
    	
    	for(int i=0;i<=a;i++)
    	{
    		bar1.setValue(i);
    		try
    		{
    			Thread.sleep(100);
    		}catch(Exception ex) {}
    	}
    	for(int i=0;i<=b;i++)
    	{
    		bar2.setValue(i);
    		try
    		{
    			Thread.sleep(100);
    		}catch(Exception ex) {}
    	}
    	for(int i=0;i<=c;i++)
    	{
    		bar3.setValue(i);
    		try
    		{
    			Thread.sleep(100);
    		}catch(Exception ex) {}
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass3();
	}

}
