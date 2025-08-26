public class EventCommand extends Commands {
    private final TaskList tasks;
    private final String eventName;
    private final String startDate;
    private final String endDate;

    public EventCommand(TaskList tasks, String eventName, String startDate, String endDate) {
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
