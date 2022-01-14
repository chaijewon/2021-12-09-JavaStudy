package com.sist.main;
// 사용자 요청 => 오라클처리 (INSERT,UPDATE,DELETE,SELECT)
// 사용자 대신 오라클연동을 위해서 SQL문장 만들어서 처리 
// DAO => 오라클은 연결해 주는 클래스 
import java.sql.*; 
/*
 *  Connection : 오라클 연결 
 *  PreparedStatement : SQL문장 송수신 
 *  ResultSet : 결과값을 메모리에 저장 
 */
import java.util.*; // List => 결과값을 모아서 저장 
// Zipcode : 우편번호 한개에 대한 정보를 가지고 있다 
// 우편번호 여러개 요청 => List<Zipcode>
/*
 *    1. 드라이버 등록 Class.forName()
 *    2. 오라클 연결  Connection getConnection(URL,"user","password")
 *    3. SQL문장 전송 : PreparedStatement => conn.preparedStatement(sql)
 *    4. SQL문장 실행 요청 
 *         = SELECT : 결과값을 읽어 온다 ==> executeQuery()
 *         = INSERT,UPDATE,DELETE : 오라클 자체 처리 ==> executeUpdate() 
 *                                                 ==> commit()
 *                                         *** 자바는 autocommit()
 *    *** SQL문장 
 *    
 *    285~293page 
 */
/*
 *   JDBC ====> DBCP =====> ORM 
 *   -----      ----        ---- 라이브러리 (MyBatis,Hibernate, JPA)
 *               웹(속도 최적화)             --------(*)
 *   Spring : 자바(코틀린) ,  MyBatis , JSP 
 *   -------  서버 역할 <==> Front연결 
 *            Spring-Boot
 */
public class ZipcodeDAO {
     // 오라클 연결 객체 생성 
	 private Connection conn;
	 // 오라클로 송수신 객체 생성 
	 private PreparedStatement ps;
	 // URL주소 
	 private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	 
	 // 드라이버 등록 => 한번만 수행 (생성자)
	 public ZipcodeDAO()
	 {
		 try
		 {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 // ojdbc8.jar => 반드시 추가 (Oracle에서 제공) 
			 // 데이터베이스 => 각 업체에서 다운로드 (MySQL,MariaDB)
		 }catch(Exception ex) {}
	 }
	 // 오라클 연결 
	 public void getConnection()
	 {
		 try
		 {
			 conn=DriverManager.getConnection(URL,"hr","happy");
		 }catch(Exception ex) {}
	 }
	 // 오라클 종료
	 public void disConnection()
	 {
		 try
		 {
			 if(ps!=null) ps.close();
			 if(conn!=null) conn.close();
		 }catch(Exception ex) {}
	 }
	 // 기능 => 우편번호 찾기 , 검색 갯수 확인
	 public int zipcodeFindCount(String dong)
	 {
		 // count(*) 
		 int count=0;
		 try
		 {
			 // 1. 연결 
			 getConnection();
			 // 2. SQL문장 제작
			 String sql="SELECT COUNT(*) "
					   +"FROM zipcode "
					   +"WHERE dong LIKE '%'||?||'%'";
			 // 3. 오라클로 SQL문장 전송 
			 ps=conn.prepareStatement(sql);
			 // ?에 값을 채운다 
			 ps.setString(1, dong);
			 // 4. SQL실행 후 결과값을 읽어 온다 
			 ResultSet rs=ps.executeQuery();
			 // 5. 읽어온 데이터를 변수에 대입 
			 rs.next(); // 실제 데이터 출력위치에 커서 올리기
			 // 커서가 있는 위치의 데이터를 가지고 온다 
			 count=rs.getInt(1);
			 
			 rs.close();
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
			 // 에러 확인 
		 }
		 finally
		 {
			 disConnection();// 오라클 해제
		 }
		 return count;
	 }
	 // 실제 우편번호를 찾아 온다 
	 public List<Zipcode> zipcodeListData(String dong)
	 {
		 List<Zipcode> list=new ArrayList<Zipcode>();
		 try
		 {
			 // 1. 연결 
			 getConnection();
			 // 2. SQL문장 제작 
			 String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					   +"FROM zipcode "
					   +"WHERE dong LIKE '%'||?||'%'";
			 // 테이블명과 컬럼명이 동일해도 무관하다 
			 // 문제가 발생 
			 // 3. 오라클로 SQL문장 전송 
			 ps=conn.prepareStatement(sql);
			 // 4. ?에 값을 채워준다 
			 ps.setString(1, dong);//dong => 사용자가 보내준 값 
			 // 5. SQL문장을 실행하고 결과값을 읽어 와라 
			 ResultSet rs=ps.executeQuery();
			 // 6. ResultSet에 들어가 있는 결과값을 List에 값을 채워준다 
			 while(rs.next())
			 {
				 Zipcode z=new Zipcode();
				 z.setZipcode(rs.getString(1));
				 z.setSido(rs.getString(2));
				 z.setGugun(rs.getString(3));
				 z.setDong(rs.getString(4));
				 z.setBunji(rs.getString(5));
				 
				 list.add(z);// 읽어온 우편번호를 추가 한다 
				 
			 }
			 rs.close();
		 }catch(Exception ex)
		 {
			 // 오류 확인
			 ex.printStackTrace();
		 }
		 finally
		 {
			 // 닫기
			 disConnection();
		 }
		 return list;
	 }
}











