package com.sist.movie;
// 영화 시스템 ==> 메소드 
// 1. 데이터를 수집 ==> 공통으로 사용 (static) 
import java.util.*;
import java.io.*;
public class MovieSystem {
  // 1. 공유할 데이터 선언 
  private static MovieVO[] movie_data=new MovieVO[1938];
  // 사용자 정의 클래스 => 일반 데이터형과 동일하게 사용 한다 
  // class => 데이터를 모아서 관리 
  // 클래스 배열 , String[] => 객체 배열 
  // movie_data => 값을 첨부 
  static
  {
	  // 초기화 블록
	  try 
	  {
		 FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
		 // 파일 읽기 
		 StringBuffer sb=new StringBuffer();
		 int i=0;
		 // 'A' => 65 , 'a' => 97
		 while((i=fr.read())!=-1) // -1 (EOF => end of file)
		 {
			 sb.append(String.valueOf((char)i));
		 }
		 
		 //System.out.println(sb.toString());
		 String movie=sb.toString();
		 String[] m=movie.split("\n");
		 System.out.println("크기:"+m.length);
		 for(int j=0;j<m.length;j++)
		 {
			
			 String[] rm=m[j].split("\\|");
			 MovieVO vo=new MovieVO();
			 vo.setNo(Integer.parseInt(rm[0]));// String => int
			 // Integer.parseInt ==> Wrapper (각 데이터형별로 클래스가 만들어져 있다)
			 vo.setTitle(rm[1]);
			 vo.setGenre(rm[2]);
			 vo.setPoster(rm[3]);
			 vo.setActor(rm[4]);
			 vo.setRegdate(rm[5]);
			 vo.setGrade(rm[6]);
			 vo.setDirector(rm[7]);
			 System.out.println(vo.getNo());
			 //System.out.println("제목:"+vo.getTitle());
			 movie_data[j]=vo;
			
		 }
	  }catch(Exception ex){}
  }
  
  public static void main(String[] args) {
	   for(MovieVO vo:MovieSystem.movie_data)
	   {
		   System.out.println("제목:"+vo.getTitle());
		   System.out.println("장르:"+vo.getGenre());
		   System.out.println("===============================");
	   }
  }
	
}






