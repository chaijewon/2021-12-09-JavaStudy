package com.sist.main;
// 오라클 컬럼과 자바의 멤버변수 매칭 
// 오라클 => 원본은 그대로 유지 , 자바 메모리에 저장된 데이터가 변경 
// 오라클에 있는 데이터를 읽어와서 메모리에 저장 => 자바로 제어 
// JSP(웹프로그램) ==> 핵심 (오라클 연동) => IO
// 사용자 요청값 (받기) , 결과 전송(브라우저)
// 1차 => 오라클 연동 
// 2차 => 실무 (오라클 연동 , REST API(OpenAPI=> 공공데이터,서울시 데이터...) 
// 3차 => 현재 사용중이 최신기술 
// 1,2,3 => AWS에 배포 ...
// 소회의실 ==> 조별 (소개,테마)=> 사이트 => 요구사항 (어떤 기능 구현)
// 테마 => 예약과 관련 , 스트리밍 , 추천 , 코스 , 쇼핑몰(결제)...
// 4시 ~ 5시 30분 
// 프로젝트 ==> 세미프로젝트 (70~85% --> 15%조별) 
import java.util.*;
// ~VO  EmpVO , MovieVO .... FoodVO 
// 데이터 무결성 => 캡슐화 
public class Emp {
     private int empno;  // empno NUMBER
     private String ename; // ename VARCHAR2
     private String job; // job VARCHAR2
     private int mgr; // mgr NUMBER
     private Date hiredate; // hiredate DATE
     private int sal; // sal NUMBER
     private int comm; // comm NUMBER
     private int deptno; //deptno NUMBER
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
  
}
