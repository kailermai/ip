public class Angus {
    public static void main(String[] args) {
        String horizontalLine = "____________________________________________________________\n";

        String greetings = horizontalLine
                + "Hello! I'm Angus\n"
                + "What can I do for you?";

        String goodbye = horizontalLine
                + "Bye. Hope to see you again soon!\n"
                + horizontalLine;

        System.out.println(greetings);
        System.out.println(goodbye);
    }   
}
