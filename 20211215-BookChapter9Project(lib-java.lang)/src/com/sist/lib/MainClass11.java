package com.sist.lib;
// StringBuffer / StringBuilder
// 동기화  / 비동기화 
// 데이터 수집 => 나머지 String
import java.io.*; // 파일 읽기 
public class MainClass11 {
    public void stringUse()
    {
    	String movie="";
        long start=System.currentTimeMillis();//log파일 
        // 파일 읽기
        // IOException ==> CheckException
        try
        {
        	// 파일 읽기 
        	FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
            int i=0;//char => read() => int  A=65
            while((i=fr.read())!=-1) //-1 EOF
            {
            	movie+=String.valueOf((char)i);
            }
            fr.close();
            System.out.println(movie);
            
        }catch(Exception ex){}
        long end=System.currentTimeMillis();
        System.out.println("수행시간:"+(end-start));
    }
    //33156 VS 506 ==> 문자열 결합의 최적화 (StringBuffer)
    // 504
    public void stringBufferUse()
    {
    	StringBuffer sb=new StringBuffer();
    	long start=System.currentTimeMillis();//log파일 
        // 파일 읽기
        // IOException ==> CheckException
        try
        {
        	// 파일 읽기 
        	FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
            int i=0;//char => read() => int  A=65
            while((i=fr.read())!=-1) //-1 EOF
            {
            	sb.append(String.valueOf((char)i));
            }
            fr.close();
            System.out.println(sb.toString());
            
        }catch(Exception ex){}
        long end=System.currentTimeMillis();
        System.out.println("수행시간:"+(end-start));
    }
    public void stringBuilderUse()
    {
    	StringBuilder sb=new StringBuilder();
    	long start=System.currentTimeMillis();//log파일 
        // 파일 읽기
        // IOException ==> CheckException
        try
        {
        	// 파일 읽기 
        	FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
            int i=0;//char => read() => int  A=65
            while((i=fr.read())!=-1) //-1 EOF
            {
            	sb.append(String.valueOf((char)i));
            }
            fr.close();
            System.out.println(sb.toString());
            
        }catch(Exception ex){}
        long end=System.currentTimeMillis();
        System.out.println("수행시간:"+(end-start));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MainClass11 m=new MainClass11();
        //m.stringUse();
        //m.stringBufferUse();
        m.stringBuilderUse();
	}

}
