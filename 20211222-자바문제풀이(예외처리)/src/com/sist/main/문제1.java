package com.sist.main;
/*
 *   1. 예외에 대한 설명 중 틀린 것은 무엇입니까?
① 예외는 사용자의 잘못된 조작, 개발자의 잘못된 코딩으로 인한 프로그램 오류를 말한다.
② RuntimeException의 하위 예외는 컴파일러가 예외 처리 코드를 체크하지 않는다.
③ 예외는 try-catch 블록을 사용해서 처리된다.
④ 자바 표준 예외만 프로그램에서 처리할 수 있다.
  =========== 사용자가 정의도 처리가 가능하다 
  = 데이터형 (기본 데이터형) 
    ====== 키워드 : class (없는 데이터 , 지원 하지 않는 데이터)
                  ======
                  사용자 정의 데이터형을 제작 
  = 메소드 

      예외처리
      => 기본 if
      => 처리가 어렵거나 예측을 =>  예외처리
      ================================================ 
      => 예외 처리 목적 
         프로그램의 비정상 종료를 방지하고 정상 수행이 가능하게 만든다 
      => 예외 처리 정의
         에러에 대해서 사전에 대비하는 프로그램 
      ================================================ 기술면접
      1) 에러 종류 
         =======
         에러 : 심각한 오류 (처리할 수 없는 에러)
               = 메모리 부족 
               = 쓰레드 충돌 
         예외 : 가벼운 에러 (소스상에 수정이 가능한 에러)
               = 파일 경로명 , URL주소 ....
               = 사용자가 잘못 입력 
               = 프로그래머가 실수 
               = 문자열일 경우에는 처리
                 => 컴파일상 오류 (문법상의 에러) => CheckException
                 => 실행시에 오류 => UnCheckExeption
      2) 예외처리의 방법 
         ===========
         예외 복구 
            try ~ catch ~ finally
            try : 정상수행이 가능한 명령문이 첨부
            catch: 에러가 발생시에 에러복구 / 건너뛴다 
            finally : 에러 발생 , 정상 수행 => 무조건 수행 
            ==> catch절을 여러개 사용시에 순서 
         예외 회피 
            메소드() throws 예외종류....
            발생(예측)할 수 있는 에러를 자바시스템 => 예외 선언 
            ==> 예외 선언에 순서가 없다  
         예외 발생 : 테스트할 경우에 주로 사용 
                   견고한 프로그램을 제작할때 사용 
                   throw new 예외처리생성자();
         사용자 정의 (자바에서 지원하지 않는 예외일 경우)
             class MyException extends Exception 
       
       3) 예외처리의 계층구조 
                     Object 
                       |
                    Throwable
                       |
              --------------------------
              |                        |
            Error                 Exception
                                       |
                     CheckException            UnCheckException
                     컴파일시에 예외처리 체크        예외처리를 감시하지 않는다 
                     JVM
                    -------------------------------------
                    |   
                  IOException(입출력)
                  SQLException(오라클)
                  InterruptedException(쓰레드)
                  ClassNotFoundExeption(Class)
                  MalformedURLException    
                                            UnCheckException
                                            ================
                                              RuntimeException
                                                 |
                                              NumberFormatException
                                              parseInt("10 ")
                                              ArrayIndexOutOfBoundsExeption
                                              ArithmeticException
                                              ClassCastException
                                              class A(남자)
                                              class B(여자)
                                              A a=new A();
                                              B b=(여자)남자;
                                              => is-a(상속)
                                                 has-a(포함)
                                              NullPointerException 
                                               => 클래스 메모리 할당이 안된 경우 
                                                                  
 */
public class 문제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
