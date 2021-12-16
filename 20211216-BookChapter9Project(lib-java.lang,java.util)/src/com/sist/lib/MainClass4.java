package com.sist.lib;
// UPDOWN 게임 ==> 숫자 야구게임 
import java.util.*; //Scanner , Random => 예약일 지정 
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
        // 1. 임의의 수 저장 => 난수 => Random ==> 1~100
		Random r=new Random();
		int com=r.nextInt(100)+1; //0~99 => 1~100
		// 2. 사용자가 입력해서 정답 
		System.out.println("UPDOWN 게임을 시작합니다");
		
		Scanner scan=new Scanner(System.in);
		while(true) // 반복횟수를 모르는 경우 => 무한루프 
		{
			// 사용자 입력 
			System.out.print("1~100 사이의 정수 입력:");
			int user=scan.nextInt();
			// 1~100가 아닌 경우
			if(user<1 || user>100)
			{
				System.out.println("잘못된 입력입니다!!");
				continue;
				/*
				 *   while ==> 조건식으로 이동 
				 *   for ==> 증가식으로 이동 
				 */
			}
			count++;
			// 힌트 
			if(user<com)
			{
				System.out.println("입력값보다 높은 숫자를 입력하세요");
			}
			else if(user>com)
			{
				System.out.println("입력값보다 낮은 숫자를 입력하세요");
			}
			else // 같은 경우 
			{
				System.out.println("정답입니다!!");
				System.out.println("입력 횟수:"+count);
				break; // while을 종료 
			}
			// 정답 여부 => 종료 
		}
	}

}








