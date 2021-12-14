package com.sist.main;
// 폴더 => 파일 제작 ==> IO => 자바에서 제공하는 라이브러리는 대부분 예외처리 
// 선언 (알림) => throws , 직접처리 => try~catch
import java.io.*;
/*
 *   io (input/output)
 *    => 메모리 입출력 
 *    => 파일 입출력 
 *    => 네트워크 입출력 
 */
// ==> 433page
public class MainClass3 {

	public static void main(String[] args) /*throws IOException*/{
		// TODO Auto-generated method stub
        File dir=new File("c:\\download");
        if(!dir.exists()) //폴더가 존재하지 않으면 
        {
        	dir.mkdir();
        }
        
        File file=new File("c:\\download\\test.txt");
        if(!file.exists())
        {
        	try
        	{
        	   file.createNewFile();// 예외처리가 필요한 메소드 
        	}catch(Exception e) {}
        }
        System.out.println("생성 완료!!");
        // 삭제 
        file.delete();
        dir.delete(); 
        System.out.println("삭제 완료!!");
	}

}
