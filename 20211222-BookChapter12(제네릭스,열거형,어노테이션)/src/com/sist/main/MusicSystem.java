package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
 * <tr class="list" songid="95299676">
      <td class="check"><input type="checkbox" class="select-check" title="Counting Stars (Feat. Beenzino)" /></td>
      <td class="number">1
       <span class="rank">
       <span class="rank"><span class="rank-none"><span
       class="hide">유지</span></span></span>
       </span>
      </td>
      <td><a href="#" class="cover" onclick="fnViewAlbumLayer('82433812');return false;"><span class="mask"></span><img src="//image.genie.co.kr/Y/IMAGE/IMG_ALBUM/082/433/812/82433812_1639126931936_1_140x140.JPG/dims/resize/Q_80,0" onerror="this.src='//image.genie.co.kr/imageg/web/common/blank_68.gif';" alt="Counting Stars" /></a></td>
      <td class="link"><a href="#" class="btn-basic btn-info" onclick="fnViewSongInfo('95299676');return false;">곡 제목 정보 페이지</a></td>
      <td class="info">
       <a href="#" class="title ellipsis" title="재생" onclick="fnPlaySong('95299676','1');return false;">
       Counting Stars (Feat. Beenzino)</a>
       <a href="#" class="artist ellipsis" onclick="fnViewArtist('80828775');return false;">BE'O (비오)</a>
       <div class="toggle-button-box" >
       <button type="button" class="btn artist-etc" onclick="fnRelationArtistList('95299676');">외</button>
       <ul class="list" id="RelationArtist_95299676"></ul>
                                        </div>
       <i class="bar">|</i>
       <a href="#" class="albumtitle ellipsis" onclick="fnViewAlbumLayer('82433812');return false;">Counting Stars</a>
     </tr>
 */
public class MusicSystem {
   // Music전체 데이터를 공유 ==> static (오라클 => static)
   private static ArrayList<Music> list=new ArrayList<Music>();
   // 프로그램 시작과 동시에 데이터를 모아둔다 (초기화)
   /*
    *                   Exception (소스상에서 에러를 처리=> 가벼운 에러)
    *                      |
    *    -------------------------------------
    *         |                        |
    *    CheckException(javac)   UnCheckException(java)
    *    네트워크 => URL주소 , 서버주소      => Runtime관련 (생략이 가능)
    *    오라클 => (서버) => 서버주소(IP)   => 사용자 입력
    *    쓰레드 => 충돌 방지 
    *    클래스관련 => 클래스명을 잘못 준 경우
    *    입출력 => 파일 (경로명)
    *    => 사전에 에러를 방지하는 프로그램 
    *    => 프로그램의 동작을 정상적으로 수행 
    */
   static
   {
	  //웹 연결(네트워크) => CheckException
	  try
	  {
		  // 서버연결후 읽어온 데이터를 저장 
		  Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		  Elements title=doc.select("tr.list a.title");
		  Elements singer=doc.select("tr.list a.artist");
		  Elements album=doc.select("tr.list a.albumtitle");
		  for(int i=0;i<title.size();i++)
		  {
			  System.out.println("순위:"+(i+1));
			  System.out.println(title.get(i).text());
			  System.out.println(singer.get(i).text());
			  System.out.println(album.get(i).text());
			  System.out.println("============================");
			  // ArrayList에 데이터 저장 
			  // 1.데이터 클래스에 저장 
			  Music m=new Music();
			  m.setRank(i+1);
			  m.setTitle(title.get(i).text());
			  m.setSinger(singer.get(i).text());
			  m.setAlbum(album.get(i).text());
			  // 2. 저장된 클래스 => ArrayList에 저장 
			  list.add(m);
			  
		  }
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();
	  } 
   }
   // 기능 
   // 전체 목록
   public ArrayList<Music> musicAllData()
   {
	   return list;
   }
   // 프로그램 => 데이터 관리 
   // 데이터 관리 : 메모리 / 파일 / 오라클 / 웹서버
   // ========= 1. 모아서 관리 (클래스,배열,컬렉션) => 가공 (연산자,제어문)
   // 찾기 
   public ArrayList<Music> musicFindData(String ss)
   {
	   // ss => searchString
	   // 찾은 데이터를 다시 모아서 전송 
	   ArrayList<Music> mList=new ArrayList<Music>();
	   for(Music m:list)
	   {
		   if(m.getTitle().contains(ss))
		   {
			   mList.add(m);
		   }
	   }
	   return mList;
   }
   // 중복없는 가수 출력 => HashSet  
   // 메소드 => 리턴형을 먼저 설정하고 처리 
   public ArrayList<String> singerData()
   {
	   ArrayList<String> sList=new ArrayList<String>();
	   HashSet<String> set=new HashSet<String>();
	   for(Music m:list)
	   {
		   set.add(m.getSinger()); // 중복된 가수명은 제거 
	   }
	   sList.addAll(set);//List=> Set , Set =>List
	   return sList;
   }
	
}







