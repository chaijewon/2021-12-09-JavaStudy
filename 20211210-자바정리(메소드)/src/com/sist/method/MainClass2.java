package com.sist.method;
/*
 *   숫자 야구게임 
 *   ==========
 *     난수 => 3개 발생     345
 *     사용자 입력 => 3개   567 ==> 0S-1B ==> 3S
 *     while => 횟수 지정이 없는 경우 
 */
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 난수 변수 
		int[] com={5,8,3};// 중복 없는 난수 => 피망맞고
		// 사용자 입력 
		int[] user=new int[3];
		
		// 입력 요청 
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			// 사용자 입력 
			System.out.println("세자리 정수를 입력하세요:");
			int input=scan.nextInt();
			// 세자리 정수가 아닌 경우에 처리 
			/*if(input>99 && input<1000) // && 포함이 된 경우
			{
				
			}*/
			if(input<100 || input>999) // 오류 (범위 => ||)
			{
				System.out.println("세자리 정수만 사용해야 된다!!");
				continue; // 조건문으로 이동 => 처음부터 다시 시작 
				/*
				 *   continue 
				 *   while ==> while의 조건문으로 이동  
				 *   for   ==> 증가식으로 이동 
				 */
			}
			// user[]에 저장  123 => 1 987/100 ==> 9
			// 987%100 ==> 87/10 => 8
			user[0]=input/100;
			user[1]=(input%100)/10;
			user[2]=input%10;
			
			// 오류처리 
			if(user[0]==user[1]||user[1]==user[2]||user[0]==user[2])
			{
				System.out.println("중복된 숫자는 사용 할 수 없습니다!!");
				continue; 
			}
			
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				System.out.println("0을 사용 할 수 없습니다!!");
				continue;
			}
			// 힌트 
			int s=0; //자리수 + 숫자
			int b=0; //숫자 
			for(int i=0;i<3;i++) // com
			{
				for(int j=0;j<3;j++) // user
				{
					if(com[i]==user[j]) // 같은 수가 있는지 여부 
					{
						if(i==j) // 같은 자리수 라면
							s++;
						else     // 다른 자리라면 
							b++;
							
					}
				}
			}
			// 힌트 
			System.out.printf("Input Number:%d,Result:%dS-%dB\n",
					   input , s , b);
			// 종료 여부 ==> break
			if(s==3)
			{
				System.out.println("Game Over!!");
				break;// 종료
			}
		}
		
	}

}







