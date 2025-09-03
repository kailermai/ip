package angus;

import angus.command.Commands;
import angus.exception.AngusException;
import angus.storage.Storage;
import angus.task.TaskList;
import angus.ui.Parser;
import angus.ui.Ui;
import javafx.application.Platform;
import javafx.stage.Stage;

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
        this.storage = new Storage("data/Angus.txt");
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

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        ui.printGreetingsMessage();

        try {
            Commands c = parser.parse(input);
            boolean isExit = c.isExit();
            if (isExit) {
                Platform.exit();
            }
            return c.execute();
        } catch (IllegalArgumentException e) {
            return ui.printUnknownCommand();
        } catch (AngusException e) {
            return ui.printError(e.getMessage());
        }
    }
}
