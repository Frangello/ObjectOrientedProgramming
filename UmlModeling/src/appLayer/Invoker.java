package appLayer;

import java.util.Stack;

public class Invoker {

    private Stack<Command> undoStack = new Stack<Command>();
    private Stack<Command> redoStack = new Stack<Command>(); 
    
    public void setCommand(Command cmd){
    	if (cmd != null){
        	cmd.execute();
        	undoStack.push(cmd);
    	}
    }

	public void redo(){
		if (redoStack.size() <= 0) return;

        Command cmd = redoStack.pop();
        cmd.redo();
        undoStack.push(cmd);
	}

	public void undo(){
		if (undoStack.size() <= 0) return;

        Command cmd = undoStack.pop();
        cmd.undo();
        redoStack.push(cmd);
	}
}
