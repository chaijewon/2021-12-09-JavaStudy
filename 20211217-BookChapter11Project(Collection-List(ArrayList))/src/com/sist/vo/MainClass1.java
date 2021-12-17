package com.sist.vo;
// ==> 모아서 처리 
import java.util.*;
public class MainClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 초기값 
		Food food=new Food(); // 맛집 1개를 만든다 
		// 어떤 데이터를 저장할지 초기값 => 저장 
		food.setTitle("고기리막국수");
		food.setScore(4.5);
		food.setAddress("경기도 용인시 수지구 이종무로 157 "
				  +"지번 경기도 용인시 수지구 고기동 593-4");
		food.setTel("031-263-1107");
	    food.setType("국수 / 면 요리");
	    food.setPrice("만원 미만");
	    food.setParking("무료주차 가능");
	    food.setTime("11:00 - 21:00");
	    food.setMenu("들기름막국수 "
	    		+ "8,000원 "
	    		+ "물막국수 "
	    		+ "8,000원 "
	    		+ "비빔막국수 "
	    		+ "8,000원 "
	    		+ "사리 "
	    		+ "4,000원 "
	    		+ "수육 (소) "
	    		+ "13,000원");
	    food.setGood(153);
	    food.setSoso(15);
	    food.setBad(10);
		
	    // 맛집 한개 저장 출력 
	    System.out.println(food.getTitle()+" "+food.getScore());
	    System.out.println("======================");
	    System.out.println("주소 "+food.getAddress());
	    System.out.println("전화번호 "+food.getTel());
	    System.out.println("음식 종류 "+food.getType());
	    System.out.println("가격대 "+food.getPrice());
	    System.out.println("주차 "+food.getParking());
	    System.out.println("영업시간 "+food.getTime());
	    System.out.println("메뉴 ");
	    StringTokenizer st=new StringTokenizer(food.getMenu(),"원");
	    while(st.hasMoreTokens())
	    {
	    	System.out.println("    "+st.nextToken()+"원");
	    }
	    System.out.println("======================");
	    System.out.println("좋아요("+food.getGood()+") "
	    		  +"괜찮다("+food.getSoso()+") "
	    		  +"별로("+food.getBad()+")");
	}

}







