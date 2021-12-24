package com.sist.main;
// FileReader / FileWriter => 한글이 있는 데이터 읽거나 , 파일에 저장 
// 한글 => 2byte => 한글자(2byte) => 문자 기반 스트림 
import java.io.*;
import java.util.*;
// 한명(개)에 대한 정보 => new를 이용해서 메모리를 여러개 생성 
// MemberVO , MemberDTO (한명에 대한 정보를 모아서 전송 목적)
// JSP => MemberBean
/*
 *    클래스 : 프로그램 
 *    1. 데이터를 모아 둔다 (VO,DTO) => 변수
 *    2. 요청에 대한 처리 => 메소드 
 *    3. 화면 출력 
 */
class Member{
	private int no;
	private String name;
	private String sex;
	private String addr;
	private String tel;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Member(int no, String name, String sex, String addr, String tel) {
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.addr = addr;
		this.tel = tel;
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// => 오라클 / 웹 / Open Api
        ArrayList<Member> list=
        		new ArrayList<Member>();
        list.add(new Member(1, "홍길동", "남자", "서울", "010-1111-1111"));
        list.add(new Member(2, "이순신", "남자", "부산", "010-2222-2222"));
        list.add(new Member(3, "춘향이", "여자", "제주", "010-3333-3333"));
        list.add(new Member(4, "소서노", "여자", "광주", "010-4444-4444"));
        list.add(new Member(5, "강감찬", "남자", "인천", "010-5555-5555"));
        // 필요한 위치에 try~catch를 사용한다 (예상되는 부분에서)
        try
        {
        	StringBuffer sb=new StringBuffer();
        	File file=new File("c:\\java_data\\address.txt");
        	// 파일 쓰기 => 존재 여부 (없는 경우 : 파일 생성,있는 경우: 통과)
        	if(!file.exists()) // 파일이 있는지 확인 
        	{
        		file.createNewFile(); // 파일 제작 
        	}
        	FileWriter fw=new FileWriter(file);//파일에 쓰기 
        	for(Member m:list)
        	{
        		String data=m.getNo()+"|"
        				   +m.getName()+"|"
        				   +m.getSex()+"|"
        				   +m.getAddr()+"|"
        				   +m.getTel()+"\n"; // \n:한명씩 구분 , | 한사람의 정보
        		sb.append(data);
        	}
        	// 파일에 저장 
        	fw.write(sb.toString());// sb에 저장된 모든 데이터에 출력 
        	fw.close(); // 파일 닫기 
        	System.out.println("회원 목목 저장 완료!!");
        }catch(Exception ex) 
        {
        	ex.printStackTrace();
        }
	}

}








