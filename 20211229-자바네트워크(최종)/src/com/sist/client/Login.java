package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class Login extends JPanel{
    JLabel la1,la2;
    JTextField tf1,tf2;
    JButton b1,b2;
    public Login()
    {
    	la1=new JLabel("아이디");
    	la2=new JLabel("이름");
    	
    	tf1=new JTextField();
    	tf2=new JTextField();
    	b1=new JButton("로그인");
    	b2=new JButton("취소");
    	
    	setLayout(null);
    	// 배치 
    	// 1,3 ==> 옆에 출력  ==> +5
    	// 2,4 ==> 아래 출력  ==> +5
    	la1.setBounds(10, 15, 50, 30);
    	tf1.setBounds(65, 15, 150, 30);
    	
    	la2.setBounds(10, 50, 50, 30);
    	tf2.setBounds(65, 50, 150, 30);
    	
    	// 버튼이 여러개 묶어서 => JPanel
    	JPanel p=new JPanel();
    	p.add(b1);
    	p.add(b2);
    	
    	p.setBounds(10, 90, 205, 35);
    	
    	// 윈도우에 올리기 
    	add(la1);add(tf1);
    	add(la2);add(tf2);
    	add(p);
    }
}







