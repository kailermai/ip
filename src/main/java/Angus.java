public class Angus {
    private final Ui ui;
    private final TaskList tasks;
    private final Parser parser;

    public Angus() {
        this.ui = new Ui();
        this.tasks = new TaskList(ui);
        this.parser = new Parser(ui, tasks);
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
