public class Angus {
    private final Ui ui;
    private TaskList tasks;
    private final Parser parser;
    private Storage storage;

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

    public void run() {
        boolean isExit = false;
        ui.printGreetingsMessage();

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Commands c = parser.parse(fullCommand);
                c.execute();
                isExit = c.isExit();
            } catch (IllegalArgumentException e) {
                ui.printUnknownCommand();
            } catch (AngusException e) {
                ui.printError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Angus("data/Angus.txt").run();
    }
}
