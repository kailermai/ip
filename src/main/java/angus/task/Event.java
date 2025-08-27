package angus.task;

import java.time.LocalDate;

import angus.ui.Parser;

public class Event extends Task {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Event(String description, LocalDate startDate, LocalDate endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String saveTask() {
        return "E//" + super.getCompleteStatus() + "//"
                + super.description + "//" + this.startDate + "//" + this.endDate;
    }

    @Override
    public String toString() {
        String reformattedStartDate = startDate.format(Parser.FORMATTER_TO);
        String reformattedEndDate = endDate.format(Parser.FORMATTER_TO);
        return "[E]" + super.toString() + " (from: " + reformattedStartDate + " to: " + reformattedEndDate
                + ")";
    }
}
