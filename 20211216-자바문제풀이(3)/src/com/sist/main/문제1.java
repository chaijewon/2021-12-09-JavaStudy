package com.sist.main;
/*
 *  1) Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 양수인지 음수인지 판별하여 출력하라
 *     if(조건문)
 *     {
 *        조건문 true 
 *     }
 *     else
 *     {
 *        조건문 false
 *     }
 *     
 *     조건 ? 출력1 : 출력2 ==> 웹 
 */
import java.util.*;
public class 문제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("정수 입력:");
        int num=scan.nextInt();
        ///////// 1줄
        /*if(num>0)
        {
        	System.out.println(num+"는(은) 양수입니다");
        }
        else
        {
        	System.out.println(num+"는(은)  음수입니다");
        }*/
        ////////
        // 삼항연산자 
        System.out.println(num>0?num+"는(은) 양수입니다":num+"는(은)  음수입니다");
	}

}








