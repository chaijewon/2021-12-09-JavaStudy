package com.sist.main;
// 실제 선언되어 있는 소스 
/*
 *     메소드() throws 예외처리가 여러개 ....
 *     
 *     => 호출시에 예외처리를 하고 사용 
 *        1. 메소드() throws (통합:Exception,Throwable) 
 *        2. 메소드()
 *           {
 *              try
 *              {
 *              }catch(Exception,Throwable){}
 *           }
 */
public class MainClass2 {
    // 선언 (라이브러리) => 오라클
	// IO , Network , Oracle ...
	String name;
	public static MainClass2 createClass() throws Exception
	{
		// 클래스이름으로 메모리 할당이 가능 (리플렉션)
		// 스프링 => 클래스 이름을 제공하면 => 메모리 할당 (클래스 관리)
		// 스프링 => 클래스 관리 
		Class clsName=Class.forName("com.sist.main.MainClass2");
		Object obj=clsName.getDeclaredConstructor().newInstance();
		return (MainClass2)obj;
		// 결합성(다른 영향이 있는지 여부) , 응집성(메소드) 
	}
	// 이미 코드가 되어 있는 상태 => throws (유지보수)
	// 코드가 없는 상태 => try~catch(개발)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
          MainClass2 m=createClass(); // 반드시 예외처리가 존재한다
          m.name="홍길동";
          System.out.println(m.name);
        // try~catch 
        // 선언 throws 
		}catch(Exception e) {}
	}

}
