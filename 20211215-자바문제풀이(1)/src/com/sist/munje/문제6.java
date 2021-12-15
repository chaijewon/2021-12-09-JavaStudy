package com.sist.munje;
/*
 * 6.	100~999 사이의 4의배수가 아닌 수의 갯수,합을 출력하는 프로그램 작성
	결과)
 */
public class 문제6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0,sum=0; //누적이나 갯수 => 0으로 초기화 
        for(int i=100;i<=999;i++)
        {
        	if(i%4!=0)// 4의 배수가 아닌 
        	{
        		count++;// 갯수 
        		sum+=i;//누적 
        	}
        }
        System.out.println("4의 배수가 아닌 갯수:"+count);
        System.out.println("4의 배수가 아닌 합:"+sum);
        
	}

}
