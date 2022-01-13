package com.sist.main;
// ROW => 객체 매칭 ===> CategoryVO
// 데이터 관리 (캡슐화) 
/*
 *   2차 자바 : Web관련 (오라클 연결 , 브라우저로 전송)
 *   클래스 
 *   -----
 *     1. 데이터 관리 (데이터 읽기/쓰기) => 사용자 정의 데이터형 
 *                       ----------- getter / setter
 *        ~DTO  => MovieDTO => MyBatis
 *        ~VO      MovieVO  => Spring(******)
 *        ~Bean => MovieBean => JSP
 *     2. 기능 담당(메소드) 
 *        ~DAO => 데이터베이스 연결 
 *        ~Manager => 크롤링 , 공공데이터 
 *        ~Service => 여러개 테이블 연결 
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
