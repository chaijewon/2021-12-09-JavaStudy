package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
 *  <tr class="list" songid="95038278">
        <td class="check"><input type="checkbox" class="select-check" title="리무진 (Feat. MINO) (Prod. by GRAY)" /></td>
            <td class="number">3
              <span class="rank">
               <span class="rank"><span class="rank-none"><span
                           class="hide">유지</span></span></span>
  </span>
  </td>
 <td><a href="#" class="cover" onclick="fnViewAlbumLayer('82398969');return false;"><span class="mask"></span><img src="//image.genie.co.kr/Y/IMAGE/IMG_ALBUM/082/398/969/82398969_1637305467028_1_140x140.JPG/dims/resize/Q_80,0" onerror="this.src='//image.genie.co.kr/imageg/web/common/blank_68.gif';" alt="쇼미더머니 10 Episode 3" /></a></td>
 <td class="link"><a href="#" class="btn-basic btn-info" onclick="fnViewSongInfo('95038278');return false;">곡 제목 정보 페이지</a></td>
 <td class="info">
  <a href="#" class="title ellipsis" title="재생" 
  onclick="fnPlaySong('95038278','1');return false;">
 리무진 (Feat. MINO) (Prod. by GRAY)</a>
<a href="#" class="artist ellipsis" 
onclick="fnViewArtist('80828775');return false;">BE'O (비오)</a>

<a href="#" class="albumtitle ellipsis" 
onclick="fnViewAlbumLayer('82398969');return false;">
쇼미더머니 10 Episode 3</a>
                                </td>
 */
public class MusicSystem {
   private static ArrayList list=new ArrayList(); // 뮤직의 전체정보를 가지고 있다 
   // 음악은 정보는 1개만 사용하면 된다 => 공동으로 사용하는 데이터 
   // 1. 데이터 초기화 (저장) ==> 오라클 
   // 데이터 읽이어서 초기화 (구현) => 초기화 블록(호출없이 자동 처리) , 생성자 
   // 초기화 블록을 이용해서 데이터를 메모리에 저장 
   static 
   {
	   try
	   {
	     // 1. 사이트 연결 => 서버에서 가지고 오는 데이터를 저장
	     Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
	     // 2. 해당 데이터 읽기
	     Elements title=doc.select("td.info a.title");
	     Elements singer=doc.select("td.info a.artist");
	     Elements album=doc.select("td.info a.albumtitle");
	     // 3. Music에 저장 
	     for(int i=0;i<title.size();i++)
	     {
	    	 Music music=new Music();
	    	 // 초기값 
	    	 music.setTitle(title.get(i).text());
	    	 music.setSinger(singer.get(i).text());
	    	 music.setAlbum(album.get(i).text());
	    	 list.add(music);
	     }
	     // 4. list에 추가 
	   }catch(Exception ex){}
   }
   // 목록 출력
   public ArrayList musicListData()
   {
	   return list;
   }
   // 찾기 => 제목 , 가수명 , 앨범 ==> contains 
   public ArrayList musicFindData(String fd)
   {
	   ArrayList fList=new ArrayList(); // 찾은 데이터만 모아서 전송 
	   for(int i=0;i<list.size();i++)
	   {
		   Music m=(Music)list.get(i); // 저장됭어 있는 Music을 1개씩 읽어 온다 
		   if(m.getTitle().contains(fd))
		   {
			   // 노래 제목안에 사용자 보내준 검색어가 포함여부 확인 
			   fList.add(m);
		   }
	   }
	   return fList;
   }
   
}
















