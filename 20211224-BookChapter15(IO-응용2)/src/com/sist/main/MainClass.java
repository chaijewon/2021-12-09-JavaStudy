package com.sist.main;
// 클라이언트 (브라우저) => 사용자 보는 곳 (Front-End)
import java.util.*;
import com.sist.music.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 사용자 요청 => 해당페이지 요청 
		Scanner scan=new Scanner(System.in);
		MusicSystem ms=new MusicSystem();
		int total=ms.musicTotalPage();
		System.out.print("페이지 입력(1~"+total+"page):");
		int page=scan.nextInt();
		// 해당 페이지의 값을 받는다 
		ArrayList<Music> list=ms.musicListData(page);
		// 받은 데이터 출력 
		System.out.println("===== "+page+"page 뮤직 목록=====");
		for(Music m:list)
		{
			System.out.println(m.getNo()+"."+m.getTitle());
		}
		
		System.out.println("===== 등폭이 가장 큰 뮤직 목록 =====");
		list.clear();
		list=ms.musicMaxData();
		for(Music m:list)
		{
			System.out.println(m.getNo()+"."+m.getTitle()
			           +"("+m.getIdcrment()+")");
		}
		
		System.out.println("===== 제목으로 찾기 =====");
		System.out.print("제목 입력:");
		String title=scan.next();
		list.clear();
		list=ms.titleFindData(title);
		for(Music m:list)
		{
			System.out.println(m.getNo()+"."+m.getTitle());
		}
		System.out.println("===== 가수명으로 찾기 =====");
		System.out.print("가수 입력:");
		String singer=scan.next();
		list.clear();
		list=ms.singerFindData(singer);
		for(Music m:list)
		{
			System.out.println(m.getNo()+"."+m.getTitle()+
					"("+m.getSinger()+")");
		}
		
	}

}
