package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *    1. ��ȭ => ���̹� / ���� (******) Youtube (������)
 *    *****2. ���� => �����÷���Ʈ 
 *    3. ���� => ���� ���� / ?
 *    4. ������ => 10000�� 
 *    5. ���� => ���� / ���  (******) Youtube (������) 
 *    6. ��ǰ => 10000�� 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// Jsoup => Html Parser
        	// �� ����Ʈ�� ���� 
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





