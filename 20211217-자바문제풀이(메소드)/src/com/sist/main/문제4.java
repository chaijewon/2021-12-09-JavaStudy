package com.sist.main;
/*
 *  3. 년도를 입력 받아 윤년여부를 확인하는 프로그램 작성
    년도 입력 메소드
    윤년 처리 
    출력 

 */
import java.util.*;
public class 문제4 {
    public int input()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("년도 입력:");
    	return scan.nextInt(); // 입력한 값을 넘겨준다  
    }
    public boolean isYear(int year)
    {
    	boolean bCheck=false;// default 
    	if((year%4==0 && year%100!=0)||(year%400==0))
    		 bCheck=true;
    	return bCheck;
    }
    public void print(int year)// 메소드 자체에서 처리 
    {
    	if(isYear(year)) // 윤년이라면 
    	{
    		System.out.println(year+"년도는 윤년입니다!!");
    	}
    	else // 윤년이 아니면 
    	{
    		System.out.println(year+"년도는 윤년이 아닙니다!!");
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 메소드가 저장이 안됨
		문제4 m=new 문제4();
		int year=m.input();
		m.print(year);
		
	}

}
