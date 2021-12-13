package com.sist.exception;
// Check Exception ==> 컴파일러가 감시 
import java.io.*;// 데이터 읽기
import java.net.*; // 웹사이트 연결 
// => 예외처리를 반드시 한다 
public class MainClass7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	/*
        	 *    URLConnection (상위 클래스) double
        	 *       |
        	 *  HttpURLConnection (하위클래스) int
        	 *    int i=(int)10.5; 
        	 *  HttpURLConnection conn=(HttpURLConnection)new URLConnection();
        	 *  
        	 *      동물 
        	 *       |
        	 *      인간 
        	 *      
        	 *      인간 a=(인간)new 동물();
        	 */
        	//1. 웹사이트 연결 
        	URL url=new URL("https://sist.co.kr/index.jsp");
        	HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        	
        	if(conn!=null) // 연결되었다면 
        	{
        		BufferedReader br=
        				new BufferedReader(new InputStreamReader(
        						conn.getInputStream(),"UTF-8"));
        		while(true)
        		{
        			String s=br.readLine();
        			if(s==null) break;
        			System.out.println(s);
        		}
        	}
        	
        }catch(Exception e){
        	e.printStackTrace(); // 422page 
        }
	}

}
