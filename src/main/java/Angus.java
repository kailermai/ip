import java.util.Arrays;
import java.util.Scanner;

public class Angus {
    private final Ui ui;
    private final TaskList tasks;

    public Angus() {
        this.ui = new Ui();
        this.tasks = new TaskList(ui);
    }

    private final static String HORIZONTAL_LINE =
            "____________________________________________________________";
    private final static String LINE_SEPARATOR = "\n\t";

    public static String angusResponse(String text) {
        return "\t" + HORIZONTAL_LINE + LINE_SEPARATOR + text + LINE_SEPARATOR + HORIZONTAL_LINE;
    }

    enum Commands {
        bye,
        mark,
        unmark,
        list,
        todo,
        deadline,
        event,
        delete
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        String command;
        ui.greetingsMessage();

        while (running) {
            command = input.nextLine();
            String[] commandList = command.split(" ");
            String message;
            int taskNum;
            StringBuilder endDate;

            try {
                Commands mainCommand = Commands.valueOf(commandList[0]);
                switch (mainCommand) {
                case bye:
                    running = false;
                    break;
                case list:
                    tasks.getTaskList();
                    break;
                case mark:
                    if (commandList.length != 2) {
                        throw new AngusException("Wrong usage of mark!" +
                                LINE_SEPARATOR +
                                "Usage: mark [task number]");
                    }

                    // Handles case: mark [non integer]
                    try {
                        taskNum = Integer.parseInt(commandList[1]) - 1;
                    } catch (NumberFormatException e) {
                        throw new AngusException("Wrong usage of mark!" +
                                LINE_SEPARATOR +
                                "Usage: mark [task number]");
                    }
                    tasks.markTask(taskNum);
                    break;
                case unmark:
                    if (commandList.length != 2) {
                        throw new AngusException("Wrong usage of unmark!" +
                                LINE_SEPARATOR +
                                "Usage: unmark [task number]");
                    }

                    // Handles case: unmark [non integer]
                    try {
                        taskNum = Integer.parseInt(commandList[1]) - 1;
                    } catch (NumberFormatException e) {
                        throw new AngusException("Wrong usage of unmark!" +
                                LINE_SEPARATOR +
                                "Usage: unmark [task number]");
                    }
                    tasks.unmarkTask(taskNum);
                    break;
                case todo:
                    StringBuilder todoName = new StringBuilder();
                    for (int i = 1; i < commandList.length; i++) {
                        todoName.append(" ").append(commandList[i]);
                    }
                    if (todoName.isEmpty()) {
                        throw new AngusException("Description of a ToDo cannot be empty!"+
                                LINE_SEPARATOR +
                                "Usage: todo [description]");
                    }
                    tasks.addTodo(todoName.toString());
                    break;
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
                                LINE_SEPARATOR +
                                "Usage: deadline [description] /by [due date]");
                    } else if (endDate.isEmpty()) {
                        throw new AngusException("Deadline due date cannot be empty!" +
                                LINE_SEPARATOR +
                                "Usage: deadline [description] /by [due date/time]");
                    }
                    tasks.addDeadline(deadlineName.toString(), endDate.toString());
                    break;
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
                                LINE_SEPARATOR +
                                "Usage: event [description] /from [start date/time] /to [end date/time]");
                    } else if (startDate.isEmpty()) {
                        throw new AngusException("Event start date cannot be empty!" +
                                LINE_SEPARATOR +
                                "Usage: event [description] /from [start date/time] /to [end date/time]");
                    } else if (endDate.isEmpty()) {
                        throw new AngusException("Event end date cannot be empty!" +
                                LINE_SEPARATOR +
                                "Usage: event [description] /from [start date/time] /to [end date/time]");
                    }
                    tasks.addEvent(eventName.toString(), startDate.toString(), endDate.toString());
                    break;
                case delete:
                    if (commandList.length != 2) {
                        throw new AngusException("Wrong usage of delete!" +
                                LINE_SEPARATOR +
                                "Usage: delete [task number]");
                    }

                    // Handles case: delete [non integer]
                    try {
                        taskNum = Integer.parseInt(commandList[1]) - 1;
                    } catch (NumberFormatException e) {
                        throw new AngusException("Wrong usage of delete!" +
                                LINE_SEPARATOR +
                                "Usage: delete [task number]");
                    }
                    tasks.deleteTask(taskNum);
                    break;
                }
            } catch (IllegalArgumentException e) {
                message = "Angus does not know what that means :<" +
                        LINE_SEPARATOR +
                        "Try any of the following commands:" +
                        LINE_SEPARATOR +
                        Arrays.asList(Commands.values());
                System.out.println(angusResponse(message));
            }
            catch (AngusException e) {
                message = angusResponse("[ERROR] " + e.getMessage());
                System.out.println(message);
            }
        }
        ui.goodbyeMessage();
    }

    public static void main(String[] args) {
        new Angus().run();
    }
}
