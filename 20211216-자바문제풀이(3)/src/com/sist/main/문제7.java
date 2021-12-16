package com.sist.main;
/*
 *  정수 2개와 연산자(+,-,*,/)를 입력 받아 사칙 연산하는 프로그램을 만들어라 
   (switch~case 사용) 

 */
import java.util.*;
public class 문제7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
        System.out.print("첫번째 정수 입력:");
        int num1=scan.nextInt();
        System.out.print("두번째 정수 입력:");
        int num2=scan.nextInt();
        System.out.print("연산자 입력(+,-,*,/):");
        String op=scan.next();
        
        switch(op) // String , char , int
        {
        case "+":
        	System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);
        	break;
        case "-":
        	System.out.printf("%d-%d=%d\n",num1,num2,num1-num2);
        	break;
        case "*":
        	System.out.printf("%d*%d=%d\n",num1,num2,num1*num2);
        	break;
        case "/": // 오류처리 (if) ==> try~catch
        	if(num2==0)
        		System.out.println("0으로 나눌 수 없습니다");
        	else
        	    System.out.printf("%d/%d=%d\n",num1,num2,num1/num2);
        	break;
        }
	}

}
