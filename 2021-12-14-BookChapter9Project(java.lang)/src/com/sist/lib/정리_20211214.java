package com.sist.lib;
/*
 *    프로그램 제작 (사용자 중심의 프로그램)
 *    ========== 순서 , 예측 (에러) , 구현  ==> 견고한 프로그램 
 *                     =========
 *                      if , try~catch
 *    예외처리 
 *     = 예외 복구 (try~catch~finally)
 *       형식)
 *            try
 *            {
 *              ====================================
 *                정상적으로 수행하는 문장 
 *                => 사용자 실수 , 프로그래머 실수 
 *                   원하지 않는 에러가 발생 (사전에 대비)
 *              ====================================
 *            }
 *            catch(예외처리 종류)
 *            {
 *              =========================
 *               => 에러 복구를 하는 프로그램 
 *               => 에러 위치 확인 
 *               => 여러개를 사용 할 수 있다 (예상되는 에러를 잡을 수 있다)
 *               => 통합 : Exception/Throwable
 *              =========================
 *            }
 *            finally
 *            {
 *              ================
 *               => 닫기 (서버,오라클,파일)
 *               => 생략이 가능 
 *               => try,catch 상관없이 무조건 수행 문장 
 *              ================
 *            }
 *            *** 일반적으로 가장 많이 사용되는 예외 처리 
 *            *** 소스코딩이 되어 있는 상태(SM:유지보수) => throws
 *            *** 소스코딩이 없는 상태 (SI:개발) => try~catch
 *     = 예외 회피 (throws)
 *       = 예상되는 에러를 선언 => JVM에 알려준다 (통과=> 컴파일이 가능하게 만들어 준다)
 *       = 사용시에는 반드시 처리하고 사용 한다 
 *         1) throws 이용하는 방식 
 *         2) try~catch이용하는 방식 
 *         3) 예외가 여러개 선언시에 Exception,Throwable로 통합이 가능하다 
 *    = try~with~resource 
 *      try (FileReader fr=new FileReader(""))
 *      {
 *          fr는 try 블록이 종료가 되면 자동으로 fr.close() 호출 
 *      }catch(Exception e){}
 *      
 *      => 계층구조 
 *         = CheckException
 *           => 파일 관련 ==> IOException
 *           => 네트워크 관련 ==> MalformedURLException
 *           => 오라클 관련 ==> SQLException
 *           => 클래스 관련 ==> ClassNotFoundExeption 
 *           ============컴파일시에 예외처리가 되었는지 확인========
 *         = UnCheckException
 *           => 필요에 따라 예외처리 할 수 없다 
 *              (자주 에러가 발생하는 부분에서는 사용)
 *    라이브러리 (java.lang) => 9장 
 *     = Object : 모든 클래스의 상속을 내리는 클래스 
 *                =========
 *                1. 사용자 정의 클래스 (개발자 만드는 클래스)
 *                2. 자바에서 제공하는 클래스 (라이브러리)
 *                3. 외부에서 제공하는 클래스 (Jsoup,Spring,MyBatis)
 *                                       ============ ======== google
 *                                         open source
 *                   => 최적화 , 가독성(***) => 표준화 (스프링,마이바티스)
 *        = Object 클래스가 지원하는 기능(메소드)
 *          = toString() : 객체를 문자열로 변환 (호출이 없어도 자동으로 호출된다)
 *            A a=new A();
 *            System.out.println(a.toString())
 *            System.out.println(a) 
 *          = finalize() : 객체 소멸시에 자동 호출되는 메소드 
 *                         => 소멸자 
 *          = clone() : 객체를 복제 (같은 메모리를 복사해서 새로운 메모리 생성)
 *            ======= prototype 
 *            복제 => 새로운 메모리가 생성 
 *            참조 => 같은 메모리를 제어 (별칭) => 클래스,배열 
 *     = String : 클래스 / 데이터형 
 *        => 값을 주입 
 *           String s="값"; *** 가장 많이 사용 
 *           String s=new String("값");
 *        => 문자열을 제어하는 클래스 
 *        => 문자열을 제어하는 기능(메소드)
 *           1) length() : 문자의 갯수(index번호보다 1개가 더 많다) 
 *              => String ==> char[]
 *                 index번호는 0번부터 시작한다 
 *                 Hello Java
 *                 0123456789
 *           2) charAt() : 원하는 index를 이용해서 => 문자를 추출 
 *           3) contains() : 문자열 중에 포함된 문자가 있는 경우에 출력 
 *           4) startsWith() : 시작문자열이 같은지 확인
 *           5) endsWith() : 끝나는 문자열이 같은지 여부 확인
 *           
 */
public class 정리_20211214 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
