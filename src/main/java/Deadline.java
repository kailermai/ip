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
    public String getStatusIcon() {
        return "[D]" + super.getStatusIcon();
    }

    @Override
    public String toString() {
        String reformattedDateTime = endDate.format(Parser.FORMATTER_TO);
        return super.toString() + " (by: " + reformattedDateTime + ")";
    }
}
