package com.sist.collection;
// Set => TreeSet 
import java.util.*;
/*
 *   ArrayList , HashSet , HashMap ==> 웹
 */
public class MainClass10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeSet set=new TreeSet();
        // 데이터 추가 
        /*
         *  min=100
	        min=80  set.add(80);
			min=80  set.add(100);
			min=70  set.add(70);
			        set.add(85);
			        set.add(98);
			        set.add(83);
         */
        set.add(80);
        set.add(100);
        set.add(70);
        set.add(85);
        set.add(87);
        set.add(98);
        set.add(92);
        set.add(83);
        
        System.out.println("가장 낮은 점수:");
        int min=100;// 가장 높은 값 => 비교해서 변경 
        for(Object score:set)
        {
        	int a=(int)score;
        	if(min>a)
        		min=a;
        }
        System.out.println(min);
        System.out.println("가장낮은 값:"+set.first());// 최소값
        System.out.println("가장 높은 점수:");
        int max=70;// 가장 낮은 값 => 비교해서 변경 
        for(Object score:set)
        {
        	int a=(int)score;
        	if(max<a)
        		max=a;
        }
        System.out.println(max);
        System.out.println("가장 높은 값:"+set.last());// 최대값 
        System.out.println(set.lower(90));//90이하  => 가장 근사치 
        System.out.println(set.higher(90));//90이상 => 가장 근사치 
        System.out.println(set.floor(98));// 98이거나 바로 아래 
        System.out.println(set.ceiling(97));// 98이거나 바로 위
        // 내림 차순 : DESC
        NavigableSet d=set.descendingSet();
        System.out.println(d.toString());
        // 올림 차순 : ASC
        NavigableSet a=d.descendingSet();
        System.out.println(a.toString());
        
        // ~ ORDER BY no DESC|ASC
	}

}
