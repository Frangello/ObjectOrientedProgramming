package appLayer.Drawing;

import java.awt.Point;

public class ClassComponent{
	private Point location;
	private String name;
	int x,y; 
	
	public ClassComponent(){
	}
	
	public int getX(){
		return (int) location.getX();
	}
	
	public int getY(){
		return (int) location.getY();
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
