package com.sist.main;
// 670page => 2차 자바 => 오라클 연결 (java.sql) => 웹 (javax.http)
/*
 *   Generics 
 *   =========
 *   1. 목적 
 *       = 객체 타입의 안전성을 높이고 형변환을 사용하지 않게 만드는 프로그램 
 *       = 가독성이 좋다 , 코드가 간결해진다 
 *   2. 형식 
 *      클래스<클래스명>
 *           =======
 *            =============
 *            T : Type
 *            E : Element
 *            ============= 클래스 => 지정한 클래스가 Object를 대신 
 *                          => 모든 메소드의 데이터이 변경이 된다 
 *            K : Key
 *            V : Value 
 *   3. 예)
 *      ArrayList<String> => Object get(int index)
 *                           =====================
 *                           String get(int index)
 *                           
 *                           void add(Object obj)
 *                           =====================
 *                           void add(String obj)
 *                           
 *    class Box<T>
 *    {
 *        T item;
 *        void setItem(T item)
 *        {
 *           this.item=item;
 *        }
 *        T getItem()
 *        {
 *           return item;
 *        }
 *    }
 *    
 *    Box<String> box=new Box<String>();
 *    
 *    class Box<T> ==> 사용하지 않으면 => Object
 *    {
 *        String item;
 *        void setItem(String item)
 *        {
 *           this.item=item;
 *        }
 *        String getItem()
 *        {
 *           return item;
 *        }
 *    }
 *    // 사용이 쉽게 => 사용자 지정한 데이터형으로 변경이 된다 
 */
import java.util.*;
// 제네릭스 => Collection 
class Box<T>
{
	T item; // 제한 static은 에러가 발생  => 멤버(인스턴스)로만 사용이 가능 
	public void setItem(T item)
	{
		this.item=item;
	}
	public T getItem()
	{
		return item;
	}
}
public class MainClass {
    // 데이터형을 통합 => 형변환이 필요가 없어진다 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Box box=new Box();
        box.setItem("홍길동");
        String name=(String)box.getItem();
        System.out.println(name);
        
        Box<String> box1=new Box<String>();
        box1.setItem("심청이");
        String name2=box1.getItem();
        System.out.println(name2);
	}

}


