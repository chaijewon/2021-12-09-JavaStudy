package com.sist.lib;
// Math ==> 수학관련 
/*
 *   ==> 데이터 얻기 => 오라클 
 *   1. 난수 => random()
 *      원형) public static double random();
 *                                ========= 임의의 수를 추출 
 *                                0.0~0.99 
 *                                ========
 *                               (int)((0.0~0.99)*100)+1
 *                                     ========== ====
 *                                         1        2
 *                                =====
 *                                   3                 ==
 *                                                      4
 *                                1,2=> 0.0~99.0
 *                                3=> 0~99
 *                                4=> 1~100
 *   2. 올림 => ceil()  ==> ceil(17/5.0) ==> 3.4 ==> 4 => 총페이지 
 */
public class MainClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int count=103;// 데이터 총갯수 
        int total=103/15;
        if(total%15>0)
        {
        	total++;
        }
        System.out.println("총페이지:"+total);
        
        System.out.println("=====lib이용=====");
        int total2=(int)Math.ceil(count/15.0);
        System.out.println(total2);
        // 자바 => CBD (이미 만들어진 라이브러리 => 조립식) => 레고 
        // 기능 => 검색 (구글링) => 분석 
	}

}











