package com.sist.server;
/*
 *   사용 클래스 
 *   =========
 *    1. 서버구동  =======> ServerSocket
 *    2. 접속자 정보 저장 ==> ArrayList
 *    3. 음악 정보 저장  ==> ArrayList ===> ObjectInputStream 
 *    4. 통신   
 *        송신 : 결과값  ==> OutputStream
 *        수신 : 요청을 받는다 ==> BufferedReader 
 *        
 *    ===============================================
 *      1. 서버구동 
 *         1) 소켓을 생성 
 *         2) 대기상태 
 *      2. 접속자 접속대기 
 *         1) 접속자의 정보를 받는다
 *         2) 접속자마다 따로 통신이 가능하게 만든다 (프로그램을 별도로 수행)
 *                                           ================== 쓰레드 
 *      =============웹 서버 , 오라클 서버 ========================
 *      3. 접속자와 통신 (쓰레드)
 *         ==========
 *         웹프로그램 : 파일을 이용한다 
 *  
 */
import java.util.*;
import java.io.*;
import java.net.*;
///// 자바 라이브러리 
import com.sist.music.*;
import com.sist.common.*;
///// 사용자 정의 라이브러리 
/*
 *    클래스 
 *     = 사용자 정의 클래스 (프로그래머가 제작)
 *     = 자바에서 지원하는 클래스 , Open API(외부에 제공)
 *       *** Open Api (Jsoup,Spring(open source),MyBatis(google))
 *     ==================== 조립해서 한개 프로그램 ===================
 *     ==> 70~80% 자바,외부라이브러리 사용 
 *     ==> 30~20% 사용자가 만들어서 사용 
 *     ==> 자바는 조립형 프로그램 , CBD 
 */
