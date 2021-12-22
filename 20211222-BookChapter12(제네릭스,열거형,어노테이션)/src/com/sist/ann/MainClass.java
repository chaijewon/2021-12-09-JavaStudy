package com.sist.ann;
import java.util.*;
class UserAction
{
	public void aaa()
	{
		System.out.println("aaa() Call...");
	}
	public void bbb()
	{
		System.out.println("bbb() Call...");
	}
	public void ccc()
	{
		System.out.println("ccc() Call...");
	}
	public void ddd()
	{
		System.out.println("ddd() Call...");
	}
	public void eee()
	{
		System.out.println("eee() Call...");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 메소드 호출 
		UserAction u=new UserAction();
		/*u.aaa();
		u.bbb();
		u.ccc();
		u.ddd();
		u.eee();*/
		Scanner scan=new Scanner(System.in);
		System.out.print("메소드 호출(a,b,c,d,e):");
		String method=scan.next();// 사용자가 요청 
		switch(method) // 사용자 요청 처리 
		{
		case "a":
			u.aaa();
			break;
		case "b":
			u.bbb();
			break;
		case "c":
			u.ccc();
			break;
		case "d":
			u.ddd();
			break;
		case "e":
			u.eee();
			break;
		default:
			System.out.println("찾는 메소드가 없습니다!!");
		}
		
	}

}
