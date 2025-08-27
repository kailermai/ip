package angus.command;

import angus.exception.AngusException;

/**
 * Represents the abstract base class for all commands.
 * <p>
 * Each commands encapsulate an action that the command will execute when called, as well
 * as whether the command is an exit command which will break out of the program loop.
 */
public abstract class Commands {
    /**
     * Represents the enumeration of all available commands known by Angus.
     */
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
