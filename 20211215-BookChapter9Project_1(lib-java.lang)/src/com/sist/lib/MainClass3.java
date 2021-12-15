package com.sist.lib;
import java.util.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 0(가위),1(바위),2(보)
		String[] data={"가위","바위","보"};
        //1. 컴퓨터 
		int com=(int)(Math.random()*3);
		//System.out.println("컴퓨터:"+data[com]);
		//2. 사용자 입력 
		Scanner scan=new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2):");
		int user=scan.nextInt();
		
		System.out.println("컴퓨터:"+data[com]);
		System.out.println("사용자:"+data[user]);
		System.out.println("=====결과=====");
		/*
		 *     user    com
		 *     가위(0)
		 *             가위(0)  => 0 (S)
		 *             바위(1)  => -1 (C)
		 *             보(2)    => -2 (P)
		 *     바위(1)
		 *             가위(0)   => 1 (P)
		 *             바위(1)   => 0 (S)
		 *             보(2)    => -1 (C)
		 *     보(2)
		 *             가위(0)  => 2  (C)
		 *             바위(1)  => 1  (P)
		 *             보(2)    => 0  (S)
		 *             
		 *       C => -1 , 2
		 *       P => -2 , 1
		 * 
		 * 
		 */
		//3. 결과 출력 
		switch(user-com)
		{
		case -1:case 2:
			System.out.println("컴퓨터 Win!!");
			break;
		case -2:case 1:
			System.out.println("Player Win!!");
			break;
		case 0:
			System.out.println("비겼다!!");
		}
	}

}
