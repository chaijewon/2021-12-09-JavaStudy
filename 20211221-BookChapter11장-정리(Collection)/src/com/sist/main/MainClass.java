package com.sist.main;
/*
 *   변수 (설정) , 연산자 , 제어문 , 배열 (1차) => 프로그램언어가 동일 
 *   ==> 프로그래머 필수 과정 
 *   객체 지향 
 *    => 캡슐화 (사용자 정의 데이터형)
 *       => 접근지정어 
 *          private < default < protected < public 
 *          =======                         ======
 *          은닉화                            통신 
 *          통신 => 메소드 (클래스와 클래스의 통신(연결) => 메소드)
 *    => 상속 / 포함 (많이 등장) 
 *       ===
 *        예외 조건 : static , 생성자 , 상속은 가능 사용하지 못한다(private)
 *    => 오버라이딩 (재정의)
 *    =========================== 객체 지향의 3대 특성 
 *    ***스프링 / 데이터베이스 
 *    ===== 기본 기조 : 다른 클래스에 영향이 없게 만드는 과정 
 *                               ======== 상속 , 포함 => POJO 
 *    결합성 => 낮은 , 응집성(메소드) => 높게 
 *    =========================================================
 *    웹 
 *     ===================================================
 *     HTML / CSS : 기능은 없고 => 화면 디자인 
 *     JavaScript : 메뉴 클릭시 , 이미지 회전 ... (이벤트)
 *                  브라우저내에서 동작 (동적)
 *     =================================== front-end
 *     Java  : 데이터 관리 => AI,데이터 분석, 챗봇 
 *     오라클 : 데이터를 저장한 장소(영구적 저장) 
 *     =================================== back-end
 *     ===================================================
 *      한번에 관리 ==> 프레임워크 (스프링)
 *      
 *     자바 : 클래스로 시작해서 클래스로 끝난다 
 *           => 독립적인 메소드(X) , 클래스 내부에 작업 
 *              ** 객체지향 프로그램 (6장 ~ 7장)
 *              ** 클래스를 관리하기 위해서 
 *                 단독으로 사용 , 묶어서 사용할 수 있다 (인터페이스)
 *           => 변수 (데이터를 저장 => 가공해서 사용) 
 *           => 사용자 요청에 대해서 동작 ==> 메소드 
 *           => 웹으로 데이터 전송 (묶어서 전송)
 *              *** 묶어서 전송 => Collection
 *           => 데이터 형태소 분석 => 라이브러리 (꼬꼬마,코모란..)
 *           => 사용자 요청 구분 => 어노테이션 
 *           => 필요하면 외부에서 데이터를 가지고 와서 파일에 저장 
 *               => IO
 *           => 사용자 요청에 따라 파일업로드,파일 다운로드 (IO)
 *           => 핵심 : 데이터베이스(오라클 => 연결)
 *     사이트 : 외국 / 한국 (시각적 효과)
 *            (정보 전달) 
 *            2권 => 10장 : Date , Calendar , SimpleDateFormat 
 *                  11장 : ArrayList , HashSet , HashMap
 *                  12장 : 제네닉스 , 어노테이션 
 *                  15장 : File 
 *                  
 *     => 우대 (Front : VueJS , ReactJS) ==> ***
 *            (Back : AWS(***) , AI(***) , 장고 (파이썬))
 *            정보처리기사 . 마이바티스 . Spring-Boot , SpringFramework
 *    
 *     => Collection정리 
 *          용도 => 이론 => 구현 
 *                   Collection 
 *                       |
 *              ---------------------
 *              |상속     |          |          Map<K,V>
 *                                             K(Key),V(Value) 
 *            List      Set       Queue            |구현
 *                                              HashMap
 *              |구현     |구현       |
 *          ---------  ---------  ------ LinkedList
 *          |       |          |
 *        ArrayList Vector  HashSet(중복없는 데이터)
 *        =========
 *        Vector를 보완 (가장 많이 사용하는 컬렉션)
 *        ArrayList => 데이터베이스 연결 
 *        
 *        ArrayList => 데이터의 접근 속도가 빠르다 , 자주 수정 , 삭제 => 속도가 저하 
 *           => 데이터베이스는 오라클 => 수정 ,삭제 
 *        LinkedList => 자주 수정 , 삭제가 있는 경우에 주로 사용
 *                      파일 관련 , 애플리케이션 프로그램 (게임..) 
 *        Map => 웹 (데이터 전송시 , 쿠키 저장 , 세션 저장 , 클래스 관리)
 *        === 스프링 (클래스 관리) , 마이바티스(SQL문장 관리)
 *        === 웹에서 네트워크 => 저장하는 클래스 HashMap(웹 소켓)
 *        
 *        === 668 page 
 *        ============================ 입력,출력, 데이터 읽기 
 *        List , Map , Set , Queue => interface 
 *        ArrayList , HashMap , HashSet , LinkedList ==> 클래스
 *        
 *                     extends
 *        *** interface ===> inteface
 *                     implements
 *            interface ===> class 
 *            
 *        예)
 *            interface Collection 
 *            
 *            interface List extends Collection 
 *            class ArrayList implements List
 *            
 *            interface Queue extends Collection
 *            class LinkedList implements Queue
 *            
 *            
 *             
 *     => 제네릭스 : 형변환없이 사용이 가능 (데이터형 통합) => 1.8
 *     
 *     ArrayList ,       HashSet , HashMap
 *     =========
 *       = 순서를 가지고 있다 (index) => 자동 지정 => 번호 0번부터 시작 
 *                  오라클 : 1번부터 시작 
 *       = 중복된 데이터를 허용 
 *       = 데이터베이스 연결할때 가장 많이 등장하는 클래스 (오라클)
 *     ***= void add(Object obj) : 추가 
 *     = remove(int index) : 삭제 
 *     ***= Object get(int index) : 데이터 가지고 오기 
 *     ***= int size() : 저장 갯수 ==> 0
 *     ***= boolean isEmpty() : 데이터 유무 
 *     = set(int index,Object obj)
 *       Object => 모든 데이터를 저장할 수 있다 
 *       ====== 가장 큰 데이터형 (모든 기본형 데이터 , 사용자 정의 클래스) 
 *       
 *     HashSet 
 *       = 순서가 존재하지 않는다 
 *       = 데이터 중복을 허용하지 않는다 
 *       = 중복된 데이터를 제거 (*****)
 *       = add(Object obj): 추가
 *       = remove(Object obj);삭제 
 *       = size() : 저장 갯수
 *       = isEmpty() : 데이터 유무 
 *     
 *     HashMap (서버에서 관리 => 클래스 관리 ,데이터 관리)
 *       = 순서거 존재하지 않는다 
 *       = 데이터중복은 허용 , 키는 중복이 있으면 않된다 
 *       = 키,값 쌍으로 저장 => 키를 이용하면 => 값을 얻어 온다 
 *       = 관리용 (도서 관리 ==> ISBN(키) , 책 제목)
 *               우편번호 ==> 주소 
 *               ID ==> id명
 *       = 클래스 관리 (id,클래스 주소)
 *       = put(String key, Object obj):저장 
 *       = get(String key) : 값을 가지고 올때
 *       = size() : 데이터 갯수
 *       = isEmpty() : 데이터 유무 
 *    ========================== 불편한 점 (해결) => 제네릭스 
 */
