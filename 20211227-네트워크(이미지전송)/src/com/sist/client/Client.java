package com.sist.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// 네트워크 
import java.io.*;
import java.net.*;
import java.util.*;
public class Client extends JFrame implements ActionListener{
    private JButton[] btn=new JButton[5];
    private JLabel la=new JLabel();
    private String[] poster={
    	"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000084/84949/84949_320.jpg",
    	"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000082/82479/82479_320.jpg",
    	"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000085/85515/85515_320.jpg",
    	"https://adimg.cgv.co.kr/images/202112/childfund12/F_160x300.jpg",
    	"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000085/85237/85237_320.jpg"
    };
    public Client()
    {
    	JPanel p=new JPanel();
    	for(int i=0;i<btn.length;i++)
    	{
    		btn[i]=new JButton(String.valueOf(i));
    		p.add(btn[i]);
    		btn[i].addActionListener(this);
    	}
    	try
    	{
    		la.setIcon(new ImageIcon(new URL(poster[0])));
    	}catch(Exception ex) {}
    	add("North",p);
    	add("Center",la);
    	setSize(640, 750);
    	setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Client();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn[0])
		{
			try
	    	{
	    		la.setIcon(new ImageIcon(new URL(poster[0])));
	    	}catch(Exception ex) {}
		}
		if(e.getSource()==btn[1])
		{
			try
	    	{
	    		la.setIcon(new ImageIcon(new URL(poster[1])));
	    	}catch(Exception ex) {}
			
		}
		if(e.getSource()==btn[2])
		{
			try
	    	{
	    		la.setIcon(new ImageIcon(new URL(poster[2])));
	    	}catch(Exception ex) {}
		}
		if(e.getSource()==btn[3])
		{
			try
	    	{
	    		la.setIcon(new ImageIcon(new URL(poster[3])));
	    	}catch(Exception ex) {}
		}
		if(e.getSource()==btn[4])
		{
			try
	    	{
	    		la.setIcon(new ImageIcon(new URL(poster[4])));
	    	}catch(Exception ex) {}
		}
	}

}
