package com.sist.common;
// 내부 프로토콜 => 서버/클라이언트 약속 
// 클라이언트 100 => 서버 (로그인처리) => 요청번호 
// 클라이언트 200 => 서버 (채팅처리)
// 클라이언트 300 => 서버 (나가기)
// 웹 ==> 구분이 되는 것이 없다 (파일명)
// 서버 / 클라이언트에서 공통으로 사용되는 파일 
public class Function {
	// 기능 설정 => 로그인 , 채팅 , 나가기 
   public static final int LOGIN=100; // 이미 들어와 있는 접속자 처리
   public static final int MYLOG=110; // 로그인하고 들어가는 사람 
   public static final int CHAT=200;
   public static final int EXIT=300; // 남아 있는 접속자 처리 
   public static final int MYEXIT=310; // 실제 나가는 사람 처리 
   // 필요시에 기능 첨부 
}
