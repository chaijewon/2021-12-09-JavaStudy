package com.sist.main;
// JSP (��)
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ����Ŭ �����ϴ� Ŭ������ �޸𸮿� ���� 
		EmpDAO dao=new EmpDAO();
		/*// ��û�� �����͸� ��� �´� => empListData()
		List<Emp> list=dao.empListData();
		// ����� => ������ ��� 
		for(Emp e:list)
		{
			System.out.println(e.getEmpno()+" "
					+e.getEname()+" "
					+e.getJob()+" "
					+e.getHiredate().toString()+" "
					+e.getSal());
		}*/
		Scanner scan=new Scanner(System.in);
		System.out.print("����Է�:");
		int empno=scan.nextInt();
		// Front(���) , Back(������) , DBA (DB��)
		Emp emp=dao.empDetailData(empno);
		// ��û ó�� (�޼ҵ� �ȿ���) ==> ������� ���� (Emp:�Ѹ� ���� ������ ������ �ִ�)
		// ��� Ŭ������ ����� 1��,�Ѹ��� �����Ѵ� ==> ������,������ : new�� ������ ���
		// ����ڿ��� ��� 
		System.out.println("--------------- ���� ��� -----------------");
		System.out.println("���:"+emp.getEmpno());
		System.out.println("�̸�:"+emp.getEname());
		System.out.println("����:"+emp.getJob());
		System.out.println("�Ի���:"+emp.getHiredate().toString());
		System.out.println("�޿�:"+emp.getSal());
		System.out.println("������:"+(emp.getComm()==0?"����":emp.getComm()));
		System.out.println("-----------------------------------------");
		
	}

}
