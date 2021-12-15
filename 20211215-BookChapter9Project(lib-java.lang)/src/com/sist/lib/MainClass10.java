package com.sist.lib;

import java.util.StringJoiner;

/*
 *   String 
 *   =======
 *   웹 => 자주 사용하는 메소드 
 *   ***1. length() => 문자갯수 
 *   ***2. equals() => 비교 (로그인 , 아이디중복 체크)
 *   ***3. substring() => 원하는 부분을 문자 자르기 
 *   4. indexOf() , lastIndexOf() => 위치 찾기 
 *   5. valueOf() => 웹 (문자열) => 다른 데이터형 문자열 변환 
 *   ***6. trim() => 사용자 입력값의 오류방지(공백제거)
 *   7. replace() => 문자변경
 *   8. contains() => 포함 문자열을 찾는 경우 
 *   =================================================
 */
// 기타 
/*
 *   StringJoiner , Format (MessageFormat,SimpleDateFormat...)
 *   => join (문자열 연결)
 *   
 *   톰 홀랜드, 젠데이아 콜먼, 베네딕트 컴버배치
 *   
 *   클래스 객체명=new 클래스명();
 *   =====          ========
 *     = 인터페이스 , 추상클래스 
 *   List list=new ArrayList() => 인터페이스 (List)
 *   Connection conn=DriverManager.getConnection()
 *   
 *   => 객체명.메소드 ====> 인스턴스 메소드
 *      클래스명.메소드 ===> static 메소드 
 *      
 *      10<<2  ==> 40 
 *        10*2^2
 *      10>>2  ==> 2
 *        10/2^2 ==> 2
 *        
 *      =================
 *           &(*)   |(+)
 *      =================
        0 0   0     0
        0 1   0     1
        1 0   0     1
        1 1   0     1
 */
public class MainClass10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 날짜 => 예약 날짜 [~]
        String name="홍길동,박문수,심청이,이순신,강감찬";
        String[] names=name.split(",");
        // names={"홍길동","박문수","심청이","이순신","강감찬"}
        // 출력 
        for(String n:names)
        {
        	System.out.println(n);
        }
        System.out.println("===== JOIN ======");
        String ss=String.join("-",names);//static 메소드
        System.out.println(ss);
        
        StringJoiner sj=new StringJoiner(",","[","]");
        for(String n:names)
        {
        	sj.add(n);
        }
        System.out.println(sj.toString());
	}

}









