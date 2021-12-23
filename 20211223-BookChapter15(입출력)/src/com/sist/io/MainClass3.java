package com.sist.io;
import java.util.*;
import java.io.*;//915page
// 파일 , 폴더 제어 (파일만들기,폴더만들기, 삭제)
// 파일 입출력 
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	File dir=new File("C:\\download");
        	// download 폴더가 없다 
        	//1. 폴더의 유무 확인 => 있는 경우는 통과 / 없는 경우는 만든다
        	if(!dir.exists()) // 존재하지 않는 경우 
        	{
        		dir.mkdir(); // 폴더를 만든다 
        	}
        	//System.out.println("폴더 생성 완료!!");
        	File file=new File("c:\\download\\food.txt");
        	if(!file.exists())
        	{
        		// 파일을 만들어라 
        		file.createNewFile();
        	}
        	//System.out.println("파일 생성 완료!!");
        	// 삭제 
        	file.delete(); // 파일 먼저 삭제
        	dir.delete();  // 폴더 삭제
        	System.out.println("파일 삭제 완료!!");
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
	}

}
