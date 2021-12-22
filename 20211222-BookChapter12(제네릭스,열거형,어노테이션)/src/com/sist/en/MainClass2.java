package com.sist.en;
// Ä«µå³îÀÌ 
class Card{
	static final int CLOVER=0;
	static final int HEART=1;
	static final int DIAMOND=2;
	static final int SPADE=3;
	
	static final int ONE=0;
	static final int TWO=1;
	static final int THREE=2;
	static final int FOUR=3;
}
enum Kind {
	CLOVER,HEART,DIAMOND,SPADE
}
enum Value{
	ONE,TWO,THRESS,FOUR
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Kind k=Kind.CLOVER;
        if(k==Kind.CLOVER)
        {
        	System.out.println("¢¿");
        }
        k=Kind.HEART;
        if(k==Kind.HEART)
        {
        	System.out.println("¢¾");
        }
        k=Kind.SPADE;
        if(k==Kind.SPADE)
        {
        	System.out.println("¢¼");
        }
        k=Kind.DIAMOND;
        if(k==Kind.DIAMOND)
        {
        	System.out.println("¢Â");
        }
	}

}
