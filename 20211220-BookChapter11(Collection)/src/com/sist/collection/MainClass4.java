package com.sist.collection;
// interface 구현된 클래스 
// List    => ArrayList 
// Set     => HashSet
// Map     => HashMap
import java.util.*;
// Stack / Queue ==> 사용 빈도는 거의 없다 
/*
 *   Stack => LIFO (Last IN , First OUT)
 *            나중에 들어간 데이터가 먼저 출력 (메모리)
 *   Queue => FIFO (First IN , First OUT) 
 *            네트워크 전송 , 운영체제의 스케쥴러 
 *            
 *   public static void main(String[] args)
 *   {
 *       int a=10;
 *       if(a==10)
 *       {
 *          int b=20;
 *          if(b==20)
 *          {
 *             int c=30;
 *          }// c변수가 메모리에서 사라진다 
 *          
 *       }// b변수가 메모리에서 사라진다
 *   }// a변수가 사라진다 
 *   ==> 메모리 구조 
 *   ======================
 *     Method 영역 / static 
 *   ======================
 *     Stack : 지역변수,매개변수 ==> 메모리에서 관리 {}이 종료하면 
 *                              자동으로 사라지는 변수 
 *                              메모리에 저장 시점 => 메소드 호출 
 *   ======================
 *     heap : 멤버변수 (new사용해서 사용자 정의 메모리 요청)
 *            개발자 관리 영역 (new , delete) 
 *                                ======= 사용하지 않는 사람이 등장 
 *                                        가비지 컬렉션 (자동 메모리 회수)
 *     new 연산자 => 리턴형 int(주소)
 *     ====
 *       int malloc(int size) => 메모리 크기를 모른다 
 *       컴퓨터에서 알 수 있는 메모리 크기 (기본 데이터형)
 *       int a=10;
 *       ===
 *        4바이트 메모리를 만들고 10을 저장 해라 ==> 저장 공간의 이름을 a라고 쓰다 
 *       class A
 *       {
 *          int a,b,c,d...
 *       }
 *       
 *       A클래스의 메모리 크기를 확인 => 메모리를 만들어 준다 (new)
 *       malloc(A) ==> 승격 (연산자) 
 *       A a=new A();
 *           === ===  저장된 데이터 초기화 
 *           저장된 메모리 주소를 넘겨준다 (메모리 주소는 int범위를 벗어나지 않는다)
 *   ===========================================
 *            
 */
// 604page의 그림 확인 
/*
 *    Stack (뒤에서부터 추출)
 *     = 저장 : push()
 *     = 추출 : pop()
 *     = 데이터 유무  : isEmpty()
 *    Queue (앞에서부터 추출)
 *     = 저장 : opper()
 *     = 추출 : poll()
 *     = 데이터 유무 : isEmpty()
 */
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*String[] names=new String[5]; // 배열의 단점 (고정) 
        //  메모리 크기가 더 필요하면 => String[] names2=new String[10];
        //  가변 (크기를 조절할 수 있다) => 컬렉션 
        names[0]="홍길동";
        names[1]="심청이";
        names[2]="박문수";
        names[3]="이순신";
        names[4]="강감찬";
        
        // 출력 Stack
        System.out.println("===== Stack ======");
        for(int i=names.length-1;i>=0;i--)
        {
        	System.out.println(names[i]);
        }
        
        // 출력 Queue
        System.out.println("====== Queue =====");
        for(int i=0;i<names.length;i++)
        {
        	System.out.println(names[i]);
        }*/
		// Stack 사용 
		Stack st=new Stack();
		// 스택 데이터 추가 => push()
		st.push("사과");
		st.push("포도");
		st.push("수박");
		st.push("오렌지");
		st.push("메론");
		// 스택 데이터 추출 => pop()
		if(!st.isEmpty())// 스택안에 데이터가 있다면 
		{
			while(!st.isEmpty())
			{
				System.out.println(st.pop());
			}
		}
		else
		{
			System.out.println("데이터 존재하지 않습니다");
		}
		
        System.out.println("============Queue============");
        Queue queue=new LinkedList(); // Queue생성 
        // interface => 미완성된 클래스 (자신이 new를 이용해서 메모리 할당을 할수 없다)
        // 데이터 추가 offer(), 데이터 추출 poll() 
        queue.offer("홍길동");
        queue.offer("심청이");
        queue.offer("춘향이");
        queue.offer("김두한");
        queue.offer("박문수");
        
        System.out.println("=========출력==========");
        while(!queue.isEmpty())
        {
        	System.out.println(queue.poll());
        }
	}

}









