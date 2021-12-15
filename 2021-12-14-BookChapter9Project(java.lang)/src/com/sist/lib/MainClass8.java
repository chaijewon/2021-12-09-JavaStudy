package com.sist.lib;
class Card
{
	String kind;
	int num;
	public Card()
	{
		kind="¢¼";
		num=5;
	}
	public Card(String kind,int num)
	{
		this.kind=kind;
	    this.num=num;
	}
	public String toString()
	{
		return kind+":"+num;
	}
}
public class MainClass8 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        Card c=new Card("¢À",2);
        Card c2=Card.class.getDeclaredConstructor().newInstance();
        
        Class c3=c.getClass();
        System.out.println(c);
        System.out.println(c2);
        System.out.println(c3.getName());
        System.out.println(c3.toString());
        
	}

}
