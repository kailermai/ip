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

    public abstract void execute();
    public abstract boolean isExit();
}
