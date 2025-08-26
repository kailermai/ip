package angus.task;

import angus.ui.Parser;

import java.time.LocalDate;

public class Event extends Task {
    LocalDate startDate, endDate;

    public Event(String description, LocalDate startDate, LocalDate endDate) {
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
        String reformattedStartDate = startDate.format(Parser.FORMATTER_TO);
        String reformattedEndDate = endDate.format(Parser.FORMATTER_TO);
        return super.toString() + " (from: " + reformattedStartDate + " to: " + reformattedEndDate + ")";
    }
}
