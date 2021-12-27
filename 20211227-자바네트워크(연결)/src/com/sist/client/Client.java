package com.sist.client;
import java.net.*;
/*
 *   네트워크 
 *     = IO (입출력) => 
 *     = Thread => 서버에서 각 클라이언트마다 서버 동작을 따로 설정 
 *     = 네트워크 관련 라이브러리 
 *     = 윈도우 
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Socket s=new Socket("211.63.89.99",3355);
        }catch(Exception ex) {}
	}

}
