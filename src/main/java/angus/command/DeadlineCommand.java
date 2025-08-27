package angus.command;

import java.time.LocalDate;

import angus.exception.AngusException;
import angus.task.TaskList;

public class DeadlineCommand extends Commands {
    private final TaskList tasks;
    private final String deadlineName;
    private final LocalDate endDate;

    public DeadlineCommand(TaskList tasks, String deadlineName, LocalDate endDate) {
        this.tasks = tasks;
        this.deadlineName = deadlineName;
        this.endDate = endDate;
    }

    @Override
    public void execute() throws AngusException {
        tasks.addDeadline(deadlineName, endDate);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
