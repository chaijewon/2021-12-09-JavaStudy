package com.sist.main;
import java.util.*;
// 열거형 => 상수로 저장 
enum 전화국번{
	// Map에 저장 
	서울특별시("02"),  
	경기도("031"), 
	인천광역시("032"), 
	강원도("033"), 
	충청남도("041"),
	대전광역시("042"),
	충청북도("043"), 
	세종특별자치시("044"), 
	부산광역시("051"), 
	울산광역시("052"),
	대구광역시("053"), 
	경상북도("054"), 
	경상남도("055"), 
	전라남도("061"), 
	광주광역시("062"),
	전라북도("063"), 
	제주특별자치도("064");
	
	private String code;
	전화국번(String code)
	{
		this.code=code;
	}
	// ()안에 있는 데이터 읽기
	public String getCode()
	{
		return code;
	}

}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("시도 입력:");
        String sido=scan.next();
        
        for(전화국번 n:전화국번.values())
        {
        	if(n.name().contains(sido))
        	{
        		System.out.println(sido+"의 국번은 "+n.getCode());
        	}
        }
	}

}
