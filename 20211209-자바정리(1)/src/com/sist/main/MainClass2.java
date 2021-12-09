package com.sist.main;
// 배열 초기화 


/*
 *    new 이용 
 *    = int[] arr=new int[5] ==> 0
 *      double[] arr =new double[5] ==> 0.0
 *      String[] arr=new String[5] ==> null (저장주소가 없는 경우)
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr=new int[10]; // 0
        // 값 변경 
        for(int i=0;i<arr.length;i++)
        {
        	arr[i]=(int)(Math.random()*100)+1;
        	/*          =================== 1 (0.0~0.99)
        	 *           0.0 and less than 1.0
        	 *           0.0~0.99 ==> *100  ==> 0.0~99.0
        	 *     ===== 2  0~99
        	 *                             == 3 ==> 1~100
        	 *           
        	 */
        }
        // 출력 
        for(int i:arr) // arr 이라는 배열에서 실제의 값을 가지고 와서 i에 대입
        {
        	System.out.println(i);
        }
        
        /*
         *    *
         *    **
         *    ***
         *    ****
         *    i(줄수)   j(별표)  j=i 
         *    1          1
         *    2          2
         *    3          3
         *    4          4
         *    
         *    ****
         *    ***
         *    **
         *    *
         *    
         *    줄수(i)  별표(j)
         *    1         4     ↓ 역순출력 더한다 i+j=5 => j=5-i
         *    2         3  
         *    3         2
         *    4         1    
         */
        
        for(int i=1;i<=4;i++)
        {
        	for(int j=1;j<=5-i;j++)
        	{
        		System.out.print("*");
        	}
        	System.out.println();
        }
	}

}
