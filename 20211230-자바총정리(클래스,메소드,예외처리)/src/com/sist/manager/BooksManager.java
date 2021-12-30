package com.sist.manager;
import java.net.*;
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.BooksDAO;
public class BooksManager {
    // 오라클에 연결 => BooksDAO
	private BooksDAO dao=new BooksDAO(); // 데이터를 오라클에 추가 
	// try~catch (예외복구), throws(예외회피=>선언)
	// 사전에 에러발생을 차단하는 프로그램 => 에러를 잡아주는 것은 아니고 
	// 에러난 부분을 점프해서 => 다음문장으로 이동 
	// 에러난 부분을 확인 => getMessage(),printStackTrace()
	public void booksGetData()
	{
		try
		{
			// 파일 읽기 => 저장 
			StringBuffer sb=new StringBuffer();
			FileInputStream fis=
					new FileInputStream("c:\\javaDev\\books.txt");
			BufferedReader br=
					new BufferedReader(new InputStreamReader(fis,"UTF-8"));
			// 파일 전체를 읽어서 => 임시저장 
			// UTF-8  ==> EUC-KR 
			while(true)
			{
				String data=br.readLine();
				if(data==null) break;
				sb.append(data);
			}
			
			//System.out.println(sb.toString());// 메모리에 저장된 데이터를 출력
			// <> => 테그별 데이터 수집  
			// <div id="a"> => div:eq(0)
			// <div class="b"> => div:eq(1)
			// <div> => HTML
			// Jsoup => HTML Parser => 필요한 데이터를 찾아주는 역할 
			Document doc=Jsoup.parse(sb.toString());
			/*
			 *   connect() => 실제 URL을 이용해서 웹서버에 접근 
			 *   parse() => HTML문자열 , 파일
			 */
			/*
			 *  <div class="col-md-11 book-list-detail">
					<a class="book-url" href="https://wikibook.co.kr/tf">
					<h4 class="main-title">생활코딩 머신러닝 with 파이썬 텐서플로(실습편)</h4>
					</a>
					
			    <div class="col-md-1 book-list-image">
				<a href="https://wikibook.co.kr/tf/">
				<img src="https://wikibook.co.kr/images/cover/s/9791158392994.jpg">
                 
                 <div class="sub-title">보는 순간 팔로우하고 싶게 만드는</div>

                 <div class="book-info">
				<span class="author">김정은 <small>지음</small></span> |
				22,000원 |
				<span class="pub-date">2022년 01월 12일 | </span>
				<span class="isbn"><small>ISBN: </small>9791158392956</span>
				<span class="tag" style="display:none">브랜딩,인스타그램,인스타그램 브랜딩,instagram,branding</span>
				</div>
				<span id="tags">
				<i class="fas fa-tags"></i>
				<a href="https://wikibook.co.kr/tag/%eb%b8%8c%eb%9e%9c%eb%94%a9/"><span class="label label-default">브랜딩</span></a>
				<a href="https://wikibook.co.kr/tag/%ec%9d%b8%ec%8a%a4%ed%83%80%ea%b7%b8%eb%9e%a8/"><span class="label label-default">인스타그램</span></a>
				<a href="https://wikibook.co.kr/tag/%ec%9d%b8%ec%8a%a4%ed%83%80%ea%b7%b8%eb%9e%a8-%eb%b8%8c%eb%9e%9c%eb%94%a9/"><span class="label label-default">인스타그램 브랜딩</span></a>
				<a href="https://wikibook.co.kr/tag/instagram/"><span class="label label-default">instagram</span></a>
				<a href="https://wikibook.co.kr/tag/branding/"><span class="label label-default">branding</span></a>
				</span>
				</div>
			 */
			Elements title=doc.select("h4.main-title");
			Elements poster=doc.select("div.book-list-image img");
			Elements content=doc.select("div.sub-title");
			Elements author=doc.select("div.book-info span.author");
			Elements price=doc.select("div.book-info");
			Elements regdate=doc.select("div.book-info span.pub-date");
			Elements isbn=doc.select("div.book-info span.isbn");
			Elements tags=doc.select("div.book-info span.tag");
			/*
			 *    <div>값</div> ==> text() 
			 *    <img src="값"> ==> attr("src")
			 */
			for(int i=0;i<title.size();i++)
			{
				String title_data=title.get(i).text();
				String poster_data=poster.get(i).attr("src");
				String author_data=author.get(i).text();
				String regdate_data=regdate.get(i).text()
						           .replace("|", "");
				String isbn_data=isbn.get(i).text();
				String tags_data=tags.get(i).text();
				
				String cd="";
				try
				{
				   String content_data=content.get(i).text();
				   cd=content_data;
				}catch(Exception ex){}
				
				String price_data=price.get(i).text();
				String p="";
				StringTokenizer st=new StringTokenizer(price_data,"|");
				int count=st.countTokens();
				if(count==4)
				{
					String[] ss=price_data.split("\\|");
					p=ss[1];
				}
				else
				{
					String[] ss=price_data.split("\\|");
					p=ss[2];
				}
				
				System.out.println("번호:"+(i+1));
				System.out.println("저자:"+title_data);
				System.out.println("그림:"+poster_data);
				System.out.println("소개:"+cd);
				System.out.println("가격:"+p);
				System.out.println("등록일:"+regdate_data);
				System.out.println("isbn:"+isbn_data);
				System.out.println("태그:"+tags_data);
				
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








