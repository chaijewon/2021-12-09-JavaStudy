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
        	}
        }catch(Exception ex){}
	}

}





