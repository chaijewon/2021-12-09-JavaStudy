package com.sist.game;
import java.awt.*;
import javax.swing.*;
// JFrame / JDialog / JWindow => 위에 올려서 사용 
// JPanel은 단독 수행이 불가능하다 (컴포넌트 묶어서 관리) => 화상 
public class GameView extends JPanel{
   private Image horse;
   private HorseThread h=new HorseThread();
   public GameView()
   {
	  horse=Toolkit.getDefaultToolkit().getImage("c:\\java_data\\horse1.gif");
   }
   // 그림을 그린다 
   public void paint(Graphics g)
   {
	   g.setColor(Color.white);
	   g.fillRect(0, 0, getWidth(), getHeight());
	   g.drawImage(horse, h.x, h.y,100,60,this); 
   }
   public void start()
   {
	   h.start();
   }
   public void end()
   {
	   h.interrupt();
   }
   class HorseThread extends Thread
   {
	   int x=850;
	   int y=600;
	   public void run()
	   {
		   while(true)
		   {
			   try
			   {
				   x-=5;
				   if(x<0)
				   {
					   x=-100;
					   interrupt();// 쓰레드 종료 
					   break;
				   }
				   Thread.sleep(300);
				   repaint();// 그림을 다시 그린다
			   }catch(Exception ex) {}
		   }
	   }
   }
}






