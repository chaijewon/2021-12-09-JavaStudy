package com.sist.lib;
import java.util.*;
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 난수 발생 
		int[] com=new int[3];
		// 중복없는 난수 발생 
		int su=0; // 난수 저장 
		boolean bCheck=false; // 중복여부 확인 
		// 중복이 있는면 난수 다시 발생 , 중복이 없는 경우에는 com에 저장 
		// 1~9 사이의 정수 발생  ==> nextInt(9)+1
		Random r=new Random();
		for(int i=0;i<3;i++)
		{
			bCheck=true;
			while(bCheck) // 중복 체크 
			{
				// 난수 발생 
				su=r.nextInt(9)+1;
				bCheck=false;
				for(int j=0;j<i;j++)
				{
					if(com[j]==su) // 중복이 있냐?
					{
						bCheck=true; // 중복이 있다면 
						break; // while을 다시 수행 
					}
				}
			}
			// 중복없는 정수가 발생 
			com[i]=su;
		}
		
        //System.out.println(Arrays.toString(com));
		int[] user=new int[3];
		Scanner scan=new Scanner(System.in);
		 
		while(true)
		{
			// 사용자 입력
			System.out.print("3자리 정수 입력:");
			int input=scan.nextInt();
			// 오류처리 ==> || , 정상 처리 => &&
			if(input<100 || input>999)
			{
				System.out.println("잘못된 입력입니다");
				continue; // while처음으로 돌아간다 (while=>조건식)
			}
			//배열에 저장 ==> 345/100 (3)
			user[0]=input/100;
			user[1]=(input%100)/10; // 345%100 ==> 45/10 => 4
			user[2]=input%10; 
			
			// 중복된 수를 입력하면 안된다 
			if(user[0]==user[1] || user[1]==user[2] || 
					user[0]==user[2])
			{
				System.out.println("중복된 수는 사용 할 수 없습니다!!");
				// 다시 처음부터 시작 
				continue;
			}
			// 0을 사용할 수 없다 
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				System.out.println("0을 사용 할 수 없습니다!!");
				continue;
			}
			// 힌트
			int s=0;// 자리수 
			int b=0;// 숫자 
			/*
			 *    345  => 378 ==> 1S-0B
			 *    345  => 789 ==> 0S-0B
			 *    345  => 459 ==> 0S-2B 
			 *    
			 *    3 4 5
			 *    |
			 *    3 7 8
			 */
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(com[i]==user[j])// 같은 수가 있냐?
					{
						if(i==j) // 같은 자리에 있다면 
							s++;
						else  // 다른 자리에 같은 수가 존재 
							b++;
					}
				}
			}
		    System.out.printf("Input Numer:%d,Result:%dS-%dB\n",
		    		    input , s ,b);
			// 종료여부 확인
		    if(s==3)
		    {
		    	System.out.println("Game Over!!");
		    	break;// 종료 System.exit(0)
		    }
		}
		 
	}

}








