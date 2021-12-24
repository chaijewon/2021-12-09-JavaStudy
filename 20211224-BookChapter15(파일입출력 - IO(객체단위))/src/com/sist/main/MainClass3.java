package com.sist.main;
// FileReader : 문자 기반 스트림 (한글자 => 2byte)
/*
 *    int read() 
 *    close()
 *    int read(char[],int s, int e)
 */
import java.io.*;
import java.util.*;
// => ArrayList저장 ==> 읽을때 ArrayList => 객체 단위 스트림 
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 읽어와서 => ArrayList에 첨부
		ArrayList<Member> list=new ArrayList<Member>();
		// 1. 파일 => 문자열로 저장 => String 메소드를 이용해서 문자열 분해 
		try
		{
			FileReader fr=new FileReader("c:\\java_data\\address.txt"); 
		    String data="";
		    int i=0; // 한글자씩 읽어 온다 (문자번호로 읽는다) => char
		    while((i=fr.read())!=-1) // -1 문장의 끝
		    {
		    	// '1' => 49 , '0' => 48.....
		    	System.out.println(i+"|"+((char)i));
		    	data+=String.valueOf((char)i);//문자열 변환 
		    	// toString() 사용 할 수 없다 
		    	// toString() 객체
		    	// 문자열 결합 
		    }
		    fr.close();
		    
		    // 분리 
		    String[] member=data.split("\n");
		    for(String line:member)
		    {
		    	String[] info=line.split("\\|");
		    	/*
		    	 *   정규식 (오라클)
		    	 *   ^ => 시작   ^A
		    	 *   $ => 끝    A$
		    	 *   . => 임의의 문자 
		    	 *   + => 1개이상 다른 글자가 존재
		    	 *   * => 0개이상 다른 글자가 존재
		    	 *   | => 둘중에 1개 선택 
		    	 *   ? => 문자가 있든 없든...
		    	 */
		    	Member m=new Member(Integer.parseInt(info[0]),
		    			info[1], info[2], info[3], info[4]);
		    	list.add(m); // list자체를 브라우저 , 핸드폰 
		    }
		    
		    // 모아둔 데이터 출력 
		    for(Member m:list)
		    {
		    	System.out.println("회원번호:"+m.getNo());
		    	System.out.println("이름:"+m.getName());
		    	System.out.println("성별:"+m.getSex());
		    	System.out.println("주소:"+m.getAddr());
		    	System.out.println("전화:"+m.getTel());
		    	System.out.println("===================");
		    }
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		// ArrayList에 있는 데이터 출력 
	}

}



















