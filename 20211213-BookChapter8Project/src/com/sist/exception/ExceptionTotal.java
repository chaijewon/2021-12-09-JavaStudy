package com.sist.exception;
/*
 *    예외처리 : 수정이 가능한 에러 
 *      => 정의 : 프로그램을 실행시 발생할 수 있는 에러에 대한 대비한 코드 적성 
 *                                        =============
 *      => 아주 간단한 처리 : if문으로 처리 ==> 처리가 불가능하면 예외처리를 한다
 *    예외처리 
 *      => 직접 처리 : try~catch~finally
 *         (예외를 잡아서 복구) => 예외복구(catch절)
 *         => catch를 사용하는 순서 
 *      => 간접 처리 : throws (메소드 뒤에 설정) => 순서가 없다 
 *         (시스템에 알려만 준다) => 예외회피
 *      => 직접 발생 : throw (프로그래머가 직접 발생) => 테스트용 
 *      => 지원하지 않는 예외 처리 제작 (사용자 정의 예외처리)
 *      
 *    1. 순서 (계층구조)
 *            모든 클래스의 최상위 클래스 (사용자 정의 클래스,라이브러리)
 *                   Object
 *                     |
 *                  Throwable : Error,Exception
 *                     |
 *              ====================================
 *              |                                  |
 *            Error                            Exception
 *              OutOfMemory 
 *              (변수,주소가 저장 할 곳이 부족)
 *              
 *                       Exception : 예외처리의 최상위 클래스
 *                                   예외에 대한 모든것을 처리할 수 있다 
 *                           |
 *                      ==================
 *                      |                |
 *                    컴파일예외(javac)  런타임 예외(java)
 *                    ======== 컴파일   ======= 인터프리터
 *                      => 반드시 예외처리를 한다  => 필요시에만 예외처리
 *                      CheckException     UnCheckException
 *                         |
 *                       **파일 입출력 : 경로명 
 *                         IOException
 *                       네트워크 : 서버주소 , URL
 *                         MalformedURLException
 *                       쓰레드 : 충돌 
 *                         InterruptedException
 *                       **오라클 : SQL (DML)
 *                         SQLException
 *                         
 *                       UnCheckException
 *                         RuntimeException 
 *                            |
 *                           배열의 범위 초과
 *                           ArrayIndexOutOfBoundsException
 *                           정수변환 오류
 *                           NumberFormatException (웹)
 *                           주소값이 없는 경우 
 *                           NullPointerException 
 *                             null => 객체의 주소가 없는 상태 
 *                             String s; ==> s=null
 *                             A a;  ==> a=null
 *                           0으로 나눌 경우 
 *                           ArithmeticException
 *                           
 *                           ==> 사용자가 자주 에러를 발생하는 부분 => 
 *                                예외처리를 하면 좋다 (유효성)
 *                       
 *    2. 사용법 
 *       try
 *       {
 *         ===================
 *          정상 실행이 가능한 소스
 *          => 에러가 발생 
 *             = 프로그래머 실수 
 *             = 사용자의 입력값 
 *         ===================
 *         예상되는 예외가 많은 경우 
 *       }catch(예외처리 종류) ==> catch는 여러개 사용이 가능 
 *       {
 *         =============================
 *          비정상 종료를 방지하는 프로그램 소스 
 *          에러 확인 
 *          복구=> 처음으로 다시 돌아가서 실행 
 *         =============================
 *       }
 *       finally => 생략이 가능 
 *       {
 *          =========================
 *            닫기 
 *            = 파일 입출력 
 *            = 네트워크 연결 => 서버 연결 해제 
 *            = 오라클 => 오라클 연결 해제 
 *          =========================
 *       }
 *    
 *      
 *       *** catch 사용 
 *       여러개 사용
 *       catch(IOException e){}
 *       catch(SQLException e){}
 *       catch(RuntimeException e)(} 
 *       한개 
 *       catch(IOExeption | SQLException | RuntimeException e)
 *       한개 
 *       catch(Exception e) => 가장 많다 
 *       
 *       *** catch는 사용하는 순서를 가지고 있다
 *           상위클래스(상속을 내리는 클래스는 나중에 사용)
 *       *** 전체사용도 가능 하지만 부분적으로 사용 할 수 있다 
 *      
 */
import java.util.*;
public class ExceptionTotal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1. 정수를 두개를 받아서 나누기 => 0
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력:");
		int no1=scan.nextInt();
		System.out.print("두번째 정수 입력:");
		int no2=scan.nextInt();
		try
		{
			System.out.printf("%d/%d=%d\n",no1,no2,no1/no2);
		}catch(Exception e)
		{
			System.out.println("0으로 나눌 수 없습니다!!");
		}
		/*if(no2==0)
		{
			System.out.println("0으로 나눌 수 없습니다!!");
		}
		else
		{
			System.out.printf("%d/%d=%d\n",no1,no2,no1/no2);
		}*/
	}

}
