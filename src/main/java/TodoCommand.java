public class TodoCommand extends Commands {
    private final TaskList tasks;
    private final String todoName;

    public TodoCommand(TaskList tasks, String todoName) {
        this.tasks = tasks;
        this.todoName = todoName;
    }

    @Override
    public void execute() throws AngusException {
        tasks.addTodo(todoName);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
