package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Ball {
	private Color color = Color.blue;
	private double dx;
	private double dy;
	private Point location;
	private int radius;

	public Ball(Point location, int radius) {
		super();
		this.location = location;
		this.radius = radius;
	}

	public Color getColor() {
		return color;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public Point getLocation() {
		return location;
	}

	public int getRadius() {
		return radius;
	}

	public int getX() {
		return location.x;
	}

	public int getY() {
		return location.y;
	}

	public void move() {
		location.translate((int) dx, (int) dy);
	}

	public void moveTo(int x, int y) {
		location.move(x, y);
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(location.x - radius, location.y - radius, 2 * radius,
				2 * radius);

	}

	public void reflectHorz() {
		dx = -dx;
	}

	public void reflectVert() {
		dy = -dy;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void setMotion(double ddx, double ddy) {
		dx = ddx;
		dy = ddy;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
