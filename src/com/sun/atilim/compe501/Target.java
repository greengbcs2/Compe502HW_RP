package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Target extends TargetAdaptor {
	Rectangle rectangle;
	Color color;
	
	public Target(Rectangle r,Color color) {
		this.rectangle=r;
		this.color=color;
	}
	public Target(Color color) {
		this.color=color;
	}

    public void paint (Graphics g) {
        g.setColor (color);
        g.fillRect(rectangle.x, rectangle.y, (int)rectangle.getWidth(),(int) rectangle.getHeight());
    }
    
	public boolean hitByBall(Rectangle rectangleByBall) {
		if(rectangleByBall.intersects(rectangle))
			return true;
		else
			return false;
		
	}

}
