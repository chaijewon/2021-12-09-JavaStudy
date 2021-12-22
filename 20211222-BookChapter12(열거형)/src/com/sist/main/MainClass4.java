package com.sist.main;
import java.util.*;

enum Card{
	// static final String CLOVER=0
	CLOVER(1,"♣"),
	SPADE(2,"♠"),
	HEART(3,"♥");
	
	private int num;
	private String kind;
	Card(int num,String kind)
	{
		this.num=num;
		this.kind=kind;
	}
	
	public int getNum()
	{
		return num;
	}
	
	public String getKind()
	{
		return kind;
	}
}
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap map=new HashMap();
        for(Card c:Card.values())
        {
        	/*System.out.println("카드명:"+c.name());
        	System.out.println("숫자:"+c.getNum());
        	System.out.println("카드종류:"+c.getKind());
        	System.out.println("========");*/
        	map.put(c.name(),c.getKind());
        }
        
        System.out.println(map.toString());
	}

}





