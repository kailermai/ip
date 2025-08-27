package angus.task;

import angus.ui.Parser;

import java.time.LocalDate;

/**
 * Represents a task with a deadline.
 * <p>
 * A deadline stores a description and an end date to the task.
 */
public class Deadline extends Task {
    LocalDate endDate;

    /**
     * Constructs a new Deadline task.
     * @param description The description of the new deadline task.
     * @param endDate The end date of the new deadline task.
     */
    public Deadline(String description, LocalDate endDate) {
        super(description);
        this.endDate = endDate;
    }

    @Override
    public String saveTask() {
        return "D//" + super.getCompleteStatus() + "//" + super.description + "//" + this.endDate;
    }

    @Override
    public String toString() {
        String reformattedDateTime = endDate.format(Parser.FORMATTER_TO);
        return "[D]" + super.toString() + " (by: " + reformattedDateTime + ")";
    }
}
