package appLayer;

import appLayer.Drawing.DrawingPanel;

public interface Command {
	public void setDrawingPanel(DrawingPanel panel);
	public DrawingPanel getDrawingPanel();
	public boolean execute();
	public void undo();
	public void redo();
	
}
