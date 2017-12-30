package appLayer;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import appLayer.Drawing.DrawingPanel;

public class SaveCommand implements Command{
	String filename;
	private DrawingPanel drawingPanel;

	public SaveCommand(Object[] commandParameters) {
		this.filename = (String) commandParameters[0];
	}

	@Override
	public boolean execute() {
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(
			      new BufferedOutputStream(
			        new FileOutputStream(filename)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("saving");
		encoder.writeObject(drawingPanel.getObjects());
		encoder.close();
		return true;
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
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
