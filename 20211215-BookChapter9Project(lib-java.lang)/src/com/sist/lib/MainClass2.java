package com.sist.lib;
// String 클래스 
/*
 *   String => 데이터형 , 클래스형 (기능)
 *   ====== 상속을 내리지 못하는 클래스 
 *   원형)
 *        public final class String{
 *        }
 *        ==> java.lang => final 
 *        ==> 제공한 내용을 사용한다 
 *        ==> 모든 개발자 동일하게 사용 
 *   1. 데이터형으로 사용
 *      String s="";  
 *   2. 클래스형으로 사용
 *      String s=new String("");
 *   3. 기능(제공) => 메소드 
 *      = charAt(int index) ==> 자바는 인덱스번호 => 0번부터 , 오라클=>1번
 *        예) 
 *            Hello Java
 *            0123456789   ==> charAt(7) ==> 'a'
 *            => ~At(int index)
 *      ================= 검색 
 *      = contains : 문자 포함 여부 
 *        startsWith : 시작하는 문자열 같은지 확인
 *        endsWith : 끝나는 문자열 같은지 확인 
 *      =================
 *      
 *      = 비교 (문자열) == (주소값) 
 *        ==> 실제 저장되어 있는 문자열 자체 
 *        equals()  =========> 대소문 구분 (비밀번호,ID) 
 *        equalsIgnoreCase() ==>  이름 , 검색
 *        *** 문자열 => "" 
 *            ""는 자체가 주소 
 *      = 찾기 
 *        원하는 문자의 위치 찾기  ==> 원하는 부분 추출 
 *        존재 여부 확인 ( -1 )이면 존재하지 않는다 
 *        앞에서 찾기 ==> indexOf
 *        뒤에서 찾기 ==> lastIndexOf (확장자)
 *        c:\\javaDev\\a.java => a.b
 *        012 3456789101112131415
 *          ===      ===
 *        469page ~ 471page 
 *        원형) public int indexOf(char c)
 *             public int indexOf(String s)
 *             
 *             public int lastIndexOf(char c)
 *             public int lastIndexOf(String s)
 *      
 */
// 사용자 입력 ==> 로그인 
/*
 *   4시까지 수업 
 *   => 4~5시 문제풀이 
 *   => 5시~6시 실제 풀이 ==> 정리 (연산자,제어문)
 *      => 연산자 ,제어문 
 *      => 배열 
 *      => 메소드 
 *      => 객체지향문제 ==> 1/2 객관식 , 주관식 (기술면접) 
 *      => 예외처리
 *      => 라이브러리 
 *      => 최종정리 
 *   => 시험 (EMS) => 60점 다음주 수요일  
 */
import java.util.*; // Scanner
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. 입력을 받는다
		Scanner scan=new Scanner(System.in);
		System.out.print("아이디와 비밀번호 입력:");
		String id=scan.next();
		String pwd=scan.next();
		System.out.println("ID:"+id);
		System.out.println("Password:"+pwd);
		// 2. ID,PWD를 비교한다 
		// 오라클에 저장된 데이터 
		final String myId="admin";
		final String myPwd="1234";
		// 3. 결과값 출력 
		// 중첩 if
		// equals ==> 대소문자를 구분해서 비교 
		// equalsIgnoreCase ==> 대소문자 구분없이 비교 
		if(myId.equalsIgnoreCase(id)) // 검색어 
		{
			if(myPwd.equals(pwd)) // 비밀번호 검색 
			{
				System.out.println(id+"님 로그인되었습니다");
			}
			else
			{
				System.out.println("비밀번호가 틀립니다!!");
			}
		}
		else
		{
			System.out.println("아이디가 존재하지 않습니다!!");
		}
		
	}

}












