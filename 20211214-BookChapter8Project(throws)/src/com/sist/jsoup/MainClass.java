package com.sist.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
 *  <a href="#" class="title ellipsis" title="재생" onclick="fnPlaySong('95299676','1');return false;">
                          
     Counting Stars (Feat. Beenzino)</a>
 */
public class MainClass {

	/*public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        // 네트워크 (예외처리)
		try
		{
			// 정상적으로 실행되는 문장 
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200")
					     .get();
		    //System.out.println(doc.toString());
		    Elements title=doc.select("a.title");
		    for(int i=0;i<title.size();i++)
		    {
		    	System.out.println((i+1)+"."+title.get(i).text());
		    }
		}catch(Exception ex)
		{
			ex.printStackTrace();//에러 확인 
		}
	}*/
	/*
	 *    catch => 복구가 가능 
	 *    throws => 복구는 할 수 없고 에러 확인만 가능 
	 *    =====================================
	 *     에러가 발생을 해도 정상적으로 종료를 할 수 있다  
	 */
	public static void main(String[] args) throws Exception{
		// 정상적으로 실행되는 문장 
	    Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200")
							     .get();
	    // Document org.jsoup.Connection.get() throws IOException
	    // CheckException => 무조건 예외처리
	    /*
	     *   1. try~catch
	     *   2. throws
	     */
	    //System.out.println(doc.toString());
		Elements title=doc.select("a.title");
		for(int i=0;i<title.size();i++)
		{
		   System.out.println((i+1)+"."+title.get(i).text());
		}
	}

}
