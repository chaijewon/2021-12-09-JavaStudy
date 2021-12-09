package com.sist.main;

import java.util.Arrays;

// 버블 정렬
/*
 *   45, 67, 90, 34, 12
 *   ==  ==
 *   67  45
 *       ==  ==
 *       90  45
 *           ==  ==
 *           45  34
 *               ==  ==
 *               34  12
 *   ===========================  for 1
 *   67 90  45 34
 *   == ==
 *   90 67
 *      ==  ==
 *      67  45
 *          ==  ==
 *          45  34
 *   =========================== for 2
 *   90  67  45
 *   ==  ==
 *   90  67
 *       ==  ==
 *       67  45
 *   =========================== for 3
 *   90  67
 *   ==  ==
 *   90  67
 *   =========================== for 4
 *   90  67  45  34  12 
 *     => arr.length-1
 *     1 ==> 4
 *     2 ==> 3
 *     3 ==> 2
 *     4 ==> 1     i+j=5  ==> j=5-i
 *   
 *   
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr={45, 67, 90 , 34 , 12};
        System.out.println("정렬 전:");
        System.out.println(Arrays.toString(arr));
        
        for(int i=0;i<arr.length-1;i++)
        {
        	for(int j=0;j<arr.length-1-i;j++)
        	{
        		if(arr[j]<arr[j+1])
        		{
        		  int temp=arr[j];
        		  arr[j]=arr[j+1];
        		  arr[j+1]=temp;
        		}
        	}
        }
        
        System.out.println("정렬 후:");
        System.out.println(Arrays.toString(arr));
        
	}

}
