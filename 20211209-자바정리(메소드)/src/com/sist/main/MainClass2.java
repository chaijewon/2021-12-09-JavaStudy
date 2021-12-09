package com.sist.main;
/*
 *    main() => 조립기 
 *    
 *    한개의 파일에서 두개이상의 class 코딩 
 *    => public class는 한번만 사용 
 */
class DateClass
{
	int year;
	int month;
	int week;
	int[] lastday={31,28,31,30,31,30,
		       31,31,30,31,30,31};
	
	// 1. 사용자로부터 입력을 받는다 => int
	// 2. 요일 구하는 기능 => int => 세부화 (윤년계산) > boolean
	// 3. 달력 출력 => void
	/*
	 *   변수값의저장 순서 
	 *   = 명시적 
	 *     int a=10; // 구현이 불가능 => 선언
	 *   = 초기화 블록 
	 *     {
	 *        a=100; ==> 파일에서 읽어온 데이터를 대입 
	 *                   연산자 , 메소드 
	 *     }
	 *   = 생성자 
	 *     A()
	 *     {
	 *        a=200;   ==> 200
	 *     }
	 *   ================
	 *     멤버변수 
	 *   ================
	 *     초기화 
	 *      = 생성자 
	 *      = 초기화 블록 
	 *   ================
	 *     기능 설정 (메소드)
	 *   ================
	 */
}
public class MainClass2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
