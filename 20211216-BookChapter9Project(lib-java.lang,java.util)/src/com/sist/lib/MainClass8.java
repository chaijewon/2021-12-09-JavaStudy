package com.sist.lib;
import java.text.SimpleDateFormat;
/*
 *    java.util 
 *    
 *    날짜 관련 
 *      Date (오라클 호환), Calendar (제어) 
 *    변환 관련 
 *      날짜 변환 => SimpleDateFormat 
 *                 ChoiceFormat 
 *                 MessageFormat (SQL)
 *    데이터 수집 : Collection(11장,12장)
 *    
 *    1장 ~ 8장 => 자바 기초 (필수) 
 *    
 */
import java.util.*;
public class MainClass8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. 오늘 날짜 
		/*Date date=new Date();// 시스템의 날짜 정보 (시간)
		// 2. 변환 (프로그램에 맞는 형식으로 변환)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
		String today=sdf.format(date);
		//System.out.println(today);
		StringTokenizer st=new StringTokenizer(today,"-");
		String strYear=st.nextToken();
		String strMonth=st.nextToken();
		String strDay=st.nextToken();
		
		int year=Integer.parseInt(strYear);
		int month=Integer.parseInt(strMonth);
		int day=Integer.parseInt(strDay);
		
		System.out.println(strYear+"년도 "+strMonth+"월");
		*/
		/*
		 *   yyyy-MM-dd 
		 *   yyyy/MM/dd
		 *   yyyy => 4년도 2012
		 *   M => 월  ==> 01,02...10,11 ==> MM 
		 *   d => 일  ==> dd
		 *   hh => 시간 
		 *   mm => 분 
		 *   ss => 초
		 */
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.println(year+"년도 "+month+"월");
		
		System.out.println(); 
		// 요일 출력
		String[] strWeek={"일","월","화","수","목","금","토"};
		for(String week:strWeek)
		{
			System.out.print(week+"\t");
		}
		/*
		 *    List list=new ArrayList() => interface
		 *    Calendar c=메소드() => 추상클래스  
		 */
		// Calendar설정
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH,month-1); // 0~11 ==> 12 (11)
		cal.set(Calendar.DATE, 1);
		
		// 요일 
		int week=cal.get(Calendar.DAY_OF_WEEK);// 1~7
		//System.out.println(strWeek[week-1]);
		// 마지막 날짜 
		int lastday=cal.getActualMaximum(Calendar.DATE);
		//System.out.println(lastday);
		// 객체 생성 
		// 요일 
		// 마지막 날 
		// 달력 출력 
		week=week-1;
		System.out.println("\n");
		for(int i=1;i<=lastday;i++)
		{
			if(i==1)
			{
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			week++;
			if(week>6)
			{
				week=0;
				System.out.println("\n");
			}
		}
	}

}









