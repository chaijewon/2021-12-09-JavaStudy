package com.sist.lib;
import java.util.*;
import java.text.*;
/*
 *   1. Random() => nextInt(n) => n은 제외 
 *   2. StringTokenizer 
 *      값 읽기 => nextToken
 *      반복 ==> hasMoreTokens 
 *      갯수 ==> countTokens
 *   3. Date,Calendar => 달력 
 *   4. Format 
 *   =====================================
 *   
 */
public class MainClass7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 오늘 날짜 => 달력 
		 Date date=new Date();
		 System.out.println(date);
		 SimpleDateFormat sdf=
				 new SimpleDateFormat("yyyy-M-d");
		 System.out.println(sdf.format(date));
		 StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
		 System.out.println("년도:"+st.nextToken());
		 System.out.println("월:"+st.nextToken());
		 System.out.println("일:"+st.nextToken());
		 // MM dd ==> 01 , 01  => 09  10 => 10
		 // 08 09 ==> 표현법 (0=>8진법 , 0x=>16진법) 0b00001110011 
		 // System.out.println(011);
		 System.out.println(1111);
	}

}
