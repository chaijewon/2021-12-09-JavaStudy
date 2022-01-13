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
}













