package com.sist.client;
// 윈도우 ==> HTML 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// 네트워크 
import java.io.*;
import java.net.*;
import java.util.*;
public class MusicMain extends JFrame{
    CardLayout card=new CardLayout();
    Login login=new Login();
    MusicView mv=new MusicView();
    public MusicMain()
    {
    	setLayout(card); // BorderLayout => 변경
    	// 화면=> 모아둔다 => 
    	/*
    	 *   Login => 서버 연결  
    	 *   Music => 음악 목록 , 음악 찾기 
    	 */
    	add("LOGIN",login);
    	add("MV",mv);
    	
    	// 크기 결정 
    	setSize(800,600);
    	// 윈도우 보여달라
    	setVisible(true);
    	// 종료버튼 클릭시 윈도우 해제
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 생성자만 호출 
		new MusicMain();
	}

}
