package com.sist.main;
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ����Ŭ ���� (FoodDAO)
		FoodDAO dao=new FoodDAO();
		// �����͸� �޴´� 
		List<Category> list=dao.categoryListData();
		// HTML => �������� ���� (�ڹٿ� ����Ŭ ����)
		for(Category c:list)
		{
			System.out.println(c.getCno()+" "
					+c.getTitle()+" "
					+c.getLink());
		}
	}

}
