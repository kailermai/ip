package angus.command;

import angus.exception.AngusException;
import angus.task.TaskList;

public class ListCommand extends Commands {
    private final TaskList tasks;

    public ListCommand(TaskList tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute() throws AngusException {
        tasks.getTaskList();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
