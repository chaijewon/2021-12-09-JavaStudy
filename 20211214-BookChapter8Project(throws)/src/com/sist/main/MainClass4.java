package com.sist.main;
// finally => close() , 파일 , 서버 , 데이터베이스
// try , catch 수행과 관련없이 무조건 수행하는 문장 
import java.io.*;
public class MainClass4 {
    // throws FileNotFoundException,IOException => throws Exception
	// throws FileNotFoundException,IOException => throws Throwable
	/*public static void main(String[] args) 
			  throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
        // 파일 읽기 
		FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
		int i=0;// 읽은 데이터 => char(ASC)
		while((i=fr.read())!=-1) // -1 (EOF)
		{
			System.out.print((char)i);
		}
		
		fr.close();
	}*/
	/*public static void main(String[] args) {
		FileReader fr=null;// main 전체에서 사용 
		try
		{
			fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1)
			{
				System.out.print((char)i);// 읽은 파일을 출력 
			}
		}catch(FileNotFoundException e) {}
		 catch(IOException e) {}
		// 평상시에는 사용빈도가 낮다 (데이터베이스 , 네트워크 , 파일)
		finally
		{
			try
			{
			  fr.close();
			}catch(IOException ex){}
		}
	}*/
	// 437page 
	public static void main(String[] args) {
		try (FileReader fr=new FileReader("c:\\javaDev\\movie.txt"))
		{
			int i=0;
			while((i=fr.read())!=-1)
			{
				System.out.print((char)i);
			}
		}
		// try 블럭을 벗어나면 자동으로 close()가 호출 
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
	}

}






