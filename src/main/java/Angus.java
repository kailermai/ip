import java.util.Scanner;

public class Angus {
    public static void main(String[] args) {
        String horizontalLine = "\t____________________________________________________________";

        String greetings = horizontalLine
                + "\n\tHello! I'm Angus o_O\n"
                + "\tWhat can I do for you today?\n"
                + horizontalLine;

        String goodbye = horizontalLine
                + "\n\tGoodbye. Hope to see you again soon!\n"
                + horizontalLine;

        Scanner input = new Scanner(System.in);
        System.out.println(greetings);
        String command = input.nextLine();
        while (!command.equals("bye")) {
            String message = horizontalLine
                    + "\n\t" + command + "\n"
                    + horizontalLine;
            System.out.println(message);
            command = input.nextLine();
        }
        System.out.println(goodbye);
    }   
}
