package appLayer;

import appLayer.Drawing.DrawingPanel;

public class CommandFactory {
	private static CommandFactory instance = null;
	public Invoker invoker; 
	public DrawingPanel drawingPanel;
	private Command command;
	
	private CommandFactory(){
		
	}
	
	public static CommandFactory getInstance(){
		if(instance == null){
			instance = new CommandFactory();
		}
		return instance; 
	}
	
	
	public void CreateAndDo(String commandType,  Object...commandParameters){
		command = null;
		
		///     For new, no parameters
        ///     For addc, 
        ///         [0]:  Point     center location for the class
        ///     For addr, 
        ///         [0]: String      type of the relationship
        ///         [1]: Point      center location for starting point
        ///         [2]: Point      center location for ending point
        ///     For load,
        ///         [0]: string     filename of file to load from  
        ///     For save,
        ///         [0]: string     filename of file to save to  
		
        switch (commandType.trim().toUpperCase())
        {
            case "NEW":
                command = new NewCommand();
                break;
            case "ADDC":
                command = new AddClassCommand(commandParameters);
                break;
            case "ADDR":
                command = new AddRelationCommand(commandParameters);
                break;
            case "LOAD":
                command = new LoadCommand(commandParameters);
                break;
            case "SAVE":
                command = new SaveCommand(commandParameters);
                break;
            default:
            	break;
        }
        if (command != null)
        {
        	command.setDrawingPanel(drawingPanel);
            invoker.setCommand(command);
        }
	}

}
