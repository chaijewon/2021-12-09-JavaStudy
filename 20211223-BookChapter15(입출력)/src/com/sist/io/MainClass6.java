package com.sist.io;
// FileWriter => 2byte로 저장 ==> 문자 스트림 
// =>byte변환없이 => String을 그대로 첨부가 가능하다 
// => default (w) => 실행시마다 새로운 파일을 만들어 준다 
// => a ==> new FileWriter("경로명",true) => 데이터 추가 
//  뉴스 : 검색 ==> 
import java.io.*;
public class MainClass6 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;
        try
        {
        	// 정상 수행이 가능하게 만든다 
        	File file=new File("c:\\java_data\\news.txt");
        	if(!file.exists())
        	{
        		// 파일이 없으면 파일을 만들어라 
        		// 컴퓨터에 명령 
        		file.createNewFile();
        		System.out.println("파일 생성 완료!!");
        	}
        	// 파일에 데이터 입력 
        	/*fw=new FileWriter(file,true); // 계속 입력 
        	String news="이제훈, 이종필 감독 신작 '탈주' 주연 캐스팅 [단독]\n";
        	fw.write(news);
        	System.out.println("데이터 입력 완료!!");*/
        	// 데이터 읽기 => 2byte씩 읽어야 한글이 정상적으로 출력 
        	FileReader fr=new FileReader(file);
        	int i=0;
        	String msg="";
        	while((i=fr.read())!=-1)
        	{
        		msg+=String.valueOf((char)i);
        	}
        	System.out.println(msg);
        	fr.close();
        }catch(Exception ex) 
        {
        	ex.printStackTrace();
        }
        finally
        {
        	try
        	{
        		fw.close();
        	}catch(Exception ex) {}
        }
	}

}
