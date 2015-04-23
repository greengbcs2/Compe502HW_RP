package com.sun.atilim.compe501;

import java.awt.Graphics;

public class TargetAdaptor implements TargetInterface {

	protected int points = 0;

	@Override
	public boolean hitByBall() {
		return false;
	}

	@Override
	public void paint(Graphics g) {
	}

}
