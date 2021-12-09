package com.sist.main;

import java.util.Arrays;

// 제어문 사용 
// 메소드 
// 객체 지향  ==> 내부클래스 
// 오류없는 프로그램 (예외처리) 
// 1장 ~ 8장 
/*
 *    단일 조건문
 *    다중 조건문
 *    
 *    1~100까지 ==> 3배수 , 5배수 , 7배수의 합 
 *       단일 조건문 사용 
 *       
 *    제어문 => 조건문 
 *      포함  : &&  ==> 페이징 
 *      미포함 : || (범위를 벗어나는 경우) 
 *      
 *      
 *      45, 67, 90, 34, 12
 *      ==  ==
 *      67  45
 *      ==      ==
 *      90      67
 *      ==          ==
 *      90          34
 *      ==              ==
 *      90              12 
 *      ============================ 1 라운드 (for 1)
 *      90  45  67  34  12
 *      ==
 *     고정
 *          45  67  34  12
 *          ==  ==
 *          67  45
 *          ==      ==
 *          67      34
 *          ==          ==
 *          67          12
 *     ============================= 2 라운드 (for 2)
 *     90   67
 *             45   34  12
 *             ===  ==
 *             45   34
 *             ===      ==
 *             45       12
 *     ============================= 3 라운드 (for 3)
 *     90   67 45
 *                 34   12
 *                 ==   ==
 *                 34   12
 *     ============================= 4 라운드 (for 4)  
 *               arr.length-1
 *              일차(i) 이차 (j) m,n a,b
 *               1  => 4   i+j=5  ==> j=5-i  
 *               2  => 3
 *               3  => 2
 *               4  => 1
 *    
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 정렬 : 선택정렬 , 버블정렬 ==> ORDER BY no DESC
		int[] arr={45, 67, 90, 34, 12,13,60,57};
		/*
		 * Arrays.sort(arr); // ASC(올림차순) ,DESC(내림차순) for(int i:arr) {
		 * System.out.print(i+" "); } System.out.println("\nDESC"); for(int
		 * i=arr.length-1;i>=0;i--) { System.out.print(arr[i]+" "); }
		 */
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j]) //올림차순
				{
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
	}

}










