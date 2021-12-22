package com.sist.main;
// => 데이터만 모아서 관리 => 데이터가 변질,노출방지 => 캡슐화 
// => 데이터 : 읽기/쓰기 => 메소드를 이용해서 읽기/쓰기 가능하게 만든다 
// => getXxx() , setXxx() => getter/setter
// 음악한개에 대한 정보 => 사용자의 정의 데이터형 
// 한개의 음악에 관한 데이터 모아서 전송 
// MusicVO , MusicDTO
public class Music {
    private int rank;
    private String title;
    private String singer;
    private String album;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	   
   
   
}
