package com.sist.lib;
// 469page~471page (String) => AI,RPA,통계, 수집 => 문자열 
// 웹 , 윈도우 => 문자열만 사용이 가능 
// HTML => <input type="text"> 10 ==> "10"
/*
 *   String : 문자열을 제어하는 클래스 / 데이터형 
 *            char[]
 *            
 *   = 기능 (메소드) 
 *     charAt() : 문자열에서 문자를 자르는 경우에 사용
 *                문자열 => ""
 *                문자 => '' 
 *     원형 )
 *           public char charAt(int index)
 *           
 *           Hello Java
 *           0123456789  ==> charAt(4) => 'o'
 *                       ==> charAt(6) => 'J'
 */
// charAt ==> 연산(계산기) 
import java.util.*;
public class MainClass3 {
    //인스턴스 => MainClass3을 메모리에 저장후에 사용 
	// throws => 선언된 예외클래스를 처리후에 사용을 해야된다 
	public void calc() 
			throws ArithmeticException,NumberFormatException,Exception
	{
		Scanner scan=new Scanner(System.in);
		// 숫자 2개 입력 , 연산자 입력 
		// scan,bufferedReader ==> char(X) , String
		System.out.print("첫번째 정수 입력:");
		int num1=scan.nextInt();
		
		System.out.print("두번째 정수 입력:");
		int num2=scan.nextInt();
		
		System.out.print("연산자 입력(+,-,*,/):");
		String temp=scan.next();
		
		// switch => 문자열 case "+"
		char op=temp.charAt(0); 
		switch(op)
		{
		case '+':
			System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);
			break;
		case '-':
			System.out.printf("%d-%d=%d\n",num1,num2,num1-num2);
			break;
		case '*':
			System.out.printf("%d*%d=%d\n",num1,num2,num1*num2);
			break;
		case '/':
			if(num2==0)
				System.out.println("0으로 나눌 수 없습니다!!");
			else
			    System.out.printf("%d/%d=%.2f\n",num1,num2,
				     	         num1/(double)num2);
			// 강제 형변환 
			// int a='A';  자동 형변환 
			//       === 65  ==> a=65
			break;
	    default:
	    	System.out.println("잘못된 연산자입니다!!");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MainClass3 m=new MainClass3(); 
        // 인스턴스 메소드,인스턴스 변수 => 저장 ==> calc()=>저장 
        try
        {
            m.calc(); // 예외처리가 없어서 에러 
        }catch(Exception ex)
        {
        	// 여러개의 예외처리가 선언된 경우 ==> 가장 큰 예외처리를 할 수 있다
        	// Exception , Throwable
        	System.out.println(ex.getMessage());
        }
	}

}






