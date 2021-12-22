package com.sist.main;
import java.util.*;
enum 사이트{
	DAUM("www.daum.net"),
	NAVER("www.naver.com"),
	GOOGLE("www.google.co.kr"),
	SIST("www.sist.co.kr"),
	NATE("www.nate.com");
	
	private String site;
	사이트(String site)
	{
		this.site=site;
	}
	
	public String getSite()
	{
		return site;
	}
}
// "C:\Program Files\Google\Chrome\Application\chrome.exe"
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 사용자로부터 값을 받는다 
		Scanner scan=new Scanner(System.in);
		System.out.print("방문 할 사이트 입력:");
		String s=scan.next();
		
		//사이트 찾기
		for(사이트 site:사이트.values())
		{
			// equalsIgnoreCase(s) : 대소문자 구분없이 찾는다 
			// daum ,DAUM ,Daum....
			if(site.name().equalsIgnoreCase(s))
			{
				String ss=site.getSite();
				try
				{
					// exe파일 실행시에 사용 => CheckException(반드시 예외처리)
					Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "+ss);
				}catch(Exception ex) {}
				
			}
		}
	}

}





