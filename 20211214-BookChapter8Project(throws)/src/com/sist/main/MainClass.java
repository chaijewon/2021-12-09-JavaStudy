package com.sist.main;
/*
 *   예외처리 : 사전에 에러발생에 대한 방지 프로그램 
 *            => 비정상 종료를 하지 않고 정상수행이 가능하게 만들어 준다 
 *            => 에러가 나면 => 점프후에 에러를 벗어난다 
 *               catch()
 *   예외처리 : 코드상의 문제가 있는 경우에 수정이 가능한 에러만 처리
 *            (가벼운 에러)
 *            
 *            에러 
 *            ===
 *             1. 문법상의 에러 
 *                ; , {} , 파일의 경로명 , 서버 IP  ==> 반드시 예외처리 
 *                         => CheckException 
 *             2. 실행시 에러 
 *                => 사용자 입력가 문제 
 *                => 프로그래머 실수 
 *                => UnCheckException
 *   예외처리 방법 
 *     1. 예외 복구 ==> catch (에러 => 자주 에러를 출력 => 잡는 연습(수정))
 *                           output 
 *        =>
 *            try
 *            {
 *                 정상수행 문장 
 *                 => 에러 발생 
 *            }catch(예외 종류)
 *            {
 *                 => 1. 에러 내용 출력 (어디서 에러가 발생 확인)
 *                    = getMessage() => 에러내용 출력 
 *                      => 분리 (메소드를 세분화) => 단락 
 *                    = printStackTrace() => 실행과정을 출력 (멈추는 상태 => 코드위치)
 *                 => 2. 예외 복구 (다시 입력창으로 전송)
 *                    = 데이터 수집 (Jsoup(정적),셀레니움(동적))
 *                    = 저장 (데이터형 클래스) = ~VO
 *                 => 에러 확인 (코드 수정)
 *            }
 *            *** catch절은 여러개 사용이 가능 (예상되는 에러처리)
 *            *** 통합 => Exception,Throwable
 *            finally 
 *              = 서버 닫기 , 오라클 닫기 
 *              = 파일 닫기 
 *     2. 예외 회피 (throws=> 예외 선언하기)  => 427page 
 *        => 직접 처리하는 부분이 아니고 이런 에러가 발생할것 같다 JVM에 알려주는 상태 
 *        => 사용법 
 *           메소드() throws 예외종류1,예외종류2... => 순서없이 사용이 가능 
 *                  =========================
 *           처리방법
 *             => 1. 선언 (예외 회피) 
 *                2. try~catch를 이용해서 처리가 가능하다 
 *                3. 기본은 동일하다 
 *                   예)
 *                      public void display() 
 *                        throws NumberFormatException,ClassCastException
 *                      => display를 사용하려면 예외처리하고 사용 한다
 *                      
 *                      NumberFormatException,ClassCastException
 *                      ========================================
 *                         상위 => RuntimeException => Exception => Throwable
 *                      public void main()
 *                      {
 *                         display(); // 생략이 가능 
 *                      }
 *                      public void main() throws NumberFormatException,ClassCastException
 *                      {
 *                          display()
 *                      }
 *                      
 *                      public void main()
 *                      {
 *                         try
 *                         {
 *                             display()
 *                         }catch(NumberFormatException e){}
 *                          catch(ClassCastException e){}
 *                      }
 *                      
 *                      public void main() throws RuntimeException
 *                      {
 *                          display()
 *                      }
 *                      *****
 *                      public void main() throws Exception
 *                      {
 *                         display()
 *                      }
 *                      
 *                  Throwable 
 *                  =========
 *                     |
 *               -------------------
 *               |                 |
 *             Error          Exception
 *                               |
 *                         반드시 예외처리
 *                         CheckException             UnCheck(생략)
 *                       --------------------||||||||-----------
 *                       |                             |
 *                     IOException               RuntimeException
 *                     SQLException                    |
 *                     ClassNotFoundException        NumberFormatException
 *                                                   ClassCastException
 *             => 이클립스에서 알려준다 
 *     3.  사용자 정의 예외처리 
 *         => extends Exception 
 *         => catch절을 사용시에 자동으로 찾지를 못한다 
 *         => throw => 예외처리 호출 
 */
public class MainClass {
    // 예외가 있는 메소드 선언 (라이브러리 메소드) => 자바에서 제공, 외부 제공
	public static void add(int a,int b) throws Exception
	{
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);// b==0
	}
	// sleep(long m) throws InterruptedException
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
        try {
			add(10,20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}






