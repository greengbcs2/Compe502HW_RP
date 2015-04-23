package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick extends Target {
	static Color BRICK_COLOR = Color.YELLOW;

	public Brick(Rectangle rectangle) {
		super(rectangle, BRICK_COLOR);
	}

	public void removeBrick(Graphics g) {
		g.clearRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}

}
