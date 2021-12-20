package com.sist.collection;
// Set => HashSet => 데이터 출력 Iterator이용 , toString()
import java.util.*;
public class MainClass9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. 저장공간 , 중복된 데이터(ArrayList), 중복 없는 데이터(HashSet) 
	    HashSet set=new HashSet();// 중복이 없는 데이터만 첨부 
	    set.add("배");
	    set.add("사과");
	    set.add("오렌지");
	    set.add("수박");
	    set.add("자몽");
	    set.add("바나나");
	    set.add("귤");
	    // ==> 
	    System.out.println("과일의 종류:"+set.size());
	    System.out.println("===== 과일 출력 =====");
	    System.out.println(set.toString());
	    
	    System.out.println("===== 과일 삭제후 =====");
	    set.remove("배"); // remove(Object)
	    System.out.println("과일 종류:"+set.size());
	    System.out.println(set.toString());
	    
	    System.out.println("===== 새로운 과일 추가 ======");
	    set.add("바나나");// 중복일 경우에는 추가하지 않는다 
	    System.out.println("과일 종류:"+set.size());
	    System.out.println(set.toString());
	    
	    System.out.println("===== 전체 삭제 ======");
	    set.clear();
	    System.out.println("과일 종류:"+set.size());
	    // 확인 
	    if(set.isEmpty())
	    {
	    	System.out.println("바구니가 비었습니다!!");
	    }
	    /*
	     *   1. add
	     *   2. size
	     *   3. clear
	     *   4. isEmpty
	     *   5. Iterator사용법 =>
	     *       set.iterator()
	     *       hasNext()
	     *       next()
	     */
	}

}
