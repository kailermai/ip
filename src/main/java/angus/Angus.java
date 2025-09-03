package angus;

import angus.command.Commands;
import angus.exception.AngusException;
import angus.storage.Storage;
import angus.task.TaskList;
import angus.ui.Parser;
import angus.ui.Ui;

/**
 * Represents the entry point of the chatbot application.
 */
public class Angus {
    private final Ui ui;
    private TaskList tasks;
    private final Parser parser;
    private Storage storage;

    /**
     * Default constructor for JavaFX
     */
    public Angus() {
        this.storage = new Storage("data/angus.Angus.txt");
        this.ui = new Ui();
        try {
            this.tasks = new TaskList(ui, storage.load());
        } catch (AngusException e) {
            ui.printError(e.getMessage());
            this.tasks = new TaskList(ui);
        }
        this.parser = new Parser(ui, tasks, storage);
    }
    /**
     * Constructs a new instance of Angus with the given file path.
     * @param filePath The path to the storage file to save tasks.
     */
    public Angus(String filePath) {
        this.storage = new Storage(filePath);
        this.ui = new Ui();
        try {
            this.tasks = new TaskList(ui, storage.load());
        } catch (AngusException e) {
            ui.printError(e.getMessage());
            this.tasks = new TaskList(ui);
        }
        this.parser = new Parser(ui, tasks, storage);
    }

//    /**
//     * Runs the program loop to continuously read user input until an exit command such as
//     * "bye" is inputted. Any errors thrown will be displayed on the console without
//     * terminating the program loop.
//     */
//    public void run() {
//        boolean isExit = false;
//        ui.printGreetingsMessage();
//
//        while (!isExit) {
//            try {
//                String fullCommand = ui.readCommand();
//                Commands c = parser.parse(fullCommand);
//                c.execute();
//                isExit = c.isExit();
//            } catch (IllegalArgumentException e) {
//                ui.printUnknownCommand();
//            } catch (AngusException e) {
//                ui.printError(e.getMessage());
//            }
//        }
//    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        boolean isExit = false;
        ui.printGreetingsMessage();

        try {
            String fullCommand = ui.readCommand();
            Commands c = parser.parse(fullCommand);
            isExit = c.isExit();
            return c.execute();
        } catch (IllegalArgumentException e) {
            return ui.printUnknownCommand();
        } catch (AngusException e) {
            return ui.printError(e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        new Angus("data/angus.Angus.txt").run();
//    }
}
