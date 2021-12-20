package com.sist.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MainClass_Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
        list.add("사과"); // 0
        list.add("배"); // 1
        list.add("참외"); // 2
        list.add("딸기"); // 3
        list.add("복숭아");// 4
        list.add("딸기"); // 5
        list.add("복숭아");// 6
        System.out.println("===== 중복 제거전 =====");
        System.out.println(list.toString());
        
        HashSet set=new HashSet();
        for(Object obj:list)
        {
        	set.add(obj);
        }
        System.out.println("===== Set 데이터 출력 =====");
        System.out.println(set.toString());
        // list2=new ArrayList();
        list.clear();
        Iterator it=set.iterator();
        while(it.hasNext())
        {
        	list.add(it.next());
        }
        
        System.out.println("===== 중복 제거후 =====");
        System.out.println(list.toString());
        /*for(Object obj:list2)
        {
        	System.out.println(obj);
        }*/
	}

}
