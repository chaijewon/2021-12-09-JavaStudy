package com.sist.main;
/*
 *   IO(InputStream / OutputStream) => java.io.* => (nio)
 *   => Frame => JFrame => JavaFX (웹)
 *   => 자바 => 1995(Applet) => 인터넷 (정적페이지:정보만 확인) 
 *             ============= 동적 페이지 (발전 => 5/23)
 *   => 그린프로젝트 : 리모콘(통합) => 지원(실패) => 임베디드 => 모바일 
 *      ========= 네스케이프 (브라우저) => 웹 
 *   
 *   => IO (입출력)
 *      1. 메모리 
 *         = System.in , System.out(표준 입출력) 
 *         = Scanner
 *      2. 파일
 *         = FileInputStream/FileOutputStream
 *         = FileReader / FileWriter
 *      3. 네트워크 
 *         = Socket (입출력) ==> 전화기 (유심=IP,PORT(연결선)) 
 *           = Socket 저장공간을 이용해서 => 통신 (Stream)=> 신뢰성(TCP)
 *           
 *   => 자바에서 지원하는 IO
 *      바이트 기반 스트림                 /       문자 기반 스트림 
 *      InputStream / OutputStream             Reader / Writer
 *        |              |                       |        |
 *     FileInputStream / FileOutputStream      FileReader / FileWriter
 *     ObjectInputStream / ObjectOutputStream           |
 *                                                 BufferdReader
 *                                                 
 *     파일에 대한 정보 : File
 *     ** 보조스트림 => InputStreamReader 
 *                   =========== ======
 *                    바이트 => 문자로 변경
 *     
 *     FileInputStream(파일읽기) / FileOutputStream(파일 쓰기)
 *     int read()                void write(int b),void write(byte[])
 *     ==== 문자 번호(char)         *** String => byte[] 
 *                                      getBytes()
 *     int read(byte[],int o,int s) void write(byte[],int s, int e)
 *     ==== 읽은 바이트 수 
 *     close()                   close()
 *     *** -1 (EOF=End Of File)
 *     ========================> 웹 (업로드 , 다운로드) => 자료실
 *       => 그림을 뒤집어서 출력  => 그림파일을 byte[]을 받아서 length()-1
 *      
 *     FileReader(한글이 포함된 텍스트 파일 읽기)/FileWriter(한글이 포함된 데이터를 텍스트 파일에 전송)
 *       => int read()                     => void write(int c)
 *          === 문자번호 (0~65535)           => void write(String s)
 *              => char(2byte씩 읽어 온다)
 *       => int read(char[],int s,int e)
 *       => close()
 *     ==========================================================
 *     보조 스트림 
 *     BufferedReader : 파일 =====> 전체메모리에 저장후 응용프로그램 
 *                      응용프로그렘 ======> 전체를 모아서 하드디스크
 *     ==> readLine() , close()
 *     ==========================================================
 *     파일에 정보 : File (파일,디렉토리)
 *     1. 파일 정보 
 *        File file=new File("c:\\javaDev\\a.png")
 *     2. 디렉토리 정보  
 *        File dir=new File("c:\\javaDev")
 *     3. 생성 (파일 : createNewFile(),디렉토리:mkdir() , 삭제: delete())
 *     4. 파일 정보 
 *        getName() : 파일명만 읽어 온다 
 *        getPath() : 경로명~파일명 
 *        getParant() : 경로명 
 *        length() : 파일 크기 (리턴형 : long)
 *        listFiles() : 폴더안에 있는 모든 파일,디렉토리를 읽어 온다 
 *     ============================================================
 *     ObjectInputStream      /  ObjectOutputStream 
 *      => Object readObject()  void writeObject()
 *      => close()              => close()
 *     ========================================= 객체 단위 : 직렬화 / 역직렬화 
 *     
 *     //1 . FileInputStream / FileOutputStream 
 *       => 업로드 (파일을 복사해서 => 원하는 폴더이동)
 *          ===== local => server
 *          
 *       // C:\\Users\\user\\Desktop\\자료\\2021-12-13.zip
 *       // c:\\java_data
 */
// 라이브러리 첨부 
import java.io.*;
public class MainClass {
    // FileInputStream/FileOutputStream => 파일 복사 , 업로드 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 읽을 파일 설정 
        	FileInputStream fis=
        			new FileInputStream("C:\\Users\\user\\Desktop\\자료\\2021-12-13.zip");
        	// 저장 파일 설정 
        	FileOutputStream fos=
        			new FileOutputStream("c:\\java_data\\2021-12-13.zip");
        	int i=0; // 읽은 바이트 수 
        	byte[] buffer=new byte[1024];
        	// 1024 (TCP) , 512 (UDP) 
        	while((i=fis.read(buffer, 0, 1024))!=-1)
        	{
        		//System.out.println("읽은 바이트 수:"+i);
        		// 읽은 바이트를 원하는 파일에 출력 
        		fos.write(buffer, 0, i);
        		//                  읽은 바이트 수 만큼 출력 
        	}
        	// 종료 => 반드시 파일 닫기 
        	fis.close();
        	fos.close();
        	System.out.println("파일 복사 완료!!");
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
	}

}






