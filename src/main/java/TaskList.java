import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> taskList;
    private final Ui ui;
    public static int count = 0;

    public TaskList(Ui ui) {
        this.taskList = new ArrayList<>();
        this.ui = ui;
    }

    public TaskList(Ui ui, List<Task> taskList) {
        this.taskList = taskList;
        this.ui = ui;
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
        TaskList.count++;
        ui.printAddTodo(newTodo, TaskList.count);
    }

    public void addDeadline(String deadlineName, String endDate) {
        Deadline newDeadline = new Deadline(deadlineName, endDate);
        taskList.add(newDeadline);
        TaskList.count++;
        ui.printAddDeadline(newDeadline, TaskList.count);
    }

    public void addEvent(String eventName, String startDate, String endDate) {
        Event newEvent = new Event(eventName, startDate, endDate);
        taskList.add(newEvent);
        TaskList.count++;
        ui.printAddEvent(newEvent, TaskList.count);
    }

    public void deleteTask(int taskNum) throws AngusException {
        if (taskNum >= TaskList.count) {
            throw new AngusException("Task does not exist!" +
                    Ui.LINE_BREAK +
                    "Usage: delete [task number]");
        }
        Task removedTask = taskList.get(taskNum);
        TaskList.count--;
        taskList.remove(taskNum);
        ui.printDeleteTask(removedTask, TaskList.count);
    }
}
