package com.sist.ann;
import java.util.*;
// annotation => XML을 대처한다 
// Spring 4 => XML
// Spring 5 => Annotaion
public class MainClass3 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Class clsName=Class.forName("java.util.ArrayList");
        	Object obj=clsName.getDeclaredConstructor().newInstance();
        	ArrayList<String> list=(ArrayList<String>)obj;
        	list.add("홍길동");
        	list.add("심청이");
        	for(String name:list)
        	{
        		System.out.println(name);
        	}
        }catch(Exception ex){}
	}

}
