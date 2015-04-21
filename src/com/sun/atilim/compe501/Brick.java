package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Brick extends Target{

	public Brick(Rectangle rectangle,Color color) {
		super(rectangle,color);
	}
	
	public boolean hitByBall(Rectangle rectangleByBall) {
		if(rectangleByBall.intersects(rectangle))
			return true;
		else
			return false;
		
	}
	public void removeBrick(Graphics g){
		g.clearRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}

}
