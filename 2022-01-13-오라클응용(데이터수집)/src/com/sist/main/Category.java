package com.sist.main;
// ROW => ��ü ��Ī ===> CategoryVO
// ������ ���� (ĸ��ȭ) 
/*
 *   2�� �ڹ� : Web���� (����Ŭ ���� , �������� ����)
 *   Ŭ���� 
 *   -----
 *     1. ������ ���� (������ �б�/����) => ����� ���� �������� 
 *                       ----------- getter / setter
 *        ~DTO  => MovieDTO => MyBatis
 *        ~VO      MovieVO  => Spring(******)
 *        ~Bean => MovieBean => JSP
 *     2. ��� ���(�޼ҵ�) 
 *        ~DAO => �����ͺ��̽� ���� 
 *        ~Manager => ũ�Ѹ� , ���������� 
 *        ~Service => ������ ���̺� ���� 
 */
public class Category {
    private int cno;
    private String title;
    private String subject;
    private String poster;
    private String link;
    
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
    
    
}
