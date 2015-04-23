package com.sun.atilim.compe501;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Peddal extends Target {

	Rectangle rectangle;
	private double dx;	
	
	public Peddal(Rectangle r, Color color) {
		super(r,color);
		rectangle=r;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

    @SuppressWarnings("deprecation")
	public void moveTo (int x,int y) { 
    	rectangle.move(x, y); 
    }

    public void move (){ 
    	rectangle.translate((int) dx, 0); 
    }
    
    public void paint (Graphics g) {
        g.setColor (color);
        g.fillRect(rectangle.x, rectangle.y, (int)rectangle.getWidth(),(int) rectangle.getHeight());
    }

}
