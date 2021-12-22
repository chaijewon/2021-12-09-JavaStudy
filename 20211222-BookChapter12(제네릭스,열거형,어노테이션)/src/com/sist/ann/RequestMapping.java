package com.sist.ann;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) // 저장기간 
/*
 *   RUNTIME : 메모리에서 유지되는 기간 => 프로그램 종료시까지 유지
 *             (스프링은 런타임이 기본)
 *   ========= 
 *   CLASS
 *   SOURCE 
 *   ========= 메모리에서 유지되는 기간 => 컴파일하고 바로 메모리 해제 
 */
@Target(METHOD) //구분 (어떤것을 구분)
/*
 *   어노테이션 => 인덱스 (역할은 없고 => 찾기) => 구분만 하는 
 *   찾는 경우 => 바로 위에 있거나 옆에 존재한다 
 *   
 *   TYPE
 *   METHOD
 *   FIELD 
 *   CONSTRUCTOR
 *   PARAMETER
 *   
 *   @  ===> TYPE
 *   public class A
 *   {
 *       @ ==> FIELD
 *       B b=new B();
 *       
 *       @ ==> CONSTRUCTOR
 *       public A(){}
 *       
 *       public A(@ ==> PARAMETER B b){}
 *       
 *       @ ==> METHOD
 *       public void display()
 *       {
 *       }
 *   }
 */
// 메소드 찾기 
/*
 *     ==> 메소드 이름을 몰라도 호출이 가능 
 *     @RequestMapping("a")
 *     public void aaa(){}
 *     @RequestMapping("b")
 *     public void bbb(){}
 *     @RequestMapping("c")
 *     public void ccc(){}
 */
public @interface RequestMapping {
  // 구분 
	public String value();
}










