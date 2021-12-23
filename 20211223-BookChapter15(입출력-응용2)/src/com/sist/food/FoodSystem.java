package com.sist.food;
// 요청 처리 => 사용자 => 결과를 보내주는 역할 => 스프링
// 데이터를 묶어서 저장 
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
// 카테고리 => 파일 저장 ==> 클라이언트 전송 (ArrayList => 파일)
// 맛집정보 => 파일 저장 ==> 클라이언트 전송 (ArrayList => 파일)
/*
 *    멤버변수의 초기화 
 *    시작과 동시에 작업
 *    
 *    ==> 초기화 블록 , 생성자 => 호출 
 *        ========= 클래스가 로드된 경우 자동 실행 
 *        
 *        초기화 블록 
 *        
 *        {
 *           // 인스턴스 초기화 블록 
 *        }
 *        static 
 *        {
 *           // 정적 블록
 *        }
 *        ***** 클래스 블록 => 구현하지 못하고 선언만 한다 
 *                                      ====
 *                                      선언과 동시에 값을 설정 
 *        초기화 
 *        1. 명시적 초기화  : private int a;
 *                         a=10;
 *        =====================
 *        2. 초기화 블록 
 *        3. 생성자 
 *        ===================== 구현 (파일읽기,파일저장..외부데이터 읽기)
 */
public class FoodSystem {
   public static void main(String[] args) {
	   FoodSystem f=new FoodSystem();
	   
   }
   // 1. 실행 => 파일(오라클)에 저장 
   // 1-1 초기화 블록 ==> 시작과 동시에 수행이 가능 
   // 1-2 생성자 ==> 시작과 동시 호출
	/*
	 *  <div class="top_list_slide">
        <ul class="list-toplist-slider" style="width: 531px;">
            <li>
              <img class="center-croping" alt="안주가 맛있는 술집 베스트 40곳 사진"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/ypeawavxjl9-_zkc.png?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>

              <a href="/top_lists/1482_anju"
                 onclick="trackEvent('CLICK_TOPLIST', {&quot;section_position&quot;:0,&quot;section_title&quot;:&quot;믿고 보는 맛집 리스트&quot;,&quot;position&quot;:0,&quot;link_key&quot;:&quot;R3PGZKC&quot;});">
                <figure class="ls-item">
                  <figcaption class="info">
                    <div class="info_inner_wrap">
                      <span class="title">안주가 맛있는 술집 베스트 40곳</span>
                      <p class="desc">"맛있는 안주와 함께했더니 술에서 꿀맛이 나...!"</p>
	 */
   public FoodSystem()
   {
	   try
	   {
		   Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
	       Elements title=doc.select("div.top_list_slide span.title");
	       Elements subject=doc.select("div.top_list_slide p.desc");
	       StringBuffer sb=new StringBuffer();
	       for(int i=0;i<title.size();i++)
	       {
	    	   System.out.println(title.get(i).text());
	    	   System.out.println(subject.get(i).text());
	    	   System.out.println("\n");
	    	   String data=(i+1)+"|"+title.get(i).text()+"|"
	    			      +subject.get(i).text()+"\n";
	    	   sb.append(data);
	       }
	       
	       File file=new File("c:\\java_data\\category.txt");
	       if(!file.exists())
	       {
	    	   file.createNewFile();
	       }
	       
	       // 파일에 카테고리 저장하기 
	       FileWriter fw=new FileWriter(file);
	       fw.write(sb.toString());
	       fw.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // 2. 사용자가 요청 => 파일(오라클) 읽어서 => ArrayList에 저장후 전송 
}