import java.util.*;
/*interface A
{
	public void display();
	public default void aaa()
	{
		
	}
}
// B < A
class B implements A
{
	public void display()
	{
		
	}
	public void aaa()
	{
		
	}
}
// C < A
class C implements A
{
	public void display()
	{
		
	}
}
// D < A
class D implements A
{
	public void display()
	{
		
	}
}*/
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. ArrayList 사용 방법 
		// 1-1. 저장 공간 생성
		ArrayList list=new ArrayList(); // 제네릭스 필수 
		// *** 가변형 (17만개) 
		// 1-2. 데이터 첨부 
		list.add("사과"); // index => 0
		list.add("오렌지"); // index => 1
		list.add("수박"); // index => 2
		// 1-3. 요청 => 관리 
		// 1-3-1. 목록 (데이터를 보여 달라)
		/*
		 *    모든 형변환 
		 *    => 상속 / 포함 ==> 클래스 크기 결정 
		 *    
		 *    class A(int = 100개)
		 *    class B(int = 1개)
		 *    =========> 데이터형이 틀리기 때문에 A와 B는 크기를 설정 할 수 없다 
		 *    class A
		 *    class B extends A
		 *       A  > B
		 *       
		 *    //상속 => is-a
		 *    class Object
		 *    class String extends Object 
		 *      Object > String 
		 *    
		 *    // 포함 => has-a
		 *    class A
		 *    {
		 *        B b=new B();
		 *    }
		 *    class B
		 *    {
		 *    }
		 *    
		 *    A > B 
		 *    
		 *    ***** interface도 상위 클래스
		 *          interface => 다중 상속  
		 *          ========== 1.8 기능 확장 
		 *            => 추상클래스 대신 interface
		 *            => 추상 클래스는 존재 , interface는 없던 것이 있다
		 *               =========        =========
		 *               메소드 => 구현 , 미구현(선언) 미구현(선언),구현메소드도 있다
		 *            => 프로그래머가 요청 => 기능 추가가 되면 관련된 클래스가 오류 발생 
		 *            => 소프트웨어 => 인터페이스 고정  
		 *          class => 단일 상속 
		 */
		for(int i=0;i<list.size();i++)
		{
			String f=(String)list.get(i);
			System.out.println(f);
		}
		// 1-4. 데이터 지우기 
		System.out.println("==== 삭제 후====");
		list.remove(1); // 2->1변경 
		for(Object obj:list) // obj => 실제 저장된 값을 순차적으로 대입 
		{
			System.out.println(obj); // toString을 생략 
			/*
			 *   valueOf() ==> int , double ==> 문자열 변경 
			 *   toString() ==> 클래스 객체를 문자열로 변경 
			 */
		}
		System.out.println("==== 데이터 출력 =====");
		list.forEach(obj->System.out.println(obj));//{}생략 
		// JavaScript =>  화살표 함수 (ES6)
		// ES5 => ES6 (외국 => ES8)
		
		// 람다식 (함수 포인터) => *
		System.out.println("==== 전체 삭제 ====");
		list.clear();
		if(list.isEmpty())// 데이터가 없다면 
		{
			System.out.println("데이터가 없습니다");//찾기 
		}
		
		// 2. HashSet 사용 방법 
		System.out.println("==== HashSet ====");
		// 2-1. 저장 공간 생성 ==> 중복된 데이터가 들어가면 =>추가가 안된다
		HashSet set=new HashSet();
		// 2-2. 데이터 추가 
		set.add(1);
		set.add(2);
		set.add(3);
		// 2-3. 데이터를 출력 
		// => for-each 
		for(Object obj:set)
		{
			System.out.println(obj);
		}
		System.out.println("==== Iterator 사용 ====");
		// HashMap , HashSet 
		Iterator it=set.iterator(); // 데이터를 접근이 가능하게 it에 연결 
		// => Iterator 
		while(it.hasNext()) // 접근 가능한 데이터 있는 것까지만 반복을 수행 
		{
		   	// it.next() => 실제 접근된 값을 읽어 온다 
			int value=(int)it.next();
			// => 기본데이터형으로 클래스값을 받는다 : 언박싱 
			// Integer i=(Integer)it.next()
			System.out.println(value);
		}
		System.out.println("==== 삭제 ====");
		set.remove(2);
		set.forEach((obj)->System.out.println(obj));
		System.out.println(set.toString());
		// 프로그램 => 어렵다 (경우의 수)
		// 가장 쉬운 프로그램 => Spring / MyBatis
		// => 패턴 (형식) => 동일
		System.out.println("==== 전체 삭제 =====");
		set.clear();
		if(set.isEmpty())
		{
			System.out.println("데이터가 존재하지 않습니다");
		}
		System.out.println("===== HashSet 주로 하는 역할 =====");
		ArrayList list2=new ArrayList();
		list2.add("홍길동");
		list2.add("심청이");
		list2.add("박문수");
		list2.add("홍길동");
		list2.add("박문수");
		
		// 출력 
		for(Object obj:list2)
		{
			System.out.println(obj);
		}
		// 중복제거 
		System.out.println("==== List => Set ====");
		HashSet set2=new HashSet();
		set2.addAll(list2);// list2에 있는 모든 데이터를 => set2으로 이동 
		for(Object obj:set2)
		{
			System.out.println(obj);
		}
		
		list2.clear();// List,Set갱신=> 한번을 전체 삭제 => 추가 
		list2.addAll(set2);
		// => List => Set , Set => List로 변경이 가능 addAll()
		for(Object obj:list2)
		{
			System.out.println(obj);
		}
		// Set ==> 주로 사용처 (장바구니) , Cookie 
		// 3. HashMap 사용 방법 ==> 다음 (클래스 관리:스프링)
		// 3-1. 생성 
		HashMap map=new HashMap();
		// 3-2. 데이터 추가 
		// => 값이 두개 , 키 , 값 
		map.put("aaaaa", "홍길동");
		map.put("bbbb", "심청이");
		map.put("ccc", "춘향이");
		map.put("dd", "박문수");
		map.put("eee", "이순신");
		// 키를 중복하면 안된다 , 데이터는 중복이 가능 
		
		//System.out.println(map.get("b"));
		System.out.println("==== 전체적으로 출력 ====");
		/*for(char c='a';c<='e';c++)
		{
			String name=(String)map.get(String.valueOf(c));
			System.out.println(name);
		}*/
		Set s=map.keySet();// map에 저장되어 있는 키 전체를 읽어 온다 
		Iterator i=s.iterator();
		while(i.hasNext())
		{
			String key=(String)i.next();
			String name=(String)map.get(key);
			System.out.println(name);
		}
		
		System.out.println("====  삭제 ====");
		map.remove("dd"); // 키설정 
		map.forEach((key,value)->System.out.println(value));
		
		System.out.println("==== 전체 삭제 =====");
		map.clear();
		if(map.isEmpty())
		{
			System.out.println("데이터가 없습니다");
		}
	}

}










