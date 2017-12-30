package unitTests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import appLayer.AddRelationCommand;
import appLayer.Drawing.DrawingPanel;

public class Test_AddRelationshipCommand {
	AddRelationCommand cmd;
	Field drawingField;
	DrawingPanel original, modified, redone;
	
	@Before
	public void initialize() throws NoSuchFieldException, SecurityException{
		Object[] objects = new Object[3];
		objects[0] = "BIN";
		objects[1] = new Point(0,0);
		objects[2] = new Point(1,1);
		cmd = new AddRelationCommand(objects);
		System.out.println(cmd.type);
		drawingField = AddRelationCommand.class.getDeclaredField("drawingPanel");
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
