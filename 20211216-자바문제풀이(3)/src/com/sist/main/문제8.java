package com.sist.main;
/*
 *  8) 2+4+6+....100까지의 정수의 합을 구하고 출력하라 (for 사용)
 *  
 *       1  →  2  ← 4
 *  for(초기값;조건식;증감식)
 *           ↓      ↗
 *     반복문장 수행 3 
 */
public class 문제8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int sum=0;
        for(int i=2;i<=100;i+=2)
        {
        	sum+=i;
        }
        
        System.out.println("2+4+6+....100까지의 정수의 합:"+sum);
	}

}
