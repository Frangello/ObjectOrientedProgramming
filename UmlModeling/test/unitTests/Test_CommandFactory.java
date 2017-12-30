package unitTests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import appLayer.AddClassCommand;
import appLayer.AddRelationCommand;
import appLayer.Command;
import appLayer.CommandFactory;
import appLayer.Invoker;
import appLayer.NewCommand;
import appLayer.Drawing.DrawingPanel;

public class Test_CommandFactory {
	CommandFactory instance;
	Command cmd; 
	Invoker invoker;
	DrawingPanel drawingPanel;
	Field commandField;
	
	@Before
	public void initializeFactory() throws NoSuchFieldException, SecurityException{
		 invoker = new Invoker();
		 drawingPanel = new DrawingPanel();
		 instance = CommandFactory.getInstance();
		 instance.invoker = invoker;
		 instance.drawingPanel = drawingPanel;
		 
		 commandField = CommandFactory.class.getDeclaredField("command");
		 commandField.setAccessible(true);
	}

	@Test
	public void testSingleton() {
		assertNotNull(instance);
	}
	
	@Test
	public void testCommandTypes() throws IllegalArgumentException, IllegalAccessException{
		instance.CreateAndDo("new");
		cmd = (Command)commandField.get(instance);
		assertTrue(cmd instanceof NewCommand);
		
		instance.CreateAndDo("addc", new Point(0,0));
		cmd = (Command)commandField.get(instance);
		assertTrue(cmd instanceof AddClassCommand);
		
		instance.CreateAndDo("addr", "null", new Point(0,0), new Point(0,0));
		cmd = (Command)commandField.get(instance);
		assertTrue(cmd instanceof AddRelationCommand);
	}

}
