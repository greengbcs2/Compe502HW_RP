package com.sun.atilim.compe501;

import java.awt.*;



public class Ball {
	private Point location;
	private int radius;
	private double dx;
	private double dy;
	private Color color = Color.blue;
	
	public Ball(Point location, int radius) {
		super();
		this.location = location;
		this.radius = radius;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
    public void reflectHorz () { 
    	dx = - dx; 
    }

    public void reflectVert () { 
    	dy = - dy; 
    }
    
    public void setMotion(double ddx, double ddy){
    	dx = ddx; dy = ddy;
    }
	
    public int getX(){
    	return location.x;
    }
    
    public int getY(){
    	return location.y;
    }
    
    public void moveTo (int x, int y) { 
    	location.move(x, y); 
    }

    public void move (){ 
    	location.translate((int) dx, (int) dy); 
    }
    
    public void paint (Graphics g) {
        g.setColor (color);
        g.fillOval (location.x-radius, location.y-radius, 2*radius, 2*radius);
    }	
}
