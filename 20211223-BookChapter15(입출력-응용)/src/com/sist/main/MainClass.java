package com.sist.main;
/*
 *   1. 데이터형 (필요한 데이터를 모아서 한번에 관리)
 *      News => 데이터 변질, 다른 클래스에서 접근이 없게 만든다 (캡슐화)
 *   2. 실제 사용자가 요청한 내용을 처리하는 기능(액션 클래스) => 기능 처리 (메소드)
 *   3. 사용자가 사용이 가능하게 만든다 (main()) 
 *      ================================ JSP , main.kt
 */
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        NewsSystem ns=new NewsSystem();
        // 검색어 입력 요청 
        Scanner scan=new Scanner(System.in);
        System.out.print("검색어 입력:");
        String fd=scan.next();
        ns.newsGetData(fd);// 파일에 저장 
        ArrayList<News> list=ns.newsAllData();
        System.out.println("***** 검색 결과 *****");
        for(News n:list)
        {
        	System.out.println(n.getTitle());
        	System.out.println(n.getDescription());
        	System.out.println(n.getAuthor());
        	System.out.println("\n");
        }
	}

}
