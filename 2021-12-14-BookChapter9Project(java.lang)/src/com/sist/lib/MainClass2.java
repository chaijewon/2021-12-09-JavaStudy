package com.sist.lib;
// 복제 => 같은 메모리를 새롭게 추가 
// 메모리 따로 생성이 된다 
// 참조 => 같은 메모리를 제어 
class Member
{
	String name;
}
class Student implements Cloneable
{
	String name;
	String sex;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
public class MainClass2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        // 메모리에 저장 
		Member m1=new Member();
		m1.name="홍길동";
		// 출력
		System.out.println("이름:"+m1.name);
		
		// 객체 참조 
		Member m2=m1;
		
		// 주소값 (참조:별칭) => 같은 메모리를 제어 
		System.out.println("m1주소값"+m1);
		System.out.println("m2주소값"+m2);
		m2.name="심청이";
		
		// 출력 
		System.out.println("m2.name="+m2.name);// 심청이
		System.out.println("m1.name="+m1.name);// 심청이
		
		Student s1=new Student();
		s1.name="이순신";
		s1.sex="남자";
		
		Student s2=(Student)s1.clone(); // 복제 (새로운 메모리 제작)
		// 클래스 형변환 ==> 일반 데이터형과 동일 
		// Student(int) Object(double)
		// 출력 
		System.out.println("s1.name="+s1.name);
		System.out.println("s1.sex="+s1.sex);
		System.out.println("s2.name="+s2.name);
		System.out.println("s2.sex="+s2.sex);
		
		// 변수값 변경 
		s2.name="강감찬";
		s2.sex="남자";
		
		System.out.println("s1.name="+s1.name);
		System.out.println("s1.sex="+s1.sex);
		System.out.println("s2.name="+s2.name);
		System.out.println("s2.sex="+s2.sex);
		
		// => 아바타 제작 => 복제 
		// 스프링에서 => 메모리 복제 (prototype)
		// Object ==> 형변환 
		
		/*
		 *    class A
		 *    {
		 *        String name;
		 *        String sex;
		 *    }
		 *    class B extends A
		 *    {
		 *        ==========
		 *        String name;
		 *        String sex;
		 *        ==========
		 *        int age;
		 *    }
		 *    
		 *    A a=new A();  ====> name , sex
		 *    B b=new B();  ====> name , sex , age 
		 *    A c=new B();  ====> name,sex (A클래스가 가지고 있는 변수만)
		 *    ===
		 *     c.age = (X)
		 *    클래스 => 제어하는 변수
		 *    메소드는 생성자 타입 
		 */
		
	}

}
