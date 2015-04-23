package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Peddal extends Target {

	static Rectangle PEDDAL_RECTANGLE = new Rectangle(200,
			MyFrame.MYHEIGHT - 10, 150, 15);;
	private double dx;
	public static final Color PEDDAL_COLOR = Color.BLUE;

	public Peddal() {
		super(PEDDAL_RECTANGLE, PEDDAL_COLOR);
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	@SuppressWarnings("deprecation")
	public void moveTo(int x, int y) {
		PEDDAL_RECTANGLE.move(x, y);
	}

	public void move() {
		PEDDAL_RECTANGLE.translate((int) dx, 0);
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(PEDDAL_RECTANGLE.x, PEDDAL_RECTANGLE.y,
				(int) PEDDAL_RECTANGLE.getWidth(),
				(int) PEDDAL_RECTANGLE.getHeight());
	}

}
