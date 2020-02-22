package commands;

import java.util.Stack;

public class CommandManager {
    private Stack<Command> commandUndo = new Stack<Command>();
    private Stack<Command> commandRedo = new Stack<Command>(); //stack pt comenzile undoite, pt redo.
    // TODO
    /* - void undo()
       - void redo()
       - void executeCommand(Command c)
       - maybe check if undo() and redo() are available ?
             -> check GameState class, see the errors
       - keep track of the commands somehow
    */

    public boolean isUndoAvailable() {
        return !commandUndo.isEmpty();
    }

    public boolean isRedoAvailable() {
        return !commandRedo.isEmpty();
    }

    public void executeCommand(Command c) {
        commandUndo.push(c);
        commandRedo.clear();
        c.execute();
    }

    public void undo() {
        if(!commandUndo.isEmpty()) {
            commandUndo.peek().undo();
            commandRedo.push(commandUndo.pop());
        }
    }

    public void redo() {
        if(!commandRedo.isEmpty()) {
            commandRedo.peek().execute();
            commandUndo.push(commandRedo.pop());
        }
    }


}
