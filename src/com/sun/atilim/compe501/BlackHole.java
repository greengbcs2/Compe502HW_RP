package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class BlackHole extends Holes{
	private Color color;
	public BlackHole(Point location, int radius) {
		super(location, radius);
		color=Color.BLACK;
	}
	public void hitByBall() {}
	public void paint(Graphics g) {}
}
