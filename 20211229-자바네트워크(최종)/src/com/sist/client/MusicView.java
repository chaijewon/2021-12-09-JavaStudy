package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class MusicView extends JPanel{
    JTable table;
    DefaultTableModel model;
    JButton b1,b2;
    JTextField tf;
    public MusicView()
    {
    	b1=new JButton("검색");
    	b2=new JButton("목록");
    	tf=new JTextField(20);
    	JPanel p=new JPanel();
    	p.add(tf);
    	p.add(b1);
    	p.add(b2);
    	
    	String[] col={"순위","곡명","가수명","앨범"};
    	String[][] row=new String[0][4];
    	model=new DefaultTableModel(row,col);
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	
    	// 배치 
    	setLayout(new BorderLayout());
    	// => North , South , East , West , Center
    	add("North",p);
    	add("Center",js);
    	
    }
}






