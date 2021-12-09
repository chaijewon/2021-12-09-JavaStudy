package com.sist.main;
/*
 *    사용자가 년도/월 입력 ==> 
 *    달력 출력 => 윤년 
 *    
 *    로마시대 (윤년 , 암호화)
 *    = 4년마다 
 *    = 100년 마다 제외
 *    = 400년 마다 
 *    
 *    1. 1년 1월 1일 => 작년도까지의 총날수
 *    2. 현재년도의 1월 부터 입력한 월 총날 수 
 *    3. 1++
 *    ================================ +
 *       총날 수 % 7 => 요일 
 *    ===> Calendar
 *    
 *    
 */
import java.util.*;
// 생략 => java.lang.* 
/*
 *    public class MainClass extends Object
 *    {
 *       public MainClass()
 *       {
 *       }
 *       public void display()
 *       {
 *          return
 *       }
 *    }
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 사용자 입력 완료 
		Scanner scan=new Scanner(System.in);
        System.out.print("년도 입력:");
        int year=scan.nextInt();
        
        System.out.print("월 입력:");
        int month=scan.nextInt();
        
        // 요청한 내용을 가공 => 1일자의 요일 구하기
        // 전년도까지의 총날 수 
        int total=(year-1)*365
        		 +(year-1)/4
        		 -(year-1)/100
        		 +(year-1)/400;
        // 전달까지의 합
        int[] lastday={31,28,31,30,31,30,
        		       31,31,30,31,30,31};
        
        if((year%4==0 && year%100!=0)||(year%400==0)) // 윤년 
        {
        	lastday[1]=29;
        }
        else
        {
        	lastday[1]=28;
        }
        
        for(int i=0;i<month-1;i++)
        {
        	total+=lastday[i];
        }
        
        total++;
        
        // 요일 구하기 
        int week=total%7; 
        
        // 출력 
        /*
         *     문자열을 입력받아서 꺼꾸로 출력 
         *     ========================
         *     그림파일을 읽어와서 꺼꾸로 출력 
         *     byte[] buffer=fileReader()
         *     
         */
        String[] strWeek={"일","월","화","수","목","금","토"};
        // 요일 출력 
        System.out.println(year+"년도 "+month+"월");
        for(int i=0;i<strWeek.length;i++)
        {
        	System.out.print(strWeek[i]+"\t");
        }
        System.out.println("\n");
        for(int i=1;i<=lastday[month-1];i++)
        {
        	//System.out.print(i+"\t");
        	if(i==1)// 첫줄 
        	{
        		for(int j=0;j<week;j++)
        		{
        			System.out.printf("\t");
        		}
        	}
        	System.out.printf("%2d\t",i);
        	week++;
        	if(week>6)
        	{
        		week=0;
        		System.out.println();
        	}
        }
        
	}

}













