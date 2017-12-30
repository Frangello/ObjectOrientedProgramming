package appLayer;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import appLayer.Drawing.DrawingPanel;

public class LoadCommand implements Command {
	private String filename;
	private DrawingPanel drawingPanel;

	public LoadCommand(Object[] commandParameters) {
		this.filename = (String) commandParameters[0];
	}

	@Override
	public boolean execute() {
		XMLDecoder decoder = null;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(
			    new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CommandFactory.getInstance().drawingPanel.setObjects((Object[])decoder.readObject());
		CommandFactory.getInstance().drawingPanel.validate();
		CommandFactory.getInstance().drawingPanel.repaint();
        decoder.close();
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
