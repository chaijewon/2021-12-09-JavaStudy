package com.sist.lib;
// *** contains() => 문자열에 중에 포함되었는지 여부 => LIKE
// 원형) public boolean contains(String word) = 자바 스크립트 (SearchBar)
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
// ==> 영화추천 ==> 블로그 , 카페에서 입력글을 읽는다 => 실시간 (트워터)
/*
 *   <div class="wrap_song_info">
	<a href="javascript:melon.play.
	playSong('1000002721',34061322);"
	 title="사랑은 늘 도망가 재생">사랑은 늘 도망가</a>
	</span></div><br>
 */
public class MainClass6 {

	public static void main(String[] args) {
		// 1. 사용자 입력 
		Scanner scan=new Scanner(System.in);
		System.out.print("검색어 입력:");
		String fd=scan.next();
		
		// 2. 찾기  => contains 
		try
		{
			Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			// 사이트에 접근해서 모든 데이터를 읽어 와라 
			Elements elem=doc.select("div.wrap div.wrap_song_info a");
			for(int i=0;i<elem.size();i++)
			{
				String ss=elem.get(i).attr("title");// 노래 제목 
				if(ss.contains(fd)) // 노래 제목에 입력된 단어 포함된 경우
				{
					System.out.println(ss);
				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();// 에러 확인 
		}
		// 3. 찾기 결과를 보여준다 
	}

}











