package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Holes extends TargetAdaptor {
	private Point location;
	private int radius;
	private Color color;
	private Rectangle rectangle;

	public Holes(Point location, int radius, Color c) {
		this.setLocation(location);
		this.setRadius(radius);
		color = c;
		rectangle = new Rectangle(location.x - radius, location.y - radius,
				2 * radius, 2 * radius);
	}

	public boolean hitByBall(Point p) {
		if (rectangle.contains(p))
			return true;
		else
			return false;
	}

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

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(location.x - radius, location.y - radius, 2 * radius,
				2 * radius);
	}
}
