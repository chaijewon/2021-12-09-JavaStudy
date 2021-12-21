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
		    * private String title;
			    private double score;
			    private String reserve;
			    private String story;
			    private String regdate;
		    */
		   Elements title=doc.select("");
		   Elements score=doc.select("");
		   Elements reserve=doc.select("");
		   Elements story=doc.select("");
		   Elements regdate=doc.select("");
		   
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage()); // 오류 메세지 출력 
	   }
	   
   }
   //1.종류별 목록 
   //2.찾기 
}










