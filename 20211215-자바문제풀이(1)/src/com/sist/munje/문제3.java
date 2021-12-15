package com.sist.munje;
/*
 * 3.	1에서 100까지 3의 배수를 더하는 while 문의 빈칸에 적절한 코드를 삽입하라.
	 
	int sum=0, i=1;
	while (i<100) {
	    if(i%3 != 0) {
	        i++;
	        continue;
	    }
	    else sum += i;
	    i++;
	}
 */
public class 문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0, i=1;
		while (i<100) {
		    if(i%3 != 0) {
		        i++;
		        continue;// 3의배수가 아니면 제외한다 
		    }
		    else sum += i;//3배수 누적 
		    i++;
		}
		System.out.println("sum="+sum);
	}

}
