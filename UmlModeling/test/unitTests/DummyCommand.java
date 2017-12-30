package unitTests;

import appLayer.Command;
import appLayer.Drawing.DrawingPanel;

public class DummyCommand implements Command{
	
	public DummyCommand(){
		
	}

	@Override
	public void setDrawingPanel(DrawingPanel panel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DrawingPanel getDrawingPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
}
