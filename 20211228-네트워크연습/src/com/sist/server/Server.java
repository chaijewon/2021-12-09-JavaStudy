package com.sist.server;
// ==> Server : 사용자 요청 => 처리 => 결과값을 전송한다 
// ==> 접속시 처리 / 사용자마다 통신 (Thread)
import java.util.*; // StringTokenizer , 저장 (사용자 정보) ArrayList

import com.sist.common.Function;

import java.net.*; // 네트워크 관련 
import java.io.*; // 읽기 (readLine)/ 쓰기 (write) 
// 접속시 처리 => 쓰레드 Runnable=>구현이 안된 메소드 (run())
public class Server implements Runnable{
    // 서버 구동 : ServerSocket
	// 접속자 정보 저장 => ArrayList
	// 서버 => 접속하는 라인선 ==> 포트번호 => 고정 => 3355
	private ServerSocket ss;
	private ArrayList<Client> waitVc=new ArrayList<Client>();
    //1. 서버 구동 => 한번만 사용 => 한번만 수행하는 메소드 (생성자)
	public Server()
	{
	    try
	    {
	    	ss=new ServerSocket(3355); // 서버 구동 완료 
	    	// bind() : 개통 , listen() : 대기상태 
	    	System.out.println("Server Start...");
	    }catch(Exception ex) {}
	}
	// 접속시에 처리하는 메소드 (쓰레드)
	public void run()
	{
		while(true) // 서버거 종료하기 전까지 접속을 받는다 
		{
			try
			{
				// Server:Socket=>Client정보
				Socket s=ss.accept(); // 접속시에 호출되는 메소드 => 접속한 클라이언트의 정보 리턴 
				// 클라이언트 정보 (클라이언트 : IP , PORT)
				// Socket ==> 쓰레드에 전송하면 => 쓰레드는 한사람만 통신이 가능하게 만든다 
				//Client:Socket=>Server정보 
			}catch(Exception ex){}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/////////////////// 접속시 처리 ==> 기지국(교환)
	// 접속자 정보를 저장한 후에 ==> Thread를 연결해 주는 역할 
	// 통신 => 로그인 처리 , 채팅 처리 , 나가기 처리 
	class Client extends Thread
	{
		// 쓰레드 확장 
		private String id;
		private String sex;
		private String name;
		/// 접속자 기본 정보 ====> 로그인시에 클라이언트가 전송 
		/// 네트워크 관련 
		private OutputStream out; // => 요청시에 처리 결과값을 보내주는 역할 
		private BufferedReader in;// => 클라이언트 요청
		private Socket s; // 통신도구
		
		public Client(Socket s)
		{
			// 접속자와 연결 
			try
			{
				// 전화를 받는다
				this.s=s;
				// 송신
				out=s.getOutputStream();
				// 수신
				in=new BufferedReader(
						new InputStreamReader(s.getInputStream()));
			    /*
			     *   char => 1byte(싱글바이트) => ASC(아스키) 
			     *           0~256 (C/C++)
			     *   char => 2byte(멀티바이트) => Unicode
			     *           0~65535(Java,C#)
			     *   *** ASC VS Unicode 
			     */
			}catch(Exception ex) {}
		}
		
		// 통신 시작 => 서버는 1개 ==> 클라이언트가 여러명이기 때문에
		// 접속자마다 => 통신을 따라 할 수 있게 만든다 
		public void run()
		{
			try
			{
				while(true)
				{
					//1. 접속자의 요청을 받는다 
					String msg=in.readLine();
					// readLine() => \n까지 읽는 메소드 
					// 100|hong|홍길동|남자\n ==>
					StringTokenizer st=
							new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());
					// 가독성 
					switch(protocol)
					{
					  case Function.LOGIN:
					  {
						  // 로그인 요청 => 전송데이터를 저장 
						  id=st.nextToken();
						  name=st.nextToken();
						  sex=st.nextToken();
						  // 이전에 접속한 사람들에게 정보를 전송 
						  messageAll(Function.LOGIN+"|"
								  +id+"|"+name+"|"+sex);
						  
						  messageAll(Function.CHAT+"|[알림 ☞] "+name+"님이 접속하셨습니다");
						  
						  // 로그인한 사람을 ArrayList에 추가 
						  waitVc.add(this);
						  // 화면 변경 
						  messageTo(Function.MYLOG+"|"+name);
						  // 이전에 접속자 정보를 로그인 하는 사람에게 전송
						  
						  for(Client c:waitVc)
						  {
							  messageTo(Function.LOGIN+"|"+c.id+"|"
						       +c.name+"|"+c.sex);
							  
						  }
						  
					  }
					  break;
					  case Function.CHAT:
					  {
						  
					  }
					  break;
					  case Function.EXIT:
					  {
						  
					  }
					  break;
					}
				}
			}catch(Exception ex){}
		}
		
		// 경우수가 2가지
		// => 접속자 전체에 메세지 전송 (여러명)
		// 동기화 설정 synchronized
		/*
		 *   |
		 *   | ====>
		 *   | ====>
		 *   | ====>    비동기화 
		 *   |
		 *   
		 *   |
		 *   | ======> 
		 *   |        =======>
		 *   |                ========>
		 *   |
		 */
		public synchronized void messageAll(String msg) //동기화 
		{
			for(int i=0;i<waitVc.size();i++) //waitVc는 접속한 모든 사람들 
		    {
			  try
			  {
				  Client c=waitVc.get(i);
				  c.messageTo(msg);
			  }catch(Exception ex)
			  {
				  waitVc.remove(i);// 메세지를 받지 않는 사람들은 제거 
			  }
		    }
			
		}
		// => 접속한 사람에게 메세지 전송 (한명) 
		public void messageTo(String msg) // 비동기화 
		{
			try
			{
				out.write((msg+"\n").getBytes());//byte[]로 변경(인코딩) 
				// decoding => InputStreamReader => 필터스트림  
			}catch(Exception ex){}
		}
	}

}








