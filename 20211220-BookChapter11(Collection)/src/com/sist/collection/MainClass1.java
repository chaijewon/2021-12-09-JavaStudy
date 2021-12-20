package com.sist.collection;
/*
 *    Collection : 데이터 그룹(데이터를 모아서 관리)
 *    => CollectionFramework : 표준화 
 *          Collection 
 *             |
 *      ------------------------
 *      | 상속      |           |
 *    List        Set         Map ==> 인터페이스 
 *      | 구현된 클래스
 *     => 순서를 가지고 있다 (인덱스로 순서를 구분)
 *     => 중복 데이터를 허용 
 *     => 라이브러리에서 제공하는 기능 (CURD)
 *        ***1. 추가 : add(Object) => 어떤 데이터형이든 상관없이 추가
 *                 => 데이터가 여러종류를 첨부 => 제어하기 어렵다(반복문 수행이 어렵다)
 *                 => 같은 데이터형 처리
 *                 => String , Integer , ***사용자 정의 클래스  
 *                 ArrayList list=new ArrayList();
 *                  => 데이터 저장 공간 생성 
 *                  => 1) 데이터 추가 
 *                     list.add("홍길동");
 *                     list.add(100);
 *                     list.add(100,5);
 *                     list.add('A');
 *                     list.add(true) ==> for이 불가능하다 
 *                      ==> 반복문을 사용하려면 
 *                          => 패턴 (수 => 수열)
 *        2. 삭제 : remove(int index)
 *        3. 수정 : set(int index,Object o)
 *        ***4. 읽기 : get(int index) 
 *        ***5. 저장 갯수 : size() 
 *        6. 데이터 유무 : isEmpty() (boolean)
 *        7. 전체 삭제 : clear()
 *        
 *     ***1) ArrayList (가장 많이 사용 => 데이터베이스(오라클) 연결
 *           =>  비동기 
 *           =>  Vector를 보완한 클래스
 *     2) Vector : 네트워크 프로그램 
 *        => 기능 (동기) ==> 쓰레드 (데드락,스타베이션)
 *           => 웹에서 등장 (실시간) 
 *           => 데이터 수집 
 *        => 추가  add(Object) , addElement(Object)
 *        => 삭제  remove(int index) , removeElementAt(int index)
 *        => 수정  set(int index) 
 *        => 갯수 확인 size()
 *        => 읽기  get(int index) , elementAt(int index)
 *        => 전체 삭제 clear()
 *     3) LinkedList : C언어 호환 
 *             => 추가 add , 수정 set , 삭제 remove , 갯수 확인 size()
 *             => 값을 읽기 get
 *           |
 *          Queue
 *            => 저장 : offer , 읽기 poll
 *          Stack 
 *            => 저장 : push  , 읽기 pop
 *    
 *    저장 방법 
 *    List => 가장 많이 사용되는 컬렉션 (인터페이스)
 *      구현된 클래스 
 *      ArrayList , Vector , LinkedList , Queue
 *    Set  => 순서가 없다 , 데이터중복을 허용하지 않는다 
 *            Iterator : 데이터를 모아서 관리 
 *         => HashSet , TreeSet (정렬)
 *    Map  => 키와 값을 동시에 저장 
 *            키는 중복없는 데이터 , 값은 중복을 허용 
 *         => 스프링,마이바티스 , JSP의 내장 객체 
 *         => 스프링 : 클래스 등록 , 클래스 관리 
 *            마이바티스 : 데이터베이스 관련 => 키,SQL
 */
// => 584 
import java.util.*;
public class MainClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Collection 
		// 1. 메모리 할당 (저장할 수 있는 공간 확보)
		//ArrayList list=new ArrayList();
		//Vector list=new Vector();
		LinkedList list=new LinkedList();
		// 2. 데이터 저장 
		list.add("사과");//0
		list.add("포도");//1
		list.add("배");//2
		list.add("수박");//3
		list.add("귤");//4
		// 3. 확인 
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.print(f+" ");
		}
		// 4. 출력 
		// 5. 수정 
		list.set(4,"오렌지");
		/*
		 *      list.add("사과");//0
				list.add("포도");//1
				list.add("배");//2
				list.add("수박");//3
				list.add("오렌지");//4
		 */
		// 6. 출력
		System.out.println("\n===== 수정후 출력 =====");
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.print(f+" ");
		}
		// 7. 삭제
		list.remove(2);
		/*
		 *      list.add("사과");//0
				list.add("포도");//1
				list.add("수박");//2
				list.add("오렌지");//3
		 */
		// 8. 출력 
		System.out.println("\n===== 삭제후 출력 =====");
		/*for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.print(f+" ");
		}*/
		for(Object obj:list) //list는 Object가 첨부되어 있다 
		{
			System.out.print(obj+" ");
		}
		// 9. 전체 삭제
		list.clear();
		// 10.출력 
		if(list.isEmpty()) // list가 비워져 있는지 확인 
		{
			System.out.println("\n바구니에 과일이 없습니다");
		}
	}

}








