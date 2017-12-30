package appLayer;

import java.awt.Point;

import javax.swing.JOptionPane;

import appLayer.Drawing.ClassComponent;
import appLayer.Drawing.DrawingPanel;

public class AddClassCommand implements Command {
	Point location;
	ClassComponent drawing;
	DrawingPanel drawingPanel;

	public AddClassCommand(Object[] commandParameters) {
		this.location = (Point) commandParameters[0];
		//Default
		this.drawingPanel = new DrawingPanel();
	}

	@Override
	public boolean execute() {
		drawing = new ClassComponent();
		drawing.setLocation(location);
		drawing.setName((String)JOptionPane.showInputDialog("Enter class name"));
		drawingPanel.addClass(drawing);
		return true;
	}

	@Override
	public void undo() {
		drawingPanel.removeClass(drawing);
	}

	@Override
	public void redo() {
		drawingPanel.addClass(drawing);
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
