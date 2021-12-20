/*
 * 
 * 1. SutdaCard  => num , isKwang 
 * 2. Student => name ,ban , no ,kor ,eng,math 
 * 
 *   객체 지향 프로그램 
 *   ==============
 *   1. 데이터 보호 : 캡슐화 
 *      데이터 은닉화 , 메소드를 이용해서 접근이 가능 
 *      ==========
 *        => 접근지정어 (private)
 *   2. 재사용 
 *      변경해서 사용 ==> 상속
 *      있는 그대로 사용 => 포함 
 *      상속 
 *      class A
 *      {
 *      }
 *      class B extends A  ==> 확장 
 *      {
 *      }
 *      포함 => 라이브러리는 거의 포함 => HashMap map=new HashMap()
 *      class C
 *      {
 *         A a=new A();
 *      }
 *   3. 추가 , 수정이 가능 
 *      추가 : 오버로딩 
 *      수정 : 오버라이딩 
 *   ===================================> 객체지향 프로그램은 목적을 유지보수 
 *      개발 : 6개월~1년 (8개월)
 *      유지보수 : 10년 ~15년 
 *      
 *   ====> 재사용을 하기 위한 준비 작업 
 *   클래스 => 변수,메소드 
 *   클래스 (부품 => 컴포넌트) ==> 조립 
 *   ==========
 *   구성요소 
 *   class className
 *   {
 *     ==========================================================
 *      page 246
 *      변수 => 프로그램 종료시까지 사용 (클래스 전체에서 사용:전역변수,멤버변수)
 *      ===
 *        ****** 클래스에 있는 모든 내용 (메소드,변수)
 *               반드시 메모리에 저장이 된 경우에만 사용이 가능 
 *        = 객체마다 따로 메모리에 저장한 후에 사용 
 *          인스턴스 변수 
 *            => new를 이용해서 저장 
 *        = 저장 공간을 한개만 만들고 공유변수
 *            => 컴파일될때 저장 
 *          정적변수 (static)
 *        = 메소드안에서 처리 변수
 *          매개변수 , 지역변수  
 *            => 메소드 호출 
 *     =========================================================
 *      메소드 : 설정된 변수의 활용 (동작 => 다른 클래스와 통신)
 *      page 249 
 *       1) 반복을 제거 
 *       2) 한가지의 기능을 수행 할 수 있게 명령문의 집합 
 *       3) 구조적 프로그램 (문장 => 단락) => 가독성 , 오류처리 , 유지보수
 *                                      재사용 
 *       4) 문법 형태
 *          접근지정어 (public) static|abstract 메소드명(매개변수..)=> tjsdjsqn
 *          {
 *             // 처리부 /구현부 
 *          }
 *          외부 클래스 통신 
 *          
 *          종류 
 *          리턴형(O) 매개변수(O)
 *          리턴형(O) 매개변수(X)
 *          리턴형(X) => void 매개변수(O)
 *          => 맨 마지막에 return이 없는 경우 자동으로 추가  
 *          리턴형(X) 매개변수(X)
 *     =========================================================
 *      생성자 : 멤버변수에 대한 초기화 담당 
 *             생성자는 클래스안에 한개 이상이 첨부되어 있어야 한다
 *             *** 없는 경우는 컴파일러의 의해 추가 (디폴트 생성자)
 *             특징
 *              1) 클래스명과 동일 
 *              2) 리턴형이 없다 
 *              3) 다른 클래스에서 사용이 가능 => public 
 *              4) 생성자는 여러개를 추가 할 수 있다 (오버로딩)
 *              5) 상속의 예외 조건
 *              6) 호출시에는 반드시 new 생성자()
 *              
 *      => 변수의 초기화 
 *         1) 클래스 영역에 선언된 변수는 기본 초기화 
 *            int => 0
 *            double => 0.0
 *            String => null
 *            float => 0.0F
 *            long => 0L
 *         2) 실제 필요한 데이터값을 설정 
 *            = 명시적 초기화 (1)
 *              class A
 *              {
 *                  int a=100;
 *                  String name="홍길동";
 *              }
 *            = 초기화 블록 (2)
 *              class A
 *              {
 *                  int a;
 *                  String name;
 *                  
 *                  {
 *                     a=100;
 *                     name="김두한";
 *                  }
 *              }
 *            = 생성자 (3)
 *              class A
 *              {
 *                  int a;
 *                  String name;
 *                  
 *                  public A()
 *                  {
 *                     a=100;
 *                     name="박문수";
 *                  }
 *              }
 *     ==========================================================
 *   }
 *   
 *   ***** 수정 / 추가 
 *   추가 : 오버로딩 
 *         1. 한개의 클래스안
 *         2. 메소드명이 동일 
 *         3. 매개변수의 데이터형 / 매개변수의 갯수가 다르다 
 *         4. 리턴형은 관계없다 
 *   수정 : 오버라이딩 
 *         1. 상속 , 익명의 클래스에서 가능 
 *         2. 메소드명이 동일 
 *         3. 매개변수가 동일 
 *         4. 리턴형이 동일 
 *         5. 확장은 가능 => 축소는 불가능하다
 *            접근지정어 
 *            private < default < protected < public 
 *            
 *            class A
 *            {
 *                void diplay() throws Exception
 *                {
 *                }
 *            }
 *            
 *            class B extends A
 *            {
 *                void diplay() throws Exception
 *                {
 *                }
 *                protected void display(){}
 *                public void display(){}
 *            }
 *         6. 예외처리는 상의 클래스보다 많으면 안된다  
 * 
다음의 코드에 정의된 변수들을 종류별로 구분해서 적으시오.
class PlayingCard { 
	int kind; 
	int num; // 인스턴스 => new 의 갯수만큼 메모리가 할당 
	static int width; 
	static int height; // 컴파일러에 의해 메모리 할당 
	PlayingCard(int k, int n) {  // 호출시에 메모리 할당 
	kind = k; 
	num = n; 

} 
인스턴스(객체)변수 : kind , num => 객체를 통해서 접근 
정적변수(공유변수,클래스변수 )=>static : width,height => 클래스명으로 접근 
지역변수 : k,n => 지역변수 , 매개변수 
 
 width,height => 미리 메모리에 저장 
 PlayingCard p=new PlayingCard();==> kind,num
   => p.kind , p.num
   => PlayingCard.width , PlayingCard.height


 다음 중 생성자에 대한 설명으로 옳지 않은 것은? (모두 고르시오) 
 a. 모든 생성자의 이름은 클래스의 이름과 동일해야한다.
 b. 생성자는 객체를 생성하기 위한 것이다. (O)
           ================== new => 초기화를 담당 
 c. 클래스에는 생성자가 반드시 하나 이상 있어야 한다.
            ====================
 d. 생성자가 없는 클래스는 컴파일러가 기본 생성자를 추가한다.
    ========================================
 e. 생성자는 오버로딩 할 수 없다.(O)
    ====================== 오버로딩 지원한다

 다음 중 this에 대한 설명으로 맞지 않은 것은? (모두 고르시오)
a. 객체 자신을 가리키는 참조변수이다.
b. 클래스 내에서라면 어디서든 사용할 수 있다.(O) ==> static메소드에서는 사용 금지 
c. 지역변수와 인스턴스변수를 구별할 때 사용한다.
d. 클래스 메서드 내에서는 사용할 수 없다.
class A
{
   int a;
   int b;
   static int c;
   public void display(){this를 사용할 수 있다 }
   public static void aaa(){this를 사용 할 수 없다 }
   public A(int a)
   {
      this.a=a
      인스턴스 변수 ==> 지역변수 
   }
   
}
A => 가지고 있는 변수 / 메소드 ==> 인스턴스 
     int a;
     int b;
     public void display(){} 

 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은? (모두 고르시오)
a. 메서드의 이름이 같아야 한다.
b. 매개변수의 개수나 타입이 달라야 한다.
c. 리턴타입이 달라야 한다.(O)
d. 매개변수의 이름이 달라야 한다.(O)
   aaa(int a,int b) => aaa(int,int)
   aaa(int k,int y) => aaa(int,int)
   ================ 같은 메소드 
오버로딩의 조건
1. (   메소드  ) 이름이 같아야 한다.
2. (     매개변수 )의 개수 또는 타입이 달라야 한다.
3. 매개변수는 같고 (    리턴형   )이 다른 경우는 오버로딩이 성립되지 않는다.   

	다음 중 아래의 add메서드를 올바르게 오버로딩 한 것은? (모두 고르시오)
long add(int a, int b) { return a+b; }
a. long add(int x, int y) { return x+y; } => 같은 메소드 
b. long add(long a, long b) { return a+b; } (O)
c. int add(byte a, byte b) { return a+b; } (O)
d. int add(long a, int b) { return (int)(a+b); }(O)



 다음 중 초기화에 대한 설명으로 옳지 않은 것은? (모두 고르시오)
a. 멤버변수는 자동 초기화되므로 초기화하지 않고도 값을 참고할 수 있다.
b. 지역변수는 사용하기 전에 반드시 초기화해야 한다.
c. 초기화 블럭보다 생성자가 먼저 수행된다.(O)
d. 명시적 초기화를 제일 우선적으로 고려해야 한다.
e. 클래스변수보다 인스턴스변수가 먼저 초기화된다.(O)
   ======= 컴파일시 === new 생성자()

 다음 중 인스턴스변수의 초기화 순서가 올바른 것은?
a. 기본값-명시적초기화-초기화블럭-생성자(O)
        ==========================
b. 기본값-명시적초기화-생성자-초기화블럭
c. 기본값-초기화블럭-명시적초기화-생성자
d. 기본값-초기화블럭-생성자-명시적초기화

 다음 중 지역변수에 대한 설명으로 옳지 않은 것은? (모두 고르시오)
a. 자동 초기화되므로 별도의 초기화가 필요없다.(O)
b. 지역변수가 선언된 메서드가 종료되면 지역변수도 함께 소멸된다.
c. 메서드의 매개변수로 선언된 변수도 지역변수이다.
d. 클래스변수나 인스턴스변수보다 메모리 부담이 적다.
e. 힙(heap)영역에 생성되며 가비지 컬렉터에 의해 소멸된다.(O)


	오버라이딩의 정의와 필요성에 대해서 설명하시오.
                   ===== 상속을 받아서 프로그램에 맞게 수정해서 사용 

 다음 중 오버라이딩의 조건으로 옳지 않은 것은? (모두 고르시오)
a. 조상의 메서드와 이름이 같아야 한다.
b. 매개변수의 수와 타입이 모두 같아야 한다.
c. 접근 제어자는 조상의 메서드보다 좁은 범위(축소)로만 변경할 수 있다.(O)
   private < default < protected < public 
d. 예외는 조상 클래스의 메서드보다 좁은 범위로 변경할 수 있다(O)

 다음 중 접근제어자를 접근범위가 넓은 것에서 좁은 것의 순으로 바르게 나열한 것은?
a. public-protected-(default)-private(O)
b. public-(default)-protected-private
c. (default)-public-protected-private
d. private-protected-(default)-public
접근 제어자가 사용될 수 있는 곳 - 클래스, 멤버변수, 메서드, 생성자
( private    ) - 같은 클래스 내에서만 접근이 가능하다.
(  default   ) - 같은 패키지 내에서만 접근이 가능하다.
( protected    ) - 같은 패키지 내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능하다.
( public    ) - 접근 제한이 전혀 없다.

 다음 중 접근 제어자에 대한 설명으로 옳지 않은 것은? (모두 고르시오)
a. public은 접근제한이 전혀 없는 접근 제어자이다.
b. (default)가 붙으면, 같은 패키지 내에서만 접근이 가능하다.
c. 지역변수에도 접근 제어자를 사용할 수 있다.(O)
   => 지역변수는 사용 할 수 있는 키워드 => final만 사용이 가능 (상수)
d. protected가 붙으면, 같은 패키지 내에서도 접근이 가능하다.
e. protected가 붙으면, 다른 패키지의 자손 클래스에서 접근이 가능하다.

 */
/*
 *  1. SutdaCard  => num , isKwang 
 * 2. Student => name ,ban , no ,kor ,eng,math 
 */
// 캡슐화 
// 변수명이 틀린 경우 
// 지역변수 우선 => 멤버변수 
class SutdaCard{
	private int num;
	private boolean isKwang;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public boolean isKwang() {
		return isKwang;
	}
	public void setKwang(boolean isKwang) {
		this.isKwang = isKwang;
	}
	
}
class Student{
	private String name;
	private int ban,no,kor,eng,math;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
