package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Rectangle;

public class Peddal extends Target {

	public Peddal(Rectangle r, Color color) {
		super(r, color);
	}

	public boolean hitByBall(Rectangle rectangleByBall) {
		return false;
	}

	public void moveTo() {
	}

	public void move() {
	}

}
