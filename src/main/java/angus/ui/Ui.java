package angus.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import angus.command.Commands;
import angus.task.Deadline;
import angus.task.Event;
import angus.task.Task;
import angus.task.ToDo;

/**
 * Handles interaction with the user through printing to the console and returning to GUI.
 * Handles interaction with the user through printing to the console and returning to GUI.
 */
public class Ui {
    public static final String LINE_BREAK = "\n";
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

    /**
     * Prints and returns the greeting message.
     */
    public String printGreetingsMessage() {
        String greetingsText = "Hello! I'm Angus o_O"
                + LINE_BREAK
                + "What can I do for you today?";
        System.out.println(angusResponse(greetingsText));
        return greetingsText;
    }

    /**
     * Prints and returns the goodbye message.
     */
    public String printGoodbyeMessage() {
        String goodbyeText = "Goodbye. Hope to see you again soon!";
        System.out.println(angusResponse(goodbyeText));
        return goodbyeText;
    }

    /**
     * Prints and returns the list of commands available to Angus when an unknown command is received.
     */
    public String printUnknownCommand() {
        String message = "Angus does not know what that means :<"
                + LINE_BREAK
                + "Try any of the following commands:"
                + LINE_BREAK
                + Arrays.asList(Commands.CommandList.values());
        System.out.println(angusResponse(message));
        return message;
    }

    /**
     * Prints and returns the error message.
     * @param errorMessage The error message received when an exception is thrown.
     */
    public String printError(String errorMessage) {
        String message = "[ERROR] " + errorMessage;
        System.out.println(message);
        return message;
    }

    /**
     * Prints and returns the current list of tasks the user has.
     * <p>
     * This method is implemented using a StringBuilder for efficient string concatenation.
     * @param taskList The current list of tasks the user has.
     */
    public String printTaskList(List<Task> taskList) {
        Task curTask;
        StringBuilder list = new StringBuilder();
        list.append("Here are your tasks:\n");
        for (int i = 0; i < taskList.size(); i++) {
            curTask = taskList.get(i);
            list.append(i + 1);
            list.append(".");
            list.append(curTask);
            if (i < taskList.size() - 1) {
                list.append(LINE_BREAK); // prevent empty line at the end
            }
        }
        System.out.println(angusResponse(list.toString()));
        return list.toString();
    }

    /**
     * Prints and returns the result of marking a task.
     * @param result True if marking a task is successful, otherwise False.
     * @param curTask The task that is to be marked.
     */
    public String printMarkTask(boolean result, Task curTask) {
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
        return message;
    }

    /**
     * Prints and returns the result of unmarking a task.
     * @param result True if unmarking a task is successful, otherwise False.
     * @param curTask The task that is to be unmarked.
     */
    public String printUnmarkTask(boolean result, Task curTask) {
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
        return message;
    }

    /**
     * Prints and returns the result of adding a ToDo task to the list.
     * @param newTodo The ToDo task that has been added.
     * @param count The number of tasks in the list.
     */
    public String printAddTodo(ToDo newTodo, int count) {
        String message = "Angus has added this task:"
                + LINE_BREAK
                + "\t" + newTodo
                + LINE_BREAK
                + "You now have " + count + " tasks in the list";
        System.out.println(message);
        return message;
    }

    /**
     * Prints and returns the result of adding a Deadline task to the list.
     * @param newDeadline The Deadline task that has been added.
     * @param count The number of tasks in the list.
     */
    public String printAddDeadline(Deadline newDeadline, int count) {
        String message = "Angus has added this deadline:"
                + LINE_BREAK
                + "\t" + newDeadline
                + LINE_BREAK
                + "You now have " + count + " tasks in the list";
        System.out.println(message);
        return message;
    }

    /**
     * Prints and returns the result of adding a Event task to the list.
     * @param newEvent The Event task that has been added.
     * @param count The number of tasks in the list.
     */
    public String printAddEvent(Event newEvent, int count) {
        String message = "Angus has added this event:"
                + LINE_BREAK
                + "\t" + newEvent
                + LINE_BREAK
                + "You now have " + count + " tasks in the list";
        System.out.println(message);
        return message;
    }

    /**
     * Prints and returns the result of deleting the task, including the deleted task and the number of tasks left.
     * @param removedTask The deleted task from the list.
     * @param count THe number of tasks in the list.
     */
    public String printDeleteTask(Task removedTask, int count) {
        String message = "All done! Angus has removed this task:"
                + LINE_BREAK
                + "\t" + removedTask
                + LINE_BREAK
                + "You now have " + count + " tasks in the list";

        System.out.println(angusResponse(message));
        return message;
    }

    /**
     * Prints and returns the list of tasks after filtering using a keyword.
     * @param tasks The filtered list of tasks.
     */
    public String printFilteredTasks(List<Task> tasks) {
        Task curTask;
        StringBuilder list = new StringBuilder();
        list.append("Here are the matching tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            curTask = tasks.get(i);
            list.append(i + 1);
            list.append(".");
            list.append(curTask);
            if (i < tasks.size() - 1) {
                list.append(LINE_BREAK); // prevent empty line at the end
            }
        }
        System.out.println(angusResponse(list.toString()));
        return list.toString();
    }
}
