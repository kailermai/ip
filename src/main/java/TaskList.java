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

    public void addDeadline(String deadlineName, String endDate) {
        Deadline newDeadline = new Deadline(deadlineName, endDate);
        taskList.add(newDeadline);
        ui.printAddDeadline(newDeadline, taskList.size());
    }

    public void addEvent(String eventName, String startDate, String endDate) {
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
}
