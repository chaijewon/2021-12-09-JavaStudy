package com.sist.exception;
/*
 *   문법 
 *     변수 , 메소드 (연산자 + 제어문) , 클래스 , 예외처리 
 *     ==> 활용 (웹:JSP , Spring , Spring-boot,Mybatis) 
 *     ==> OpenAPI (카카오 => 맵 , 뉴스 , data.go.kr)
 */
// try~catch 예외처리 
import java.io.*;
// C:\Windows\System32\
import java.util.*; // Scanner
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 예외처리 
		//try
		//{
			Scanner scan=new Scanner(System.in);
			// System.in => 표준 입력 => 입력을 받는 경우에 사용 
			// 키보드로부터 입력값을 받는 경우에 읽어오는 기능 
			// System(클래스)  ==> in (InputStream) => static 
			// 클래스명.메소드 , 변수 => static 
			// Math.random()
			System.out.print("계산기(1),그림판(2),메모장(3), 인터넷(4) 입력:");
			// 입력한 값을 받아서 메모리에 저장 
			int no=scan.nextInt();
			/*
			 *    CheckException => 반드시 예외처리를 해야 사용 할 수 있다 
			 *     = IOException  => File 관련 (경로명)
			 *     = InterrupedException => 쓰레드(충돌)
			 *     = ClassNotFoundException 
			 *     = SQLException => 오라클
			 *     = MalformedURLException => 네트워크 (WEB주소)
			 */
			// 화면을 보여주기 시작 
			// 부분마다 가능 => 전체적으로 가능 
			if(no==1)
			{
				try {
					Runtime.getRuntime()
					  .exec("c:\\windows\\system32\\calc.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //exe파일 실행 
			}
			else if(no==2)
			{
				try {
					Runtime.getRuntime()
					  .exec("c:\\windows\\system32\\mspaint.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			else if(no==3)
			{
				try {
					Runtime.getRuntime()
					  .exec("c:\\windows\\system32\\notepad.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			else if(no==4)
			{
				try
				{
					Runtime.getRuntime()
					 .exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe http://daum.net");
				}catch(Exception ex) {}
			}
			else
			{
				System.out.println("메뉴 선택이 잘못되었습니다!!");
				// 예외처리 => 에러를 사전에 방지 (if) ==> try~catch
				// 코테 => 오류방지 
			}
		//}catch(Exception e)
		//{
			//System.out.println("입력된 경로가 틀립니다!!");
		//}
	}

}
