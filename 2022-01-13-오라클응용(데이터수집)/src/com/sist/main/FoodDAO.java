package com.sist.main;
/*
 *    ����Ŭ ���� : JDBC
 *    ***** ����̹� ���� 
 *          thin / oci
 *          ----- Class.forName("oracle.jdbc.driver.OracleDriver")
 *    1. ����Ŭ ���� 
 *       Connection 
 *       ----------- ����Ŭ�� �ּ� 
 *                   jdbc:oracle:thin:@ip:1521:XE(�����ͺ��̽�:����)
 *                   ---- ------     ------------
 *                         ��ü��         �����ּ�
 *                   CREATE DATEBASE project
 *                   getConnection(url,"user��","pwd")
 *                                        hr     happy
 *                   => conn hr/happy
 *    2. SQL���� ���� (*******)
 *       String sql="SELECT * FROM emp";
 *       PreparedStatement => ����/������� �޴´� 
 *    3. ����� �ޱ� 
 *       �޸𸮿� ���� => ResultSet
 *                    =========== ArrayList => �귯������ ���� 
 *    4. ����Ŭ ���� ����  
 *       conn.close()
 *       
 *    ==> ���� 1��  
 */
import java.sql.*; // Connection,Statement,ResultSet
public class FoodDAO {
    // ���� ��ü 
	private Connection conn;
	// SQL ���� ��ü
	private PreparedStatement ps;
	// URL
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	// 1. ����̹� ��� : �ѹ��� ��� => ������ 
	public FoodDAO()
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
		}catch(Exception ex) {}
	}
	// 3. ����Ŭ ����
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close(); // �ۼ��� ���̶�� ��ȭ�� 
			if(conn!=null) conn.close();// �ڵ��� ���� 
		}catch(Exception ex) {}
	}
	// 4. ��� => Category�� ������ �߰� 
	// INSERT , UPDATE , DELETE => void
	// SELECT : ������ �˻� ����� �о� �´� (������)
	// �ڹ� �޼ҵ� => ����(1��) ,�Ű�����(�⺻ 3���̻� (X))
	// 3�̻��̸� ��� ó�� (�迭,Ŭ����)
	public void categoryInsert(Category c)
	{
		try
		{
			// 1. ����Ŭ ���� 
			getConnection();
			// 2. SQL���� ����
			String sql="INSERT INTO category VALUES(cate_cno_seq.nextval,?,?,?,?)";
			// 3. ����Ŭ�� ���� 
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getTitle());
			ps.setString(2, c.getSubject());
			ps.setString(3, c.getPoster());
			ps.setString(4, c.getLink());
			
			// ���� ���
			ps.executeUpdate(); // @test46
		}catch(Exception ex)
		{
			// ���� ó�� (Ȯ��)
			ex.printStackTrace();
		}
		finally
		{
			// try/catch ���þ��� ������ ���� => �����ݱ� , ����Ŭ �ݱ�
			disConnection();
		}
	}
}













