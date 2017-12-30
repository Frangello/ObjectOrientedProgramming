package unitTests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import appLayer.NewCommand;
import appLayer.Drawing.DrawingPanel;

public class Test_NewCommand {
	NewCommand cmd;
	Field drawingField, previousField;
	DrawingPanel original, modified, redone;
	
	@Before
	public void initialize() throws NoSuchFieldException, SecurityException{
		cmd = new NewCommand();
		drawingField = NewCommand.class.getDeclaredField("drawingPanel");
		drawingField.setAccessible(true);
		previousField = NewCommand.class.getDeclaredField("previousPanel");
		previousField.setAccessible(true);
		assertTrue(cmd.execute());
	}
	
	@Test
	public void testUndo() throws IllegalArgumentException, IllegalAccessException {
		original = (DrawingPanel)drawingField.get(cmd);
		modified = (DrawingPanel)previousField.get(cmd);
		cmd.undo();
		assertEquals(original.getObjects(), modified.getObjects());
	}

}
