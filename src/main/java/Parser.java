import java.util.Arrays;

public class Parser {
    private final Ui ui;
    private final TaskList tasks;

    public Parser(Ui ui, TaskList tasks) {
        this.ui = ui;
        this.tasks = tasks;
    }

    public Commands parse(String fullCommand) throws AngusException {
        String[] commandList = fullCommand.split(" ");
        Commands.CommandList mainCommand = Commands.CommandList.valueOf(commandList[0]);
        int taskNum;
        StringBuilder endDate;
        switch (mainCommand) {
        case bye:
            return new ByeCommand(ui);
            // no break because return prevents fallthrough
        case list:
            return new ListCommand(tasks);
            // no break because return prevents fallthrough
        case mark:
            if (commandList.length != 2) {
                throw new AngusException("Wrong usage of mark!" +
                        Ui.LINE_BREAK +
                        "Usage: mark [task number]");
            }
            // Handles case: mark [non integer]
            try {
                taskNum = Integer.parseInt(commandList[1]) - 1;
            } catch (NumberFormatException e) {
                throw new AngusException("Wrong usage of mark!" +
                        Ui.LINE_BREAK +
                        "Usage: mark [task number]");
            }
            return new MarkCommand(tasks, taskNum);
            // no break because return prevents fallthrough
        case unmark:
            if (commandList.length != 2) {
                throw new AngusException("Wrong usage of unmark!" +
                        Ui.LINE_BREAK +
                        "Usage: unmark [task number]");
            }

            // Handles case: unmark [non integer]
            try {
                taskNum = Integer.parseInt(commandList[1]) - 1;
            } catch (NumberFormatException e) {
                throw new AngusException("Wrong usage of unmark!" +
                        Ui.LINE_BREAK +
                        "Usage: unmark [task number]");
            }
            return new UnmarkCommand(tasks, taskNum);
            // no break because return prevents fallthrough
        case todo:
            StringBuilder todoName = new StringBuilder();
            for (int i = 1; i < commandList.length; i++) {
                todoName.append(" ").append(commandList[i]);
            }
            if (todoName.isEmpty()) {
                throw new AngusException("Description of a ToDo cannot be empty!"+
                        Ui.LINE_BREAK +
                        "Usage: todo [description]");
            }
            return new TodoCommand(tasks, todoName.toString());
            // no break because return prevents fallthrough
        case deadline:
            int j = 1;
            StringBuilder deadlineName = new StringBuilder();
            endDate = new StringBuilder();
            while (j < commandList.length && !commandList[j].equals("/by")) {
                deadlineName.append(" ").append(commandList[j]);
                j++;
            }

            j++;

            while (j < commandList.length) {
                endDate.append(" ").append(commandList[j]);
                j++;
            }

            if (deadlineName.isEmpty()) {
                throw new AngusException("Deadline description cannot be empty!" +
                        Ui.LINE_BREAK +
                        "Usage: deadline [description] /by [due date]");
            } else if (endDate.isEmpty()) {
                throw new AngusException("Deadline due date cannot be empty!" +
                        Ui.LINE_BREAK +
                        "Usage: deadline [description] /by [due date/time]");
            }
            return new DeadlineCommand(tasks, deadlineName.toString(), endDate.toString());
            // no break because return prevents fallthrough
        case event:
            int i = 1;
            StringBuilder eventName = new StringBuilder();
            StringBuilder startDate = new StringBuilder();
            endDate = new StringBuilder();
            while (i < commandList.length && !commandList[i].equals("/from")) {
                eventName.append(" ").append(commandList[i]);
                i++;
            }

            i++;

            while (i < commandList.length && !commandList[i].equals("/to")){
                startDate.append(" ").append(commandList[i]);
                i++;
            }

            i++;

            while (i < commandList.length) {
                endDate.append(" ").append(commandList[i]);
                i++;
            }

            if (eventName.isEmpty()) {
                throw new AngusException("Event description cannot be empty!" +
                        Ui.LINE_BREAK +
                        "Usage: event [description] /from [start date/time] /to [end date/time]");
            } else if (startDate.isEmpty()) {
                throw new AngusException("Event start date cannot be empty!" +
                        Ui.LINE_BREAK +
                        "Usage: event [description] /from [start date/time] /to [end date/time]");
            } else if (endDate.isEmpty()) {
                throw new AngusException("Event end date cannot be empty!" +
                        Ui.LINE_BREAK +
                        "Usage: event [description] /from [start date/time] /to [end date/time]");
            }
            return new EventCommand(tasks, eventName.toString(), startDate.toString(), endDate.toString());
            // no break because return prevents fallthrough
        case delete:
            if (commandList.length != 2) {
                throw new AngusException("Wrong usage of delete!" +
                        Ui.LINE_BREAK +
                        "Usage: delete [task number]");
            }

            // Handles case: delete [non integer]
            try {
                taskNum = Integer.parseInt(commandList[1]) - 1;
            } catch (NumberFormatException e) {
                throw new AngusException("Wrong usage of delete!" +
                        Ui.LINE_BREAK +
                        "Usage: delete [task number]");
            }
            return new DeleteCommand(tasks, taskNum);
            // no break because return prevents fallthrough
        default:
            throw new IllegalArgumentException();
        }
    }
}
