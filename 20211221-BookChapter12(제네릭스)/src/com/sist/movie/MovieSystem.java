package com.sist.movie;
// Back-End
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class MovieSystem {
   // 1. 영화의 모든 정보를 가지고 있다 
   // 2. 모든 클라이언트(사용자) => 같은 데이터를 사용 => 공유 
   // 3. 공유 => static (static공간 => 메모리 공간 1개다) 
   // 4. static => 모든 데이터 공유할 수 있는 => 오라클 
   // 5. 영화 1개에 대한 정보 => Movie => 여러개 (저장)
   // ======> 배열 / Collection
   // 배열 => 영화 갯수 확인 (고정) , Collection => 가변 
   private static ArrayList<Movie> list=new ArrayList<Movie>();
   // list=null => size=0 => 초기화 
   /*
    *    명시적 초기화 => X (일반 데이터만 처리)
    *    초기화 블록 => 외부 데이터 읽어서 대입 
    *    생성자     => 외부에서 데이터 읽어서 대입
    */
   // 초기화 블록 => 클래스가 로드되었을때 자동으로 수행하는 명령 => 초기화 블록이 수행된다  
   static 
   {
	   // 데이터 읽기 
	   // 1.사이트에 연결 (네트워크 => CheckException) => 반드시 예외처리 
	   // 1. IO (파일 입출력) , 2. 쓰레드 , 3 네트워크 , 4. SQL(데이터베이스)
	   try
	   {
		   // 사이트 연결 => 데이터를 읽어서 저장 (Document:문서 저장)
		   Document doc=Jsoup.connect("https://movie.daum.net/ranking/reservation").get();
		   /*
		    *   private String title;
			    private double score;
			    private String reserve;
			    private String story;
			    private String regdate;
			    <strong class="tit_item"> 
<a href="/moviedb/main?movieId=146656" 
  class="link_txt" data-tiara-layer="moviename">
   스파이더맨: 노 웨이 홈</a></strong>
   
   <span class="txt_append"> <span class="info_txt">
   평점<span class="txt_grade">8.2</span></span> 
   
   <span class="info_txt">예매율<span class="txt_num">68.4%</span></span> <
/span> <span class="txt_info"> 개봉<span class="txt_num">21.12.15</span> 
 * <a href="/moviedb/main?movieId=146656" class="link_story" data-tiara-layer="poster"> 영화 <스파이더맨: 노 웨이 홈>은 정체가 탄로난 스파이더맨 '피터 파커'(톰 홀랜드)가문제를 해결하기 위해 '닥터 스트레인지'(베네딕트 컴버배치)의 도움을 받던 중 뜻하지 않게 멀티버스가 열리게 되고,이를 통해 '닥터 옥토퍼스'(알프리드 몰리나) 등 각기 다른 차원의 숙적들이 나타나며 사상 최악의 위기를 맞게 되는 이야기를 그린 마블 액션 블록버스터. </a> 


		    */
		   Elements title=doc.select("strong.tit_item a.link_txt");
		   // Element => 태그 한개를 모아 준다 
		   // Elements (Collection) => 같은 태그 여러개 
		   Elements score=doc.select("span.txt_grade");//css selector =>UI
		   Elements reserve=doc.select("span.info_txt span.txt_num");
		   Elements story=doc.select("a.link_story");
		   Elements regdate=doc.select("span.txt_info span.txt_num");
		   for(int i=0;i<title.size();i++)
		   {
			   System.out.println(title.get(i).text());
			   System.out.println(score.get(i).text());
			   System.out.println(reserve.get(i).text());
			   System.out.println(regdate.get(i).text());
			   System.out.println(story.get(i).text());
			   System.out.println("===================================");
			   
			   Movie m=new Movie();
			   m.setNo(i+1);
			   m.setTitle(title.get(i).text());
			   m.setStory(story.get(i).text());
			   m.setReserve(reserve.get(i).text());
			   m.setRegdate(regdate.get(i).text());
			   m.setScore(Double.parseDouble(score.get(i).text()));
			   // 한개 영화 정보 => 20개 
			   list.add(m);
			   // 변수(여러개) => 클래스 묶는다 ==> 여러개 ==>  Collection
		   }
		   
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage()); // 오류 메세지 출력 
	   }
	   
   }
   //1.종류별 목록 
   // ArrayList<Movie> => 영화정보 전체
   // Movie => 영화 한개 
   public ArrayList<Movie> movieAllData()
   {
	   return list;
   }
   //2.상세보기 (영화한개에 대한 정보를 본다)
   public Movie movieDetailData(int no)
   {
	   Movie m=new Movie();
	   for(Movie mm:list)
	   {
		   if(mm.getNo()==no)
		   {
			   m=mm;
			   break;// 찾은 경우에 종료하고 루프를 끝낸다 
		   }
	   }
	   return m;
   }
   //3. 찾기 => 영화가 여러개 있는 경우도 있다 
   public ArrayList<Movie> movieFind(String title)
   {
	   ArrayList<Movie> mList=new ArrayList<Movie>();
	   // mList에 찾은 영화(Movie) 모아서 넘겨준다
	   for(Movie m:list)
	   {
		   if(m.getTitle().contains(title))
		   {
			   mList.add(m);
		   }
	   }
	   return mList;
   }
}










