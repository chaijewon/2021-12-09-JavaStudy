package com.sist.movie;
// 영화 한개에 대한 정보를 가지고 있는 클래스 
// 자바 => 영화 데이터형 (존재하지 않는다)
// 사용자 정의로 만드는 데이터형 
// => MyBatis (MovieDTO) , Spring(MovieVO) , JSP(MovieBean)
// => 데이터 변질 , 다른 변경이 불가능하게 데이터 보호 (캡슐화)
public class Movie {
    private int no; // 구분 변수 
    private String title;
    private double score;
    private String reserve;
    private String story;
    private String regdate;
    public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
