package appLayer;

import appLayer.Drawing.DrawingPanel;

public class NewCommand implements Command {
	DrawingPanel drawingPanel, previousPanel;
	
	public NewCommand(){
		drawingPanel = new DrawingPanel();
		previousPanel = new DrawingPanel();
	}
	
	@Override
	public boolean execute() {
		previousPanel.setObjects(drawingPanel.getObjects());
		drawingPanel.clearObjects();
		drawingPanel.repaint();
		return true;
	}

	@Override
	//Fix, only undos if undo,undo,redo
	public void undo() {
		drawingPanel.setObjects(previousPanel.getObjects());
		drawingPanel.repaint();
	}

	@Override
	public void redo() {
		drawingPanel.clearObjects();
		drawingPanel.repaint();
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
