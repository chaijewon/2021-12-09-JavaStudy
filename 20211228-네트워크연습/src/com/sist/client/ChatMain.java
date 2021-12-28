package com.sist.client;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ChatMain extends JFrame{
    Login login=new Login();
    WaitRoom wr=new WaitRoom();
    CardLayout card=new CardLayout();
    public ChatMain()
    {
    	setLayout(card);
    	add("WR",wr);
    	add("LOGIN",login);
    	setSize(1000, 750);
    	setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new ChatMain();
	}

}
