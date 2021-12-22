package com.sist.main;
/*
 *    11장 
 *    ====
 *      컬렉션 : 데이터를 모아서 저장 ==> 가변 (표준화)
 *             컬렉션의 종류 
 *      
 *      ======================================
 *       List : 순서가 있고 
 *              중복된 데이터 허용 
 *              => 데이터베이스 => 오라클 
 *      ======================================
 *       Set : 순서가 없고 
 *             중복을 허용하지 않는다 
 *             => sort 
 *             => 장르 , 맛집 종류 
 *      ======================================
 *       Map : (키,값) => enum => 
 *             키는 중복이 불가능 , 값은 중복된 데이터 첨부 
 *             => 웹 (Cookie,Session,클래스 등록, 우편번호)
 *      ======================================
 *             Collection 
 *                 |
 *        --------------------
 *        |        |         |
 *      List<T>   Set<E>  Queue<E>      Map<K,V> Object=> 대신 
 *       |          |        |          저장하고 싶은 데이터형 변경
 *     ArrayList  HashSet  LinkedList        |  
 *                                         HashMap
 *                                         
 *     1) ArrayList : 가장 많이 사용되는 컬렉션
 *        ***add() : 추가 
 *        remove() : 삭제
 *        set() : 수정 
 *        ***clear(): 데이터 전체를 비운다 
 *        ***size(): 저장된 갯수 확인 
 *        ***get() : 저장된 데이터를 한개씩 읽기 
 *        isEmpty() : 데이터 유무 (검색)
 *     2) HashSet 
 *        ***add() : 추가 
 *        remove() : 삭제
 *        ***size() : 저장된 갯수 확인
 *        isEmpty() : 데이터 유무 (검색)
 *     3) Queue ==> FIFO
 *        offer(): 데이터 저장 
 *        poll(): 데이터 읽기
 *     4) HashMap
 *        ***put() : 데이터 저장 
 *        ***get() : 데이터 읽기
 *        size() : 저장된 데이터 갯수 
 *     ===========================> for-each 
 *     
 *    12장 => 제네릭스 : 데이터형을 변경해서 사용하기 쉽게 만든다 
 *                     => 한번에 모든 데이터형이 변경이 된다(데이터형 통일)
 *                     => 형변환 없이 사용이 가능 (간결하다,가독성)
 *           형식) 클래스명<클래스>
 *                ArrayList<String> ==> Object : String
 *                Set<Integer> ===> Object : Integer
 *                => 사용자 정의 데이터형도 첨부 할 수 있다 
 *                => 형변환 (ArrayList<String>)
 *                => 제네릭스를 사용하지 않으면 이클립스에서 컬렉션은 경고를 받는다 
 *                => 노란색 밑줄 => 경고 
 *                => 중간에 라인선 => 권장하지 않는다 (다음에는 없어진다)
 *        => 어노테이션 : 메소드 , 클래스 ,멤버변수를 구분할때 사용 
 *                     => 기능은 없이 구분자로의 역할만 수행(인덱스)
 *           어노테이션 사용 위치 => 바로 위에 , 바로 옆에
 *                              =======   ======== 옆에있는 데이터 제어
 *                              아래있는 메소드나 클래스 
 *                              
 *            => target()
 *               TYPE ==> 클래스를 찾기 
 *               METHOD ==> 메소드를 찾는 경우
 *               PARAMETER ==> 매개변수 
 *               CONSTRUCTOR ==> 생성자
 *               FIELD ==> 멤버 
 *               
 *               TYPE 
 *               class A
 *               {
 *                   FIELD
 *                   B b=new B();
 *                   
 *                   CONSTRUCTOR
 *                   public A(){}
 *                   
 *                   METHOD
 *                   public void display(){}
 *                   
 *                   public void setB(PARAMETER B b){}
 *               }
 *               // => JSP (스프링)
 *           열거형 
 *            => 상수의 집합 => 배열 , Map
 *            => 관리하기 편하다
 *            => 데이터 추가 
 *            => C언어에서 파생 
 *            => 형식)
 *               enum 열거형명{
 *                  상수값1,상수값2,상수값3... => 배열
 *               }
 *               
 *               enum 열거형명{
 *                  상수(값),    ==> Map
 *                  상수(값)
 *               }
 *               enum 열거형명{
 *                  상수(값,값),
 *                  상수(값,값), ==> List
 *                  상수(값,값)
 *               }
 *                
 */
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //ArrayList list=new ArrayList();
		
	}

}
