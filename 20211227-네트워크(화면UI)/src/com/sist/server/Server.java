package com.sist.server;
/*
 *     접속처리 : 클라이언트 접속시 처리 ==> 클라이언트 IP를 저장 
 *     =========================
 *     통신을 담당하는 클래스 : IP를 찾아서 연결후에 데이터를 전송 
 *     
 *     ==> innerClass : 서로 다른 클래스끼리 => 공통으로 사용되는 변수나 메소드가 
 *                      있는 경우 주로 사용 
 *     ==> 멤버 클래스 
 *         ========
 *         class A
 *         {
 *            ============
 *             공유하는 데이터 
 *            ============
 *            class B
 *            {
 *               A가 가지고 있는 데이터 사용이 가능 
 *               => 네크워크 
 *               => 쓰레드 
 *            }
 *         }
 *      ==> 익명의 클래스 (extends가 존재하지 않는다) => 오버라이딩이 가능 
 *          class A
 *          {
 *             B b=new B(){
 *                B가 가지고 있는 메소드를 재정의가 가능,추가  
 *             }
 *          }
 *          
 *      ==> Spring의 기조는 독립적인 클래스를 선호 (상속(X) , 포함(O))
 *          => POJO 
 *         
 *      
 */
import java.io.*;
import java.util.*;
import java.net.*;
/*
 *    Thread : 
 *       프로그램은 프로세서 (프로세서안에는 여러개 프로그램을 동시에 동작 
 *                       쓰레드) 
 *                       한개의 실행파일에는 1개이상의 쓰레드가 존재한다 
 *       => 자바 특징은 멀티쓰레드를 지원한다 
 *       => 사용자 정의시에 
 *          ============
 *           쓰레드가 2개 동작 
 *           1)  main() => 쓰레드
 *           2)  gc() => 쓰레드 
 *       => 만드는 방법 
 *          =========
 *          인터페이스
 *            => class A implements Runable
 *               {
 *                   public void run()
 *                   {
 *                   }
 *               } 
 *          상속 class A extends Thread
 *              {
 *              }
 *              
 *       => Thread의 생명 주기 
 *        Thread t=new Thread() t.start() t.run              sleep()   
 *        Thread 생성 ==> Thread 대기 ==> Thread 동작(실행) <===> 일시 정지
 *             (Thread 동작에 필요한 데이터 수집)  |
 *                                           | interrupt()
 *                                         Dead(쓰레드 종료)
 *        시간을 분할해서 작업 역할 
 *         
 */
public class Server implements Runnable{
    //1. 접속한 클라이언트(정보:IP,PORT) 저장 
	private Vector<Client> waitVc=new Vector<Client>();
	//2. 서버 가동 
	private ServerSocket ss;
	//3. PORT(연결선) 
	private final int PORT=3355;//0~65535사이에서 결정 
	// 서버가동 
	// 접속시에 처리 => waitVc저장에 저장 
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);
			System.out.println("Server Start!!");
		}catch(Exception ex) {}
	}
	public void run()
	{
		while(true)
		{
			try
			{
				// 접속시 => IP,PORT를 저장 
				Socket s=ss.accept(); // 전화 접속 => 발신자 번호
				// 서버에서는 저장을 하고 => 통신을 시작해라
				Client c=new Client(s);
				waitVc.add(c);
				c.start();
			}catch(Exception ex){}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server s=new Server();
        new Thread(s).start();
	}
    // 접속한 클라이언트와 통신 (요청 => 응답) ==> JSP
	class Client extends Thread
	{
		//통신 => 입출력 
		//클라이언트로부터 요청을 받는다
		BufferedReader in;
		//클라이언트로 값을 전송
		OutputStream out;
		//전화 받기
		Socket s;
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				in=new BufferedReader(
						new InputStreamReader(
								s.getInputStream()));
				out=s.getOutputStream();
			}catch(Exception ex) {}
		}
		
		// 실제 통신
		public void run() // 쓰레드 동작을 코딩 
		{
			while(true)
			{
				try
				{
					// 클라이언트가 보내준 요청을 읽는다 
					String msg=in.readLine();
					// 접속한 모든 사람에게 전송 
					for(Client c:waitVc)
					{
						c.out.write((msg+"\n").getBytes());
						// 네트워크 => 1byte => 받을때 2byte로 변환 
					}
				}catch(Exception ex) {}
			}
				
		}
	}
}






