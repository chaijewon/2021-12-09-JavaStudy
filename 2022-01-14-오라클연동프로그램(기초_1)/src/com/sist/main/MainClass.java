package com.sist.main;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 사용자 요청 => 오라클에 있는 데이터를 보여준다 
		ZipcodeDAO dao=new ZipcodeDAO(); // 오라클 연결하는 클래스
		// 사용자로부터 dong 입력값을 받는다 
		Scanner scan=new Scanner(System.in);
		System.out.print("동 입력:");
		String dong=scan.next();
		
		// 결과값 출력 
		int count=dao.zipcodeFindCount(dong);
		List<Zipcode> list=dao.zipcodeListData(dong); // 찾은 목록 
		
		if(count==0)
		{
			System.out.println("★★★★★ 검색한 결과가 없습니다!! ★★★★★");
		}
		else
		{
			System.out.println("검색결과:"+count+"건");
			for(Zipcode z:list)
			{
				System.out.println(z.getZipcode()+" "
						+z.getAddress());
			}
		}
	}

}
