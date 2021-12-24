package com.sist.main;
// ArrayList단위로 파일을 저장 ==> 저장 활용 
import java.util.*;
import java.io.*;
/*
 *  1|
 *  쇼생크 탈출|
 *  드라마|
 *  https://movie-phinf.pstatic.net/20160119_278/
 *  14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2|
 *  팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|
 *  2016 .02.24 재개봉, 1995 .01.28 개봉|
 *  15세 관람가|
 *  프랭크 다라본트

 */
// 영화 한개에 대한 데이터를 모아서 사용 (사용자의 데이터형) => 캡슐화 
// implements Serializable => 단위 객체단위
class Movie implements Serializable
{
	private int mno;
	private String title;
	private String genre;
	private String poster;
	private String actor;
	private String regdate;
	private String grade;
	private String director;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 파일을 읽어서 => ArrayList에 저장 
		// ArrayList => 통째로 파일에 저장 ==> 활용하기가 편하다 
		// 오라클 (데이터베이스) => 중심 => MariaDB(무료),MySQL 
		ArrayList<Movie> list=new ArrayList<Movie>();
		// 파일을 읽기 => 예외처리 
		try
		{
			FileInputStream fis=new FileInputStream("c:\\java_data\\movie.txt");
			BufferedReader br=
					new BufferedReader(new InputStreamReader(fis));
			// byte => char로 변환 : InputStreamReader 
			while(true)
			{
				// 한줄씩 읽어온다
				String data=br.readLine();
				if(data==null) // 읽을 데이터가 없는 경우까지 
					break; // while을 종료한다 
				// | => 데이터를 잘라온다 ==> Movie => ArrayList
				// spilt() , StringTokenizer
				StringTokenizer st=
						new StringTokenizer(data,"|");
				Movie m=new Movie();
				m.setMno(Integer.parseInt(st.nextToken()));
				m.setTitle(st.nextToken());
				m.setGenre(st.nextToken());
				m.setPoster(st.nextToken());
				m.setActor(st.nextToken());
				m.setRegdate(st.nextToken());
				m.setGrade(st.nextToken());
				m.setDirector(st.nextToken());
				
				list.add(m);
			}
			fis.close();
			br.close();
			
			// 데이터가 추가되었는지 확인
			/*for(Movie m:list)
			{
				System.out.println("번호:"+m.getMno());
				System.out.println("제목:"+m.getTitle());
			}*/
			// ArrayList단위로 저장 파일 => 계속 활용이 가능 
			//1. 파일 => 파일 생성 
			File file=new File("c:\\java_data\\movie_object.txt");
			// 파일 존재 여부 확인 
			if(!file.exists())
			{
				// 파일 존재하지 않으면 => 파일을 만들어라 
				file.createNewFile();
			}
			FileOutputStream fos=
					new FileOutputStream(file);
			ObjectOutputStream oos=
					new ObjectOutputStream(fos);
			oos.writeObject(list);// 객체단위로 저장 
			// 닫기 
			fos.close();
			oos.close();
			System.out.println("객체 단위 저장 완료!!");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}








