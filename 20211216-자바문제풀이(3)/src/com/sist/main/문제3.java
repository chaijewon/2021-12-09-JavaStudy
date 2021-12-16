package com.sist.main;
/*
 *  3) Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 정수의 절대값을 출력하라
 *     if(num<0)
 *     {
 *         System.out.println(num+"의 절대값은 "+num*-1)
 *         num+"의 절대값은 "+(num+1)
 *         num+"의 절대값은 "+(num-1) ==> 오류 
 *         num+"의 절대값은 "+num*1
 *         num+"의 절대값은 "+num/1
 *     }
 *     else
 *     {
 *        System.out.println(num+"의 절대값은 "+num)
 *     }
 */
import java.util.*;
public class 문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("정수 입력:");
        int num=scan.nextInt();
        System.out.println(num+"의 절대값은 "+Math.abs(num));
	}

}
