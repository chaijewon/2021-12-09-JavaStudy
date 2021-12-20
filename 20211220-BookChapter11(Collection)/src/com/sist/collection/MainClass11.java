package com.sist.collection;
// TreeSet => headSet: 작은 값 전체 , tailSet : 큰 값 전체 
import java.util.*;
/*
 *     TreeSet 
 *       =>  기능 
 *           1.add() 추가 
 *           2.remove() 삭제
 *           3.clear() 전체 삭제
 *           4.isEmpty() 데이터 유무
 *           5.first() 가장 낮은 값 
 *           6.last() 가장 높은 값
 *           7.headSet() : ~보다 낮은 값
 *           8.tailSet() : ~보다 높은 값  
 */
public class MainClass11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeSet set=new TreeSet();
        int[] score=new int[10]; // new => 자동 0으로 설정 
        // 배열 초기화 
        Random r=new Random();
        for(int i=0;i<10;i++)
        {
        	score[i]=r.nextInt(101); //0~100
        }
        System.out.println(Arrays.toString(score));
        // 기준 
        // 60이상인 데이터를 출력
        System.out.println("===== 60이상 데이터 출력 ======");
        for(int jumsu:score)
        {
        	if(jumsu>=60)
        	{
        		System.out.println(jumsu);
        	}
        }
        
        System.out.println("===== 60미만 데이터 출력 ======");
        for(int jumsu:score)
        {
        	if(jumsu<60)
        	{
        		System.out.println(jumsu);
        	}
        }
        
        // TreeSet에 데이터 첨부 
        System.out.println("===== TreeSet에 데이터 첨부 =====");
        for(int jumsu:score)
        {
        	set.add(jumsu);
        }
        System.out.println(set.toString());
        
        System.out.println("===== TreeSet에 50보다 큰 수 =======");
        System.out.println(set.tailSet(50));
        System.out.println("===== TreeSet에 50보다 작은 수 =======");
        System.out.println(set.headSet(50));
        
	}

}
