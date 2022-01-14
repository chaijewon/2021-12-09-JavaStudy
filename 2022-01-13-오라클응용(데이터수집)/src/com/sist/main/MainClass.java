package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *    1. 영화 => 네이버 / 다음 (******) Youtube (동영상)
 *    *****2. 맛집 => 망고플레이트 
 *    3. 여행 => 서울 여행 / ?
 *    4. 레시피 => 10000개 
 *    5. 뮤직 => 지니 / 멜론  (******) Youtube (동영상) 
 *    6. 상품 => 10000개 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 데이터베이스 연결 
        	FoodDAO dao=new FoodDAO();
        	// Jsoup => Html Parser
        	// 웹 사이트에 연결 
        	Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
        	//System.out.println(doc);
        	Elements title=doc.select("div.info_inner_wrap span.title");
        	Elements subject=doc.select("div.info_inner_wrap p.desc");
        	Elements poster=doc.select("ul.list-toplist-slider img.center-croping");
        	Elements link=doc.select("ul.list-toplist-slider a");
        	/*
        	 *    <p class="desc">aaaa</p> => text()
        	 *    <img data-lazy="aaa"> ===> attr("data-lazy")
        	 *    <a href="aaa"> ==> attr("href")
        	 */
        	for(int i=0;i<title.size();i++)
        	{
        		System.out.println(i+1);
        		System.out.println(title.get(i).text());
        		System.out.println(subject.get(i).text());
        		System.out.println(poster.get(i).attr("data-lazy"));
        		System.out.println(link.get(i).attr("href"));
        		Category c=new Category();
        		c.setTitle(title.get(i).text());
        		c.setSubject(subject.get(i).text());
        		c.setPoster(poster.get(i).attr("data-lazy").replace("&", "^"));
        		// 오라클에서는 & => 사용자 입력 
        		// 데이터 수집 => & , || => replace를 이용해서 변경한다 
        		c.setLink("https://www.mangoplate.com"+link.get(i).attr("href"));
        	    // 데이터를 읽을때 마다 오라클에 첨부 
        		dao.categoryInsert(c);
        		// INSERT , UPDATE , DELETE => 정상 수행시 COMMIT
        		// 비정상 수행시는 ROLLBACK 
        		// 자바에서 오라클 연결시에는 INSERT , UPDATE , DELETE => AutoCommit()
        	}
        	System.out.println("오라클에 저장 완료!!");
        }catch(Exception ex){}
	}

}





