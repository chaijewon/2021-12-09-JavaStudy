package com.sist.munje;
/*
 * 5.	100~999사이에 7의 배수의 갯수와 합을 출력하는 프로그램 작성
	결과)
 */
public class 문제5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int count=0,sum=0; //누적이나 갯수 => 0으로 초기화 
        for(int i=100;i<=999;i++)
        {
        	if(i%7==0)// 7의 배수
        	{
        		count++;// 갯수 
        		sum+=i;//누적 
        	}
        }
        System.out.println("7의 배수 갯수:"+count);
        System.out.println("7의 배수 합:"+sum);
        
	}

}
