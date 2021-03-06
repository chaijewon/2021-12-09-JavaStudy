package com.sist.main;
// 450~456 Object
/*
 *   자바 라이브러리 
 *   클래스 
 *   =====
 *     1. 사용자 정의 클래스 
 *          = 데이터 저장용 (변수 => 읽기/쓰기) => 캡슐화 
 *          = 기능(요청) 처리 (메소드) => 상속(재사용)
 *          = 선언 => 인터페이스 
 *     2. 라이브러리 (자바 제공 , 외부에서 제공 => Jsoup , lombok)
 *     3. 조립 클래스 (main() => 클래스)
 *   자바의 라이브러리 
 *   =============
 *      java , javax = (확장된 버전:XML,웹,JSON...) => JDK1.2 
 *      =====
 *       java.lang : 자바의 기본 라이브러리 => 클래스(특이점=> final)
 *                   => 상속을 받아서 오버라이딩을 할 수 없다 
 *                   => 있는 그대로 사용 => 포함클래스 
 *                   => 고정된 클래스 
 *       ========== 해당 클래스 ============
 *       1. Object 
 *          => 자바의 최상위 클래스 (모든 클래스에 상속 내려준 클래스)
 *          => 컴파일러가 자동으로 상속을 내려서 처리 (모든 Object로부터 시작)
 *          => Object 클래스는 모든 데이터형값을 받을 수 있는 클래스 
 *             Object i=10;
 *             Object i=10.5;
 *             Object i='A';
 *             Object i="aaa"; ==> 가장 큰 데이터형
 *             단점 => 형변환 
 *             배열 => 같은 데이터형 
 *             Object[] obj={"홍길동",20,'A',10.5}
 *             int[] i={10,20,'A','b'...}
 *             int i='A'
 *                   ==== 자동 형변환 (65)
 *          => 기능 (모든 클래스) 
 *             1) clone : 메모리 복제한후에 새로운 메모리를 만들어 준다 
 *                        => prototype : 게임 아바타 제작 
 *                           ========== 스프링(싱글턴=>prototype)
 *             2) toString() : 생략이 가능 , 객체가 가지고 있는 내용을 문자열
 *                ===> 가장 많이 오버라이딩
 *                Object obj=new Object();
 *                System.out.println(obj);
 *                System.out.println(obj.toString()); 
 *             3) finalize() : 소멸자함수 (객체 메모리 해제) 자동 호출되는 메소드
 *                ========== 가비지 컬렉션 
 *       2. String 
 *            => 클래스 / 일반 데이터형 => 문자열만 저장하는 클래스
 *               일반 데이터형 
 *                 String s=""; (*******)
 *               클래스 
 *                 String s=new String("");
 *               *** "" => 문자열(문자를 여러개 저장이 가능)
 *                      => 문자열 자체가 주소다 
 *               *** String a="Hello";
 *               if("Hello".equals(a))  ""=>String이 가지고 있는 모든 메솓,ㅡ사용 
 *            => char[]를 이용해서 만든 프로그램 
 *            => 기능(메소드) 
 *               1. length() : 문자 갯수
 *               2. substring() : 원하는 부분의 데이터 자르기 
 *               3. indexOf() / lastIndexOf() : 해당 문자.문자열
 *                  =========   =============
 *                   앞에서         뒤에서 
 *               4. replace() / replaceAll() => 문자의 형태를 만들어 
 *                                              해당내용 변경 
 *                                              => 정규식
 *                                              [가-힣],[A-Z]
 *                                              [a-z],[0-9]
 *                                              .*Hello*.
 *                                              ^[가-힣]
 *                                              [A-Z]$ =====> AI
 *                  =========
 *                    특정 문자.문자열 변경 
 *               5. equals() : 메모리안에 저장된 문자열이 같은지 여부 
 *                             로그인 , 아이디찾기 , 아이디중복 
 *               6. trim() : 좌우의 공백제거 
 *                           <a> Hello</a>
 *                           사용자의 실수 => space
 *               7. valueOf() : 일반데이터형(기본)을 문자열형으로 변경 
 *                              valueOf(10) => "10"
 *               8. split() : 구분문자로 분해 => 배열 
 *                  ======= 정규식 (문자패턴) 
 *               9. contains() => 포함 여부 (추천)
 *               10. 자동완성기 : startsWith(),endsWith()
 *       3. StringBuffer(임시저장장소 만든후 => 데이터를 다 모아준다)
 *            => append() => 문자열 결합 
 *            => toString() : 저장된 모든 데이터 출력 
 *            => 문자열결합의 최적화 => 대용량 문자열 
 *       4. Math => 수학관련 기능 
 *            => random() => 0.0~0.99 사이의 임의의 수를 추출
 *            => ceil() => 페이징 기법 (총페이지) => 올림 
 *               => 10.1  ==> 11 , 10.0 ==> 10
 *            => round() => 반올림 
 *            => 오라클안에도 동일한 함수가 존재 
 *       5. Wrapper
 *            => 
 *            기본형      클래스   ==> 기본형 데이터를 쉽게 제어
 *                 <=== 언박싱
 *            int       Integer
 *            double    Double
 *            float     Float
 *            boolean   Boolean 
 *            long      Long
 *                  ===> 박싱(오토박싱)
 *                  
 *            Integer i=10; 박싱
 *            int i=new Integer(1); 언박싱 ==> int , Integer
 *                                  ==> 제네릭스 
 *                                      <int>(X) <Integer>(클래스형)
 *            ==> 문자열 => 해당 데이터형으로 변경 
 *                Integer.parseInt("10") => 10
 *                Double.parseDouble("10.5") => 10.5
 *                Boolean.parseBoolean("true") => true
 *       6. System
 *            ==> System.out => 표준 출력 => print, println,printf
 *                System.in  => 표준 입력 => read
 *                System.exit(0) => 프로그램 정상 정료
 *                System.gc() => 메모리 해제 요청 (가비지 컬렉션)
 *       java.util
 *            ==> Date , Calendar , StringTokenizer
 *                Date:시스템의 날짜.시간 정보 
 *                Calendar : 월 (0~11) ==> month-1
 *                           요일 (1~7) ==> week-1
 *                StringTokenizer
 *                 = countTokens() : 자른 갯수
 *                 = hasMoreTokens() : 자른 데이터 유무 
 *                 = nextToken() : 자른 데이터를 읽어 온다 
 *            ==> Collection
 *       java.text
 *       java.io
 *       java.net
 *       
 *   외부에서 제공하는 라이브러리(오픈 소스) => mvnrepository  
 *   =====================
 */
class B
{
	
}
class A
{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hello A!!";
	}
	
}
public class 문제_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A a=new A();
        System.out.println(a);
        B b=new B();
        System.out.println(b);// 객체 주소값 출력 
	}

}
