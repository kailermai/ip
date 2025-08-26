import java.util.ArrayList;
import java.util.List;
import static java.lang.Character.LINE_SEPARATOR;

public class TaskList {
    private final List<Task> taskList;
    private final Ui ui;

    public TaskList(Ui ui) {
        this.taskList = new ArrayList<>();
        this.ui = ui;
    }

    public void getTaskList() throws AngusException {
        if (taskList.isEmpty()) {
            throw new AngusException("Your task list is empty!");
        }
        ui.displayTaskList(this.taskList);
    }

    public void markTask(int taskNum) throws AngusException {
        if (taskNum >= taskList.toArray().length) {
            throw new AngusException("Task does not exist!" +
                    LINE_SEPARATOR +
                    "Usage: mark [task number]");
        }
        Task curTask = taskList.get(taskNum);
        boolean result = curTask.markDone();
        ui.displayMarkTask(result, curTask);
    }
}
