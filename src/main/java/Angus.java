import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Angus {
    private final static String HORIZONTAL_LINE =
            "\t____________________________________________________________";
    private final static String LINE_SEPARATOR = "\n\t";

    List<Task> taskList = new ArrayList<>();

    public static String angusResponse(String text) {
        return HORIZONTAL_LINE + LINE_SEPARATOR + text + "\n" + HORIZONTAL_LINE;
    }

    public static void main(String[] args) {
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

                    break;

                default:
                    String message = angusResponse(command);
                    System.out.println(message);
                    break;
            }
        }
        System.out.println(goodbye);
    }   
}
