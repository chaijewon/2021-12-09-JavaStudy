package com.sist.main;

import java.util.Scanner;

public class 문제6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
        System.out.print("점수 입력:");
        int score=scan.nextInt();
        char c='A';
        switch(score/10)
        {
        case 10:case 9: // if(score/10==10 || score/10==9)
        	c='A';
        	break;
        case 8:
        	c='B';
        	break;
        case 7:
        	c='C';
        	break;
        case 6:
        	c='D';
        	break;
        default:
        	c='F';
        }
        System.out.println("학점:"+c);
	}

}
