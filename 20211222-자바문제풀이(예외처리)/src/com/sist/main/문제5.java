package com.sist.main;
/*
 * 5. 다음과 같은 메소드가 잇을 때 예외를 잘못 처리한 것은 무엇입니까?
public void method1() throws 
  NumberFormauException,       ClassNotFoundException { ... }
  =====================UnCheck ======================= Check
① try{ method1(); } catch (Exception e) { }
② void method2() throws Exception { method1();  }
③ try{ method1(); }  catch (ClassNotFoundException e) { }
                     catch (Exception e) { }
   => 순서 
④ try{ method1(); } catch (ClassNotFoundException e) { } 
                    catch (NumberFormauException e) { }

 */
public class 문제5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
