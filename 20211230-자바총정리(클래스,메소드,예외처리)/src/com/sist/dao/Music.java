package com.sist.dao;
// 데이터 저장 
/*
 *  NO                                                 NUMBER
 TITLE                                              VARCHAR2(500)
 SINGER                                             VARCHAR2(500)
 ALBUM                                              VARCHAR2(500)
 RANK                                               NUMBER
 STATE                                              VARCHAR2(20)
 IDCREMENT                                          NUMBER
 KEY                                                VARCHAR2(50)
 POSTER                                             VARCHAR2(260)
 */
public class Music {
    private int no;
    private String title;
    private String singer;
    private String album;
    private int rank;
    private String state;
    private int idcrement;
    private String key;
    private String poster;
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
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	   
   
}









