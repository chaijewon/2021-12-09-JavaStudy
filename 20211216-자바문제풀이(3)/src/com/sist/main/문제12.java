package com.sist.main;
/*
 *  12) 1부터 30까지의 정수에서 짝수만 한 줄에 3개씩 출력하라
 
    13) 1-2+3-4+5-6+7-8+9-10 계산 값을 for문을 이용하여 출력하라 

    14) 1~10 사이의 숫자 중 3의 배수를 제외하고 출력하라 (continue 사용)

 */
public class 문제12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=1;i<=30;i++)
        {
        	if(i%2==0)
        	{
        		
        		System.out.printf("%2d ",i);
        		if(i%3==0)
        			System.out.println();
        		
        	}
        }
        System.out.println();
        int sum=0;
        for(int i=1;i<=10;i++)
        {
        	if(i%2==0)
        		sum-=i;
        	else
        		sum+=i;
        }
        System.out.println("1-2+...+7-8+9-10 합:"+sum);
        
        System.out.println();
        for(int i=1;i<=10;i++)
        {
        	if(i%3==0)
        		continue; // 3의 배수 제외 
        	System.out.print(i+" ");
        }
	}

}
