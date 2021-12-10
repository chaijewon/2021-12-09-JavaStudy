package com.sist.method;
/*
 *    메소드 요소 
 *    ===== 변수+연산자+제어문 
 *      연산자 : 증감(++,--) , 산술 , 비교 , 논리 
 *             ========== 전치 /후치 
 *                       ++a   a++ 
 *      int a=10;
 *      int b=++a + a++ + a++ + ++a 
 *            ===   ===   ===   ===
 *             11    11    12    14 ==> 48
 *      int a=10;
 *      int b=++a + ++a + ++a + ++a
 *            ===   ===   ===   ===
 *             11   12     13    14  => 50
 *      
 *           
 *      int a=10;
 *      int b=++a;
 *            ==
 *             1
 *          ===
 *            2
 *      
 *      int b=a++;
 *          ==
 *           1
 *             ===
 *               2
 *      
 */
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=++a + ++a + ++a + ++a;
		System.out.println(b);
	}

}
