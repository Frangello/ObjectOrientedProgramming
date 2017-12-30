package appLayer.Drawing;

import java.awt.Point;

public class RelationshipComponent{
	private Point start;
	private Point end;
    private String lineType;
	
	public RelationshipComponent(){
	}
	
	public Point getStart(){
		return start;
	}
	public void setStart(Point start){
		this.start = start;
	}
	public Point getEnd(){
		return end;
	}
	public void setEnd(Point end){
		this.end = end;
	}

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}
}
