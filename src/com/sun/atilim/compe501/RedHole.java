package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Point;

public class RedHole extends Holes {
	private static Color COLOR = Color.RED;

	public RedHole(Point location, int radius) {
		super(location, radius, COLOR);
	}

}
