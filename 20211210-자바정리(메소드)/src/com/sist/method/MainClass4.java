package com.sist.method;
/*
 *    제어문 
 *    ===== 형식 
 *    조건문 : 단일 조건문 (if) , 선택 조건문 (if~else) 
 *           형식) if(조건문) => 조건문(true/false) => 부정연산자 
 *                                             논리연산자 , 비교연산자
 *                {
 *                   조건이 true일때 수행 
 *                }
 *                => 필요한 내용만 출력이 가능 
 *                
 *                if(조건문)
 *                {
 *                    조건 true일때
 *                }
 *                else
 *                {
 *                    조건 false일때 
 *                }
 *                ====================== 웹 (삼항연산자)
 *                
 *    반복문 : for , while(데이터베이스,네트워크)
 *           ==== for-each
 *           
 *           for 
 *           ==> 일반 for
 *                    1   →   2       4
 *               for(초기값 ; 조건식 ; 증감식)
 *               {            ↓
 *                   실행문장  3        ↗
 *               }
 *               
 *               1 -> 2 -> 3 -> 4
 *               초기값 => 조건 (true) => 실행문장 => 증가 
 *                    2 -> 3 -> 4
 *                    2 -> 3 -> 4
 *                    2 -> 3 -> 4
 *                    == false면 종료  
 *           ==> for-each => 출력만 할 경우 (웹에서 출력)
 *               for(데이터형 변수:배열(컬렉션)) => 형변환 
 *               {   ========== 저장된 데이터보다 크면 상관없다 
 *                   => 배열이나 컬렉션에 저장된 데이터를 대입 
 *               }
 *               
 *           while  : 무한루프 => while(true) : 반드시 종료 조건을 처리
 *           형식)
 *                 초기화 ==========  1
 *                 while(조건문) ===  2 ==> false면 종료 
 *                 {
 *                    반복 수행문장 === 3
 *                    증감식     === 4 ===> 2(조건식으로 이동)
 *                 }
 *           
 *    반복제어문 : break : 반복을 중단 
 */
import java.util.*;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] result={"가위","바위","보"};
        // 모든 가상 ==> 0,1,2
        // 컴퓨터가 가위,바위,보 => 선택 
        int com=(int)(Math.random()*3);//0,1,2
        // 사용자가 가위,바위,보 => 선택 
        Scanner scan=new Scanner(System.in);
        System.out.print("가위(0),바위(1),보(2) 입력:");
        int user=scan.nextInt();
        
        System.out.println("============= 결과 ==========");
        System.out.println("컴퓨터:"+result[com]);
        System.out.println("사용자:"+result[user]);
        int r=com-user;
        if(r==-1 || r==2) 
        {
        	System.out.println("사용자 Win!!");
        }
        else if(r==-2 || r==1)
        {
        	System.out.println("컴퓨터 Win!!");
        }
        else
        {
        	System.out.println("비겼다!!");
        }
        // 비교 
        /*      com          user
         *     컴퓨터        사용자           com-user
         *       가위(0)      가위(0)  (S)      0
         *                   바위(1)  (U)     -1
         *                   보(2)    (C)    -2
         *                   
         *       바위(1)      가위(0)   (C)     1
         *                   바위(1)   (S)     0
         *                   보(2)     (U)     -1
         *                   
         *       보(2)        가위(0)  (U)      2
         *                   바위(1)  (C)      1
         *                   보(2)    (S)      0
         *                   
         *       ================================
         *         user => -1 , 2
         *         com  => -2 ,1 
         *     
         */
	}

}





