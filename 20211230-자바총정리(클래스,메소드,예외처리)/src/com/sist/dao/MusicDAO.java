package com.sist.dao;
import java.sql.*;
import java.util.*;

import com.sist.common.DataBase;
/*
 *    DB2 : 대용량 데이터베이스 : 금융권 , 공기업 , 학교
 *    =================
 *    중형 
 *    Oracle : 대기업
 *    MS-SQL : 시청 ... (MS)
 *    =================
 *    중소형 ====================> 실무에서는 가장 많이 사용 (무료)
 *    MY-SQL : 오라클 
 *    MariaDB : MySQL에서 나와서 새롭게 만든다 
 *    =================
 *    소형 
 *    SQLITE : 핸드폰 
 *    =================
 */
/*
 *    클래스  : 대문자 시작
 *    변수  : 소문자 
 *    상수  : 전체 대문자
 *    메소드 : 소문자 
 *    괄호 
 *    public void display(){
 *       if(){
 *       }else{
 *       }
 *       
 *    }
 */
public class MusicDAO implements DataBase{
    // 연결 객체 (오라클) 
	private Connection conn;
	// 오라클로 명령어 전송 
	private PreparedStatement ps;
	// 오라클 주소 => 대소문자 구분을 하지 않는다 
	// SELECT ~~    ,  select , Select , SeLeCt => 키워드는 대문자 
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 1. 드라이버 등록 : 한번만 수행 => 생성자 
	public MusicDAO()
	{
		try
		{
			//  드라이버 등록 , 서버연결 , 쓰레드 동작 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex){}
	}
	// 2. 오라클 연결 
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
			// 오라클 => conn hr/happy
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	// 3. 오라클 해제
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
			// exit
		}catch(Exception ex) {}
	}
	// 4. 기능 ====> 오라클 데이터 추가 
	@Override
	public void dbInsert(Object obj){
		// TODO Auto-generated method stub
		try 
		{
			Music m=(Music)obj;
			//1.연결 
			getConnection();
			//2.오라클 명령문 전송 => SQL
			/*
			 *   SQL 
			 *    = DML =  데이터 조작언어
			 *      SELECT : 데이터 검색 
			 *      INSERT : 데이터 추가
			 *      UPDATE : 데이터 수정
			 *      DELETE : 데이터 삭제
			 *    = DDL =  데이터 선언언어 
			 *      TABLE / VIEW / SEQUENCE / INDEX / PROCEDURE
			 *      FUNCTION / TRIGGER
			 *      CREATE :  데이터베이스 설계 (정규화)
			 *      DROP
			 *      ALTER
			 *      RENAME
			 *      TRUNCATE
			 *    = DCL =  데이터 제어언어
			 *      GRANT
			 *      REVOKE 
			 *    = TCL =  트랜잭션 제어 언어
			 *      COMMIT
			 *      ROLLBACK  
			 */
			String sql="INSERT INTO genie_music VALUES(?,?,?,?,?,?,?,?,?)";
			//3.값을 채워서 실행 명령
			ps=conn.prepareStatement(sql);
			ps.setInt(1,m.getNo() );
			ps.setString(2, m.getTitle());
			ps.setString(3, m.getSinger());
			ps.setString(4, m.getAlbum());
			ps.setInt(5, m.getRank());
			ps.setString(6, m.getState());
			ps.setInt(7, m.getIdcrement());
			ps.setString(8, m.getKey());
			ps.setString(9, m.getPoster());
			
			ps.executeUpdate(); // 녹색화살표 , 엔터 
			// COMMIT ==. AutoCommit
		}catch(Exception ex)
		{
			// 에러체크
			ex.printStackTrace();
		}
		finally
		{
			// 오라클 종료 
			disConnection();
		}
	}
}










