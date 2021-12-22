package com.sist.main;
/*
 * 6. 다음 코드가 실행되었을 때 출력 결과는 무엇입니까?
public class TryCatchFinallyExample {
	public static void main(String[] args){
    	String[] strArray = { "10" , "2a" };
        int value = 0;
        for(int i = 0; i <= 2; i++ ){
        	try{
            	value = Integer.parseInt(strArray[i]);
            	// i=0 => value=10
            	// i=1 => 오류 (NumberFormatException) value=10
            	// i=2 => 오류 (배열 범위 초과) value=10
            } catch(ArrayIndexOutOfBoundException e){
            	System.out.println("인덱스를 초과했음");
            } catch(NumberFormatException e) {
            	System.out.println("숫자로 변환할 수 없음");
            } finally {
            	System.out.println(value);
            }
        }
    }
}

1. 10
2. 숫자로 변환할 수 없음
3. 10
4. 인덱스를 초과했음
5. 10


 */
public class 문제6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArray = { "10" , "2a" };
        int value = 0;
        for(int i = 0; i <= 2; i++ ){
        	try{
            	value = Integer.parseInt(strArray[i]);
            	// i=0 => value=10
            	// i=1 => 오류 (NumberFormatException) value=10
            	// i=2 => 오류 (배열 범위 초과) value=10
            } catch(ArrayIndexOutOfBoundsException e){
            	System.out.println("인덱스를 초과했음");
            } catch(NumberFormatException e) {
            	System.out.println("숫자로 변환할 수 없음");
            } finally {
            	System.out.println(value);
            }// 증가식으로 올라 간다 
        }
	}

}
