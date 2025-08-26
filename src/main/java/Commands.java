public abstract class Commands {
    enum CommandList {
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
