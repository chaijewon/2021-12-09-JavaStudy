package com.sist.win;
import javax.swing.*;
/*
 *     Container : 관리 영역 (Spring) ==> awt=>swing=>javaFx
 *       =>  윈도우 창 
 *           => 기본창 : JFrame 
 *           => Dialog 
 *           => JWindow
 *           => JPanel
 *     Component
 *       => 기능을 가지고 있다 
 *           => JButton , JMenu , JRadioButton , JCheckBox 
 *           => JTextArea , JTextField , JEditPane , JTextPane
 *              =========                =========   =========
 *               메모장                     브라우저         카톡
 *       => 목록 출력 
 *          =======
 *          1. JTable : 접속자 목록 
 *          2. JTree  : 탐색기 
 *          3. 그림 , 글자 : JLabel 
 *    =========================================================
 *           
 */
public class MyWindow {
	JFrame f=new JFrame(); //has-a
    public MyWindow()
    {
    	f.setSize(640, 480);
    	f.setVisible(true);// 윈도우를 보여 달라 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 생성자 호출 
		new MyWindow();
	}

}






