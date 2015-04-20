package com.sun.atilim.compe501;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	
	private Vector<Ball> balls = new Vector<Ball>();
	public static final int MYHEIGHT = 500;
	public static final int MYWIDTH = 700;
	Brick brc;
	
	public MyFrame(){		
		setSize(MYWIDTH, MYHEIGHT);
		setTitle("A window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		addMouseListener(new MyMouseListener());
		Rectangle rec=new Rectangle(10,10,20,20);
		Color c=Color.BLACK;
		brc=new Brick(rec,c);
	}	
	
	public void paint (Graphics g) {
		super.paint(g);
		brc.paint(g);
		for (int i=0 ; i < balls.size() ; i++){
			balls.get(i).paint(g);
		}
	}
	
	
	public static void main(String[] args) {
		MyFrame myWindow = new MyFrame();
		myWindow.setVisible(true);
	}
	
	
	
	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			
		
			Random r = new Random();
			Ball b = new Ball(new Point(e.getX(),e.getY()), r.nextInt(15)+3);
			b.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			b.setMotion((r.nextInt()%10), r.nextInt()%10);
			balls.addElement(b);
			(new MyBallController(b)).start();
			
		}
	}
	
	private class MyBallController extends Thread{
		private Ball myBall;
		
		public MyBallController(Ball b){
			myBall = b;
		}

		@Override
		public void run() {
			super.run();
			while(true){
				myBall.move();
				int x = myBall.getX();
				int y = myBall.getY();
				int r = myBall.getRadius();
				
				if ( x < r || x > getWidth() - r)
					myBall.reflectHorz();
				
				if ( y < r || y > getHeight() - r)
					myBall.reflectVert();
				
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {}
				repaint();
			}			
		}
	}
	

}
