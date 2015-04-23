package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class BallWorldPanel extends JPanel {

	private Ball aBall = new Ball(new Point(10, 15), 5);

	public BallWorldPanel(Color ballColor) {
		aBall.setColor(ballColor);
		aBall.setMotion(3.0, 6.0);
	}

	public void moveBall(int width, int height) {
		aBall.move();
		int r = aBall.getRadius();
		if ((aBall.getX() < r) || (aBall.getX() > width - r))
			aBall.reflectHorz();
		if ((aBall.getY() < r) || (aBall.getY() > height - r))
			aBall.reflectVert();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		aBall.paint(g);
	}
}
