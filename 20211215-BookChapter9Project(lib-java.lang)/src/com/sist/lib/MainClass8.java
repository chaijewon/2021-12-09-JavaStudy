package com.sist.lib;
import java.util.*;
// 응용 => toUpperCase(문자-32) , toLowerCase(문자+32)
// 조건 ==> && (포함), ||(미포함)
/*
 *   if(score>=0 && score<=100) => BETWEEN 0 AND 100
 *   if(score<0 || score>100) => 오류 처리 
 */
public class MainClass8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 입력값 받기 
		Scanner scan=new Scanner(System.in);
		System.out.print("알파벳 입력:");
		String data=scan.next();
		// ASC 
		/*
		 *   A => 65 
		 *   a => 97
		 *   '0'=> 48 '1' '2' 
		 */
		// 대문자로 변환 => toUpperCase()
		/*for(int i=0;i<data.length();i++)
		{
			char c=data.charAt(i);
			if(c>='a' && c<='z') // 소문자라면 
			{
				System.out.print((char)(c-32));
			}
		}*/
		// 소문자 변환  => toLowerCase()
		for(int i=0;i<data.length();i++)
		{
			char c=data.charAt(i);
			if(c>='A' && c<='Z') // 소문자라면 
			{
				System.out.print((char)(c+32));
			}
		}
		System.out.println((int)'0');
	}

}
