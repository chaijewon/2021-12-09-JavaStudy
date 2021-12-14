package com.sist.lib;
// charAt 
// 문자열을 입력받아서 문자가 좌우 대칭 여부 확인하는 프로그램
// ABBA
// => 구글 코테 
// => 그림 
import java.util.*;
// 1. length() => 문자 갯수 (오류 처리) ==> 문자열이 짝수여야 한다 
// 2. charAt()
public class MainClass4 {
    // aaa bbb ==> String ==> enter
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 문자열 입력을 받는다 
		Scanner scan=new Scanner(System.in);
		System.out.print("문자열 입력:");
		String s=scan.next();
		// 예외 처리 => if , try~catch 
		if(s.length()%2==0)
		{
			//System.out.println("정상 수행이 가능합니다!!");
			//HEL LOO
			boolean bCheck=true;//반복문에서 비교 할때는 디폴트설정 실행 
			for(int i=0;i<s.length()/2;i++)
			{
				char f=s.charAt(i);//앞에서부터 
				char e=s.charAt(s.length()-1-i);//뒤에서부터 
				//System.out.println(f+"|"+e);
				if(f!=e) // 같은 문자가 아니면 종료 
				{
					bCheck=false;
					break;
				}
			}
			
			if(bCheck==true)
			{
				System.out.println("좌우 대칭입니다");
			}
			else
			{
				System.out.println("좌우 대칭이 아닙니다");
			}
		}
		else
		{
			System.out.println("입력한 문자갯수가 짝수여야 합니다!!");
		}
	}

}







