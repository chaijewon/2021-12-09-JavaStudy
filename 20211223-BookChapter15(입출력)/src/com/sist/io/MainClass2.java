package com.sist.io;
// 폴더 정보 => 폴더 모든 파일읽기 
import java.io.*;
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	File dir=new File("C:\\Users\\user\\Desktop\\자료");
        	System.out.println("폴더명:"+dir.getName());
        	System.out.println("경로명:"+dir.getPath());
        	System.out.println("크기:"+dir.length());
        	System.out.println("수정일:"+dir.lastModified());
        	System.out.println("==========폴더안에 있는 모든 파일 읽기====");
        	File[] files=dir.listFiles();// 업로드 => 같은 파일이 올라오면 
        	// 같은 폴더안에는 같은 파일명을 올릴 수 없다
        	HashSet<String> set=new HashSet<String>();
        	for(File f:files)
        	{
        		if(f.isFile()) // 파일일 경우에만 출력 
        		{
        			//System.out.println(f.getName());
        			// 확장자만 출력 
        		    String name=f.getName();
        		    String ext=
        		    	name.substring(name.lastIndexOf(".")+1);
        		    System.out.println(ext);
        		    set.add(ext);
        		}
        	}
        	// 중복이 없는 확장자를 출력 ==> HashSet
        	// 중복이 없는 확장자만 출력 
        	System.out.println("===중복없는 확장자 출력===");
        	for(String s:set)
        	{
        		System.out.println(s);
        	}
        	/*
        	 *   파일을 읽기 => 파일정보를 읽기 
        	 *   => 중복없이 저장 : HashSet 
        	 *   => 중복된 데이터 포함 저장 : ArrayList
        	 *   => 파일명 , 크기 ==> Map , enum
        	 */
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
	}

}
