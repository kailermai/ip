package angus.task;

import angus.ui.Parser;

import java.time.LocalDate;

public class Deadline extends Task {
    LocalDate endDate;

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
