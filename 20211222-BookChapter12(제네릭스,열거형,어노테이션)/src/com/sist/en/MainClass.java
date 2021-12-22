package com.sist.en;
/*
 *  2권 => 
 *        10장 : Date , Calendar(O)
 *        11장 : ArrayList,HashSet,HashMap(O)
 *        12장 : <> => 데이터형 통일(O) , enum , annotataion
 *        13장 : Thread
 *        14장 : 기타 => 람다 / 스트림 
 *        15장 : IO (O)
 *        16장 : 네트워크 
 */
// enum : 열거형 (상수를 모아서 관리) => 배열 
// 상수를 나열하고 편리하게 사용 => C언어에만 존재 => JDK 1.5 자바에 첨부 
// 오라클 개발자 (C언어) => printf(), 람다 -> 
/*
 *    열거형 사용 방법 
 *    enum 열거형명 {
 *      상수명1,상수명2....
 *    }
 */
// 용도 => 메뉴 , 카드놀이(모양) , 화투 ===> 게임)
// 네트워크 => 기능 (사용자 요청=> LOGIN, MAKEROOM , ROOMIN , ROOMOUT
// WAITCHAT , ROOMCHAT)
// 상수를 관리하는 프로그램 : enum
enum Season{
	봄,여름,가을,겨울 
}
public class MainClass {
    private String name;
    private Season fs;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MainClass m=new MainClass();
        m.name="홍길동";
        m.fs=Season.봄;
        System.out.println("이름:"+m.name);
        System.out.println("좋아하는 계절:"+m.fs);
        
        // 상수 전체 출력 
        // Season.values() => 상수전체값을 가지고 온다 
        for(Season s:Season.values())
        {
        	System.out.println(s);
        }
        
        Season ss=Season.봄;
        System.out.println(ss.ordinal());// 인덱스 읽기 (인덱스 0)
	}

}






