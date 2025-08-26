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
}
