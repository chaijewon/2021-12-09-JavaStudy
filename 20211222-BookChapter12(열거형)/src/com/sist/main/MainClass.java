package com.sist.main;
import java.util.*;
enum 과일명{
	망고("mango"), 
	수박("watermelon"), 
	사과("apple"),
	배("pear"),
	복숭아("peach"),
	포도("graph"),
	딸기("strawberry"),
	키위("kiwi"),
	멜론("melon"),
	오렌지("orange"),
	레몬("lemon"),
	바나나("banana"),
	자두("plum");
	private String en;
    과일명(String en) // 클래스형으로 사용 (생성자)
    {
    	this.en=en;
    }
    public String getEn()
    {
    	return en;
    }
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 과일명 입력 
		Scanner scan=new Scanner(System.in);
		System.out.print("과일명 입력:");
		String f=scan.next();
		
		// 영문을 찾아서 출력 
		for(과일명 n:과일명.values())
		{
			System.out.println(n);
			// n.name => 한글 
			// n.getEn()
			if(n.name().equals(f))
			{
				System.out.println(f+"의 영어명은 "+n.getEn());
				break; // 종료 
			}
		}
	}

}






