package unitTests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Stack;

import org.junit.Test;

import appLayer.Command;
import appLayer.Invoker;

public class Test_Invoker {
	
	@Test
	public void testSizeOfStacks() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Invoker invoker = new Invoker();
		invoker.setCommand(new DummyCommand());
		invoker.setCommand(new DummyCommand());
		invoker.setCommand(new DummyCommand());
		
		Field undoField = Invoker.class.getDeclaredField("undoStack");
		undoField.setAccessible(true);
		
		Field redoField = Invoker.class.getDeclaredField("redoStack");
		redoField.setAccessible(true);
		
		//Tests setCommand
		assertEquals(3, ((Stack<Command>) undoField.get(invoker)).size());
		
		//Tests undo
		invoker.undo();
		assertEquals(2, ((Stack<Command>) undoField.get(invoker)).size());
		assertEquals(1, ((Stack<Command>) redoField.get(invoker)).size());
		
		//Tests redo
		invoker.redo();
		assertEquals(0, ((Stack<Command>) redoField.get(invoker)).size());
		assertEquals(3, ((Stack<Command>) undoField.get(invoker)).size());
	}


}
