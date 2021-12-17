package com.sist.main;
// 사용자가 볼 수 있게 만든 프로그램 (브라우저)
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // MusicSystem 사용 
		MusicSystem ms=new MusicSystem();
		ArrayList list=ms.musicListData(); // 뮤직의 모든 목록 
		System.out.println("========= Music Top50 ===========");
		for(int i=0;i<list.size();i++)
		{
			Music m=(Music)list.get(i);
			System.out.println((i+1)+"."+m.getTitle()+"("
					 +m.getSinger()+")");
		}
		System.out.println("==================================");
		// 찾기 
		Scanner scan=new Scanner(System.in);
		System.out.print("검색어 입력:");
		String fd=scan.next();
		ArrayList fList=ms.musicFindData(fd);
		
		if(fList.size()==0)
		{
			System.out.println("검색된 음악이 없습니다!!");
		}
		else
		{
			System.out.println("검색 결과:"+fList.size()+"건");
		}
		//  검색된 뮤직을 출력 
		for(int i=0;i<fList.size();i++)
		{
			Music m=(Music)fList.get(i); // 저장된 클래스 읽기 (Music)
			System.out.println(m.getTitle());
		}
		
	}

}











