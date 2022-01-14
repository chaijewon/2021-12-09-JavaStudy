package com.sist.main;
// JSP (웹)
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 오라클 연동하는 클래스를 메모리에 저장 
		EmpDAO dao=new EmpDAO();
		/*// 요청후 데이터를 얻어 온다 => empListData()
		List<Emp> list=dao.empListData();
		// 사용자 => 데이터 출력 
		for(Emp e:list)
		{
			System.out.println(e.getEmpno()+" "
					+e.getEname()+" "
					+e.getJob()+" "
					+e.getHiredate().toString()+" "
					+e.getSal());
		}*/
		/*Scanner scan=new Scanner(System.in);
		System.out.print("사번입력:");
		int empno=scan.nextInt();
		// Front(뷰단) , Back(서버단) , DBA (DB단)
		Emp emp=dao.empDetailData(empno);
		// 요청 처리 (메소드 안에서) ==> 결과값을 전송 (Emp:한명에 대한 정보를 가지고 있다)
		// 모든 클래스의 설계는 1개,한명을 설계한다 ==> 여러개,여러명 : new를 여러번 사용
		// 사용자에게 출력 
		System.out.println("--------------- 실행 결과 -----------------");
		System.out.println("사번:"+emp.getEmpno());
		System.out.println("이름:"+emp.getEname());
		System.out.println("직위:"+emp.getJob());
		System.out.println("입사일:"+emp.getHiredate().toString());
		System.out.println("급여:"+emp.getSal());
		System.out.println("성과급:"+(emp.getComm()==0?"없음":emp.getComm()));
		System.out.println("-----------------------------------------");*/
		Scanner scan=new Scanner(System.in);
		System.out.print("검색할 사원의 이름 입력:");
		String ename=scan.next();
		// 오라클로부터 데이터 받기 
		List<Emp> list=dao.empFindData(ename);
		// 출력 => 사용자가 볼 수 있게 만들어 준다 
		for(Emp e:list)
		{
			System.out.println("사번:"+e.getEmpno());
			System.out.println("이름:"+e.getEname());
			System.out.println("직위:"+e.getJob());
			System.out.println("입사일:"+e.getHiredate().toString());
			System.out.println("급여:"+e.getSal());
			System.out.println("성과급:"+(e.getComm()==0?"없음":e.getComm()));
			System.out.println("---------------------------");
		}
		
	}

}
