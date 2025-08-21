public class Deadline extends Task {
    String endDate;

    public Deadline(String description, String endDate) {
        super(description);
        this.endDate = endDate;
    }

    @Override
    public String getStatusIcon() {
        return "[D]" + super.getStatusIcon();
    }

    @Override
    public String toString() {
        return super.toString() + " (by:" + this.endDate + ")";
    }
}
