package com.sist.main;
class Swap
{
	// Call By Value => 일반 데이터형 (int,long,double,boolean...)
	// 특이 => String 
	public void callByValue(int x, int y)
	{
	   System.out.println("x="+x+",y="+y);
	   // a와 b값을 변경 
	   /*
	    *    a=10 , b=20
	    *    a=b => a=20
	    *    b=a => b=20
	    */
	   int tmp=x;// 임시변수 
	   x=y;
	   y=tmp;
	   System.out.println("x="+x+",y="+y);
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a=100;
        int b=200;
        System.out.println("a="+a+",b="+b);
        System.out.println("====== Swap을 호출 후=======");
        Swap s=new Swap();
        s.callByValue(a, b);
        System.out.println("호출후:a="+a+",b="+b);
	}

}
