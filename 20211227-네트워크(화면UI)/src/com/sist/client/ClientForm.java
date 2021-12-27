package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
/*
 *    웹 , 오라클 ==> 네트워크 이용 (쓰레드)
 *    
 *    웹 
 *    ===
 *     = HTML/CSS => 퍼블리셔 (디자인너)
 *     = Front : JavaScript (라이브러리:Jquery,AJax,VueJS,ReactJS,NodeJS)
 *     = Back : Java,Oracle (라이브러리:Spring,MyBatis) => AI(*****)
 *     Spring => 설정파일 (설정없이 사용=> Spring-Boot)
 *     =========================== Full Stack(요구)
 *    
 *    => 클라이언트 => 동작 2
 *    1) 채팅문자열 전송 
 *    2) 서버로부터 채팅문자열을 읽어와서 출력 ==> 쓰레드 
 */
import java.io.*;
import java.net.*;
import java.util.*;
public class ClientForm extends JFrame 
implements Runnable,ActionListener
{
	// 화면 UI관련 
    JTable table;
    DefaultTableModel model;
    JTextArea ta;
    JTextField tf;
    JButton loginBtn, sendBtn, endBtn;
    // 네트워크와 관련 
    Socket s; // 서버와 연결 
    BufferedReader in; // 서버로부터 값을 읽어 온다 
    OutputStream out; // 서버로 요청값을 전송 
    String name="";
    public ClientForm()
    {
    	// 멤버변수의 초기화 
    	ta=new JTextArea();
    	ta.setEditable(false);// 편집방지
    	JScrollPane js1=new JScrollPane(ta);
    	tf=new JTextField();
    	loginBtn=new JButton("로그인");
    	sendBtn=new JButton("전송");
    	endBtn=new JButton("종료");
    	
    	String[] col={"ID","Name","Sex"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row,col);
    	table=new JTable(model);
    	JScrollPane js2=new JScrollPane(table);
    	// Spring / AWS / MyBatis
    	// Spring-Boot == VueJS , ReactJS  AI
    	// 윈도우에 배치 
    	setLayout(null);
    	js2.setBounds(10,15,500,200);
    	js1.setBounds(10,220,500,250);
    	tf.setBounds(10,475, 500, 30);
    	
    	JPanel p=new JPanel();
    	p.add(loginBtn);
    	p.add(endBtn);
    	p.setBounds(10, 510, 500, 35);
    	// 추가 
    	add(js1);add(js2);add(tf);add(p);
    	setSize(550,590);
    	setVisible(true);
    	
    	// 등록 (이벤트)
    	loginBtn.addActionListener(this);// click => actionPerformed
    	tf.addActionListener(this);// enter=>actionPerformed
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ClientForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginBtn)// 로그인버튼을 클릭했다면
		{
			name=JOptionPane.showInputDialog("이름 입력:");
			try
			{
				s=new Socket("localhost",3355);
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// 서버에서 보내준 데이터가 1byte=>2byte로 변환후에 받는다 
				out=s.getOutputStream();
			}catch(Exception ex) {}
			// 서버에서 들어오는 값을 출력한다 
			new Thread(this).start(); // run()을 호출해서 다른 사람이 보낸 데이터를 출력 
		}
		if(e.getSource()==tf)//채팅 => enter
		{
			// 서버로 문자열을 보낸다
			try
			{
				// 사용자가 입력한 채팅문자열 읽기
				String msg=tf.getText();
				if(msg.length()<1) return;
				out.write(("["+name+"]"+msg+"\n").getBytes());
				
				tf.setText("");
			}catch(Exception ex) {}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 서버에서 들어오는 값을 출력 
		while(true)
		{
			try
			{
				String msg=in.readLine();
				ta.append(msg+"\n");
			}catch(Exception ex) {}
		}
	}

}







