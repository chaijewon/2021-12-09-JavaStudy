package com.sist.exception;
/*
 *    프로그램 : 오류발생 (33대란) 소프트포럼 
 *    1,000 ==> 10,00 
 *    ===============================
 *      오류발생 
 *        = 에러(Error) => 소스상에서 해결할 수 없는 에러
 *           예) 메모리 부족 , 이클립스상에서 오류  
 *        = 예외(Exception) => 소스상에서 해결리 가능한 가벼운 에러 
 *          ==============
 *           예)  1. 사용자 입력값이 잘못된 경우 (유효성 검사)
 *                   나누기 => 10/0 => 0으로 나눌 수 없다 
 *               2. 프로그래머의 실수 
 *                   배열 범위 초과 
 *                   int[] arr=new int[2];
 *                   arr[2]=100;      == 0,1
 *                   => 네트워크 , 데이터베이스 => ip (ip가 틀려서 연결(X))
 *                   => File의 경로명 잘못
 *                   => SQL문장 (오라클) 
 *       = 자바 => 실행 (2번)
 *         A.java ========> A.class ==========> 실행
 *         ======  컴파일(javac)       한줄씩 읽어서 번역(인터프리터) 
 *                                        java
 *         원시소스 : 프로그래머만 알고 있는 소스 
 *                          ========
 *                          바이트 코드(컴퓨터가 알 수 있는 언어) 
 *                          
 *         => 컴파일 에러 (문법에러) ==> CheckExeption 
 *                => 반드시 예외처리를 사용한다 (필수)
 *         => 런타임 에러 (실행시 에러) ==> UnCheckException
 *                => 필요시에 따라서 예외 처리를 한다 (필수가 아니다)
 *                
 *         CheckException 
 *           => java.net(네트워크)
 *           => java.io (파일 입출력) 
 *           => java.sql (오라클 연결)
 *         UnCheckException
 *           => NumberFormatExeption => 문자열을 정수형 변경 
 *                   => 웹 , 윈도우 (정수가 없다 => 문자열) 
 *                   => Integer.parseInt("10");
 *                      Integer.parseInt("10 ");
 *                      list.jsp?page=1  => "1" , " 1"
 *           => class A
 *              {
 *                 public void display(){}
 *              }
 *                
 *              A a; => A a=new A();
 *              a.display();  => NullPointerException
 *              
 *           => int[] arr=new int[2];
 *              arr[2]=100;   ====== 0,1
 *              ArrayIndexOutOfBoundsException
 *              
 *           => 10/0 => ArithmeticException 
 *          ===========================> 414page
 *        ==> 예외처리 => 순서가 있다 
 *            예외처리의 계층구조 ==> 415page 
 *                    Object
 *                      |
 *                   Throwable
 *                      |
 *               ===================
 *               |                 |
 *             Error          Exception
 *                                 |
 *                          ===================
 *                          |                 |
 *                        (CheckException) (UnCheckException)
 *                          |
 *                         IOException
 *                          => 파일,메모리,네트워크
 *                         URLMalformedException
 *                          => 사이트 주소 틀린 경우 
 *                         SQLException 
 *                          => 오라클 관련 
 *                         ClassNotFoundException
 *                         
 *                         (UnCheckException)
 *                            |
 *                           RuntimeException 
 *                            |
 *                            NumberFormatException
 *                            NullPointerException
 *                            ArithmeticException
 *                            ArrayOutOfBoundsException
 *            예외처리 방법 ==> 416page
 *            ==========
 *             ***= 예외 복구 ( try~catch ) : 가장 많이 사용 
 *                => 직접 처리
 *             ***= 예외 회피 ( throws )
 *                => 간접 처리  
 *             = 예외 만들기 (throw)
 *                => 예외 던지기 ( 배포 )
 *             = 사용자 정의 예외 (자바에서 완벽하게 예외처리를 지원하지 않는다)
 *               class MyException extends Exception 
 *               
 *               
 *       예외처리 방법 
 *       ==========
 *        목적 : 비정상 종료를 방지하고 정상 수행이 가능하게 만든다 
 *        정의 : 사전에 예상되는 에러를 방지하기 위한 방법론 
 *        
 *        요구사항 분석  ===> 데이터베이스 설계 =====> 데이터 수집 
 *              (사이트)   ===> 오라클 
 *        ====> 화면 UI =========> 구현 ======> 테스팅 ====> 배포(발표)
 *           ==> HTML/CSS       자바 / JS                   AWS
 *                              ========
 *                              웹 프로그램 
 *        요구사항 분석 ==> 어떤 에러가 발생할 지 (예상)
 *        
 *       예외처리 사용법 
 *       1) 직접처리(예외복구) => try~catch~finally(생략이 가능)
 *       
 *       try
 *       {
 *          정상수행이 가능한 소스 (지금까지 코딩한 내용)
 *          ==> 에러 발생 
 *              프로그래머 실수 , 사용자 실수 
 *       }catch(예외처리의 종류) ==> 여러번 사용이 가능 (예상되는 에러)
 *       {
 *          ==> 에러 처리 ==> 복구 
 *       }
 *       finally
 *       {
 *          ==> 정상 수행 , 비정상 수행 => 무조건 실행 
 *              네트워크 서버 해제 , 오라클 연결 해제 
 *       }
 *       
 *       문장 (수행 여부)
 *          
 *        
 *        
 *        => 
 *        try
 *        {
 *           1. 사용자의 입력값 받기 (정수 2개)
 *           2. 두개의 정수를 배열에 저장 (배열 범위 초과) 
 *                ===> 에러발생  
 *                int[] arr=new int[2];
 *                arr[0]=10;
 *                arr[2]=0; ======> catch로 이동 
 *          ============================================
 *           3. 배열에 등록된 정수를 나누기 (0으로 나눌 수 있다)
 *           4. 결과값을 출력  
 *          ============================================
 *           
 *        }catch(배열 범위 초과)
 *        {
 *           처리 ===>  처리 (원상 복구)
 *        }catch(0으로 나눌 경우)
 *        {
 *           처리
 *        }
 *        finally
 *        {
 *           try,catch와 관계없이 무조건 수행하는 문장 
 *        }
 *        
 *        |
 *       밖에 있는 문장 수행
 *       
 *       public static void main(String[] arg)
 *       {
 *            1) 문장  ==> 수행
 *            2) 문장  ==> 수행
 *            try
 *            {
 *               3)문장 ==> 수행 
 *               4)문장 ==> 예외처리 종류1 발생 catch이동 
 *               5)문장
 *            }catch(예외 처리 종류1)
 *            {
 *               6)문장 ==> 수행 
 *            }
 *            catch(예외 처리 종류2)
 *            {
 *               7)문장
 *            }
 *            finally
 *            {
 *               8)문장 ==> 수행 (무조건 수행) => 생략이 가능 
 *            }
 *            
 *            9)문장  ==> 수행
 *            10)문장 ==> 수행 
 *            
 *            1-2-3-6-8-9-10 ==> 정상 종료 
 *       }
 *        
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  try
	  {
        int[] arr=new int[2];
        arr[0]=Integer.parseInt("10 ");
        arr[2]=0; // 에러 출력 (배열 범위 초과)
        int result=arr[0]/arr[1]; // error ==> catch 2
        System.out.println(result);
	  }
	  catch(ArrayIndexOutOfBoundsException e)
	  {
		  System.out.println(e.getMessage());// 에러메세지 출력 
	  }catch(ArithmeticException e)
	  {
		  System.out.println("0으로 나눌 수 없습니다!!");
	  }
	  catch(Exception e) // 예외처리의 상위 클래스 => 
      // 모든 예외를 처리 할 수 있다
	  {
		  System.out.println(e.getMessage());
	  }
	  
      System.out.println("프로그램 종료!!");
	}
	/*
	 *      Throwable
	 *      =========
	 *      |       |
	 *    Error   Exception
	 *              |
	 *            RuntimeException(여러개 동시처리)
	 *              |
	 *              (한개씩 처리)
	 *            ArrayIndexOutOfBoundsException
	 *            ArithmeticException
	 */

}







