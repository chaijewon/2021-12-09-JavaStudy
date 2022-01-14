package com.sist.main;
// 오라클 연동 (오라클 관련)
/*
 *    1. Driver 등록  => oracle.jdbc.driver.OracleDriver
 *                      ------------------ ------------
 *                             패키지명        클래스명
 *         => Class.forName("클래스명")
 *                           ------- 반드시 패키지명.클래스명 
 *         => 한번만 수행 => 생성자에서 주로 등록 
 *         => Class.forName() => 드라이버를 클래스로 제작 
 *            --------------- 리플랙션 (클래스의 정보를 읽어 와서)
 *                            메모리 할당이 가능 
 *                            메소드 호출이 가능 
 *                            
 *    2. 오라클 연결  => 1) URL(오라클 주소) , 2) USER , 3) Password 
 *          => URL(오라클 주소)
 *             jdbc:oracle:thin:@IP(원격):1521:XE(데이터베이스)
 *                              -------- ---- 오라클 연결선
 *                       localhost(127.0.0.1)
 *             USER : hr
 *             Password : happy
 *          => Connection => getConnection(url,"hr","happy")
 *                                             -------------
 *    3. SQL문장 전송 
 *          => PreparedStatement => conn.preparedStatement(sql)
 *    4. 실행 결과 얻기 
 *          => ResultSet rs=ps.executeQuery() => SELECT 
 *             ------------- SELECT로 실행 요청 =>자바에 저장을 해준다 (ResultSet)
 *    5. 닫기 (연결종료)
 *          => ps.close(),conn.close()
 *          
 *    기능 여러개 ==> 오라클 연결 / 오라클 해제 ==> 50개 이상 (오라클 다운)
 *                 ---------   -------- 메소드화 (반복)
 *                 getConnection , disConnection
 *                                 -------------- 반드시 try(정상),catch(오류)
 *                                                상관없이 무조전 연결을 해제 
 *                                                finally
 */
// ~ SELECT : GROUP BY ==> 자바에서 오라클 연동 (DML:SELECT,INSERT,UPDATE,DELETE)
// Connection,ResultSet , PreparedStatement => java.sql
// 컬렉션 => List => java.util
import java.sql.*;
import java.util.*;
public class EmpDAO {
   // Connection을 한개만 사용 
   // PreparedStatement 한개만 사용 ==> 멤버
   private Connection conn;
   private PreparedStatement ps;
   // 멤버변수 (일반 변수,클래스 , 배열, 인터페이스)
   // 오라클 URL주소 
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // 1. 드라이버 등록 
   public EmpDAO()
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
		   // conn hr/happy
	   }catch(Exception ex) {}
   }
   // 3. 오라클 연결 종료 ===> 오라클 연동 필수 조건 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close(); // 사용중이면 
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // 4. 기능(추가, 상세보기,목록 , 수정 , 삭제)
   // 4-1 사원 전체 출력 (Emp => 한명에 대한 정보) => 14개를 모아서 전송 (List)
   // 목록 출력 (게시판 목록,영화목록 , 맛집 목록...)
   public List<Emp> empListData()
   {
	   List<Emp> list=new ArrayList<Emp>();
	   // ROW (Record) => Emp 
	   try
	   {
		   // 1. 연결 (오라클) => 데이터 가지고 올 준비 
		   getConnection();
		   // 2. SQL문장을 만든다(전송은 문자열로) => SQL=> 문장형식 (String) 
		   String sql="SELECT empno,ename,job,hiredate,sal "
				     +"FROM emp";
		   // 오라클 문장이 끝나면 ;을 사용한다 => 자바에서는 ;을 사용하지 않는다 
		   // 3. SQL문장을 오라클 보낸다 
		   ps=conn.prepareStatement(sql);
		   // 4. 필요한 데이터가 없는 경우 ( ? ) => 실행요청을 한다 
		   // 실행한 결과를 받아 본다 
		   ResultSet rs=ps.executeQuery();
		   // 결과값을 List에 저장해서 사용자에게 전송 
		   while(rs.next())
		   {
			   // 처음위치에 커서를 위치 => 한줄씩 읽어서 다음줄로 내려간다
			   // => 데이터가 없는 경우에는 false , 있는 경우=> true
			   Emp e=new Emp();
			   e.setEmpno(rs.getInt(1));
			   e.setEname(rs.getString(2));
			   e.setJob(rs.getString(3));
			   e.setHiredate(rs.getDate(4));
			   e.setSal(rs.getInt(5));
			   
			   list.add(e);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   // 오류 발생시 => 확인 
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 오라클 연결 종료 
		   disConnection();
	   }
	   return list;
   }
   // 4-2 사원 정보 보기 (한명에 대한) => 매개변수 (사용자부터 데이터를 받는 경우에 사용)
   // 상세보기 (게시판내용보기 , 영화상세 , 음악상세)
   public Emp empDetailData(int empno)
   {
	   Emp emp=new Emp();// 사원 한명이 가지고 있다 데이터 모음 
	   // FoodHouse =>  맛집 한개의 값을 채워서 넘겨 준다
	   // 오라클 연결하는 클래스 => CheckException (컴파일시 예외처리 여부 확인)
	   // java.io,java.sql,java.net => 반드시 예외처리를 사용한다 
	   try
	   {
		   // 1. 오라클 연결 
		   getConnection();
		   // 2. SQL문장 
		   //                    1    2    3      4     5    6
		   String sql="SELECT empno,ename,job,hiredate,sal,comm "
				     +"FROM emp "
				     +"WHERE empno=?"; // Primary Key로 설정된 값을 이용 
		   // 3. SQL문장을 전송한후에 ?에 값을 채워준다 
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, empno); // 데이터형을 설정 
		   // setInt() , setDouble() ,setString() ,setDate()
		   // getInt() , getDouble() , getString() , getDate()
		   // 4. 오라클에 실행을 요청한 다음 결과값을 메모리(ResultSet)에 저장해 달라 
		   ResultSet rs=ps.executeQuery();
		   // 커서를 데이터가 출력된 위치로 이동 => next()
		   rs.next();
		   
		   // ResultSet에 있는 데이터를 Emp에 저장 
		   emp.setEmpno(rs.getInt(1));
		   emp.setEname(rs.getString(2));
		   emp.setJob(rs.getString(3));
		   emp.setHiredate(rs.getDate(4));
		   emp.setSal(rs.getInt(5));
		   emp.setComm(rs.getInt(6));
		   
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   // 에러 확인 
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 오라클 종료 
		   disConnection();
	   }
	   return emp;
   }
   // 4-3 사원 찾기 (검색) => 오라클하고 자바에서 제작하는 SQL문장이 약간 틀리다 
   // LIKE 
}











