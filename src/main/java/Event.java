public class Event extends Task {
    String deadline;

    public Event(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String getStatusIcon() {
        return "[E]" + super.getStatusIcon();
    }

    @Override
    public String toString() {
        return super.toString() + this.deadline;
    }
}
