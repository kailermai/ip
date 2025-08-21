import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Angus {
    private final static String HORIZONTAL_LINE =
            "____________________________________________________________";
    private final static String LINE_SEPARATOR = "\n\t";

    public static String angusResponse(String text) {
        return "\t" + HORIZONTAL_LINE + LINE_SEPARATOR + text + LINE_SEPARATOR + HORIZONTAL_LINE;
    }

    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        String greetingsText = "Hello! I'm Angus o_O" +
                LINE_SEPARATOR +
                "What can I do for you today?";
        String greetings = angusResponse(greetingsText);

        String goodbyeText = "Goodbye. Hope to see you again soon!";
        String goodbye = angusResponse(goodbyeText);

        Scanner input = new Scanner(System.in);
        System.out.println(greetings);
        boolean running = true;
        String command;

        while (running) {
            command = input.nextLine();
            String[] commandList = command.split(" ");
            String mainCommand = commandList[0];
            String message;
            int taskNum;
            Task curTask;
            boolean result;
            StringBuilder endDate;

            switch (mainCommand) {
                case "bye":
                    running = false;
                    break;
                case "list":
                    StringBuilder list = new StringBuilder();
                    list.append("Here are your tasks:\n\t");
                    for (int i  = 0; i < taskList.size(); i++) {
                        curTask = taskList.get(i);
                        list.append(i + 1);
                        list.append(".");
                        list.append(curTask);
                        if (i < taskList.size() - 1){
                            list.append(LINE_SEPARATOR); // prevent empty line at the end
                        }
                    }
                    System.out.println(angusResponse(list.toString()));
                    break;
                case "mark":
                    taskNum = Integer.parseInt(commandList[1]) - 1;
                    curTask = taskList.get(taskNum);
                    result = curTask.markDone();
                    if (result) {
                        message = "Angus has marked this task as done!"
                                + LINE_SEPARATOR
                                + "\t" + curTask;
                    } else {
                        message = "This task is already marked as done!"
                                + LINE_SEPARATOR
                                + "\t" + curTask;
                    }
                    System.out.println(angusResponse(message));
                    break;
                case "unmark":
                    taskNum = Integer.parseInt(commandList[1]) - 1;
                    curTask = taskList.get(taskNum);
                    result = curTask.markNotDone();
                    if (result) {
                        message = "Angus has marked this task as NOT done!"
                                + LINE_SEPARATOR
                                + "\t" + curTask;
                    } else {
                        message = "This task is already marked as NOT done!"
                                + LINE_SEPARATOR
                                + "\t" + curTask;
                    }
                    System.out.println(angusResponse(message));
                    break;
                case "todo":
                    StringBuilder todoName = new StringBuilder();
                    for (int i = 1; i < commandList.length; i++) {
                        todoName.append(" ").append(commandList[i]);
                    }
                    ToDo newTodo = new ToDo(todoName.toString());
                    taskList.add(newTodo);
                    message = angusResponse("Angus has added this task:"
                            + LINE_SEPARATOR
                            + "\t" + newTodo
                            + LINE_SEPARATOR
                            + "You now have " + taskList.toArray().length + " tasks in the list");
                    System.out.println(message);
                    break;
                case "deadline":
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
                    Deadline newDeadline = new Deadline(deadlineName.toString(), endDate.toString());
                    taskList.add(newDeadline);
                    message = angusResponse("Angus has added this deadline:"
                            + LINE_SEPARATOR
                            + "\t" + newDeadline
                            + LINE_SEPARATOR
                            + "You now have " + taskList.toArray().length + " tasks in the list");
                    System.out.println(message);
                    break;
                case "event":
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
                    Event newEvent = new Event(eventName.toString(), startDate.toString(),
                        endDate.toString());
                    taskList.add(newEvent);
                    message = angusResponse("Angus has added this event:"
                            + LINE_SEPARATOR
                            + "\t" + newEvent
                            + LINE_SEPARATOR
                            + "You now have " + taskList.toArray().length + " tasks in the list");
                    System.out.println(message);
                    break;
                default:
                    message = angusResponse("[ERROR] Angus does not know what that means :<");
                    System.out.println(message);
                    break;
            }
        }
        System.out.println(goodbye);
    }
}
