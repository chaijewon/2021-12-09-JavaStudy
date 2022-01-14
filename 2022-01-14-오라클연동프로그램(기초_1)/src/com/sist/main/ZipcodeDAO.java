package com.sist.main;
// ����� ��û => ����Ŭó�� (INSERT,UPDATE,DELETE,SELECT)
// ����� ��� ����Ŭ������ ���ؼ� SQL���� ���� ó�� 
// DAO => ����Ŭ�� ������ �ִ� Ŭ���� 
import java.sql.*; 
/*
 *  Connection : ����Ŭ ���� 
 *  PreparedStatement : SQL���� �ۼ��� 
 *  ResultSet : ������� �޸𸮿� ���� 
 */
import java.util.*; // List => ������� ��Ƽ� ���� 
// Zipcode : �����ȣ �Ѱ��� ���� ������ ������ �ִ� 
// �����ȣ ������ ��û => List<Zipcode>
/*
 *    1. ����̹� ��� Class.forName()
 *    2. ����Ŭ ����  Connection getConnection(URL,"user","password")
 *    3. SQL���� ���� : PreparedStatement => conn.preparedStatement(sql)
 *    4. SQL���� ���� ��û 
 *         = SELECT : ������� �о� �´� ==> executeQuery()
 *         = INSERT,UPDATE,DELETE : ����Ŭ ��ü ó�� ==> executeUpdate() 
 *                                                 ==> commit()
 *                                         *** �ڹٴ� autocommit()
 *    *** SQL���� 
 *    
 *    285~293page 
 */
/*
 *   JDBC ====> DBCP =====> ORM 
 *   -----      ----        ---- ���̺귯�� (MyBatis,Hibernate, JPA)
 *               ��(�ӵ� ����ȭ)             --------(*)
 *   Spring : �ڹ�(��Ʋ��) ,  MyBatis , JSP 
 *   -------  ���� ���� <==> Front���� 
 *            Spring-Boot
 */
public class ZipcodeDAO {
     // ����Ŭ ���� ��ü ���� 
	 private Connection conn;
	 // ����Ŭ�� �ۼ��� ��ü ���� 
	 private PreparedStatement ps;
	 // URL�ּ� 
	 private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	 
	 // ����̹� ��� => �ѹ��� ���� (������)
	 public ZipcodeDAO()
	 {
		 try
		 {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 // ojdbc8.jar => �ݵ�� �߰� (Oracle���� ����) 
			 // �����ͺ��̽� => �� ��ü���� �ٿ�ε� (MySQL,MariaDB)
		 }catch(Exception ex) {}
	 }
	 // ����Ŭ ���� 
	 public void getConnection()
	 {
		 try
		 {
			 conn=DriverManager.getConnection(URL,"hr","happy");
		 }catch(Exception ex) {}
	 }
	 // ����Ŭ ����
	 public void disConnection()
	 {
		 try
		 {
			 if(ps!=null) ps.close();
			 if(conn!=null) conn.close();
		 }catch(Exception ex) {}
	 }
	 // ��� => �����ȣ ã�� , �˻� ���� Ȯ��
	 public int zipcodeFindCount(String dong)
	 {
		 // count(*) 
		 int count=0;
		 try
		 {
			 // 1. ���� 
			 getConnection();
			 // 2. SQL���� ����
			 String sql="SELECT COUNT(*) "
					   +"FROM zipcode "
					   +"WHERE dong LIKE '%'||?||'%'";
			 // 3. ����Ŭ�� SQL���� ���� 
			 ps=conn.prepareStatement(sql);
			 // ?�� ���� ä��� 
			 ps.setString(1, dong);
			 // 4. SQL���� �� ������� �о� �´� 
			 ResultSet rs=ps.executeQuery();
			 // 5. �о�� �����͸� ������ ���� 
			 rs.next(); // ���� ������ �����ġ�� Ŀ�� �ø���
			 // Ŀ���� �ִ� ��ġ�� �����͸� ������ �´� 
			 count=rs.getInt(1);
			 
			 rs.close();
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
			 // ���� Ȯ�� 
		 }
		 finally
		 {
			 disConnection();// ����Ŭ ����
		 }
		 return count;
	 }
	 // ���� �����ȣ�� ã�� �´� 
	 public List<Zipcode> zipcodeListData(String dong)
	 {
		 List<Zipcode> list=new ArrayList<Zipcode>();
		 try
		 {
			 // 1. ���� 
			 getConnection();
			 // 2. SQL���� ���� 
			 String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					   +"FROM zipcode "
					   +"WHERE dong LIKE '%'||?||'%'";
			 // ���̺��� �÷����� �����ص� �����ϴ� 
			 // ������ �߻� 
			 // 3. ����Ŭ�� SQL���� ���� 
			 ps=conn.prepareStatement(sql);
			 // 4. ?�� ���� ä���ش� 
			 ps.setString(1, dong);//dong => ����ڰ� ������ �� 
			 // 5. SQL������ �����ϰ� ������� �о� �Ͷ� 
			 ResultSet rs=ps.executeQuery();
			 // 6. ResultSet�� �� �ִ� ������� List�� ���� ä���ش� 
			 while(rs.next())
			 {
				 Zipcode z=new Zipcode();
				 z.setZipcode(rs.getString(1));
				 z.setSido(rs.getString(2));
				 z.setGugun(rs.getString(3));
				 z.setDong(rs.getString(4));
				 z.setBunji(rs.getString(5));
				 
				 list.add(z);// �о�� �����ȣ�� �߰� �Ѵ� 
				 
			 }
			 rs.close();
		 }catch(Exception ex)
		 {
			 // ���� Ȯ��
			 ex.printStackTrace();
		 }
		 finally
		 {
			 // �ݱ�
			 disConnection();
		 }
		 return list;
	 }
}











