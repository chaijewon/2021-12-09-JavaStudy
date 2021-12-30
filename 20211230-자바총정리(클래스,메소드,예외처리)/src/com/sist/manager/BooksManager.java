package com.sist.manager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.*;
// 웹에서 데이터를 읽은 후 => 오라클에 저장 
/*
 *   1.오라클에 저장 공간 (TABLE)
 *  ======================== 데이터베이스 설계 
 *   2.자바에 데이터를 모운다 (Books)
 *   3.자바에서 오라클 연결 (BooksDAO)
 *   4.웹 데이터 읽기 => DAO로 전송 
 *  ======================== 데이터 수집 
 *  
 *  실제 실무 
 *  요구사항 분석  =====> 데이터베이스 설계 ======> 데이터수집
 *  ----------         ------------         -------- 
 *  =====> 화면UI ======> 구현 ====> 테스팅 ===> 배포 
 *        -------       -----     ------     ----
 */
public class BooksManager {
    // 포함 클래스 
	private BooksDAO dao=new BooksDAO();
	public void booksGetData()
	{
		try
		{
			// 웹사이트 연결 
			/*
			 *    <a>aaa</a> ===> text()
			 *    <a href="aaa"> ==> attr("href")
			 */
			// <div class="sub-title">자바 코드로 구현하는 클린 웹 애플리케이션</div>
			Document doc=
					Jsoup.connect("https://wikibook.co.kr/list/").get();
			Elements title=doc.select("div.book-list-detail h4.main-title");
			Elements poster=doc.select("div.book-list-image img");
			Elements content=doc.select("div.book-list-detail div.sub-title");
			Elements etc=doc.select("div.book-info");
			/*
			 *   박경인 지음 | 29,000원 | 2021년 12월 15일 | ISBN: 9791158392963 콘텐츠,영상,유튜브,파이널 컷 프로,Final Cut Pro
			 */
			for(int i=0;i<title.size();i++)
			{
				try
				{
				  System.out.println(i+1);
				  System.out.println(title.get(i).text());
				  System.out.println(poster.get(i).attr("src"));
				  System.out.println(content.get(i).text());
				  System.out.println(etc.get(i).text());
				  System.out.println("========================================");
				
				  Books book=new Books();
				  book.setNo(i+1);
				  book.setTitle(title.get(i).text());
				  book.setPoster(poster.get(i).attr("src"));
				  book.setContent(content.get(i).text());
				  
				  String[] info=etc.get(i).text().split("\\|");
				  // 박경인 지음 
				  String author=info[0];
				  author=author.substring(0,author.lastIndexOf("지"));
				  book.setAuthor(author.trim());
				  book.setPrice(info[1].trim());
				  book.setRegdate(info[2].trim());
				  String temp=info[3].trim();
				  
				}catch(Exception ex){}
		   }
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BooksManager bm=new BooksManager();
		bm.booksGetData();
	}
	
}












