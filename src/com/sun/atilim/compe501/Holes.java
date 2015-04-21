package com.sun.atilim.compe501;

import java.awt.Graphics;
import java.awt.Point;

public class Holes extends TargetAdaptor {
	private Point location;
	private int radius;
	public Holes(Point location, int radius) {
		this.setLocation(location);
		this.setRadius(radius);
	}
	public void hitByBall() {}
	public void paint(Graphics g) {}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
}
