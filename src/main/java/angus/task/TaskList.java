package angus.task;

import angus.exception.AngusException;
import angus.ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks and provides operations to manage tasks.
 * <p>
 * This class provides operations on tasks such as adding, deleting, marking and unmarking tasks.
 */
public class TaskList {
    private final List<Task> taskList;
    private final Ui ui;

    /**
     * Creates an empty TaskList.
     * @param ui The user interface to interact with the user.
     */
    public TaskList(Ui ui) {
        this.taskList = new ArrayList<>();
        this.ui = ui;
    }

    /**
     * Created a TaskList with an existing list of tasks.
     * @param ui The user interface to interact with the user.
     * @param taskList The provided list of existing tasks to initialize with.
     */
    public TaskList(Ui ui, List<Task> taskList) {
        this.taskList = taskList;
        this.ui = ui;
    }

    public Task getTask(int taskNum) {
        return taskList.get(taskNum);
    }

    public int getSize() {
        return taskList.size();
    }

    public void getTaskList() throws AngusException {
        if (taskList.isEmpty()) {
            throw new AngusException("Your task list is empty!");
        }
        ui.printTaskList(this.taskList);
    }

    /**
     * Marks a task as done.
     * @param taskNum Index of the task (0-th index).
     * @throws AngusException If the task index is invalid.
     */
    public void markTask(int taskNum) throws AngusException {
        if (taskNum >= taskList.toArray().length) {
            throw new AngusException("Task does not exist!" +
                    Ui.LINE_BREAK +
                    "Usage: mark [task number]");
        }
        Task curTask = taskList.get(taskNum);
        boolean result = curTask.markDone();
        ui.printMarkTask(result, curTask);
    }

    /**
     * Marks a task as not complete (unmarks a task).
     * @param taskNum Index of the task(0-th index)
     * @throws AngusException If the task index is invalid.
     */
    public void unmarkTask(int taskNum) throws AngusException {
        if (taskNum >= taskList.toArray().length) {
            throw new AngusException("Task does not exist!" +
                    Ui.LINE_BREAK +
                    "Usage: unmark [task number]");
        }
        Task curTask = taskList.get(taskNum);
        boolean result = curTask.markNotDone();
        ui.printUnmarkTask(result, curTask);
    }

    /**
     * Adds a new ToDo task to the list.
     * @param todoName The name of the ToDo.
     */
    public void addTodo(String todoName) {
        ToDo newTodo = new ToDo(todoName);
        taskList.add(newTodo);
        ui.printAddTodo(newTodo, taskList.size());
    }

    /**
     * Adds a new Deadline to the list.
     * @param deadlineName The name of the deadline.
     * @param endDate The deadline's end date.
     */
    public void addDeadline(String deadlineName, LocalDate endDate) {
        Deadline newDeadline = new Deadline(deadlineName, endDate);
        taskList.add(newDeadline);
        ui.printAddDeadline(newDeadline, taskList.size());
    }

    /**
     * Adds a new Event to the list.
     * @param eventName The name of the event.
     * @param startDate The start date of the event.
     * @param endDate The end date of the event.
     */
    public void addEvent(String eventName, LocalDate startDate, LocalDate endDate) {
        Event newEvent = new Event(eventName, startDate, endDate);
        taskList.add(newEvent);
        ui.printAddEvent(newEvent, taskList.size());
    }

    /**
     * Deletes an event from the list.
     * @param taskNum Index of the task to be deleted (0-th index)
     * @throws AngusException If the task index does not exist.
     */
    public void deleteTask(int taskNum) throws AngusException {
        if (taskNum >= taskList.size()) {
            throw new AngusException("Task does not exist!" +
                    Ui.LINE_BREAK +
                    "Usage: delete [task number]");
        }
        Task removedTask = taskList.get(taskNum);
        taskList.remove(taskNum);
        ui.printDeleteTask(removedTask, taskList.size());
    }
}
