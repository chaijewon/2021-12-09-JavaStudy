package com.sist.lib;
// random() => 임의의 실수를 추출 (0.0,~0.99) => static

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 로또 번호 추출 
		for(int i=0;i<6;i++)
		{
			int lotto=(int)(Math.random()*45)+1;
			//        ======================= 0~44 ==> +1 1~45
			System.out.print(lotto+" ");
		}
	}

}
