public class Task {
    protected final String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean markDone() {
        this.isDone = !this.isDone;
        return this.isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }
}
