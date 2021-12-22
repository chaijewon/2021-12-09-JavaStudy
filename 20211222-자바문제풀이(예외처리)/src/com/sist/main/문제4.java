package com.sist.main;
/*
 * 4. throw에 대한 설명으로 틀린 것은 무엇입니까?
① 예외를 최초로 발생시키는 코드이다.
② 예외를 호출한 곳으로 떠넘기기 위해 메소드 선언부에 작성된다. => throws 
                  ========== 선언만 하고 넘어간다 (JVM)
③ throw로 발생된 예외는 일반적으로 생성자나 메소드 선언부에 throws로 떠넘겨진다.
④ throw 키워드 뒤에는 예외 객체 생성 코드가 온다
   예외처리 a=new 예외처리();
   throw a;
   
   throw new 예외처리()

 */
class A
{
	public void display()
	{
		System.out.println("A:Call...");
	}
}
public class 문제4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A a=new A(); // int malloc()
        a.display();
        
        new A().display();
	}

}
