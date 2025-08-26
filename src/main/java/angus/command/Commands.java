package angus.command;

import angus.exception.AngusException;

public abstract class Commands {
    public enum CommandList {
        bye,
        mark,
        unmark,
        list,
        todo,
        deadline,
        event,
        delete
    }

    public abstract void execute() throws AngusException;
    public abstract boolean isExit();
}
