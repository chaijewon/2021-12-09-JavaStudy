package com.sist.vo;
// 영화 정보에 데이터를 모아둔다 (영화 한개에 대한 정보)
public class Movie {
  private String title;
  private boolean isShow;//true(상영중) , false(개봉예정)
  private String titleEn;
  private String genre;
  private String nation;
  private String time;
  private String regdate;
  private String director;
  private String actor;
  private String grade;
  private String reserve;
  private String story;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public boolean isShow() {
	return isShow;
}
public void setShow(boolean isShow) {
	this.isShow = isShow;
}
public String getTitleEn() {
	return titleEn;
}
public void setTitleEn(String titleEn) {
	this.titleEn = titleEn;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getNation() {
	return nation;
}
public void setNation(String nation) {
	this.nation = nation;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getRegdate() {
	return regdate;
}
public void setRegdate(String regdate) {
	this.regdate = regdate;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public String getActor() {
	return actor;
}
public void setActor(String actor) {
	this.actor = actor;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getReserve() {
	return reserve;
}
public void setReserve(String reserve) {
	this.reserve = reserve;
}
public String getStory() {
	return story;
}
public void setStory(String story) {
	this.story = story;
}
  
}
