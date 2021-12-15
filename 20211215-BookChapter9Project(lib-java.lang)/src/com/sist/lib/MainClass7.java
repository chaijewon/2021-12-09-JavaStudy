package com.sist.lib;
/*
 *   변환 
 *   => toUpperCase() => 소문자 => 대문자로 변환  
 *   => toLowerCase() => 대문자 => 소문자로 변환 
 */
import java.util.*;
public class MainClass7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 문제 (오라클은 저장된 데이터 => 대소문자를 구분)
		// Admin ==> Admin , ADMIN , admin
		// 1. 입력(알파벳)=> 대소문자 입력 
		Scanner scan=new Scanner(System.in);
		System.out.print("알파벳 입력:");
		String s=scan.nextLine();
		/*
		 *   nextLine() => 공백을 포함해서 한개의 데이터 읽기
		 *   ==========admin 1234 ==> 한개 데이터 
		 *     
		 *   next() => 공백이 있으면 다른 문자열 
		 *   ====== admin 1234(두개의 데이터)
		 */
		System.out.println("받은 데이터:"+s);
		// 2. 입력된 알파벳을 대문자로 변경
		System.out.println(s.toUpperCase());
		// 3. 입력된 알파벳을 소문자로 변경
		System.out.println(s.toLowerCase());
	}

}






