package com.sist.main;

import java.util.Scanner;

/*
 *  5) 100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D,
   60점 이하면 F를 출력하라 (다중 if 사용)
   
   if(조건문)
   {
      조건문이 true => 문장 수행후 => 종료
      조건문이 false => 아래있는 조건문으로 이동 
   }
   else if(조건문)
   {
      조건문이 true => 문장 수행후 => 종료
      조건문이 false => 아래있는 조건문으로 이동
   }
   else if(조건문)
   {
      조건문이 true => 문장 수행후 => 종료
      조건문이 false => 아래있는 조건문으로 이동
   }
   else if(조건문)
   {
      조건문이 true => 문장 수행후 => 종료
      조건문이 false => 아래있는 조건문으로 이동
   }
   else
   {
       해당 조건이 없는 경우 수행하는 문장 
   }

 */
public class 문제5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
        System.out.print("점수 입력:");
        int score=scan.nextInt();
        
        char c='A';
        if(score>=90)
        	c='A';
        else if(score>=80)
        	c='B';
        else if(score>=70)
        	c='C';
        else if(score>=60)
        	c='D';
        else
        	c='F';
        
        System.out.println("학점:"+c);
	}

}
