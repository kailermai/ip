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

            switch (mainCommand) {
                case "bye":
                    running = false;
                    break;
                case "list":
                    StringBuilder list = new StringBuilder();
                    list.append("Here are your tasks:\n\t");
                    for (int i  = 0; i < taskList.size(); i++) {
                        Task curTask = taskList.get(i);
                        list.append(i + 1);
                        list.append(".");
                        list.append("[").append(curTask.getStatusIcon()).append("] ");
                        list.append(curTask.getDescription());
                        if (i < taskList.size() - 1){
                            list.append(LINE_SEPARATOR); // prevent empty line at the end
                        }
                    }
                    System.out.println(angusResponse(list.toString()));
                    break;
                case "mark":
                    int taskNum = Integer.parseInt(commandList[1]);
                    boolean result = taskList.get(taskNum).markDone();
                    if (result) {

                    } else {

                    }
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
