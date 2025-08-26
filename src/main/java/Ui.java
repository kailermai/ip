import java.util.List;

import static java.lang.Character.LINE_SEPARATOR;

public class Ui {
    private final static String HORIZONTAL_LINE =
            "____________________________________________________________";

    public static String angusResponse(String text) {
        return "\t" + HORIZONTAL_LINE + LINE_SEPARATOR + text + LINE_SEPARATOR + HORIZONTAL_LINE;
    }

    public void greetingsMessage() {
        String greetingsText = "Hello! I'm Angus o_O" +
                LINE_SEPARATOR +
                "What can I do for you today?";
        System.out.println(angusResponse(greetingsText));
    }

    public void goodbyeMessage() {
        String goodbyeText = "Goodbye. Hope to see you again soon!";
        System.out.println(angusResponse(goodbyeText));
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
                list.append(LINE_SEPARATOR); // prevent empty line at the end
            }
        }
        System.out.println(angusResponse(list.toString()));
    }

    public void printMarkTask(boolean result, Task curTask) {
        String message;
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
    }

    public void printUnmarkTask(boolean result, Task curTask) {
        String message;
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
    }

    public void printAddTodo(ToDo newTodo, int taskListLength) {
        String message = angusResponse("Angus has added this task:" +
                LINE_SEPARATOR +
                "\t" + newTodo +
                LINE_SEPARATOR +
                "You now have " + taskListLength + " tasks in the list");
        System.out.println(message);
    }
}
