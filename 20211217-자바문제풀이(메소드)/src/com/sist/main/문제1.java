package com.sist.main;
/*
 * 사용자로부터 아이디를 받아서 중복체크하는 메소드 원형을 작성하시오
 * ===================== 요청값(매개변수) => 중복체크 => 리턴형 
 * => 결과가 나올때 경우의 수 2개  ==> true/false (boolean)
 *                     여러개  ==> String , int => 권장(String)
 * public boolean idCheck(String id);
   우편번호를 검색하는 메소드 원형을 작성하시오
   public ArrayList postfind(String dong);
   2단에서 9단까지 구구단을 출력하는 메소드 원형을 작성하시오
                      ======= void (자체에서 처리)
   public void gugudan();
   ****** 프로그램은 정답이 없다 (구현) => 1. 가독성 , 2. 최적화
   *                                3. 소스 간결화 (10줄 => 3줄)
   *      => 소스 간결하게 코딩하는 것이 아니고 => 
   *      
   *      =>   
   *          *
   *          **
   *          ***
   *          ****
   *          
   *          for(int i=1;i<=4;i++)
   *          {
   *             for(int j=1;j<=i;j++)
   *             {
   *                System.out.print("*");
   *             }
   *             System.out.println();
   *          }
   *          
   *          System.out.println("*");
   *          System.out.println("**");
   *          System.out.println("***");
   *          System.out.println("****");
   *          
   *          
   객체 지향 지향 프로그램 
   1) 클래스 구성 요소 
      ======================================================
       변수 
        = 인스턴스 변수 => new를 메모리에 저장시에 저장 
                        => 객체 생성시마다 따로 저장되는 변수 
        = 정적 변수 => 컴파일시에 저장 
                        => static공간에 저장 (한개의 메모리 생성)
                        => 공통변수,공유변수 
      ======================================================
       249p ~ 259p 
       ============ 1.변수 (저장하는 데이터) , 2. 기능 (메소드)
                                          => 연산자,제어문
       메소드 (249p) => 한개의 작업을 하기 위한 명령문의 집합 
         1) 재사용 목적 
         2) 반복을 제거 
         3) 가독성 (보기 편하게 만든다) => 구조화 (문장 => 단락)
                                           ============ 
                                             자기소개 
            => 유지 보수 (수정 , 추가)
            
         4) 메소드의 형식 ==> 메소드는 다른 클래스 통신(연결)
            접근지정어(public) 리턴형 메소드명(매개변수....) ==> 선언부
              => 매개변수는 지역변수에 해당(메소드 {} 끝나면 자동으로 사라지는 변수)
            {
                   구현부 (기능 구현)
            }
            => 원형
            
            메소드 
            =====
            
            ==========================================
                리턴형(요청결과값)    매개변수(요청 데이터)
                => 1개만 설정       => 여러개 사용이 가능 
                => 여러개          => 3개이상 (배열, 클래스) 
                   (배열 , 클래스 , Collection)
            ==========================================
                   O                O
            ==========================================
                   O                X
            ==========================================
                   X                O
                   => 자체 처리 (출력,추가,수정,삭제)
            ==========================================
                   X(void)          X
            ==========================================
            
            리턴이 있는 경우 
            public int method()
            {
                return 값(int) => byte,char...
            }
            public void method()
            {
               return => 생략이 가능 (자동으로 컴파일러가 return 추가)
            }
      ======================================================
            생성자 : 생략할 수 있다 => 자동으로 컴파일러가 디폴트생성자를 생성 
            =====
             = 멤버변수의 초기화 
             = 사용자부터 입력값을 받아서 초기화 
             = 시작동시에 서버연결 , 오라클 연결 , 파일읽기 
             = 오버로딩 (생성자는 여러개를 사용 할 수 있다)
             = 특징 : 리턴형이 없다 , 클래스명과 동일 
                     모든 클래스를 해당 클래스를 사용하기 위해서 
                     접근지정어를 public으로 설정 
                     상속의 예외 
      ======================================================

 */
public class 문제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
