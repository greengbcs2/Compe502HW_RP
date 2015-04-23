package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Paper;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	private Vector<Ball> balls = new Vector<Ball>();
	private Vector<Brick> bricks = new Vector<Brick>();
	public static final int MYHEIGHT = 500;
	public static final int MYWIDTH = 700;
	private Boolean isBrickTouchedByBall;
	private Peddal peddal;
	

	public MyFrame() {
		isBrickTouchedByBall = false;
		setSize(MYWIDTH, MYHEIGHT);
		setTitle("A window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
		addBricks(15, 30, 25);
		addPeddal();
		addHoles();
		
	}

	private void addHoles() {
		Random r = new Random();
		BlackHole blackHole=new BlackHole(new Point(200, 100), 30);
	}

	private void addPeddal() {
			Rectangle rec = new Rectangle(200,MYHEIGHT-10, 150, 15);
			Color c = Color.BLACK;
			peddal= new Peddal(rec, c);
	}

	public void paint(Graphics g) {
		super.paint(g);
		peddal.paint(g);
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).paint(g);
		}
		for (int i = 0; i < bricks.size(); i++) {
			bricks.get(i).paint(g);
		}
		

	}
	
	private void addBricks(int brickNumber, int w, int h){
		for(int i=0; i<brickNumber;i++){
			Rectangle rec = new Rectangle(50+(w+5)*i, 200, w, h);
			Color c = Color.BLACK;
			Brick b = new Brick(rec, c);
			bricks.add(b);
			}
	}

	public static void main(String[] args) {
		MyFrame myWindow = new MyFrame();
		myWindow.setVisible(true);
	}

	private class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseMoved(MouseEvent e) {
			super.mouseMoved(e);
			if(MYWIDTH-e.getX()<peddal.getRectangle().getWidth())
				peddal.moveTo((int) (MYWIDTH-peddal.getRectangle().getWidth()),MYHEIGHT-10);
			else
			peddal.moveTo(e.getX(),MYHEIGHT-10);
			
		}

		public void mouseClicked(MouseEvent e) {
			Random r = new Random();
			Ball b = new Ball(new Point(e.getX(), e.getY()), r.nextInt(15) + 3);
			b.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			b.setMotion((r.nextInt() % 10), r.nextInt() % 10);
			balls.addElement(b);
			(new MyBallController(b)).start();

		}
	 
	}

	private class MyBallController extends Thread {
		private Ball myBall;

		public MyBallController(Ball b) {
			myBall = b;
		}

		@Override
		public void run() {
			super.run();
			while (true) {
				myBall.move();
				int x = myBall.getX();
				int y = myBall.getY();
				int r = myBall.getRadius();
				Rectangle rectanglBall=new Rectangle(x - r, y - r, 2 * r, 2 * r);
				for (int i = 0; i < bricks.size(); i++) {
					isBrickTouchedByBall = bricks.get(i).hitByBall(rectanglBall);
					if (isBrickTouchedByBall) {
						myBall.reflectVert();
						bricks.remove(i);

					}
				}

				if (x < r || x > getWidth() - r)
					myBall.reflectHorz();

				if (y < r || peddal.hitByBall(rectanglBall))
					myBall.reflectVert();

				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
				}
				repaint();
			}
		}
	}

}
