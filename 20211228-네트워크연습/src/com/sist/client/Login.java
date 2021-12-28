package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class Login extends JPanel{
	JLabel la1,la2,la3;
	JTextField tf1,tf2;
    JRadioButton rb1,rb2;
    JButton b1,b2;
    public Login()
    {
    	la1=new JLabel("ID");
    	la2=new JLabel("이름");
    	la3=new JLabel("성별");
    	
        tf1=new JTextField();
        tf2=new JTextField();
        
        rb1=new JRadioButton("남자");
        rb2=new JRadioButton("여자");
        // Group => 1개만 선택 
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        
        b1=new JButton("로그인");
        b2=new JButton("취소");
        
        //  배치 (컴포넌트)
        setLayout(null);
        la1.setBounds(10, 15, 40, 30);
        tf1.setBounds(55, 15, 150, 30);
        
        la2.setBounds(10, 55, 40, 30);
        tf2.setBounds(55, 55, 150, 30);
        
        la3.setBounds(10, 90, 40, 30);
        rb1.setBounds(55, 90, 70, 30);
        rb2.setBounds(130, 90, 70, 30);
        
        JPanel p=new JPanel();
        p.add(b1);p.add(b2);
        p.setBounds(10,130 , 195, 35);
        
        // 추가 
        add(la1);add(tf1);
        add(la2);add(tf2);
        add(la3);add(rb1);add(rb2);
        add(p);
        
    }
}







