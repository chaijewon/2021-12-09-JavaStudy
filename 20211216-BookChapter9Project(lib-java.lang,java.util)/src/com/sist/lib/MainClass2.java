package com.sist.lib;
// => 494 page (오토박싱/언박싱)
/*
 *    컴파일러에 의해 자동 추가 
 *    1. class A extends Object
 *               ==============
 *    2. public void display()
 *       {
 *       
 *           return이 없는 경우에 자동 추가 
 *       }
 *    3. class A
 *       {
 *          // public A(){} => 디폴트 생성자 
 *       }
 *    4. import java.lang.*;
 *    5. Integer i=10;
 *       int j=i.intValue();
 *              ============
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 오토박싱 
		Integer i=10; //int 오토박싱 
		int j=i; // 언박싱
		// int j=i.intValue() ==> 1.5 자동 추가 
		System.out.println("i="+i);
		System.out.println("j="+j);
		
		Double d1=10.5;
		double d2=d1;// 클래스가 가지고 있는 데이터 ==> 일반데이터형에 대입 (언박싱)
		
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		
		Boolean b1=true;
		boolean b2=b1; // 클래스와 일반데이터형을 매칭이 가능 
		
		System.out.println("b1="+b1);
		System.out.println("b2="+b2);
		//데이터형 통일화 => 제네릭스 
		// List<int> ==> X , List<Integer> ==> 핵심
		// 일반데이터과 동일하게 취급한다 
		// Object => 모든 데이터형 / 모든 클래스를 받을 수 있다 
		// Object => 클래스가 여러개 있는 경우 한개로 묶어서 사용이 가능 
		// 프로그램 => 묶어서 사용 ==> 한개의 이름으로 처리 
		// 데이터 여러개 있는 경우 => 배열(같은 데이터) , 클래스(다른 데이터)
		// 명령문 여러개 => 메소드 
		// 데이터 여러개 , 메소드 여러개 ==> 클래스 
		// 클래스가 여러개 ==> 인터페이스 , Object 
		// 보기 쉽게 => 가독성 , 재사용 ==> 조립식 
		Object o1=10;
		Object o2=10.5;
		Object o3=true;
		Object o4='A';
		Object o5=10.9f;
		Object o6=100L;
		System.out.println("o1="+o1);
		System.out.println("o2="+o2);
		System.out.println("o3="+o3);
		System.out.println("o4="+o4);
		System.out.println("o5="+o5);
		System.out.println("o6="+o6);
		//return 
	}

}






