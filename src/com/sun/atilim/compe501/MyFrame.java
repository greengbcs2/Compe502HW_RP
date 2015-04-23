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
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {

	private class MyBallController extends Thread {
		private Ball myBall;
		boolean stop = true;

		public MyBallController(Ball b) {
			myBall = b;
		}

		private void gameOver() {
			stop = false;
			JOptionPane
					.showMessageDialog(
							null,
							Messages.getString("MyFrame.1") + points, //$NON-NLS-1$
							Messages.getString("MyFrame.2"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$
		}

		@Override
		public void run() {
			super.run();
			while (stop) {
				myBall.move();
				int x = myBall.getX();
				int y = myBall.getY();
				int r = myBall.getRadius();
				Rectangle rectangleBall = new Rectangle(x - r, y - r, 2 * r,
						2 * r);
				for (int i = 0; i < bricks.size(); i++) {
					isBrickTouchedByBall = bricks.get(i).hitByBall(
							rectangleBall);

					if (isBrickTouchedByBall) {
						myBall.reflectVert();
						bricks.remove(i);
						points = points + 10;

					}
				}
				for (int i = 0; i < balls.size(); i++) {
					isBlackHoleTouchedByBall = blackHole.hitByBall(new Point(
							balls.get(i).getX(), balls.get(i).getY()));
					isRedHoleTouchedByBall = redHole.hitByBall(new Point(balls
							.get(i).getX(), balls.get(i).getY()));

					if (isBlackHoleTouchedByBall) {
						balls.remove(i);
						isBlackHoleTouchedByBall = false;
						gameOver();
					}
					if (isRedHoleTouchedByBall) {
						Random random = new Random();
						balls.get(i).reflectVert();
						redHole = new RedHole(new Point(
								random.nextInt(300) + 10,
								random.nextInt(50) + 50), RED_HOLE_RADIUS);
						points = points + 20;
						isBlackHoleTouchedByBall = false;
					}
					if (x < r || x > getWidth() - r)
						myBall.reflectHorz();

					if (y < r)
						myBall.reflectVert();
					else if (peddal.hitByBall(rectangleBall)) {
						myBall.reflectVert();
						while (peddal.hitByBall(rectangleBall)) {
							if (peddal.hitByBall(rectangleBall))
								break;
							else
								myBall.reflectVert();
						}
					} else if (y > MYHEIGHT) {
						gameOver();

					}
				}

				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
				}
				repaint();

			}
		}
	}

	private class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (oneBall) {
				Random r = new Random();
				Ball b = new Ball(new Point(e.getX(), e.getY()),
						r.nextInt(15) + 3);
				b.setColor(new Color(r.nextInt(255), r.nextInt(255), r
						.nextInt(255)));
				b.setMotion((r.nextInt() % 10), r.nextInt() % 10);
				balls.addElement(b);
				(new MyBallController(b)).start();
				oneBall = false;
			}

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			super.mouseMoved(e);
			if (MYWIDTH - e.getX() < Peddal.PEDDAL_RECTANGLE.getWidth())
				peddal.moveTo(
						(int) (MYWIDTH - Peddal.PEDDAL_RECTANGLE.getWidth()),
						MYHEIGHT - 10);
			else
				peddal.moveTo(e.getX(), MYHEIGHT - 10);

		}

	}

	public static final int BLACK_HOLE_RADIUS = 30;
	public static final int MYHEIGHT = 500;
	public static final int MYWIDTH = 700;
	public static final int RED_HOLE_RADIUS = 10;
	public static final int BRICK_WIDTH = 30;
	public static final int BRICK_HEIGHT = 25;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		MyFrame myWindow = new MyFrame();
		myWindow.setVisible(true);
	}

	private Vector<Ball> balls = new Vector<Ball>();
	Holes blackHole;
	private Vector<Brick> bricks = new Vector<Brick>();
	private Boolean isBlackHoleTouchedByBall;
	private Boolean isBrickTouchedByBall;
	private Boolean isRedHoleTouchedByBall;
	boolean oneBall = true;

	private Peddal peddal;

	private int points;

	Holes redHole;

	public MyFrame() {
		setSize(MYWIDTH, MYHEIGHT);
		setTitle(Messages.getString("MyFrame.0")); //$NON-NLS-1$
		points = 0;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
		addBricks(15);
		addPeddal();
		addHoles();

	}

	private void addBricks(int brickNumber) {
		for (int i = 0; i < brickNumber; i++) {
			Rectangle rec = new Rectangle(50 + (BRICK_WIDTH + 5) * i, 200,
					BRICK_WIDTH, BRICK_HEIGHT);
			Brick b = new Brick(rec);
			bricks.add(b);
		}
	}

	private void addHoles() {
		blackHole = new BlackHole(new Point(200, 100), BLACK_HOLE_RADIUS);
		redHole = new RedHole(new Point(400, 100), RED_HOLE_RADIUS);
	}

	private void addPeddal() {
		peddal = new Peddal();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		peddal.paint(g);
		blackHole.paint(g);
		redHole.paint(g);
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).paint(g);
		}
		for (int i = 0; i < bricks.size(); i++) {
			bricks.get(i).paint(g);
		}

	}

}
