package com.sist.server;
class MyThread extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(i+":"+getName());
			// getName() => 쓰레드명 (JVM => 자동으로 부여해준 이름)
			try
			{
				Thread.sleep(100);
			}catch(Exception ex) {}
		}
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyThread m1=new MyThread();
        m1.setName("홍길동-쓰레드");
        System.out.println("m1:"+m1.getName());
        m1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("m1:"+m1.getPriority());
        MyThread m2=new MyThread();
        m2.setName("이순신-쓰레드");
        System.out.println("m2:"+m2.getName());
        System.out.println("m2:"+m2.getPriority());
        MyThread m3=new MyThread();
        m3.setName("박문수-쓰레드");
        m3.setPriority(Thread.MIN_PRIORITY);
        System.out.println("m3:"+m3.getName());
        System.out.println("m3:"+m3.getPriority());
        
        // 작업을 시킨다 ==> 1~10까지 출력하는 작업 => 워크쓰레드 
        // => 서버에서는 통신 (요청 받아서 => 처리 => 결과값을 보내준다)
        // => 클라이언트마다 1개씩 생성 => 100<=>쓰레드 매핑
        m1.start(); // => run수행
        m2.start(); // => run수행
        m3.start(); // => run수행 
	}

}











