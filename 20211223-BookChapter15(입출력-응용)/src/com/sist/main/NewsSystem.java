package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
public class NewsSystem {
  public static void main(String[] args) {
	 NewsSystem ns=new NewsSystem();
	 ns.newsGetData("축구");
  }
  //1. 뉴스를 읽어와서 => 파일
  /*
   *   http://newssearch.naver.com/search.naver?where=rss&
   *   query=%EC%98%81%ED%99%94
   */
  public void newsGetData(String fd)
  {
	  try
	  {
	    // fd=> 사용자가 보내준 검색어 (find_data)
	    // 1. 사이트에 접근 
	    String strUrl="http://newssearch.naver.com/search.naver?where=rss"
			       +"&query="
			       +URLEncoder.encode(fd,"UTF-8");
	    // 2. 데이터를 읽어서 News의 종류별 제어 
	    Document doc=Jsoup.connect(strUrl).get();
	    //System.out.println(doc);
	    Elements title=doc.select("rss channel item title");//50
	    Elements desc=doc.select("rss channel item description");//50
	    Elements author=doc.select("rss channel item author");//50
	    StringBuffer sb=new StringBuffer();
	    for(int i=0;i<title.size();i++)
	    {
	    	//System.out.println(title.get(i).text());
	    	//System.out.println(desc.get(i).text());
	    	//System.out.println(author.get(i).text());
	    	//System.out.println("==================================================");
	        String msg=title.get(i).text()+"|"
	        		  +desc.get(i).text()+"|"
	        		  +author.get(i).text()+"\n";
	        sb.append(msg);
	    }
	    
	    // 저장된 내용을 파일에 저장 
	    FileWriter fw=new FileWriter("c:\\java_data\\naver_news.txt");
	    fw.write(sb.toString());
	    fw.close();
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();
	  }
	  
  }
  //2. 뉴스를 사용자에게 보낸다
  public ArrayList<News> newsAllData()
  {
	  ArrayList<News> list=new ArrayList<News>();
	  // 파일을 읽어서 데이터 전송 
	  try
	  {
		  FileInputStream fis=new FileInputStream("c:\\java_data\\naver_news.txt");
		  BufferedReader br=
				  new BufferedReader(new InputStreamReader(fis));
		  while(true)
		  {
			  String data=br.readLine(); // \n
			  if(data==null) break; // 읽을 데이터가 없는 경우 종료 
			  StringTokenizer st=
					  new StringTokenizer(data,"|");
			  News nn=new News();
			  nn.setTitle(st.nextToken());
			  nn.setDescription(st.nextToken());
			  nn.setAuthor(st.nextToken());
			  list.add(nn);
			  
		  }
	  }catch(Exception ex) 
	  {
		  ex.printStackTrace();
	  }
	  return list;
  }
}









