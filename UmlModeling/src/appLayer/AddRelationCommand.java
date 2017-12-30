package appLayer;

import java.awt.Point;

import appLayer.Drawing.DrawingPanel;
import appLayer.Drawing.RelationshipComponent;

public class AddRelationCommand implements Command {
	public Point start;
	public Point end;
	public String type;
	private DrawingPanel drawingPanel;
	private RelationshipComponent relationship;

	public AddRelationCommand(Object[] commandParameters) {
		this.type = (String) commandParameters[0];
		this.start = (Point) commandParameters[1];
		this.end = (Point) commandParameters[2];
		//Default
		this.drawingPanel = new DrawingPanel();
	}

	@Override
	public boolean execute() {
		relationship = new RelationshipComponent();
		relationship.setStart(start);
		relationship.setEnd(end);
		relationship.setLineType(type);
		drawingPanel.addLine(relationship);
		return true;
	}

	@Override
	public void undo() {
		drawingPanel.removeLine(relationship);
	}

	@Override
	public void redo() {
		drawingPanel.addLine(relationship);
	}

	@Override
	public void setDrawingPanel(DrawingPanel panel) {
		this.drawingPanel = panel;	
	}

	@Override
	public DrawingPanel getDrawingPanel() {
		return drawingPanel;
	}

}
