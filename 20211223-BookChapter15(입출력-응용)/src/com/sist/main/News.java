package com.sist.main;
// 데이터형 (사용자 정의 데이터형) => 필요한 내용을 모아서 저장 목적
// 뉴스 한개에 대한 정보 
// 읽기 / 쓰기 => 두개의 기능만 가지고 있다 
// JSP => Bean (핵심기능)
public class News {
    private String title;// 뉴스제목 
    private String description; // 뉴스내용
    private String author;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	   
}
