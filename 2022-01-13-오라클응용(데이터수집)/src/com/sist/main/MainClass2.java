package com.sist.main;
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 오라클 연결 (FoodDAO)
		FoodDAO dao=new FoodDAO();
		// 데이터를 받는다 
		List<Category> list=dao.categoryListData();
		// HTML => 브라우저로 전송 (자바와 오라클 연동)
		for(Category c:list)
		{
			System.out.println(c.getCno()+" "
					+c.getTitle()+" "
					+c.getLink());
		}
	}

}
