package com.sist.collection;
import java.util.*;
/*
 *   Vector : ArrayList가 나오전에 많이 사용된 컬렉션 
 *            쓰레드 이용해서 데이터 저장 (동기) 
 *            네트워크 서버의 사용자 정보를 저장(ip,port)
 *   List 인터페이스를 구현 
 *     메소드는 => ArrayList와 동일 
 *     추가  => add(Object obj) ,  addElement(Object obj)
 *     삭제  => remove(int index) , removeElementAt(int index)
 *     수정  => set(int index,Object obj)
 *     데이터 갯수 읽기 => size()
 *     읽기  => get(int index) , elementAt(int index)
 *     전체 삭제 => clear()
 *     데이터 유무 확인 => isEmpty()
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 저장 공간 생성 (자료구조 => 메모리에 데이터를 저장하고 관리)
		// Stack(LIFO) / Queue(FIFO)=> 운영체제 를 만들어라 (코테)
		// index = 0 , index = langth-1 
		// index =0 , index = 0
		Vector vec=new Vector();
		// Vector waitVc=new Vector() // 대기실 
		// Vector roomVc= new Vector() // 방정보
		// Vector userVc=new Vector() // 방안에 있는 사람 정보 
		// 데이터 추가 
		vec.add("홍길동");//0
		vec.addElement("심청이");//1
		vec.add("박문수");//2
		vec.addElement("이순신");//3
		vec.add("강감찬");//4
		// 추가된 데이터 출력
		System.out.println("저장된 인원수:"+vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.elementAt(i);
			// Object elementAt(int index) , Object get(int index)
			/*
			 *     Object 
			 *     ======
			 *       |
			 *     String
			 */
			System.out.println(i+"."+name);
			
		}
		System.out.println("====== 삭제후 =======");
		vec.removeElementAt(2); // vec.remove(1)
		System.out.println("저장된 인원수:"+vec.size());
		
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.elementAt(i);
			// Object elementAt(int index) , Object get(int index)
			/*
			 *     Object 
			 *     ======
			 *       |
			 *     String
			 */
			System.out.println(i+"."+name);
			
		}
		
		System.out.println("===== 수정후 ========");
		vec.set(3, "을지문덕");
		System.out.println("저장된 인원수:"+vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.elementAt(i);
			// Object elementAt(int index) , Object get(int index)
			/*
			 *     Object 
			 *     ======
			 *       |
			 *     String
			 */
			System.out.println(i+"."+name);
			
		}
		
		System.out.println("===== 전체 삭제 ======");
		vec.clear();
		System.out.println("저장된 인원수:"+vec.size());
		if(vec.isEmpty())
		{
			System.out.println("인원이 없습니다!!");
		}
		// 네트워크에서 한번 사용 
		
	}

}






