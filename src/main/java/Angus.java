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

            switch (command) {
                case "bye":
                    running = false;
                    break;
                case "list":
                    StringBuilder list = new StringBuilder();
                    for (int i  = 0; i < taskList.size(); i++) {
                        list.append(i + 1);
                        list.append(". ");
                        list.append(taskList.get(i).getTaskName());
                        if (i < taskList.size() - 1){
                            list.append(LINE_SEPARATOR); // prevent empty line at the end
                        }
                    }
                    System.out.println(angusResponse(list.toString()));
                    break;
                default:
                    taskList.add(new Task(command));
                    String message = angusResponse("added: " + command);
                    System.out.println(message);
                    break;
            }
        }
        System.out.println(goodbye);
    }   
}
