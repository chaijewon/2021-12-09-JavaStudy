package com.sist.main;
// 객체단위로 읽기 
// ObjectInputStream 
import java.io.*;
import java.util.*;
/*
 *   try ~ catch 
 *   =====> CheckException 
 *   1. IO 
 *   2. Thread
 *   3. Network 
 *   4. 리플렉션 => new없이 메모리 할당 , 메소드 제어 
 *   5. URL 
 *   6. SQL (오라클) 오라클과 자바 연결 
 *   
 *   ==========================
 *   어떤 언어든 동일 
 *     = 네트워크 
 *     = 데이터베이스 (*****) : 웹 => 공유가 된 데이터  
 *     
 *     
 *   IO
 *    파일 정보  
 *    File 
 *     => createNewFile() , mkdir() , delete()
 *     => length() , getName() , getPath() , listFiles()
 *    파일 입출력 
 *    이미지...
 *     FileInputStream / FileOutputStream
 *       read() ,close()  write() ,close()
 *    한글포함 파일 읽기/쓰기
 *     FileReader / FileWriter
 *       read() ,close()  write() ,close()
 *    객체 단위 입출력 
 *     ObjectInpuytStream / ObjectOutputStream 
 *       readObject() close() , writeObject() close()
 *    대용량 데이터를 읽기/쓰기 
 *     BufferedReader / BufferedWriter
 *     ===============
 *       readLine() .close()
 *    
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 파일을 읽어서 => ArrayList에 대입 
        	FileInputStream fis=
        			new FileInputStream("c:\\java_data\\movie_object.txt");
        	// 객체단위로 읽어 온다 
        	ObjectInputStream ois=
        			new ObjectInputStream(fis);
        	ArrayList<Movie> list=(ArrayList<Movie>)ois.readObject();
        	// 닫기
        	fis.close();
        	ois.close();
        	
        	// ArrayList에 있는 데이터를 출력 
        	for(Movie m:list)
        	{
        		System.out.println("영화번호:"+m.getMno());
        		System.out.println("영화제목:"+m.getTitle());
        		System.out.println("감독:"+m.getDirector());
        		System.out.println("출연:"+m.getActor());
        		System.out.println("장르:"+m.getGenre());
        		System.out.println("등급:"+m.getGrade());
        		System.out.println("개봉일:"+m.getRegdate());
        		System.out.println("\n");
        	}
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
	}

}



