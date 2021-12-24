package com.sist.main;
import java.util.*;
import java.io.*;
// ObjectInputStream => readObject() , close()
public class MainClass6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 객체 단위로 읽기 
        	FileInputStream fis=
        		new FileInputStream("c:\\java_data\\sawon.txt");
        	// 실제 파일을 읽는다 
        	ObjectInputStream ois=
        			new ObjectInputStream(fis);
        	// 읽은 파일을 객체단위로 변경 
        	ArrayList<Sawon> list=(ArrayList<Sawon>)ois.readObject();
        	fis.close();
        	ois.close();
        	// ArrayList출력
        	for(Sawon s:list)
        	{
        		System.out.println(s.getSabun()+" "
        				+s.getName()+" "
        				+s.getDept()+" "
        				+s.getLoc()+" "
        				+s.getPay());
        	}
        }catch(Exception ex) {}
	}

}