public class Server implements Runnable{
    private static ArrayList<Music> mList=new ArrayList<Music>();
    // 뮤직 데이터를 저장할 공간
    private ArrayList<Client> cList=new ArrayList<Client>();
    // 접속자의 정보를 저장한다 (ID,NAME,IP,PORT)
    private ServerSocket ss;
    // 기지국 => 접속을 받아서 연결
    // 1. 변수의 초기화 
    /*
     *    기본 데이터 (디폴트 설정) => 멤버변수는 기본 데이터값을 가지고 있다
     *      int : 0
     *      long : 0L
     *      double : 0.0
     *      float :0.0F
     *      boolean :false
     *      객체 : null (주소가 배정이 안된 상태)
     *             *** 메소드안에 선언된 변수를 지역변수는 초기화(X) 
     *                 =>반드시 초기화를 한다 
     *     명시적인 초기화 : 선언과 동시에 값을 부여 
     *     int a=10; ArrayList list=new ArrayList()
     *     초기화 블록 : 명시적으로 초기화를 하지 못하는 경우 
     *                *** 클래스영역에 설정된 변수는 선언만 가능 (구현(X))
     *                *** 구현 => 제어문 , 외부 파일 읽기 , 데이터베이스 연결 
     *     {} =========> 인스턴스 블록 (인스턴스 변수에 대한 초기화) 
     *     static{} ===> 정적 블록 (static 변수를 초기화 할 경우에 사용)
     *     
     *     생성자 ==> 초기화 가능 
     *     
     */
    static 
    {
    	// 자동으로 읽어서 처리 
    	// 파일을 읽어서 ArrayList에 저장후 사용 
    	FileInputStream fis=null;
    	ObjectInputStream ois=null;
    	try
    	{
    		fis=new FileInputStream("c:\\java_data\\music_object.txt");
    		// 읽은 파일을 => 객체 단위로 저장 
    		ois=new ObjectInputStream(fis);
    		// ArrayList에 저장 
    		mList=(ArrayList<Music>)ois.readObject();
    	}catch(Exception ex)
    	{
    		// 에러 처리 => 에러 확인 
    		ex.printStackTrace();
    	}
    	finally
    	{
    		// 파일 닫기 
    		try
    		{
    		  fis.close();
    		  ois.close();
    		}catch(Exception ex){}
    	}
    }
    public Server()
    {
    	// 호출시에 설정 
    	// 서버 구동 
    	try
    	{
    		ss=new ServerSocket(3355); // port=> 반드시 고정
    		// port => 프로그래머가 만들어서 사용 , 0~65535(0~1023:사용중) 
    		// 클라이언트는 시스템에 의해 자동 생성 
    		// 구동하고 있다 (알림)
    		// bind():ip,port(유심):핸드폰 개통 ==> listen():대기상태
    		System.out.println("Music Server Start...");
    	}catch(Exception ex){}
    }
    // 접속시 처리 
    public void run()
    {
    	try
    	{
    		Socket s=ss.accept(); // 접속이 되면 => 사용자의 정보 (Socket)
    	    // Socket => ip/port => 통신이 가능 
    		// ==> Socket => 쓰레드로 전송해서 접속자마다 통신이 가능하게 만들어준다 
    	    Client client=new Client(s);
    	    client.start(); // 소켓을 넘겨주고 해당 접속자와 통신을 시작한다 
    	}catch(Exception ex){}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 구동 
		Server server=new Server(); // 생성자 호출 (구동)
		new Thread(server).start(); // run()호출 => 접속자 접속처리 
	}
	// 통신 담당 클래스 => 반드시 (접속자마다 따로 생성) => 프로그램을 별도로 수행 (쓰레드)
	// 프로그램(프로세서)안에서 여러개의 다른 프로그램을 수행 => 쓰레드 
	// 쓰레드는 반드시 동작을 할때 run() ==> run()을 호출시에는 반드시 start()
	// 쓰레드를 이용해서 통신을 시작한다 (접속자 정보) 
	/*
	 *   => Server/Client ==> 내부 클래스 이용 
	 *   내부클래스 : 윈도우(javax.swing),쓰레드,빅데이터
	 *   ==>멤버 클래스
	 *   class Server
	 *   {
	 *      ArrayList cList=new ArrayList() ==> Server에서 사용 가능
	 *      class Client
	 *      {
	 *         cList는 언제든지 사용이 가능 
	 *      }
	 *   }
	 *   ==> 익명의 클래스 : 상속없이 재정의(오버라이딩) 
	 *   ==> 쓰레드,윈도우에서 등장 
	 */
	class Client extends Thread // 접속자 마다 생성되는 클래스 (별도로 동작)
	{
		Socket s;
		// 입출력 => 통신 연결 기기 
		OutputStream out; // 송신 (요청처리 결과를 보내줄때 사용)
		BufferedReader in; // 수신 (사용자의 요청을 받는 경우에 사용)
		//확장(접속자 구분) 
		String id,name; // 로그인할 때 전송을 받는다 
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				// 모든 프로그램 언어 (C/C++,C#,Python,Kotlin)
				// => 지역변수(메소드안에 선언된 변수,매개변수) 우선순위
				// 지역변수 => 멤버변수 
				// 지역변수와 멤버변수명이 같은 경우는 구분 => this(Client  객체) 
			    // 입출력(통신)을 할 수 있게 연결 
				// 입력
				in=new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				// 출력 
				out=s.getOutputStream();//추상클래스 
				/*
				 *   추상클래스 
				 *   인터페이스 (추상클래스의 일종)
				 *   ======================== 미완성된 클래스
				 *                            -----(메소드가 구현)
				 *   ==> 사용법은 반드시 구현된 클래스를 이용해서 메모리 할당을 한다 
				 *   List (인터페이스)
				 *    | 구현 
				 *  ArrayList
				 *  
				 *   List list=new ArrayList()
				 *   
				 *   ==> 서로 다른 클래스 묶어서 관리 
				 *   ==> 관련된 클래스 ==> 웹 
				 *   ==> 여러개가 있는 경우 ==> 반드시 고민 (한개의 이름으로 전체를 제어) 
				 *       =====
				 *        변수 ====> 배열 , 클래스
				 *        클래스 ===> 인터페이스 , 추상클래스 
				 */
			}catch(Exception ex){}
		}
		// 통신을 한다 => run()
		public void run()
		{
			while(true)
			{
				try
				{
					//1. 사용자 요청 
					String msg=in.readLine();
					// readLine() ==> 맨 마지막에 => \n이 반드시 존재 
					//2. 기능별 처리 
					StringTokenizer st=
							new StringTokenizer(msg,"|");
					//3. 어떤 요청이냐? => 상수 
					int protocol=Integer.parseInt(st.nextToken());
					// 전송시에 => 100|로그인 데이터\n
					switch(protocol)
					{
					  case Function.LOGIN:
					  {
						  // login처리 => 화면 변경 => 음악 데이터 전송 
						  // 데이터 받기 
						  id=st.nextToken();
						  name=st.nextToken();
						  // 저장 (접속자 정보)
						  cList.add(this); // id,name,s,in,out
						  // 2. 로그인 => 음악 화면 변경 
						  messageTo(Function.MYLOG+"|"+name);
						  // 3. 음악 데이터를 전송한다 
						  StringBuffer sb=new StringBuffer();
						  for(Music m:mList)
						  {
							  String music=m.getNo()+"%"
									     +m.getTitle()+"%"
									     +m.getSinger()+"%"
									     +m.getAlbum()+"^";
							  sb.append(music);
						  }
						  
						  messageTo(Function.LIST+"|"+sb.toString());
					  }
					  break;
					  case Function.LIST:
					  {
						  StringBuffer sb=new StringBuffer();
						  for(Music m:mList)
						  {
							  String music=m.getNo()+"%"
									     +m.getTitle()+"%"
									     +m.getSinger()+"%"
									     +m.getAlbum()+"^";
							  sb.append(music);
						  }
						  
						  messageTo(Function.LIST+"|"+sb.toString());
					  }
					  break;
					  // 받기 (요청) => 데이터를 제어 => 결과값을 보내준다 
					  case Function.FIND:
					  {
						  // 음악 검색어를 받아서 => 찾은 데이터 전송 
						  StringBuffer sb=new StringBuffer();
						  // 검색어를 받는다 
						  String ss=st.nextToken();
						  // 찾기 
						  for(Music m:mList)
						  {
							  if(m.getTitle().contains(ss))
							  {
								  String music=m.getNo()+"%"
										     +m.getTitle()+"%"
										     +m.getSinger()+"%"
										     +m.getAlbum()+"^";
								  sb.append(music);
							  }
						  }
						  
						  // 찾은 내용을 사용자에게 보낸다 
						  messageTo(Function.FIND+"|"+sb.toString());
						  /*
						   *   서버 기능 
						   *   1. 데이터 받기 : BufferedReader
						   *                  => readLine()
						   *   2. 데이터 전송 : OutputStream
						   *                  => write()
						   *   3. 데이터 검색 : contains() ,equals()
						   *   4. 데이터 추가 : Login,방만들기 
						   *   5. 데이터 수정 : NickName,방변경
						   *   6. 데이터 삭제 : 나가기 ...
						   *   
						   *   ===> 오라클 , 웹서버
						   */
					  }
					  break;
					}
				}catch(Exception ex){}
			}
		}
		// 데이터를 전송 
		public void messageTo(String msg)
		{
			try
			{
				// out => 접속자에게 데이터를 전송 
				out.write((msg+"\n").getBytes());//1byte전송 => 2byte받는다 
				//      InputStream Reader => InputStreamReader
			}catch(Exception ex){}
		}
		// 반복이 많은 경우에는 => 메소드 처리한다
		// 메소드 : 한개의 기능을 만들어서 재사용할때 
		//         코딩상에서 반복이 많은 경우 
		//         가독성이 좋게 만든다 (에러가 발생시에 빠른 처리가 가능)
	}

}







