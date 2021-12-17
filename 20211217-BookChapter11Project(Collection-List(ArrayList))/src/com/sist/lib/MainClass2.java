package com.sist.lib;
// 사용자 정의 클래스 
import java.util.*;
// 한개(명)에 대한 정보를 설계 
// 여러명을 저장 => new 메모리를 따로 배치 
// 보안 => 정보를 보호 => 캡슐화 
class Student
{
	// 변수 => 읽기(메모리에서 데이터 얻기)/쓰기(메모리에 데이터값 저장)
	//        === 기능(메소드):getter: getXxx() === 기능(메소드) setter:setXxx()
	private int hakbun;// 메모리에서 감춘다 (은닉화)
	private String name;
	private int kor,eng,math;
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	// 초기화를 위해 생성자에 매개변수를 사용한다 
	public Student(int hakbun, String name, int kor, int eng, int math) {
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	// 이번주까지 
	/*
	 *   연산자 , 제어문  
	 *   => 메소드 
	 *   => 객체지향 
	 *   => 예외처리 
	 *   => 라이브러리 정리 
	 *   => 파일 
	 *   => 쓰레드 / 네트워크 (흐름)
	 *             ============ 스프링(웹소켓)
	 *      ==== javascript (Ajax) 
	 */
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 학생 5명 저장 => 5명을 저장 할 수 있는 저장공간 (컬렉션(가변),배열(고정))
	    ArrayList list=new ArrayList();
	    // 학생 등록 
	    list.add(new Student(1, "홍길동", 89, 90, 67));
	    list.add(new Student(2, "박문수", 78, 95, 60));
	    list.add(new Student(3, "소서노", 85, 92, 90));
	    list.add(new Student(4, "이순신", 50, 80, 90));
	    list.add(new Student(5, "춘향이", 79, 93, 61));
	    // 출력 , 입력 , 수정 , 삭제 .... 메소드 
	    // 출력 => 총점 , 평균 
	    /*
	     *    Object 
	     *    ======
	     *      |
	     *    Student 
	     */
	    for(int i=0;i<list.size();i++)
	    {
	    	// 저장된 데이터를 1개씩 읽어 온다 
	    	Student std=(Student)list.get(i);
	    	// 출력 
	    	// d(정수)  s(문자열)  c(문자)  f(실수)
	    	System.out.printf("%-3d%-6s%-5d%-5d%-5d%-5d%-7.2f\n",
	    			std.getHakbun(),std.getName(),
	    			std.getKor(),std.getEng(),std.getMath(),
	    			(std.getKor()+std.getEng()+std.getMath()),
	    			(std.getKor()+std.getEng()+std.getMath())/3.0);
	    }
	    
	    // 추가 => 가변 (원하는 만큼 저장이 가능) 
	    /*System.out.println("====== 학생(5개 데이터) 추가 ========");
	    Scanner scan=new Scanner(System.in);
	    System.out.print("학번 입력:");
	    int hakbun=scan.nextInt();
	    System.out.print("이름 입력:");
	    String name=scan.next();
	    System.out.print("국어 입력:");
	    int kor=scan.nextInt();
	    System.out.print("영어 입력:");
	    int eng=scan.nextInt();
	    System.out.print("수학 입력:");
	    int math=scan.nextInt();
	    // list에 저장 
	    Student s=new Student(hakbun, name, kor, eng, math);
	    list.add(s);
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	// 저장된 데이터를 1개씩 읽어 온다 
	    	Student std=(Student)list.get(i);
	    	// 출력 
	    	// d(정수)  s(문자열)  c(문자)  f(실수)
	    	System.out.printf("%-3d%-6s%-5d%-5d%-5d%-5d%-7.2f\n",
	    			std.getHakbun(),std.getName(),
	    			std.getKor(),std.getEng(),std.getMath(),
	    			(std.getKor()+std.getEng()+std.getMath()),
	    			(std.getKor()+std.getEng()+std.getMath())/3.0);
	    }*/
	    /*System.out.println("====== 삭제(학생) remove =======");
	    System.out.println("학생수 :"+list.size());
	    list.remove((int)(Math.random()*5));//0~4
	    // 출력 
	    for(int i=0;i<list.size();i++)
	    {
	    	// 저장된 데이터를 1개씩 읽어 온다 
	    	Student std=(Student)list.get(i);
	    	// 출력 
	    	// d(정수)  s(문자열)  c(문자)  f(실수)
	    	System.out.printf("%-3d%-6s%-5d%-5d%-5d%-5d%-7.2f\n",
	    			std.getHakbun(),std.getName(),
	    			std.getKor(),std.getEng(),std.getMath(),
	    			(std.getKor()+std.getEng()+std.getMath()),
	    			(std.getKor()+std.getEng()+std.getMath())/3.0);
	    }
	    // 현재 남아 있는 인원수 확인 
	    System.out.println("학생수 :"+list.size());*/
	    System.out.println("====== 학생 수정 : set =========");
	    Scanner scan=new Scanner(System.in);
	    String msg="===== 수정할 학생 선택 하세요 =====\n";
	    for(int i=0;i<list.size();i++)
	    {
	    	Student s=(Student)list.get(i);
	    	msg+=s.getName()+"("+i+")\n";
	    }
	    msg=msg.substring(0,msg.lastIndexOf("\n"));
	    System.out.print(msg);
	    System.out.println();
	    System.out.println("수정할 대상 선택:");
	    int select=scan.nextInt();// index번호 
	    
	    System.out.print("학번 입력:");
	    int hakbun=scan.nextInt();
	    System.out.print("이름 입력:");
	    String name=scan.next();
	    System.out.print("국어 입력:");
	    int kor=scan.nextInt();
	    System.out.print("영어 입력:");
	    int eng=scan.nextInt();
	    System.out.print("수학 입력:");
	    int math=scan.nextInt();
	    
	    Student s=new Student(hakbun, name, kor, eng, math);
	    list.set(select, s);
	    // 수정된 보여준다 
	    for(int i=0;i<list.size();i++)
	    {
	    	// 저장된 데이터를 1개씩 읽어 온다 
	    	Student std=(Student)list.get(i);
	    	// 출력 
	    	// d(정수)  s(문자열)  c(문자)  f(실수)
	    	System.out.printf("%-3d%-6s%-5d%-5d%-5d%-5d%-7.2f\n",
	    			std.getHakbun(),std.getName(),
	    			std.getKor(),std.getEng(),std.getMath(),
	    			(std.getKor()+std.getEng()+std.getMath()),
	    			(std.getKor()+std.getEng()+std.getMath())/3.0);
	    }
	    
	}

}








