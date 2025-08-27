package angus.task;

import angus.ui.Parser;

import java.time.LocalDate;

/**
 * Represents a task with a start and end date.
 * <p>
 * An event stores a description and a start and end date to the task.
 */
public class Event extends Task {
    LocalDate startDate, endDate;

    /**
     * Constructs a new event task.
     * @param description The description of the new event task.
     * @param startDate The start date of the new event task.
     * @param endDate The end date of the new event task.
     */
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
