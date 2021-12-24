package com.sist.temp;
// ¿”Ω√ => µ•¿Ã≈Õ ºˆ¡˝ => ∆ƒ¿œ , ø¿∂Û≈¨ 
// 1. µ•¿Ã≈Õ ºˆ¡˝ 
// 2. ArrayListø° ¥Î¿‘ 
// 3. ArrayList∏¶ ∆ƒ¿œø° ¿˙¿Â
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import com.sist.music.*;// ªÁøÎ¿⁄ ¡§¿« ≈¨∑°Ω∫ ∑Œµ˘ 
// ∆–≈∞¡ˆ∞° ¥Ÿ∏£∏È => import∏¶ ¿ÃøÎ«ÿº≠ « ø‰«— ≈¨∑°Ω∫∏¶ ¿–æÓ ø¬¥Ÿ 
/*
 *     <input type="checkbox" class="select-check" title="All I Want for Christmas Is You"></td>
              <td class="number">1
               <span class="rank">
                 <span class="rank">3<span class="rank-none">
                 <span class="hide">ªÛΩ¬</span></span></span>
              </span>
              </td>
              <td>
               <a href="#" class="cover" onclick="fnViewAlbumLayer('80384589');return false;"><span class="mask"></span><img src="//image.genie.co.kr/Y/IMAGE/IMG_ALBUM/080/384/589/80384589_1572569104266_1_140x140.JPG/dims/resize/Q_80,0" onerror="this.src='//image.genie.co.kr/imageg/web/common/blank_68.gif';" alt="Merry Christmas (Deluxe Anniversary Edition)"></a></td>
               <td class="link">
               <a href="#" class="btn-basic btn-info" onclick="fnViewSongInfo('82146674');return false;">∞Ó ¡¶∏Ò ¡§∫∏ ∆‰¿Ã¡ˆ</a></td>
              <td class="info">
               <a href="#" class="title ellipsis" title="¿Áª˝" onclick="fnPlaySong('82146674','1');return false;">
                 All I Want for Christmas Is You</a>
               <a href="#" class="artist ellipsis" onclick="fnViewArtist('14937308');return false;">Mariah Carey</a>
               <i class="bar">|</i>
               <a href="#" class="albumtitle ellipsis" onclick="fnViewAlbumLayer('80384589');return false;">Merry Christmas (Deluxe Annivers
 */
public class MusicMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // µ•¿Ã≈Õ∏¶ ¿•ø°º≠ ¿–±‚ 
		// ¿˙¿Â ∞¯∞£ 
		ArrayList<Music> list=
				  new ArrayList<Music>();
		try
		{
			// ªÁ¿Ã∆Æ¿« µ•¿Ã≈Õ ¿–±‚ ==> 
			// https://www.genie.co.kr/chart/top200?ditc=D&ymd=20211224&hh=14&rtm=Y&pg=3
			int k=1;
			for(int i=1;i<=4;i++)
			{
				// <a>
				Document doc=
					Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20211224&hh=14&rtm=Y&pg="+i).get(); // ªÁ¿Ã∆Æø° ¿÷¥¬ µ•¿Ã≈Õ ¿–±‚ 
			    Elements title=doc.select("td.info a.title");
			    Elements singer=doc.select("td.info a.artist");
			    Elements album=doc.select("td.info a.albumtitle");
			    Elements etc=doc.select("span.rank");
			    
			    for(int j=0;j<title.size();j++)
			    {
			      try
			      {
			    	System.out.println(k);
			    	System.out.println(title.get(j).text());
			    	System.out.println(singer.get(j).text());
			    	System.out.println(album.get(j).text());
			    	String temp=etc.get(j).text();
			    	String state=temp.replaceAll("[^∞°-∆R]","");
			    	String id=temp.replaceAll("[^0-9]","");
			    	if(state.equals("¿Ø¡ˆ"))
			    	{
			    		id="0";// µÓ∆¯¿Ã æ¯¥Ÿ 
			    	}
			    	System.out.println("µÓ∆¯:"+id);
			    	System.out.println("ªÛ≈¬:"+state);
			    	System.out.println("\n");
			    	
			    	// ArrayListø° ¿˙¿Â
			    	Music m=new Music();
			    	m.setNo(k);
			    	m.setTitle(title.get(j).text());
			    	m.setSinger(singer.get(j).text());
			    	m.setAlbum(album.get(j).text());
			    	m.setState(state);
			    	m.setIdcrment(Integer.parseInt(id));
			    	list.add(m);
			    	k++;
			      }catch(Exception ex){}
			    }
			    
			}
			// ∞¥√º ¥‹¿ß ¿˙¿Â 
			FileOutputStream fos=
					new FileOutputStream("c:\\java_data\\music_object.txt");
			// ∆ƒ¿œ ¿⁄µø ª˝º∫¿Ã µ»¥Ÿ 
			ObjectOutputStream oos=
					new ObjectOutputStream(fos);
			oos.writeObject(list);
			// ¥›±‚
			fos.close();
			oos.close();
			System.out.println("∆ƒ¿œ ¿˙¿Â øœ∑·!!");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}










