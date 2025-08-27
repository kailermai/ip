package angus.task;

import angus.exception.AngusException;
import angus.ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> taskList;
    private final Ui ui;

    public TaskList(Ui ui) {
        this.taskList = new ArrayList<>();
        this.ui = ui;
    }

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

    public void addTodo(String todoName) {
        ToDo newTodo = new ToDo(todoName);
        taskList.add(newTodo);
        ui.printAddTodo(newTodo, taskList.size());
    }

    public void addDeadline(String deadlineName, LocalDate endDate) {
        Deadline newDeadline = new Deadline(deadlineName, endDate);
        taskList.add(newDeadline);
        ui.printAddDeadline(newDeadline, taskList.size());
    }

    public void addEvent(String eventName, LocalDate startDate, LocalDate endDate) {
        Event newEvent = new Event(eventName, startDate, endDate);
        taskList.add(newEvent);
        ui.printAddEvent(newEvent, taskList.size());
    }

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

    /**
     * Finds the tasks that has the word filter in its description.
     * @param filter The word to filter the list of tasks.
     * @throws AngusException If the filtered tasks has no tasks.
     */
    public void findTask(String filter) throws AngusException {
        List<Task> filteredTasks = this.taskList.stream()
                .filter(t -> t.getDescription().contains(filter))
                .toList();
        if (filteredTasks.isEmpty()) {
            throw new AngusException("There is no task with the matching keyword!");
        }
        ui.printFilteredTasks(filteredTasks);
    }
}
