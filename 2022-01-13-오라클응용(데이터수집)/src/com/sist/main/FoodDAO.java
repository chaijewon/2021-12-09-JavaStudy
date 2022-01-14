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
import java.util.*;
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
	// ���� ���� 
	/*
	 *     ����ڿ�û ===> �ڹ� ====================> ����Ŭ 
	 *                ��û ������ SQL�������� ����        |
	 *                                           SQL�� �޾Ƽ� ���� 
	 *                                              |
	 *                      <==================== ������� �ڹٷ� ����
	 *                      |
	 *                 ������� ����ڿ��� ���� 
	 *     (�ڹ�) / C# / NODEJS / C/C++ / ���̽� / ��Į��....
	 *      1. ����Ŭ�� ���� (Connection) conn hr/happy
	 *                                ---------------
	 *                                getConnection()
	 *      2. ����� ��û�� ������ SQL�������� ���� 
	 *         ------------------------------
	 *      3. SQL������ ����Ŭ�� ���� => Statement(PreparedStatement)
	 *         Statement   / PreparedStatement(�̸� SQL���� ���� , ���߿� �ʿ��� �����͸� ÷��) 
	 *         ---------     -----------------
	 *          SQL+�ʿ��� �����͸� �ѹ��� ���� 
	 *          
	 *          ����Ŭ�� ������ �߰��� ��û�ÿ� (INSERT~)
	 *          ��)
	 *              name , sex , age , address , tel (ȸ������)
	 *              
	 *              �ڹٿ��� ���� �޴´� 
	 *              String name="ȫ�浿";
	 *              String sex="����";
	 *              int age=25;
	 *              String address="�����";
	 *              String tel="010-1111-1111";
	 *              
	 *              => SQL������ ���۽ÿ� => ���ڿ��� �����ؾ� �ȴ� 
	 *              String sql="INSERT INTO member VALUES('"
	 *                        +name+"','",sex+"',"+age
	 *                        +",'"+address+"','"+tel+"')";
	 *              => String => VARCHAR2���� => '��'
	 *              => Statement 
	 *              => ������ ��û�� ���ؼ� ���� 
	 *              String sql="INSERT INTO member VALUES(?,?,?,?,?)"
	 *              => ���߿� ?�� ���� ä��� 
	 *              => setString(1,name) ==> �ڵ����� ''�� ��� 
	 *                             => 'ȫ�浿'
	 *                 setInt()
	 *                 setDouble()
	 *              => ���� => ''�� ������� �ʴ´� (�ڵ����� �߰�) => ����ϱ� ���� 
	 *              => ���� => �ҽ��� ������� 
	 *              
	 *       4. ����Ŭ �����ɾ� ���� 
	 *          = executeQuery() : SELECT (�����͸� �о� �´�)
	 *          = executeUpdate() => COMMIT�� ���� 
	 *                               => �����͸� ���� ���� �ƴ϶� ����
	 *                               => INSERT , UPDATE , DELETE
	 *                               
	 *       5. ����Ŭ���� ����� ����б�(SELECT) => ResultSet
	 *          ResultSet => Record���� ,ROW������ �б� 
	 *          =========
	 *            �����͸� ���� => 1) ó�� , 2) ������ 
	 *            
	 *            ---------------------
	 *              ID   Name    Sex
	 *            ---------------------
	 *              aaa  ȫ�浿    ����  ===> ���⼭���� ������ �������� �б�
	 *                                      next() ***
	 *            ---------------------
	 *              bbb  ��û��    ����
	 *            ---------------------
	 *              ccc  �ڹ���    ����  ===> ���⼭���� ���� �ö󰡸鼭 �б�
	 *                                      previous()
	 *            ---------------------
	 *       6. PreparedStatement / Connection�� �ݴ´� 
	 *                close()          close()
	 *              
	 *              
	 */
	/*
	 *  NO      NOT NULL NUMBER   ==> int      
		CNO              NUMBER   ==> int     
		NAME    NOT NULL VARCHAR2(200)  => String
		SCORE   NOT NULL NUMBER(2,1)    => double
		ADDRESS NOT NULL VARCHAR2(500)  => String 
		TEL     NOT NULL VARCHAR2(30)   => String 
		TYPE    NOT NULL VARCHAR2(100)  => String
		PRICE            VARCHAR2(50)   => String
		PARKING          VARCHAR2(50)   => String
		TIME             VARCHAR2(50)   => String
		MENU             CLOB           => String
		POSTER  NOT NULL VARCHAR2(4000) => String
	 */
	public void foodInsert(FoodHouse food)
	{
		try
		{
			getConnection();// ����
			// 1. SQL���� ���� 
			String sql="INSERT INTO food_house VALUES("
					  +"fh_no_seq.nextval,?,?,?,?,?,"
					  +"?,?,?,?,?,?)";
			// 2. SQL�� �ʿ��� �����Ͱ� ä��� (?)
			ps=conn.prepareStatement(sql); // �̸� ���� 
			ps.setInt(1, food.getCno());
			ps.setString(2, food.getName());
			ps.setDouble(3, food.getScore());
			ps.setString(4, food.getAddress());
			ps.setString(5, food.getTel());
			ps.setString(6, food.getType());
			ps.setString(7, food.getPrice());
			ps.setString(8, food.getParking());
			ps.setString(9, food.getTime());
			ps.setString(10, food.getMenu());
			ps.setString(11, food.getPoster());
			// ?�� ������ 1������ ���� (����Ŭ => 1������ ����)
			// ������ ����Ŭ���� 
			// => ����Ŭ�� SQL����� �ڹٿ��� ������ ����Ŭ SQL������ �ٸ��͵� �ִ� 
			// LIKE 
			/*
			 *    WHERE ename LIKE '%A%';
			 *    WHERE ename LIKE '%'||A||'%' => 97%�� ����Ŭ�� ���� , 3%
			 */
			// 3. ����Ŭ�� ��ɹ� ���� ��û 
			ps.executeUpdate();
		}catch(Exception ex)
		{
			// ���� Ȯ�� 
			ex.printStackTrace();
		}
		finally
		{
			disConnection();//���� ���� 
		}
	}
	// ������ �б� => Category�� link,cno,title
	public List<Category> categoryListData()
	{
		List<Category> list=new ArrayList<Category>();
		try
		{
			// 1. ����
			getConnection();
			// 2. SQL���� ���� 
			String sql="SELECT cno,title,link "
					  +"FROM category";
			// 3. �ʿ��� �����͸� ���� (X)
			// 4. ����Ŭ�� ���� ����� ���� 
			ps=conn.prepareStatement(sql);// SQL������ ����Ŭ�� ������ 
			// 5. ������� �޴´� 
			ResultSet rs=ps.executeQuery();// ���� ����� �޸𸮿� ���� 
			// 6. ������� List�� ÷�� 
			while(rs.next()) // ���κ��� �Ʒ��� ���پ� �о� �´� 
			{
				/*
				 *   ����Ŭ�� �ִ� �����͸� �ڹٿ� ��Ī 
				 *   ���ڿ� : getString()
 				 *   �Ǽ� : getDouble()
				 *   ���� : getInt()
				 *   ��¥ : getDate()
				 */
				Category c=new Category();
				c.setCno(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setLink(rs.getString(3));
				list.add(c);
			}
			rs.close();
			/*
			 *    ---------------------
	 *              ID   Name    Sex
	 *            ---------------------
	 *              aaa  ȫ�浿    ����  ===> ���⼭���� ������ �������� �б�
	 *                                      next() ***
	 *              1       2      3
	 *              getString(1) , getString(2) , getString(3)
	 *              
	 *              ==> 4.5 => getDouble(��ȣ) , 22/01/14 => getDate(��ȣ)
	 *              ==> 10 => getInt(��ȣ)
	 *            ---------------------
	 *              bbb  ��û��    ����
	 *            ---------------------
	 *              ccc  �ڹ���    ����  ===> ���⼭���� ���� �ö󰡸鼭 �б�
	 *                                      previous()
	 *            ---------------------
			 */
		}catch(Exception ex)
		{
			// ���� Ȯ�� 
			ex.printStackTrace();
		}
		finally
		{
			// ����
			disConnection();
		}
		return list;
	}
	
}













