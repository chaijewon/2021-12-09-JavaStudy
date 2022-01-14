package com.sist.main;
// ����Ŭ ���� (����Ŭ ����)
/*
 *    1. Driver ���  => oracle.jdbc.driver.OracleDriver
 *                      ------------------ ------------
 *                             ��Ű����        Ŭ������
 *         => Class.forName("Ŭ������")
 *                           ------- �ݵ�� ��Ű����.Ŭ������ 
 *         => �ѹ��� ���� => �����ڿ��� �ַ� ��� 
 *         => Class.forName() => ����̹��� Ŭ������ ���� 
 *            --------------- ���÷��� (Ŭ������ ������ �о� �ͼ�)
 *                            �޸� �Ҵ��� ���� 
 *                            �޼ҵ� ȣ���� ���� 
 *                            
 *    2. ����Ŭ ����  => 1) URL(����Ŭ �ּ�) , 2) USER , 3) Password 
 *          => URL(����Ŭ �ּ�)
 *             jdbc:oracle:thin:@IP(����):1521:XE(�����ͺ��̽�)
 *                              -------- ---- ����Ŭ ���ἱ
 *                       localhost(127.0.0.1)
 *             USER : hr
 *             Password : happy
 *          => Connection => getConnection(url,"hr","happy")
 *                                             -------------
 *    3. SQL���� ���� 
 *          => PreparedStatement => conn.preparedStatement(sql)
 *    4. ���� ��� ��� 
 *          => ResultSet rs=ps.executeQuery() => SELECT 
 *             ------------- SELECT�� ���� ��û =>�ڹٿ� ������ ���ش� (ResultSet)
 *    5. �ݱ� (��������)
 *          => ps.close(),conn.close()
 *          
 *    ��� ������ ==> ����Ŭ ���� / ����Ŭ ���� ==> 50�� �̻� (����Ŭ �ٿ�)
 *                 ---------   -------- �޼ҵ�ȭ (�ݺ�)
 *                 getConnection , disConnection
 *                                 -------------- �ݵ�� try(����),catch(����)
 *                                                ������� ������ ������ ���� 
 *                                                finally
 */
// ~ SELECT : GROUP BY ==> �ڹٿ��� ����Ŭ ���� (DML:SELECT,INSERT,UPDATE,DELETE)
// Connection,ResultSet , PreparedStatement => java.sql
// �÷��� => List => java.util
import java.sql.*;
import java.util.*;
public class EmpDAO {
   // Connection�� �Ѱ��� ��� 
   // PreparedStatement �Ѱ��� ��� ==> ���
   private Connection conn;
   private PreparedStatement ps;
   // ������� (�Ϲ� ����,Ŭ���� , �迭, �������̽�)
   // ����Ŭ URL�ּ� 
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // 1. ����̹� ��� 
   public EmpDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex) {}
   }
   // 2. ����Ŭ ���� 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
		   // conn hr/happy
	   }catch(Exception ex) {}
   }
   // 3. ����Ŭ ���� ���� ===> ����Ŭ ���� �ʼ� ���� 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close(); // ������̸� 
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // 4. ���(�߰�, �󼼺���,��� , ���� , ����)
   // 4-1 ��� ��ü ��� (Emp => �Ѹ� ���� ����) => 14���� ��Ƽ� ���� (List)
   // ��� ��� (�Խ��� ���,��ȭ��� , ���� ���...)
   public List<Emp> empListData()
   {
	   List<Emp> list=new ArrayList<Emp>();
	   // ROW (Record) => Emp 
	   try
	   {
		   // 1. ���� (����Ŭ) => ������ ������ �� �غ� 
		   getConnection();
		   // 2. SQL������ �����(������ ���ڿ���) => SQL=> �������� (String) 
		   String sql="SELECT empno,ename,job,hiredate,sal "
				     +"FROM emp";
		   // ����Ŭ ������ ������ ;�� ����Ѵ� => �ڹٿ����� ;�� ������� �ʴ´� 
		   // 3. SQL������ ����Ŭ ������ 
		   ps=conn.prepareStatement(sql);
		   // 4. �ʿ��� �����Ͱ� ���� ��� ( ? ) => �����û�� �Ѵ� 
		   // ������ ����� �޾� ���� 
		   ResultSet rs=ps.executeQuery();
		   // ������� List�� �����ؼ� ����ڿ��� ���� 
		   while(rs.next())
		   {
			   // ó����ġ�� Ŀ���� ��ġ => ���پ� �о �����ٷ� ��������
			   // => �����Ͱ� ���� ��쿡�� false , �ִ� ���=> true
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
		   // ���� �߻��� => Ȯ�� 
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // ����Ŭ ���� ���� 
		   disConnection();
	   }
	   return list;
   }
   // 4-2 ��� ���� ���� (�Ѹ� ����) => �Ű����� (����ں��� �����͸� �޴� ��쿡 ���)
   // �󼼺��� (�Խ��ǳ��뺸�� , ��ȭ�� , ���ǻ�)
   public Emp empDetailData(int empno)
   {
	   Emp emp=new Emp();// ��� �Ѹ��� ������ �ִ� ������ ���� 
	   // FoodHouse =>  ���� �Ѱ��� ���� ä���� �Ѱ� �ش�
	   // ����Ŭ �����ϴ� Ŭ���� => CheckException (�����Ͻ� ����ó�� ���� Ȯ��)
	   // java.io,java.sql,java.net => �ݵ�� ����ó���� ����Ѵ� 
	   try
	   {
		   // 1. ����Ŭ ���� 
		   getConnection();
		   // 2. SQL���� 
		   //                    1    2    3      4     5    6
		   String sql="SELECT empno,ename,job,hiredate,sal,comm "
				     +"FROM emp "
				     +"WHERE empno=?"; // Primary Key�� ������ ���� �̿� 
		   // 3. SQL������ �������Ŀ� ?�� ���� ä���ش� 
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, empno); // ���������� ���� 
		   // setInt() , setDouble() ,setString() ,setDate()
		   // getInt() , getDouble() , getString() , getDate()
		   // 4. ����Ŭ�� ������ ��û�� ���� ������� �޸�(ResultSet)�� ������ �޶� 
		   ResultSet rs=ps.executeQuery();
		   // Ŀ���� �����Ͱ� ��µ� ��ġ�� �̵� => next()
		   rs.next();
		   
		   // ResultSet�� �ִ� �����͸� Emp�� ���� 
		   emp.setEmpno(rs.getInt(1));
		   emp.setEname(rs.getString(2));
		   emp.setJob(rs.getString(3));
		   emp.setHiredate(rs.getDate(4));
		   emp.setSal(rs.getInt(5));
		   emp.setComm(rs.getInt(6));
		   
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   // ���� Ȯ�� 
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // ����Ŭ ���� 
		   disConnection();
	   }
	   return emp;
   }
   // 4-3 ��� ã�� (�˻�) => ����Ŭ�ϰ� �ڹٿ��� �����ϴ� SQL������ �ణ Ʋ���� 
   // LIKE 
}











