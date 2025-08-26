public class Event extends Task {
    String startDate, endDate;

    public Event(String description, String startDate, String endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String saveTask() {
        return "E//" + super.getCompleteStatus() + "//" +
                super.description + "//" + this.startDate + "//" + this.endDate;
    }

    @Override
    public String getStatusIcon() {
        return "[E]" + super.getStatusIcon();
    }

    @Override
    public String toString() {
        return super.toString() + " (from:" + this.startDate + " to:" + this.endDate + ")";
    }
}
