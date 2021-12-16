package com.sist.main;
/*
 *  10) B,D,F,H,J,L,N을 출력하는 프로그램을 작성하라 (for 사용)
 */
public class 문제10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char => 연산수행 자동으로 정수형으로 변경 
        for(char c='B';c<='N';c+=2)
        {
        	System.out.print(c+" ");
        }
	}

}
