package com.sist.lib;
/*
 *    라이브러리 (자바에서 지원 , 외부업체 지원)=> 웹에서 사용되는 라이브러리
 *             ==========   ========== open source
 *                           맵 (Map) , 크롤링 , 데이터베이스 연결 
 *                           스프링 
 *    java.lang : 자바 코딩 기본이 되는 라이브러리 
 *      **Object => 모든 클래스에 상속을 내린 클래스 (최상위 클래스) 
 *        = 기능 
 *          1) toString() => 문자열 변환 
 *          2) clone() => 객체메모리 복제 (새로운 메모리가 생성)
 *          3) finalize() => 객체 소멸시 자동 호출되는 메소드 
 *             ========== 가비지 컬렉션 (프로그램이 종료시 메모리 제거)
 *                        ==========
 *                        = 객체가 null
 *                        = 사용하지 않는 변수가 있는 경우 
 *                        = 힙영역에 저장된 메모리 
 *                        = new 
 *                        = 지역변수 , 매개변수 => 메모리 자체 관리(스택)
 *      **String 
 *      **StringBuffer
 *      StringBuilder 
 *      **Math
 *      **Wrapper (전체 기본 데이터형 => 클래스)
 *      System
 *    =============== import를 생략할 수 있다 
 *    java.util
 *    java.io
 *    java.text
 *    java.net
 *    ========== java로 시작하는 패키지 (JDk1.0)
 *    javax.xml , javax.http
 */
// toString() => 호출 => 객체를 출력 => toString()을 호출한다 
class Card
{
	String kind; // null
	int num; // 0
	// 초기화 => {} 초기화 블록 , 생성자() 
	public Card() // 디폴트 생성자 
	{
		kind="♠";
		num=1;
	}
	// 오버로딩 : 중복 메소드 정의
	public Card(String kind,int num)
	{
		this.kind=kind;
		this.num=num;
	}
	// Object가 가지고 있는 메소드를 재정의 (오버라이딩: 메소드 정의를 변경)
	public String toString()
	{
		return kind+":"+num;
	}
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Card c1=new Card();
        /*
         *   kind="♠";
		     num=1;
         */
        Card c2=new Card("♣",2);
        /*
         *   kind="♣"
         *   num=2
         */
        
        // 출력
        System.out.println(c1); // c1.toString()
        System.out.println(c2); // c2.toString() => 주소값 
        
        // 기타 
        Class c3=c1.getClass();
        System.out.println(c3);
        try
        {
          Class c4=Class.forName("com.sist.lib.Card");
          System.out.println(c4);
        }catch(ClassNotFoundException e) {}
        
	}

}
