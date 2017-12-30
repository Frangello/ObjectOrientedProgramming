package unitTests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import appLayer.AddClassCommand;
import appLayer.Drawing.DrawingPanel;

public class Test_AddClassCommand {
	AddClassCommand cmd;
	Field drawingField;
	DrawingPanel original, modified, redone;
	
	@Before
	public void initialize() throws NoSuchFieldException, SecurityException{
		Object[] objects = new Object[1];
		objects[0] = new Point(0,0);
		cmd = new AddClassCommand(objects);
		drawingField = AddClassCommand.class.getDeclaredField("drawingPanel");
		drawingField.setAccessible(true);
	}

	@Before
	public void testExecute() throws IllegalArgumentException, IllegalAccessException {
		assertTrue(cmd.execute());
		original = (DrawingPanel)drawingField.get(cmd);
		assertNotNull(drawingField.get(cmd));
	}
	
	@Test
	public void testUndo() throws IllegalArgumentException, IllegalAccessException{
		cmd.undo();		
		modified = (DrawingPanel)drawingField.get(cmd);
		assertSame(original, modified);
	}
	
	@Test
	public void testRedo() throws IllegalArgumentException, IllegalAccessException{
		cmd.redo();		
		redone = (DrawingPanel)drawingField.get(cmd);
		assertSame(original, redone);
	}

}
