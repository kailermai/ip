public class Task {
    private final String taskName;
    private boolean isDone;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public boolean markDone() {
        this.isDone = !this.isDone;
        return this.isDone;
    }
}
