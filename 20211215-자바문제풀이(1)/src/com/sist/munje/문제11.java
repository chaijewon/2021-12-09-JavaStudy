package com.sist.munje;
/*
 * 11.	정수 입력을 받아서 60이상 합격 =>불합격  if~else
	결과)
	 
	
 */
import java.util.*;
public class 문제11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("점수 입력:");
        int score=scan.nextInt();
        if(score>=60)
        	System.out.println("합격");
        else
        	System.out.println("불합격");
	}

}
