package com.sist.main;
/*
 *   1. 자바의 컬렉션 프레임워크에 대한 설명으로 틀린 것은 무엇입니까?
		① List 컬렉션은 인덱스로 객체를 관리하며 중복 저장을 허용한다.
                      ================   =============
		② Set 컬렉션은 순서를 유지하지 않으며 중복 저장을 허용하지 않는다.
		             ================ ======================
		③ Map 컬렉션은 키와 값으로 구성된 Map.Entry를 저장한다.
		             ======        ========== (키,값)
		④ Stack은 FIFO(선입선출) 자료구조를 구현한 클래스이다.
		         ============ (Queue)
		         LIST 
     배열의 단점 
       => 고정적 
       => 보완 => 가변 (컬렉션)
      컬렉션 
       => 표준화 => 인터페이스 
          상속과정
         Collection 
            |
      ----------------
      |      |       |    Map -> HashMap
     List   Set     Queue
                     |
                    LinkedList
      |      |
  ArrayList  HashSet 
  
       List : 순서가 있다(인덱스),데이터중복을 허용한다  
       Set  : 순서가 없다 , 데이터중복을 허용하지 않는다 => 중복없는 데이터를 읽어 온다 
       Map  : 순서가 없다 ==> key,value을 동시에 저장
                           key는 중복이 없다 , value는 중복을 허용한다  
       Queue : FIFO(First IN , First OUT)
       Stack : LIFO(Last In , First OUT)

 */
public class 문제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
