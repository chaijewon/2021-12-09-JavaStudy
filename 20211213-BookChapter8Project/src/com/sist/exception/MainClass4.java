package com.sist.exception;
// try~catch ==> 메소드안 , 생성자 , 초기화블록 , 클래스 블록에서는 사용 할 수 없다 
public class MainClass4 {
	// 선언만 하는 영역 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 전체 예외처리 
		//try
		//{
		    // 데이터 수집 
			for(int i=1;i<=10;i++)
			{
				try
				{
					int j=(int)(Math.random()*3);
					// 0,1,2
					int k=i/j;
					System.out.println("k="+k);
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
					// i++ ==> 이동
				}
			}
		//}catch(Exception ex)
		//{
			//System.out.println(ex.getMessage());// 에러 메세지 출력 
			/*
			 *   getMessage() => 실제 에러 메세지만 출력 
			 *   printStackTrace() => 에어만 부분 체크 (줄수)
			 */
		//}
	}

}
