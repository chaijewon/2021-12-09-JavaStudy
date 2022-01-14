package com.sist.main;
/*
 *      NO      NOT NULL NUMBER   ==> int      
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
		
		�ڹ�  ===== ����Ŭ 
		�������      �÷� 
		------      --- ���������� ��Ī 
		
		����Ŭ���� �����ϴ� ��������              �ڹ� 
		     ������ 
		        CHAR(1~2000byte)
		        VARCHAR2(1~4000byte)
		        CLOB(4�Ⱑ)
		        ------------------------> String
		     ������
		        NUMBER
		        NUMBER(4)
		        ------------------------> int
		        NUMBER(2,1)
		        ------------------------> double (int => �Ҽ����� �������)
		     ��¥�� 
		        DATE 
		        ------------------------> java.util.Date (java.sql.Date)
		     ��Ÿ�� (4�Ⱑ)=> ����,������ ...
		        BFILE(��������)
		        BLOB(���̳ʸ� ����)
		        ------------------------> java.io.InputStream 
		        
		   ROW ==> ���� ===> new FoodHouse()
		   ------------
		      50��      ===> 50��
		      ---- �ν��Ͻ� (��ü)
 */

public class FoodHouse {
    private int no,cno;
    private double score;
    private String name,tel,address,parking,time,type,menu,poster,price;
	
    public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	  
}
