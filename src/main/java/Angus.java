import java.util.Scanner;

public class Angus {
    static String HORIZONTAL_LINE = "\t____________________________________________________________";
    static String LINE_SEPARATOR = "\n\t";

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
        String command = input.nextLine();
        while (!command.equals("bye")) {
            String message = angusResponse(command);
            System.out.println(message);
            command = input.nextLine();
        }
        System.out.println(goodbye);
    }   
}
