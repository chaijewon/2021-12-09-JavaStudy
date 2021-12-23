package com.sist.io;
// 파일 입출력 => 영구적인 저장 
/*
 *    ===> 읽기              ===> 쓰기 
 *    FileInputStream / FileOutputStream ==> 영문 , 숫자 
 *    FileReader  / FileWriter ==> 한글 저장 
 *    
 *    파일 쓰기 => 모드 (w , a)
 *    w : create (파일을 덮어 쓴다) => 기존에 있는 데이터를 지운고 새로운 파일 생성
 *    a : append : 기존의 있는 데이터를 그대로 둔 상태에서 데이터 추가 
 *    ========== 한글 저장 =====================================
 *    FileWriter fw=new FileWriter("경로명") => w
 *    FileWriter fw=new FileWriter("경로명",true) => a
 *    ========== 파일 복사 , 업로드 ==============================
 *    FileOutputStream fis=new FileOutnputStream("경로명") => w
 *    FileOutputStream fis=new FileOutnputStream("경로명",true) => a
 *    
 */
// 파일 읽기 => InputStream,Reader 
import java.io.*;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileInputStream fis=null;//1byte씩 읽어오는 클래스 
		FileReader fis=null;
		// 그림파일 , zip파일 
		// 한글 => 2바이트 ==> 문자 스트림 (FileReader)
        try
        {
        	// 자바에서는 반드시 경로 설정 ==> \ => \\
        	fis=new FileReader("C:\\javaDev\\javaStudy\\20211223-BookChapter15(입출력)\\src\\com\\sist\\io\\MainClass1.java");
            // 1byte로 읽는다 => 한글자씩 읽어 온다 => int (문자의 번호)
        	// A => 65
        	int i=0; // 문자한개를 받아서 저장할 변수 
        	// ==> 파일의 끝까지 읽는다 (EOF=> End Of File) => -1
        	while((i=fis.read())!=-1)// 모든 데이터를 읽어와라 
        		  // read() => 한글자씩 읽어 온다 
        	{
        		System.out.print((char)i);
        	}
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        finally
        {
        	// 서버닫기 , 파일 닫기 , 오라클 닫기 
        	try
        	{
        	  fis.close(); // 예외처리가 필요
        	}catch(Exception ex){}
        }
	}

}




