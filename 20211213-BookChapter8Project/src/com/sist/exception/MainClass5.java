package com.sist.exception;
// 423page 멀티블록 
/*
 *   catch(예외처리클래스|예외처리클래스 a2) // 예상되는 에러가 여러개
 *   // 사용 빈도는 거의 없다 
 */
import java.util.*; //Scanner 
// 생략이 가능한 패키지 => java.lang.* (Object,String,StringBuffer..)
// java.lang , java.util , java.io , java.net , javax....
// java.sql 
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*
         *   문자열(next())로 데이터를 받아서 => 정수 변환 O
         *     NumberFormatException
         *   배열에 저장   => 배열을 벗어 날수 있다 
         *     ArrayIndexOutOfBoundsException
         *   저장된 데이터를 나눈다 => 0으로 나눌 수 있다 
         *     ArithmeticException 
         *   결과값을 출력한다 
         *   
         *    ==> catch 3개이용 
         *    ==> | 로 연결 
         *    ==> Exception/RuntimeException 
         */
		try
		{
			
			// 정상수행이 가능한 소스 
			Scanner scan=new Scanner(System.in);
			System.out.print("첫번째 정수 입력:");
			String no1=scan.next(); // 1 => "1"
			System.out.print("두번째 정수 입력:");
			String no2=scan.next();
			
			// 배열에 저장 
			int[] arr=new int[2];
			arr[0]=Integer.parseInt(no1); // 문자열을 정수형으로 변경 
			arr[1]=Integer.parseInt(no2);
			
			int result=arr[0]/arr[1];
			System.out.println(result);
			
		 // catch=> 예상되는 에러 처리 ==> 복구 
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}
		/*catch(NumberFormatException | ArrayIndexOutOfBoundsException 
				| ArithmeticException e)
		{
			e.printStackTrace(); // 실행과정 출력 => 중간에 멈춤 (에러 줄수)
		}*/ /*
			 * catch(ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage());
			 * }catch(ArithmeticException e) { System.out.println(e.getMessage()); }
			 */
		
	}
	/*
	 *   catch => 순서 
	 *   ============= 계층 구조는 위로 올라가수록 에러 잡는 범위가 크다 
	 *               Throwable : 에러의 최상위 클래스 
	 *                  |
	 *             -------------------------
	 *             |                       |
	 *            Error                 Exception
	 *            ===== 처리가 불가능 에러    ===== 처리가 가능한 에러 
	 *            메모리 부족,편집기문제         
	 *            
	 *            Exception 
	 *              |
	 *        =================================
	 *        예외처리를 반드시 처리 | 예외처리가 처리 자유
	 *          CheckException      UnCheckException
	 *          (javac => 컴파일시 확인)  (java => 실행시 에러)
	 *              |                        |
	 *           IOException               RuntimeException
	 *           SQLException                |
	 *           ClassNotFoundEaception     NumberFormatException
	 *           InterruptedException       ArrayIndexOutOfBoundsException
	 *           ....                       ArithmeticException
	 *           
	 *        ==> 큰 클래스가 밑에 있다 (순서가 존재 한다)
	 *        
	 *        catch(Exception e){}
	 *        catch(RuntimeException e){}
	 *        catch(IOException e){}
	 *        ============================== 오류 
	 *        
	 *        catch(RuntimeException e){}
	 *        catch(IOException e){}
	 *        catch(Exception e){}
	 *        ============================== 정상 수행 
	 *        
	 *        catch(RuntimeException e){}
	 *        catch(SQLException e){}
	 *        catch(NumberFormatException e){}
	 *        catch(Exception e){}
	 *        ============================== 오류
	 *        
	 *        catch(NumberFormatException e){}
	 *        catch(RuntimeException e){}
	 *        catch(SQLException e){}
	 *        catch(Exception e){}
	 *        ============================== 정상 수행
	 *        
	 */

}







