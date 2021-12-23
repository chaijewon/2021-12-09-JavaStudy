package com.sist.io;

// 파일에 쓰기 
// FileOutputStream (1byte) => 바이트 스트림 (한글)
// FileWriter => (2byte) 문자스트림 => String
/*
 *    File 
 *    FileInputStream / FileOutputStream 
 *    FileReader / FileWriter
 *    ObjectInputStream / ObjectOutputStream 
 *    BufferedReader : 네트워크에서도 사용 
 *    ======================================
 *    
 *    enum / 어노테이션 / 정규식
 *    ============== 스프링 
 *    
 *    1.일반자바 (1~8장) => 클래스 만드는 방법 / 메소드 호출 (재사용)
 *                    => 오류방지 (예외처리)
 *                    => 라이브러리 
 *    ================================= 2차 자바 
 *    2.오라클 ==> jdbc (자바로 오라클 연결)
 *    3.JSP  ==> servlet(브라우저와 연결)
 *    4.스프링 ==> XML제어 , 어노테이션 
 *    5.마이바티스 ==> XML제어 , 어노테이션
 *    6.챗봇 => JSON(JavaScript연결) => RestFul ==> 라이브러리 
 */
import java.io.*;
import java.util.*;
public class MainClass5 {
    // 멤버변수는 자동 초기화 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 모든 클래스는 초기값이 null(주소값을 가지고 있지 않는 상태)
		FileOutputStream fos=null; // 메소드(지역변수 => 반드시 초기화)
		FileInputStream fis=null;
        try
        {
        	//1. 폴더 만들기 
        	File dir=new File("c:\\java_data");
        	if(!dir.exists())
        	{
        		dir.mkdir();
        		System.out.println("폴더 생성 완료");
        	}
        	//2. 파일을 만들기 
        	File file=new File("c:\\java_data\\student.txt");
        	if(!file.exists())
        	{
        		file.createNewFile();
        		System.out.println("파일 생성 완료");
        	}
        	//3. 파일 쓰기 
        	fos=new FileOutputStream(file,true);
        	Scanner scan=new Scanner(System.in);
        	System.out.print("이름 입력:");
        	String name=scan.next();
        	System.out.print("국어 입력:");
        	int kor=scan.nextInt();
        	System.out.print("영어 입력:");
        	int eng=scan.nextInt();
        	System.out.print("수학 입력:");
        	int math=scan.nextInt();
        	//String hong="심청이|80|90|70\n";
        	String data=name+"|"+kor+"|"+eng+"|"+math+"\n";
        	fos.write(data.getBytes());
        	//fos.write(hong.getBytes());//byte로 변환
        	System.out.println("등록 완료!!");
        	//4. 파일 읽기
        	FileReader fr=new FileReader(file);
        	int i=0;
        	String msg="";
        	// 데이터 전체 읽기 
        	while((i=fr.read())!=-1)
        	{
        		msg+=String.valueOf((char)i);
        	}
        	
        	System.out.println(msg);
        	// 데이터 조절 
        	String[] student=msg.split("\n"); // 정규식에 사용중
        	for(String s:student)
        	{
        		String[] info=s.split("\\|");
        		// StringTokenizer 
        		// 문자열 => 파일 읽기 (문자열) 
        		// 정수가 필요한 경우에는 반드시 변환 Integer.parseInt(info[1])
        		System.out.println(info[0]+" "
        			+info[1]+" "
        			+info[2]+" "
        			+info[3]+" "
        			+(Integer.parseInt(info[1])
        			  +Integer.parseInt(info[2])
        			  +Integer.parseInt(info[3]))
        			+" "
        			+(Integer.parseInt(info[1])
              		  +Integer.parseInt(info[2])
            		  +Integer.parseInt(info[3]))/3);
        	}
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        finally
        {
        	try
        	{
        		fis.close();
        		fos.close();
        	}catch(Exception ex) {}
        }
	}

}











