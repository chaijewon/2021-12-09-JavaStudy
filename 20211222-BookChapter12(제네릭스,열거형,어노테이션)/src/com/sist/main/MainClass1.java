package com.sist.main;
/*
 *    => 2권 라이브러리 
 *       11장 => 컬렉션 
 *              ======
 *               ArrayList  =======> 웹개발 (오라클 , 파일)
 *               HashSet 
 *               HashMap
 *       12장 =>  제네릭스 : 일반 제네릭스 <> => 데이터형 통합 
 *                        자바에서 라이브러리를 만들때 
 *                        사용자 어떤 데이터형을 저장할 지 모른다 
 *                        (Object) 
 *                        => 매번 형변환 (보완) => 
 *                          사용자 마음대로 데이터을 변경 
 *                        => 와일드 카드 (X) 
 *               열거형 : 거의 사용하지 않는다 (배열)
 *               어노테이션 : 구분자 => 일반 자바 (O) 
 *                          스프링 (어노테이션 , XML)
 *       13장 => 쓰레드 (기본 개념) 
 *       14장 => 기타 (람다식) => 익명의 함수  ->
 *       15장 => 입출력 (*********)  
 *       16장 => 네트워크 
 *       
 *       => 오늘 시험 
 *         ======== (4시 온라인) lms1.sist.co.kr => 
 *       => 월요일 => 오라클 설치 , sqldeveloper
 *       
 *       제네릭스 => 컬렉션 , IO
 */
import java.util.*;
/*
 *    List<E> => class형  Object => 프로그램에 필요한 데이터형으로 변경 
 *                       모든 메소드나 리턴형 지정된 데이터형으로 통일 
 *    List<String> , List<Integer> , List<Double>
 *    List<Food> => 사용자 정의 클래스로 변경 
 *    Set<E>
 *    Set<String> , Set<Integer> , Set<Double>
 *    Set<Food>
 *    Map<K,V> => 두개를 동시에 지정 
 *    Map<String,Object> , Map<String,String> 
 *    Map<String,Food>
 *    => 키는 String을 주로 사용 ==> 제네릭스를 사용하지 않는 경우 : 반드시 형변환
 */
public class MainClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MusicSystem ms=new MusicSystem();
        //1. 중복없는 가수 
        ArrayList<String> list=ms.singerData();
        // 출력 
        for(int i=0;i<list.size();i++)
        {
        	System.out.println((i+1)+"."+list.get(i));
        }
        System.out.println("========전체 목록 ===============");
        ArrayList<Music> mList=ms.musicAllData();
        for(Music m:mList)
        {
        	System.out.println("순위:"+m.getRank());
        	System.out.println("곡명:"+m.getTitle());
        	System.out.println("가수명:"+m.getSinger());
        	System.out.println("앨범:"+m.getAlbum());
        	System.out.println("================================");
        }
        System.out.println("============= 찾기 ===============");
        Scanner scan=new Scanner(System.in);
        System.out.print("검색어 입력:");
        String ss=scan.next();
        ArrayList<Music> sList=ms.musicFindData(ss);
        if(sList.isEmpty())
        {
        	System.out.println("검색된 데이터가 없습니다!!");
        }
        else
        {
        	for(Music m:sList)
        	{
        		System.out.println(m.getTitle()+"("+m.getSinger()+")");
        	}
        }
        
	}

}







