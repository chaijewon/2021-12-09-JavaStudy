package com.sist.main;
// 음악 정보를 모아둔다 (음악 한개에 대한 정보)
/*
 *   클래스에 변수 설정 ==> 프로그램 종료시까지 메모리를 유지 
 *   => 필요시마다 클래스 변수 활용 => 멤버변수 
 *   => 여러개 변수가 나오면 => 클래스로 모아서 처리 (사용자 정의 데이터형)
 *   
 *   1) 순위
 *   2) 포스터 
 *   3) 노래명 
 *   4) 가수명
 *   5) 앨범
 *   6) 등폭 
 *   7) 상태 (유지 / 상승 / 하강) => ▲ ▼
 *   
 *   => 변수
 *   배열 ==> 7개 -> 50개 => 350개 
 *   => 클래스 ==> 50개 저장 
 *   
 *   클래스 => 멤버변수 (캡슐화 ==> 변수(private), 메소드를 통해서 변수에 접근)
 *           
 */
// 사용자가 필요에 의해서 데이터형을 만들어서 사용 (사용자 정의 데이터형)
// 기능 : 읽기 / 쓰기 ==> getter/setter
// 프로그램에 맞게 변수 설정 => 데이터를 모아서 관리 ==> ~VO , ~DTO
public class Music {
    private int rank;
    private String poster;
    private String title;
    private String singer;
    private String album;
    private int idcrement;
    private String state;
    // 증가 , 삭제 
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
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
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
   
}










