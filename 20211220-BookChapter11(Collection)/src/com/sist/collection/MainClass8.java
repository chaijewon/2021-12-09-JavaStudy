package com.sist.collection;
import java.util.*;
// Set 사용 
public class MainClass8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList list=new ArrayList();
        // 영화 장르 
        list.add("드라마"); //0
        list.add("액션");//1
        list.add("판타지");//2
        list.add("코믹");//3
        list.add("멜로");//4
        list.add("액션");//5
        list.add("드라마");//6 => 찾기 (인덱스를 이용하는 프로그램)
        // 배열과 거의 사용법이 비슷
        
        // List => 데이터 중복을 허용 
        System.out.println("===== list의 원본 출력 ======");
        //System.out.println(list.toString());
        Iterator it=list.iterator(); // list가 가지고 있는 데이터 접근
        while(it.hasNext())
        {
        	System.out.println(it.next());
        }
        // 중복 제거 
        HashSet set=new HashSet();
        
        for(Object genre:list)
        {
        	set.add(genre);// HashSet에 데이터를 첨부 => 중복 제거 
        }
        System.out.println("===== set에 저장된 데이터 출력 =====");
        //System.out.println(set.toString());
        it=set.iterator();
        while(it.hasNext())
        {
        	System.out.println(it.next());
        }
        
        // ArrayList => 관리하기 쉽기 때문에 
        // 기존의 데이터를 한번 지워준다 
        list.clear();
        for(Object genre:set)
        {
        	list.add(genre);
        }
        
        System.out.println("===== 중복을 제거한 데이터 출력 =====");
        //System.out.println(list.toString());
        it=list.iterator();
        while(it.hasNext())
        {
        	System.out.println(it.next());
        }
        /*
         *   출력 => list.toString() => [데이터....]
         *          for(Object obj:list)
         *          while(it.hasNext())
         *          {
         *             System.out.println(it.next())
         *          }
         *          
         *          list에 데이터를 모아서 브라우저로 전송 (자바->브라우저)
         *          request.setAttribute("list",list) 
         */
	}

}
