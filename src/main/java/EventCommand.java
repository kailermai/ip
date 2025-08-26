import java.time.LocalDate;

public class EventCommand extends Commands {
    private final TaskList tasks;
    private final String eventName;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public EventCommand(TaskList tasks, String eventName, LocalDate startDate, LocalDate endDate) {
        this.tasks = tasks;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public void execute() throws AngusException {
        tasks.addEvent(eventName, startDate, endDate);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
