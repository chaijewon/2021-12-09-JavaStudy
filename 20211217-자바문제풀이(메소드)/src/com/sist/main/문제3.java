package com.sist.main;
/*
 *   2. 임의의 정수를 배열로 생성해서 입력하고 정렬하는 프로그램 작성 
     임의의 정수 입력 (배열 생성후)
     정렬 처리
     출력 
     
 */
import java.util.*;
public class 문제3 {
    public void input(int[] arr)//Call By Reference
    {
    	Random r=new Random();
    	for(int i=0;i<arr.length;i++)
    	{
    		arr[i]=r.nextInt(100)+1;//1~100
    	}
    	System.out.println(Arrays.toString(arr));
    }
    public void sort(int[] arr)
    {
    	for(int i=0;i<arr.length-1;i++)
    	{
    		for(int j=i+1;j<arr.length;j++)
    		{
    			if(arr[i]<arr[j])
    			{
    				int temp=arr[i];
    				arr[i]=arr[j];
    				arr[j]=temp;
    			}
    		}
    	}
    }
    public void print(int[] arr)
    {
    	System.out.println(Arrays.toString(arr));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        문제3 m=new 문제3();
        int[] arr=new int[5];
        m.input(arr);
        m.sort(arr);
        m.print(arr);
        System.out.println("============");
        문제4 mm=new 문제4();// 재사용 
        mm.print(2021);
	}

}
