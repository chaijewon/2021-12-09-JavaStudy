package com.sist.io;
// => 파일에 있는 전체 데이터를 메모리에 한번에 저장후 읽는 프로그램 
// BufferedReader => 한줄씩 읽어 온다 
/*
 *    File 
 *    =====
 *      => 파일 정보 / 디렉토리 정보 
 *      => 주요 메소드 
 *         directory 
 *         =========
 *           => listFiles() : 폴더안에 있는 모든 데이터 읽기 
 *           => mkdir() : 폴더 생성 
 *           => delete() : 폴더 삭제 
 *           => exsist() : 존재여부 확인 
 *           
 *         file
 *         ====
 *           => getName() : 파일명 
 *           => getPath() : 경로명 
 *           => length() : 크기 
 *           => createNewFile()
 *    FileInputStream (1byte)
 *    FileReader(2byte)
 *       => read()
 *       => read(byte[],int,int)
 *    =================
 *    FileOutputStream(1byte)
 *    FileWriter(2byte)
 *       => write()
 *    =================
 *    BufferedReader(변환 => InputStreamReader)
 *      => readLine()
 *      
 *     // => 파일 업로드 (파일복사) 
 *     // => 외부데이터 저장 => 제어 
 *     
 */
import java.io.*;
public class MainClass7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FileInputStream fis=null;
        try
        {
        	fis=new FileInputStream("c:\\java_data\\news.txt");
        	BufferedReader br=
        			new BufferedReader(new InputStreamReader(fis));
        	//=> 1byte => 2byte로 변경 (한글이 정상적으로 수행)
        	while(true)
        	{
        		String data=br.readLine();
        		if(data==null) break; //값이 없는 경우에 종료
        		System.out.println(data);
        	}
        }catch(Exception ex)
        {
        	ex.printStackTrace();// 에러 처리 
        }
        finally
        {
        	try
        	{
        		fis.close();// 파일 닫기 (에러,에러없다 상관없이 파일 닫기를 한다 
        	}catch(Exception ex) {}
        }
	}

}
