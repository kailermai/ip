import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public List<Task> getTaskList() throws AngusException {
        if (taskList.isEmpty()) {
            throw new AngusException("Your task list is empty!");
        }
        return taskList;
    }
}
