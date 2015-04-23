package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class BlackHole extends Holes {
	private static Color COLOR = Color.BLACK;

	public BlackHole(Point location, int radius) {
		super(location, radius, COLOR);
	}

}
