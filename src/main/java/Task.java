public abstract class Task {
    protected final String description;
    private boolean isDone;

    enum TaskTypes {
        E,
        T,
        D,
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }
    public abstract String saveTask();

    public boolean markDone() {
        if (this.isDone) {
            return false;
        } else {
            this.isDone = true;
            return true;
        }
    }

    public boolean markNotDone() {
        if (!this.isDone) {
            return false;
        } else {
            this.isDone = false;
            return true;
        }
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    public String getCompleteStatus() {
        return (isDone ? "1" : "0");
    }

    @Override
    public String toString() {
        return this.getStatusIcon() + " " + this.description;
    }
}
