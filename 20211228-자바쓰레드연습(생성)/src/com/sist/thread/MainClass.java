package com.sist.thread;
// Thread => java.lang.* => import는 필요가 없다 
/*
 *   Thread 
 *   모든 프로그램은 프로세서 (프로세스안에서 다른 일을 수행하게 만드는 역할=> 쓰레드)
 *                       ====== 응용 프로그램 
 *   => 사용처 (사용자 정의 쓰레드) 
 *      1. 데이터 수집 
 *      2. 네트워크 서버 (여러명이 동시에 접근 => 통신)
 *      3. 게임 (몬스타 ==> 비행기 ...)
 *      4. 웹 (서버가 제작이 되어 있다) => 각자 사용자들의 통신을 위해서 
 *                                   쓰레드 
 *   => 사용자 정의 쓰레드 
 *      = 방법 1
 *          => Thread상속 
 *          class MyThread extends Thread
 *          {
 *               자원 공유 
 *               반드시 처리 
 *               public void run()
 *               {
 *                  쓰레드 작업 (워크 쓰레드) => 한가지 일만 정의 
 *               }
 *          }
 *      = 방법 2
 *         => 인터페이스 구현 
 *          class MyThread implements Runnable 
 *          {
 *               Runnable => 선언된 메소드 
 *               public void run()
 *               {
 *                   구현 => 동작 
 *               }
 *          }
 *          
 *      = 방법 3
 *        익명의 함수 ()=> run => 람다식 (함수명이 없어서 코딩이 간결)
 *        --> 단점 : 재사용 (객체지향을 벗어나고 있다)
 *        Runable r=()->{
 *            구현 
 *        }
 *    => 쓰레드의 생명주기(생성~소멸)
 *       new Thread()         start()                 run()  sleep()
 *       쓰레드 생성  =======> 대기 (자원 확보) =======> 쓰레드 동작 ======> 일시정지
 *             자원(쓰레드 동작시 필요한 데이터)               | interrupt()
 *                                                    쓰레드 소멸
 *    => 쓰레드
 *       1) 비동기화 : 웹 (여러가지 일을 동시에 수행)
 *       2) 동기화 : 은행 (한번씩 수행) 
 *       
 *    => 주요메소드 
 *       ***= start() => 대기상태 => run()을 호출 
 *       ***= run() => 쓰레드 실행(동작)
 *       ***= sleep() => 일시 정지 
 *       ***= interrupt() => 쓰레드 종료 
 *       = currentThread() => 현재 실행중인 쓰레드의 이름을 가지고 온다 
 *       = getName() / setName() => 쓰레드 이름 변경 
 *                     ========= 알아보기 쉽게 (종료)
 *       = getPriority() / setPriority() => 우선 순위 결정 
 *         우선순위는 1~10 => (10번이 가장 빠른 작업) 
 *         MAX_PRIORITY  : main() ==> 10
 *         MIN_PRIORITY  : gc()    ==> 1
 *         NORM_PRIORITY : 사용자 정의 쓰레드 ==> 5 
 *                                                     
 *      
 */
// 상속을 받아서 처리 
class MyThread extends Thread
{
	// 확장이 가능 => 변수 설정 
	// 동작
    public void run()
    {
    	for(int i=1;i<=10;i++)
    	{
    		System.out.println(i+" ");
    	}
    }
}
// 인터페이스 구현 
class MyThread1 implements Runnable
{
	// 동작
	public void run()
	{
		for(char c='A';c<='Z';c++)
		{
			System.out.println(c+" ");
		}
	}
}
public class MainClass {
    // Thread[main,5,main] => 쓰레드 
	// GC ==> Thread (가비지 컬렉션) ==> 멀티쓰레드를 지원한다 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //System.out.println(Thread.currentThread());
		// 상속을 받은 쓰레드 
		MyThread m=new MyThread();
		m.start(); // => run() 수행 => while() => 무한루프 
		MyThread1 m1=new MyThread1();
		new Thread(m1).start(); // m1이 가지고 있는 run() 호출 
		/*
		 *   Thread t=new Thread(m1);
		 *   t.start(); 
		 *   
		 *   t == new Thread(m1)
		 */
		
	}

}





