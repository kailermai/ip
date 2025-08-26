package angus.command;

import angus.exception.AngusException;
import angus.task.TaskList;

public class DeleteCommand extends Commands {
    private final TaskList tasks;
    private final int taskNum;

    public DeleteCommand(TaskList tasks, int taskNum) {
        this.tasks = tasks;
        this.taskNum = taskNum;
    }

    @Override
    public void execute() throws AngusException {
        tasks.deleteTask(taskNum);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
