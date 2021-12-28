package com.sist.client;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class WaitRoom extends JPanel{
   JTable table;
   DefaultTableModel model;
   JTextArea ta;
   JTextField tf;
   JButton b1;
   public WaitRoom()
   {
	   ta=new JTextArea();
	   JScrollPane js1=new JScrollPane(ta);
	   // JScrollBar(H,V)  JScrollPane(H,V가 포함)
	   tf=new JTextField();
	   b1=new JButton("나가기");
	   
	   String[] col={"아이디","이름","성별"};
	   String[][] row=new String[0][3];
	   model=new DefaultTableModel(row,col);
	   table=new JTable(model);
	   JScrollPane js2=new JScrollPane(table);
	   
	   //  배치
	   setLayout(null);
	   js2.setBounds(10, 15, 490, 300);
	   js1.setBounds(510, 15, 450, 300);
	   tf.setBounds(510, 320, 450, 30);
	   add(js1);
	   add(js2);
	   add(tf);
	   
   }
}




