package com.sist.munje;
/*
 * 8.	1~100 3의 배수이고 5의 배수를 출력하는 프로그램 작성
	결과)
 */
public class 문제8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=1;i<=100;i++)
        {
        	if(i%3==0 && i%5==0)//3의 배수이고 5의 배수
        	{
        		System.out.print(i+" ");
        	}
        }
	}

}
