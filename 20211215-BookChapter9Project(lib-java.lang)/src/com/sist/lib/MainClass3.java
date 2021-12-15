package com.sist.lib;
// indexOf 
// lastIndexOf 
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s="Hello Java!!";
        //        01234567891011
        int i=s.indexOf('a');
        System.out.println("i="+i);
        int j=s.lastIndexOf('a');
        System.out.println("j="+j);
        
        // »Æ¿Â¿⁄ 
        s="c:\\javaDev\\java.basic\\Hello.java";
        String ss=s.substring(s.lastIndexOf(".")+1);
        System.out.println(ss);
        
        		
	}

}
