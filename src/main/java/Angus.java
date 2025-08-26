import java.util.Arrays;
import java.util.Scanner;

public class Angus {
    private final Ui ui;
    private final TaskList tasks;
    private final Parser parser;

    public Angus() {
        this.ui = new Ui();
        this.tasks = new TaskList(ui);
        this.parser = new Parser(ui);
    }

    private final static String HORIZONTAL_LINE =
            "____________________________________________________________";
    private final static String LINE_SEPARATOR = "\n\t";

    public static String angusResponse(String text) {
        return "\t" + HORIZONTAL_LINE + LINE_SEPARATOR + text + LINE_SEPARATOR + HORIZONTAL_LINE;
    }

    public void run() {
        boolean isExit = false;
        ui.printGreetingsMessage();

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Commands c = parser.parse(fullCommand);
            } catch (IllegalArgumentException e) {
                ui.printUnknownCommand();
            }
            catch (AngusException e) {
                ui.printError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Angus().run();
    }
}
