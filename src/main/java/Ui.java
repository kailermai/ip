import java.util.List;

public class Ui {
    private final static String HORIZONTAL_LINE =
            "____________________________________________________________";
    private final static String LINE_SEPARATOR = "\n\t";

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

    public void displayTaskList(List<Task> taskList) {
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
}
