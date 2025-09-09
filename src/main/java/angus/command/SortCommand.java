package angus.command;

import angus.exception.AngusException;
import angus.task.TaskList;

/**
 * Represents the command to print the sorted version of the list of tasks
 * <p>
 * This class is responsible for calling the getSortedList() method in the taskList class
 * which prints the sorted list of tasks
 */
public class SortCommand extends Commands {
    private final TaskList tasks;

    /**
     * Constructs an instance of the SortCommand class with a list of tasks
     * @param tasks The current list of tasks the user has
     */
    public SortCommand(TaskList tasks) {
        this.tasks = tasks;
    }

    @Override
    public String execute() throws AngusException {
        return tasks.getSortedList();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
