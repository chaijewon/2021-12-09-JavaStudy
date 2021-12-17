package com.sist.main;
/*
 *  정수를 입력 받아서 이진법을 출력하는 메소드 작성(3개의 메소드)
    정수 입력 
    이진법 처리 => 배열 
                 ===> 전역변수 
    출력 => 배열 

 */
import java.util.*;
public class 문제2 {
    private int[] arr=new int[16];
    public int input()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("정수 입력(0~32767):");
    	return scan.nextInt();
    }
    public void binary()
    {
    	// 정수값 받기 
    	int user=input();
    	int index=15; // 배열의 맨뒤부터 데이터 채우기 
    	while(true)
    	{
    		arr[index]=user%2;
    		user=user/2;
    		if(user==0)
    			break;
    		index--;
    	}
    }
    public void print()
    {
    	for(int i=0;i<arr.length;i++)
    	{
    		if(i%4==0 && i!=0)
    			System.out.print(" ");
    		System.out.print(arr[i]);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        문제2 m=new 문제2();
        m.binary();
        m.print();
	}

}
