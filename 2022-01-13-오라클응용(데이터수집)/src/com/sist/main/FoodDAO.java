package com.sist.main;
/*
 *    오라클 연결 : JDBC
 *    ***** 드라이버 설정 
 *          thin / oci
 *          ----- Class.forName("oracle.jdbc.driver.OracleDriver")
 *    1. 오라클 연결 
 *       Connection 
 *       ----------- 오라클의 주소 
 *                   jdbc:oracle:thin:@ip:1521:XE(데이터베이스:폴더)
 *                   ---- ------     ------------
 *                         업체명         서버주소
 *                   CREATE DATEBASE project
 *                   getConnection(url,"user명","pwd")
 *                                        hr     happy
 *                   => conn hr/happy
 *    2. SQL문장 전송 (*******)
 *       String sql="SELECT * FROM emp";
 *       PreparedStatement => 전송/결과값을 받는다 
 *    3. 결과값 받기 
 *       메모리에 저장 => ResultSet
 *                    =========== ArrayList => 브러우저로 전송 
 *    4. 오라클 연결 해제  
 *       conn.close()
 *       
 *    ==> 패턴 1개  
 */
import java.sql.*; // Connection,Statement,ResultSet
import java.util.*;
public class FoodDAO {
    // 연결 객체 
	private Connection conn;
	// SQL 전송 객체
	private PreparedStatement ps;
	// URL
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	// 1. 드라이버 등록 : 한번만 등록 => 생성자 
	public FoodDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 2. 오라클 연결 
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	// 3. 오라클 해제
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close(); // 송수신 중이라면 통화중 
			if(conn!=null) conn.close();// 핸드폰 종료 
		}catch(Exception ex) {}
	}
	// 4. 기능 => Category에 데이터 추가 
	// INSERT , UPDATE , DELETE => void
	// SELECT : 데이터 검색 결과를 읽어 온다 (리턴형)
	// 자바 메소드 => 리턴(1개) ,매개변수(기본 3개이상 (X))
	// 3이상이면 묶어서 처리 (배열,클래스)
	public void categoryInsert(Category c)
	{
		try
		{
			// 1. 오라클 연결 
			getConnection();
			// 2. SQL문장 제작
			String sql="INSERT INTO category VALUES(cate_cno_seq.nextval,?,?,?,?)";
			// 3. 오라클로 전송 
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getTitle());
			ps.setString(2, c.getSubject());
			ps.setString(3, c.getPoster());
			ps.setString(4, c.getLink());
			
			// 실행 명령
			ps.executeUpdate(); // @test46
		}catch(Exception ex)
		{
			// 에러 처리 (확인)
			ex.printStackTrace();
		}
		finally
		{
			// try/catch 관련없이 무조건 수행 => 서버닫기 , 오라클 닫기
			disConnection();
		}
	}
	// 맛집 저장 
	/*
	 *     사용자요청 ===> 자바 ====================> 오라클 
	 *                요청 내용을 SQL문장으로 변경        |
	 *                                           SQL을 받아서 실행 
	 *                                              |
	 *                      <==================== 결과값을 자바로 전송
	 *                      |
	 *                 결과값을 사용자에게 응답 
	 *     (자바) / C# / NODEJS / C/C++ / 파이썬 / 스칼라....
	 *      1. 오라클에 연결 (Connection) conn hr/happy
	 *                                ---------------
	 *                                getConnection()
	 *      2. 사용자 요청한 내용을 SQL문장으로 변경 
	 *         ------------------------------
	 *      3. SQL문장을 오라클로 전송 => Statement(PreparedStatement)
	 *         Statement   / PreparedStatement(미리 SQL문장 전송 , 나중에 필요한 데이터를 첨부) 
	 *         ---------     -----------------
	 *          SQL+필요한 데이터를 한번에 전송 
	 *          
	 *          오라클에 데이터 추가를 요청시에 (INSERT~)
	 *          예)
	 *              name , sex , age , address , tel (회원가입)
	 *              
	 *              자바에서 값을 받는다 
	 *              String name="홍길동";
	 *              String sex="남자";
	 *              int age=25;
	 *              String address="서울시";
	 *              String tel="010-1111-1111";
	 *              
	 *              => SQL문장을 전송시에 => 문자열로 전송해야 된다 
	 *              String sql="INSERT INTO member VALUES('"
	 *                        +name+"','",sex+"',"+age
	 *                        +",'"+address+"','"+tel+"')";
	 *              => String => VARCHAR2변경 => '값'
	 *              => Statement 
	 *              => 개발자 요청에 의해서 변경 
	 *              String sql="INSERT INTO member VALUES(?,?,?,?,?)"
	 *              => 나중에 ?에 값을 채운다 
	 *              => setString(1,name) ==> 자동으로 ''가 사용 
	 *                             => '홍길동'
	 *                 setInt()
	 *                 setDouble()
	 *              => 장점 => ''을 사용하지 않는다 (자동으로 추가) => 사용하기 쉽게 
	 *              => 단점 => 소스가 길어진다 
	 *              
	 *       4. 오라클 실행명령어 전송 
	 *          = executeQuery() : SELECT (데이터를 읽어 온다)
	 *          = executeUpdate() => COMMIT이 포함 
	 *                               => 데이터를 읽은 것이 아니라 실행
	 *                               => INSERT , UPDATE , DELETE
	 *                               
	 *       5. 오라클에서 실행된 결과읽기(SELECT) => ResultSet
	 *          ResultSet => Record단위 ,ROW단위로 읽기 
	 *          =========
	 *            데이터를 인출 => 1) 처음 , 2) 마지막 
	 *            
	 *            ---------------------
	 *              ID   Name    Sex
	 *            ---------------------
	 *              aaa  홍길동    남자  ===> 여기서부터 밑으로 내려가면 읽기
	 *                                      next() ***
	 *            ---------------------
	 *              bbb  심청이    여자
	 *            ---------------------
	 *              ccc  박문수    남자  ===> 여기서부터 위로 올라가면서 읽기
	 *                                      previous()
	 *            ---------------------
	 *       6. PreparedStatement / Connection을 닫는다 
	 *                close()          close()
	 *              
	 *              
	 */
	/*
	 *  NO      NOT NULL NUMBER   ==> int      
		CNO              NUMBER   ==> int     
		NAME    NOT NULL VARCHAR2(200)  => String
		SCORE   NOT NULL NUMBER(2,1)    => double
		ADDRESS NOT NULL VARCHAR2(500)  => String 
		TEL     NOT NULL VARCHAR2(30)   => String 
		TYPE    NOT NULL VARCHAR2(100)  => String
		PRICE            VARCHAR2(50)   => String
		PARKING          VARCHAR2(50)   => String
		TIME             VARCHAR2(50)   => String
		MENU             CLOB           => String
		POSTER  NOT NULL VARCHAR2(4000) => String
	 */
	public void foodInsert(FoodHouse food)
	{
		try
		{
			getConnection();// 연결
			// 1. SQL문장 제작 
			String sql="INSERT INTO food_house VALUES("
					  +"fh_no_seq.nextval,?,?,?,?,?,"
					  +"?,?,?,?,?,?)";
			// 2. SQL에 필요한 데이터값 채우기 (?)
			ps=conn.prepareStatement(sql); // 미리 전송 
			ps.setInt(1, food.getCno());
			ps.setString(2, food.getName());
			ps.setDouble(3, food.getScore());
			ps.setString(4, food.getAddress());
			ps.setString(5, food.getTel());
			ps.setString(6, food.getType());
			ps.setString(7, food.getPrice());
			ps.setString(8, food.getParking());
			ps.setString(9, food.getTime());
			ps.setString(10, food.getMenu());
			ps.setString(11, food.getPoster());
			// ?는 순서가 1번부터 시작 (오라클 => 1번부터 시작)
			// 문법은 오라클문법 
			// => 오라클의 SQL문장과 자바에서 보내는 오라클 SQL문장이 다른것도 있다 
			// LIKE 
			/*
			 *    WHERE ename LIKE '%A%';
			 *    WHERE ename LIKE '%'||A||'%' => 97%는 오라클과 동일 , 3%
			 */
			// 3. 오라클에 명령문 실행 요청 
			ps.executeUpdate();
		}catch(Exception ex)
		{
			// 에러 확인 
			ex.printStackTrace();
		}
		finally
		{
			disConnection();//연결 해제 
		}
	}
	// 데이터 읽기 => Category의 link,cno,title
	public List<Category> categoryListData()
	{
		List<Category> list=new ArrayList<Category>();
		try
		{
			// 1. 연결
			getConnection();
			// 2. SQL문장 제작 
			String sql="SELECT cno,title,link "
					  +"FROM category";
			// 3. 필요한 데이터를 전송 (X)
			// 4. 오라클에 실행 명령을 전송 
			ps=conn.prepareStatement(sql);// SQL문장을 오라클로 보낸다 
			// 5. 결과값을 받는다 
			ResultSet rs=ps.executeQuery();// 샐행 결과를 메모리에 저장 
			// 6. 결과값을 List에 첨부 
			while(rs.next()) // 위로부터 아래로 한줄씩 읽어 온다 
			{
				/*
				 *   오라클에 있는 데이터를 자바와 매칭 
				 *   문자열 : getString()
 				 *   실수 : getDouble()
				 *   정수 : getInt()
				 *   날짜 : getDate()
				 */
				Category c=new Category();
				c.setCno(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setLink(rs.getString(3));
				list.add(c);
			}
			rs.close();
			/*
			 *    ---------------------
	 *              ID   Name    Sex
	 *            ---------------------
	 *              aaa  홍길동    남자  ===> 여기서부터 밑으로 내려가면 읽기
	 *                                      next() ***
	 *              1       2      3
	 *              getString(1) , getString(2) , getString(3)
	 *              
	 *              ==> 4.5 => getDouble(번호) , 22/01/14 => getDate(번호)
	 *              ==> 10 => getInt(번호)
	 *            ---------------------
	 *              bbb  심청이    여자
	 *            ---------------------
	 *              ccc  박문수    남자  ===> 여기서부터 위로 올라가면서 읽기
	 *                                      previous()
	 *            ---------------------
			 */
		}catch(Exception ex)
		{
			// 에러 확인 
			ex.printStackTrace();
		}
		finally
		{
			// 해제
			disConnection();
		}
		return list;
	}
	
}













