package com.sist.main;
// ����Ŭ �÷��� �ڹ��� ������� ��Ī 
// ����Ŭ => ������ �״�� ���� , �ڹ� �޸𸮿� ����� �����Ͱ� ���� 
// ����Ŭ�� �ִ� �����͸� �о�ͼ� �޸𸮿� ���� => �ڹٷ� ���� 
// JSP(�����α׷�) ==> �ٽ� (����Ŭ ����) => IO
// ����� ��û�� (�ޱ�) , ��� ����(������)
// 1�� => ����Ŭ ���� 
// 2�� => �ǹ� (����Ŭ ���� , REST API(OpenAPI=> ����������,����� ������...) 
// 3�� => ���� ������� �ֽű�� 
// 1,2,3 => AWS�� ���� ...
// ��ȸ�ǽ� ==> ���� (�Ұ�,�׸�)=> ����Ʈ => �䱸���� (� ��� ����)
// �׸� => ����� ���� , ��Ʈ���� , ��õ , �ڽ� , ���θ�(����)...
// 4�� ~ 5�� 30�� 
// ������Ʈ ==> ����������Ʈ (70~85% --> 15%����) 
import java.util.*;
// ~VO  EmpVO , MovieVO .... FoodVO 
// ������ ���Ἲ => ĸ��ȭ 
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
