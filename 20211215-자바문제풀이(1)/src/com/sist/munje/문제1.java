package com.sist.munje;
/*
 *   1.	Scanner 클래스를 이용하여 2자리의 정수(10~99사이)를 입력받고,
	십의 자리와 1의 자리가 같은 지 판별하여 출력하는 프로그램을 작성하라.
	
	결과)
	2자리수 정수 입력(10~99) >> 77 
	10의 자리와 1의 자리가 같습니다.
	
	// 조건 ==> 오류처리 
	=> 변수 
	=> 제어문 => 연산처리 
	=> 결과값 	
	
	변수 : 한개를 저장 공간 
	      데이터형
	      정수 : int , long => (파일입출력 : byte) 
	      실수 : double : 소수점 15이상 
	      문자 : char => String
	            ===== 기술면접 (ASC vs Unicode)
	                         =====   ========
	                         싱글바이트(1byte) , 멀티바이트(2byte)
	      논리 : boolean (1byte) => true (1) / false (0)
	연산자 
	  피연산자 몇개? 
	  단항연산자 : 증감연산자 (++ ,--) , 부정연산자 (!) , 형변환 (type)
	  이항연산자 : 산술연산자 ( + , - , * , / , % )
	  ===============================================
	            비교연산자 (==, !=, < , > , <= ,>=)
	            논리연산자 (&& , ||)
	            ========================== if => true/false
	            대입연산자 (= , += ,-=)
	  삼항연산자 : (조건)?값:값  ==> if~else
	  
	제어문 
	  조건문 
	    if(조건)
	    {
	       true일때 처리되는 문장 
	    }
	    =====================
	    if(조건)
	    {
	       true일때 처리되는 문장 
	    }
	    else
	    {
	       false일때 처리되는 문장 
	    }
	    ======================
	    다중 조건문은 1개의 문장만 수행 
	    if(조건)
	    {
	       true일때 처리되는 문장 => 종료 
	       false 
	    }       ↘
	    else if(조건)
	    {
	       true일때 처리되는 문장  => 종료
	       false 
	    }       ↘
	    else if(조건)
	    {
	       true일때 처리되는 문장  => 종료
	       false 
	    }       
	    else
	    {
	       해당 조건이 없는 상태 수행 
	    }
	    
	  반복문
	    while: 반복횟수가 없는 경우에 주로 사용 (무한루프)
	           초기값  ---------- 1
	           while(조건)  ---- 2
	           {
	              반복 수행문장 ---3 
	              증감식   -------4
	           }
	           1-2-3-4
	             2-3-4
	             2-3-4
	             =false면 종료 
	    for : 반복횟수가 있는 경우 주로 사용 
	                1    2    4
	          for(초기값;조건식;증감식)
	          {
	              반복 수행문장  3
	          }
	           1-2-3-4
	             2-3-4
	             2-3-4
	             =false면 종료 
	  반복제어문 
	     break : 반복을 종료
	     continue : 특정부분 제외 
 */
import java.util.*;
public class 문제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 입력값을 받는다 
		 Scanner scan=new Scanner(System.in);
		 int num=0; // 지역변수는 반드시 사용전에 초기화 
		 while(true)
		 {
			 System.out.print("2자리수 정수 입력(10~99) >> ");
			 num=scan.nextInt();
			 if(num<10 || num>99)
			 {
				 System.out.println("10~99까지만 입력하세요");
				 continue;
			 }
			 break; // 10~99까지만 입력이 가능하게 만든다 
		 }
		 
		 // 입력을 받으면 처리 
		 if(num%11==0)
		 {
			 System.out.println("10의 자리와 1의 자리가 같습니다.");
		 }
		 else
		 {
			 System.out.println("10의 자리와 1의 자리가 같지 않습니다."); 
		 }
	}

}









