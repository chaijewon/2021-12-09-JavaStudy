package com.sist.main;
/*
 *  2) 한 개의 정수를 입력 받아 3의 배수인지 판별하여 출력하라
 *     if(i%3==0)
 *     {
 *     }
 *     else
 *     {
 *     }
 */
import java.util.*;
public class 문제2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("정수 입력:");
        int num=scan.nextInt();
        if(num%3==0)
        {
        	System.out.println(num+"는(은) 3의 배수다");
        }
        else
        {
        	System.out.println(num+"는(은) 3의 배수가 아니다");
        }
	}

}
