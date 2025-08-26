package angus.command;

import angus.exception.AngusException;
import angus.storage.Storage;
import angus.task.TaskList;
import angus.ui.Ui;

public class ByeCommand extends Commands {
    private final Ui ui;
    private final Storage storage;
    private final TaskList tasks;

    public ByeCommand(Ui ui, Storage storage, TaskList tasks) {
        this.ui = ui;
        this.storage = storage;
        this.tasks = tasks;
    }

    @Override
    public void execute() throws AngusException {
        storage.save(tasks);
        ui.printGoodbyeMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
