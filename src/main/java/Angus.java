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

            try {
                switch (mainCommand) {
                    case "bye":
                        running = false;
                        break;
                    case "list":
                        if (taskList.isEmpty()) {
                            throw new AngusException("Your task list is empty!");
                        }
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
                        if (todoName.isEmpty()) {
                            throw new AngusException("Description of a ToDo cannot be empty!"+
                                    LINE_SEPARATOR +
                                    "Usage: todo [description]");
                        }
                        ToDo newTodo = new ToDo(todoName.toString());
                        taskList.add(newTodo);
                        message = angusResponse("Angus has added this task:" +
                                LINE_SEPARATOR +
                                "\t" + newTodo +
                                LINE_SEPARATOR +
                                "You now have " + taskList.toArray().length + " tasks in the list");
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

                        if (deadlineName.isEmpty()) {
                            throw new AngusException("Deadline description cannot be empty!" +
                                    LINE_SEPARATOR +
                                    "Usage: deadline [description] /by [due date]");
                        } else if (endDate.isEmpty()) {
                            throw new AngusException("Deadline due date cannot be empty!" +
                                    LINE_SEPARATOR +
                                    "Usage: deadline [description] /by [due date/time]");
                        }

                        Deadline newDeadline = new Deadline(deadlineName.toString(), endDate.toString());
                        taskList.add(newDeadline);
                        message = angusResponse("Angus has added this deadline:" +
                                LINE_SEPARATOR +
                                "\t" + newDeadline +
                                LINE_SEPARATOR +
                                "You now have " + taskList.toArray().length + " tasks in the list");
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

                        Event newEvent = new Event(eventName.toString(), startDate.toString(),
                            endDate.toString());
                        taskList.add(newEvent);
                        message = angusResponse("Angus has added this event:" +
                                LINE_SEPARATOR +
                                "\t" + newEvent +
                                LINE_SEPARATOR +
                                "You now have " + taskList.toArray().length + " tasks in the list");
                        System.out.println(message);
                        break;
                    default:
                        throw new AngusException("Angus does not know what that means :<" +
                                LINE_SEPARATOR +
                                "Try any of the following commands:" +
                                LINE_SEPARATOR +
                                "list" +
                                LINE_SEPARATOR +
                                "todo"+
                                LINE_SEPARATOR +
                                "deadline"+
                                LINE_SEPARATOR +
                                "event");
                }
            } catch (AngusException e) {
                message = angusResponse("[ERROR] " + e.getMessage());
                System.out.println(message);
            }
        }
        System.out.println(goodbye);
    }
}
