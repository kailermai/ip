package angus.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import angus.command.Commands;
import angus.task.Deadline;
import angus.task.Event;
import angus.task.Task;
import angus.task.ToDo;

public class Ui {
    public static final String LINE_BREAK = "\n\t";
    private static final String HORIZONTAL_LINE =
            "____________________________________________________________";
    private final Scanner input;

    public Ui() {
        this.input = new Scanner(System.in);
    }

    public String readCommand() {
        return input.nextLine();
    }

    public static String angusResponse(String text) {
        return "\t" + HORIZONTAL_LINE + LINE_BREAK + text + LINE_BREAK + HORIZONTAL_LINE;
    }

    public void printGreetingsMessage() {
        String greetingsText = "Hello! I'm Angus o_O" +
                LINE_BREAK +
                "What can I do for you today?";
        System.out.println(angusResponse(greetingsText));
    }

    public void printGoodbyeMessage() {
        String goodbyeText = "Goodbye. Hope to see you again soon!";
        System.out.println(angusResponse(goodbyeText));
    }

    public void printUnknownCommand() {
        String message = "Angus does not know what that means :<" +
                LINE_BREAK +
                "Try any of the following commands:" +
                LINE_BREAK +
                Arrays.asList(Commands.CommandList.values());
        System.out.println(angusResponse(message));
    }

    public void printError(String errorMessage) {
        String message = angusResponse("[ERROR] " + errorMessage);
        System.out.println(message);
    }

    public void printTaskList(List<Task> taskList) {
        Task curTask;
        StringBuilder list = new StringBuilder();
        list.append("Here are your tasks:\n\t");
        for (int i  = 0; i < taskList.size(); i++) {
            curTask = taskList.get(i);
            list.append(i + 1);
            list.append(".");
            list.append(curTask);
            if (i < taskList.size() - 1){
                list.append(LINE_BREAK); // prevent empty line at the end
            }
        }
        System.out.println(angusResponse(list.toString()));
    }

    public void printMarkTask(boolean result, Task curTask) {
        String message;
        if (result) {
            message = "Angus has marked this task as done!"
                    + LINE_BREAK
                    + "\t" + curTask;
        } else {
            message = "This task is already marked as done!"
                    + LINE_BREAK
                    + "\t" + curTask;
        }
        System.out.println(angusResponse(message));
    }

    public void printUnmarkTask(boolean result, Task curTask) {
        String message;
        if (result) {
            message = "Angus has marked this task as NOT done!"
                    + LINE_BREAK
                    + "\t" + curTask;
        } else {
            message = "This task is already marked as NOT done!"
                    + LINE_BREAK
                    + "\t" + curTask;
        }
        System.out.println(angusResponse(message));
    }

    public void printAddTodo(ToDo newTodo, int count) {
        String message = angusResponse("Angus has added this task:" +
                LINE_BREAK +
                "\t" + newTodo +
                LINE_BREAK +
                "You now have " + count + " tasks in the list");
        System.out.println(message);
    }

    public void printAddDeadline(Deadline newDeadline, int count) {
        String message = angusResponse("Angus has added this deadline:" +
                LINE_BREAK +
                "\t" + newDeadline +
                LINE_BREAK +
                "You now have " + count + " tasks in the list");
        System.out.println(message);
    }

    public void printAddEvent(Event newEvent, int count) {
        String message = angusResponse("Angus has added this event:" +
                LINE_BREAK +
                "\t" + newEvent +
                LINE_BREAK +
                "You now have " + count + " tasks in the list");
        System.out.println(message);
    }

    public void printDeleteTask(Task removedTask, int count) {
        String message = "All done! Angus has removed this task:" +
                LINE_BREAK +
                "\t" + removedTask +
                LINE_BREAK +
                "You now have " + count + " tasks in the list";

        System.out.println(angusResponse(message));
    }

    /**
     *
     */
    public void printFilteredTasks(List<Task> tasks) {

    }
}
